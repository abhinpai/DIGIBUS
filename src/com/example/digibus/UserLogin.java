package com.example.digibus;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.digibus.parser.AsyncTaskHandler;
import com.example.digibus.utils.AppConstants;

public class UserLogin extends AppCompatActivity implements OnClickListener{

	EditText mEmail,mPassword;
	Button mLogin;
	TextView mRegister;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_login);


		initialisation();
	}

	private void initialisation() {
		mEmail=(EditText)findViewById(R.id.et_email);
		mPassword=(EditText)findViewById(R.id.et_password);
		mRegister=(TextView)findViewById(R.id.txt_reg);
		mLogin=(Button)findViewById(R.id.login_button);

		mLogin.setOnClickListener(this);
		mRegister.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.login_button:
			if(isFormvalid()){
				ArrayList<NameValuePair>nameValuePair=new ArrayList<NameValuePair>();
				nameValuePair.add(new BasicNameValuePair(AppConstants.KEY_USERNAME,mEmail.getText().toString()));
				nameValuePair.add(new BasicNameValuePair(AppConstants.KEY_PASSWORD,mPassword.getText().toString()));

				AsyncTaskHandler ahandler=new AsyncTaskHandler(UserLogin.this, nameValuePair, AppConstants.URL_USER_LOGIN, AppConstants.MESSAGE_LOADING,AppConstants.PAGE_USER_LOGIN);
				ahandler.execute();
			}
			break;

		case R.id.txt_reg:
			startActivity(new Intent(UserLogin.this,Register.class));
			break;


		default:
			break;
		}
	}

	private boolean isFormvalid() {
		Boolean status=true;

		if(TextUtils.isEmpty(mEmail.getText().toString())){
			mEmail.setError("Fill Email");
			status=false;
		}

		if(TextUtils.isEmpty(mPassword.getText().toString())){
			mPassword.setError("Fill Password");
			status=false;
		}
		return status;

	}

	public void onAsynkResult(int statusCode, String statusMsg) {
		Toast.makeText(UserLogin.this, statusMsg, Toast.LENGTH_LONG).show();
		if(statusCode==AppConstants.ERROR_CODE_SUCCESS){
			clear();
			startActivity(new Intent(UserLogin.this,BookingOption.class));
		}
	}

	private void clear() {
		// TODO Auto-generated method stub
		mEmail.setText("");
		mPassword.setText("");
	}

}
