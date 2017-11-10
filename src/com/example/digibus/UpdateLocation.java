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

public class UpdateLocation extends AppCompatActivity implements OnClickListener{
	EditText mLocation;
	Button mUpdate;
	Bundle bundle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_update_location);
		
		
		
		initialisation();
		getIntentData();
	}

	private void getIntentData() {
		bundle=getIntent().getExtras();
		mLocation.setText(bundle.getString(AppConstants.KEY_NAME));
		
	}

	private void initialisation() {
		mLocation=(EditText)findViewById(R.id.et_name);
		mUpdate=(Button)findViewById(R.id.btn_update);
		mUpdate.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View arg0) {
		if(isFormValid()){
			ArrayList<NameValuePair>nameValuePair=new ArrayList<NameValuePair>();
			nameValuePair.add(new BasicNameValuePair(AppConstants.KEY_NAME,mLocation.getText().toString()));
			nameValuePair.add(new BasicNameValuePair(AppConstants.KEY_ID,bundle.getString(AppConstants.KEY_ID)));
			AsyncTaskHandler ahandler=new AsyncTaskHandler(UpdateLocation.this, nameValuePair, AppConstants.URL_UPDATE_LOCATION, AppConstants.MESSAGE_LOADING,AppConstants.PAGE_UPDATE_LOCATION);
			ahandler.execute();
		}
		
	}

	private boolean isFormValid() {
		Boolean status=true;
		if(TextUtils.isEmpty(mLocation.getText().toString())){
			status=false;
			mLocation.setError("Fill Location");
		}
		return status;
	}

	public void onAsynkResult(int statusCode, String statusMsg) {
		Toast.makeText(UpdateLocation.this, statusMsg, Toast.LENGTH_LONG).show();
		//if(statusCode==AppConstants.ERROR_CODE_SUCCESS){
		//	clear();
			startActivity(new Intent(UpdateLocation.this,ManageLocation.class));
		//}
	}

	private void clear() {
		// TODO Auto-generated method stub
	
	}
}
