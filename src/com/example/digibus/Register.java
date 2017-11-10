package com.example.digibus;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.digibus.parser.AsyncTaskHandler;
import com.example.digibus.utils.AppConstants;

public class Register extends AppCompatActivity implements OnClickListener{
	private Button mRegister;
	EditText mName,mUsername,mPassword,mPhone,mEmail;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);


		initialisation();
		clickListener();


	}





	private void clickListener() {
		mRegister.setOnClickListener(this);
	}

	private void initialisation() {
		mRegister=(Button)findViewById(R.id.btn_register);
		mName=(EditText)findViewById(R.id.et_name);
		mUsername=(EditText)findViewById(R.id.et_username);
		mPassword=(EditText)findViewById(R.id.et_password);
		mEmail=(EditText)findViewById(R.id.et_email);

		mPhone=(EditText)findViewById(R.id.et_phone);

		Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
		if (mToolbar != null) {
			setSupportActionBar(mToolbar);
		}
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.btn_register:
			if(isFormValid()){
				onRegister();
			}
			break;

		default:
			break;
		}
	}

	private boolean isFormValid() {
		String MobilePattern = "[0-9]{10}";
		String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
		Boolean status=true;

		if(TextUtils.isEmpty(mName.getText().toString())){
			mName.setError("Fill Name");
			status=false;
		}
		
		if(!mPhone.getText().toString().matches(MobilePattern))
	    {
			mPhone.setError("Enter valid 10 digit mobile number");
			status=false;
	    }
		
		if(!mEmail.getText().toString().matches(emailPattern))
	    { 
			mEmail.setError("Please enter valid email address");
			status=false;
	    }
		
		if(mUsername.length() > 25){
			mUsername.setError("Please enter less than 25 character in Username");
			status=false;
	    }

		if(TextUtils.isEmpty(mUsername.getText().toString())){
			mUsername.setError("Fill Username");
			status=false;
		}
		

		if(mPassword.getText().length()<6 || mPassword.getText().length()>32 ){
			mPassword.setError("Enter valid Password");
			status=false;
		}

		if(mPhone.length()!=10){
			mPhone.setError("Enter valid phone number");
			status=false;
		}

		if(TextUtils.isEmpty(mEmail.getText().toString())){

			mEmail.setError("Fill Email");
			status=false;
		}
		
		

	
		return status;
	}

	private void onRegister() {
		ArrayList<NameValuePair>nameValuePair=new ArrayList<NameValuePair>();
		nameValuePair.add(new BasicNameValuePair(AppConstants.KEY_USERNAME,mUsername.getText().toString()));
		nameValuePair.add(new BasicNameValuePair(AppConstants.KEY_PASSWORD,mPassword.getText().toString()));
		nameValuePair.add(new BasicNameValuePair(AppConstants.KEY_NAME,mName.getText().toString()));
		nameValuePair.add(new BasicNameValuePair(AppConstants.KEY_EMAIL,mEmail.getText().toString()));
	
		nameValuePair.add(new BasicNameValuePair(AppConstants.KEY_PHONE,mPhone.getText().toString()));

		AsyncTaskHandler ahandler=new AsyncTaskHandler(Register.this, nameValuePair, AppConstants.URL_REGISTER, AppConstants.MESSAGE_LOADING,AppConstants.PAGE_REGISTER);
		ahandler.execute();


	}


	public void onAsynkResult(int statusCode, String statusMsg) {
		Toast.makeText(Register.this, statusMsg, Toast.LENGTH_LONG).show();
		if(statusCode==AppConstants.ERROR_CODE_SUCCESS)
		{
			clear();
			startActivity(new Intent(Register.this,UserLogin.class));
		}
	}





	private void clear() {
		// TODO Auto-generated method stub
		mRegister.setText("");
		mName.setText("");
		mUsername.setText("");
		mPassword.setText("");
		mPhone.setText("");
		mEmail.setText("");
	}

}