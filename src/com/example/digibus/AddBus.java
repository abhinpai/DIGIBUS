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
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddBus extends AppCompatActivity implements OnClickListener{
	Button mAdd;
	EditText mRoute,mRegNum,mChessis,mIsurance,mDepot;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_bus);

		initialisation();
	}

	private void initialisation() {
		mRegNum=(EditText)findViewById(R.id.et_reg_num);
		mRoute=(EditText)findViewById(R.id.et_route_num);
		mChessis=(EditText)findViewById(R.id.et_chessis);
		mIsurance=(EditText)findViewById(R.id.et_i_id);
		mDepot=(EditText)findViewById(R.id.et_depot);
	
		mAdd=(Button)findViewById(R.id.btn_add);
		mAdd.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_add:
			if(isFormvalid()){
				ArrayList<NameValuePair>nameValuePair=new ArrayList<NameValuePair>();
				nameValuePair.add(new BasicNameValuePair(AppConstants.KEY_REG_NUM,mRegNum.getText().toString()));
				nameValuePair.add(new BasicNameValuePair(AppConstants.KEY_ROUTE,mRoute.getText().toString()));
				nameValuePair.add(new BasicNameValuePair(AppConstants.KEY_CHESSIS,mChessis.getText().toString()));
				nameValuePair.add(new BasicNameValuePair(AppConstants.KEY_INSURANCE,mIsurance.getText().toString()));
				nameValuePair.add(new BasicNameValuePair(AppConstants.KEY_DEPOT,mDepot.getText().toString()));
				
				AsyncTaskHandler ahandler=new AsyncTaskHandler(AddBus.this, nameValuePair, AppConstants.URL_ADD_BUS, AppConstants.MESSAGE_LOADING,AppConstants.PAGE_ADD_BUS);
				ahandler.execute();
			}
			break;

		default:
			break;
		}
	}

	private boolean isFormvalid() {

		Boolean status=true;

		if(TextUtils.isEmpty(mRegNum.getText().toString())){
			mRegNum.setError("Fill Registration Number");
			status=false;
		}

		if(TextUtils.isEmpty(mRoute.getText().toString())){
			mRoute.setError("Fill Route Number");
			status=false;
		}
		if(TextUtils.isEmpty(mChessis.getText().toString())){
			mChessis.setError("Fill Chessis Number");
			status=false;
		}

		if(TextUtils.isEmpty(mIsurance.getText().toString())){
			mIsurance.setError("Fill Insurance ID");
			status=false;
		}		
		if(TextUtils.isEmpty(mDepot.getText().toString())){
			mDepot.setError("Fill Depot ");
			status=false;
		}	
		
		if(mRegNum.getText().length()<4 || mRegNum.getText().length()>9 ){
			mRegNum.setError("Enter valid Registration Number");
			status=false;
		}
		
		return status;
	}


	public void onResult(int statusCode, String statusMsg) {
		Toast.makeText(AddBus.this, statusMsg, Toast.LENGTH_LONG).show();
		if(statusCode==AppConstants.ERROR_CODE_SUCCESS)
		{
			clear();
			startActivity(new Intent(AddBus.this,ManageBus.class));
		}

	}

	private void clear() {
		// TODO Auto-generated method stub
		mRegNum.setText("");
		mRoute.setText("");
		mChessis.setText("");
		mIsurance.setText("");
		mDepot.setText("");
	}
}
