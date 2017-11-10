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

public class AdminLogin extends AppCompatActivity implements OnClickListener{

	EditText mEmail,mPassword;
	Button mLogin;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_admin_login);


		initialisation();
	}

	private void initialisation() {
		mEmail=(EditText)findViewById(R.id.et_email);
		mPassword=(EditText)findViewById(R.id.et_password);
		mLogin=(Button)findViewById(R.id.login_button);

		mLogin.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.login_button:
			if(isFormvalid()){
				ArrayList<NameValuePair>nameValuePair=new ArrayList<NameValuePair>();
				nameValuePair.add(new BasicNameValuePair(AppConstants.KEY_USERNAME,mEmail.getText().toString()));
				nameValuePair.add(new BasicNameValuePair(AppConstants.KEY_PASSWORD,mPassword.getText().toString()));

				AsyncTaskHandler ahandler=new AsyncTaskHandler(AdminLogin.this, nameValuePair, AppConstants.URL_LOGIN, AppConstants.MESSAGE_LOADING,AppConstants.PAGE_LOGIN);
				ahandler.execute();
			}
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
		Toast.makeText(AdminLogin.this, statusMsg, Toast.LENGTH_LONG).show();
		if(statusCode==AppConstants.ERROR_CODE_SUCCESS){
			clear();
			startActivity(new Intent(AdminLogin.this,AdminDash.class));
		}
	}

	private void clear() {
		// TODO Auto-generated method stub
		mEmail.setText("");
		mPassword.setText("");
	}

}
