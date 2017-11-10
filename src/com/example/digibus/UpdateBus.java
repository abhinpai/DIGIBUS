package com.example.digibus;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.example.digibus.parser.AsyncTaskHandler;
import com.example.digibus.utils.AppConstants;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateBus extends AppCompatActivity implements OnClickListener{
	
	EditText mRoute,mReg;
	Button mUpdate;
	Bundle bundle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_update_bus);
		
		initialisation();
		getIntentData();
	}

	private void getIntentData() {
		bundle=getIntent().getExtras();
		mRoute.setText(bundle.getString(AppConstants.KEY_ROUTE));
		mReg.setText(bundle.getString(AppConstants.KEY_REG_NUM));
		
	}

	private void initialisation() {
		mRoute=(EditText)findViewById(R.id.et_route);
		mReg=(EditText)findViewById(R.id.et_reg_num);
		
		mUpdate=(Button)findViewById(R.id.btn_update);
		mUpdate.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		if(isFormValid()){
			ArrayList<NameValuePair>nameValuePair=new ArrayList<NameValuePair>();
			nameValuePair.add(new BasicNameValuePair(AppConstants.KEY_REG_NUM,mReg.getText().toString()));
			nameValuePair.add(new BasicNameValuePair(AppConstants.KEY_ROUTE,mRoute.getText().toString()));
			nameValuePair.add(new BasicNameValuePair(AppConstants.KEY_ID,bundle.getString(AppConstants.KEY_ID)));
			Log.e("nvp", ":"+nameValuePair);
			AsyncTaskHandler ahandler=new AsyncTaskHandler(UpdateBus.this, nameValuePair, AppConstants.URL_UPDATE_BUS, AppConstants.MESSAGE_LOADING,AppConstants.PAGE_UPDATE_BUS);
			ahandler.execute();
		}
	}

	private boolean isFormValid() {
		Boolean status=true;
		
		if(TextUtils.isEmpty(mRoute.getText().toString())){
			status=false;
			mRoute.setError("Fill Route");
		}
		

		if(TextUtils.isEmpty(mReg.getText().toString())){
			status=false;
			mReg.setError("Fill Registration number");
		}
		if(mReg.getText().length()<4 || mReg.getText().length()>9 ){
			mReg.setError("Enter valid Registration Number");
			status=false;
		}
		return status;
	}

	public  void onResult(int statusCode, String statusMsg) {
		Toast.makeText(UpdateBus.this, statusMsg, Toast.LENGTH_LONG).show();
		//if(statusCode==AppConstants.ERROR_CODE_SUCCESS){
		//	clear();
			startActivity(new Intent(UpdateBus.this,ManageBus.class));
		//}
	}

	private void clear() {
		// TODO Auto-generated method stub

	}
	
}
