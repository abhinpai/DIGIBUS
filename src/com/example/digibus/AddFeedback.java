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
import android.telephony.SmsManager;


public class AddFeedback extends AppCompatActivity implements OnClickListener{
	EditText mPhone,mEmail,mDescription,mAddress,mName;
	Button mSend;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_feedback);
		
		initialisation();
	}

	private void initialisation() {
		mName=(EditText)findViewById(R.id.et_name);
		mPhone=(EditText)findViewById(R.id.et_phone);
		mEmail=(EditText)findViewById(R.id.et_email);
		mDescription=(EditText)findViewById(R.id.et_description);
		mAddress=(EditText)findViewById(R.id.et_address);	
		mSend=(Button)findViewById(R.id.btn_send);	
		mSend.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if(isFormValid()){
			//sms();
			ArrayList<NameValuePair>nameValuePair=new ArrayList<NameValuePair>();
			nameValuePair.add(new BasicNameValuePair(AppConstants.KEY_USERNAME,mName.getText().toString()));
			nameValuePair.add(new BasicNameValuePair(AppConstants.KEY_PHONE,mPhone.getText().toString()));
			nameValuePair.add(new BasicNameValuePair(AppConstants.KEY_EMAIL,mEmail.getText().toString()));
			nameValuePair.add(new BasicNameValuePair(AppConstants.KEY_ADDRESS,mAddress.getText().toString()));
			nameValuePair.add(new BasicNameValuePair(AppConstants.KEY_DESCRIPTION,mDescription.getText().toString()));

			AsyncTaskHandler ahandler=new AsyncTaskHandler(AddFeedback.this, nameValuePair, AppConstants.URL_ADD_FEEDBACK, AppConstants.MESSAGE_LOADING,AppConstants.PAGE_ADD_FEEDBACK);
			ahandler.execute();
		}
		
	}

	private void sms() {
		// TODO Auto-generated method stub
		String phoneno = "8884181767";
		String sms = mDescription.getText().toString();
		try
		{
		SmsManager smsManager=SmsManager.getDefault();
		smsManager.sendTextMessage(phoneno, null, sms, null, null);
		Toast.makeText(getApplicationContext(), " Feedback has been sent", Toast.LENGTH_LONG).show();
		}
		catch (Exception e)
		{
			Toast.makeText(getApplicationContext(), " Feedback cannot send", Toast.LENGTH_LONG).show();
		}
	}

	private boolean isFormValid() {
		boolean status=true;
		String MobilePattern = "[0-9]{10}";
		String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
		
		if(mPhone.length()!=10){
			status=false;
			mPhone.setError("Fill Phone");
			
		}
		
		if(TextUtils.isEmpty(mName.getText().toString())){
			status=false;
			mName.setError("Enter Your Name");
		}
		
		if(TextUtils.isEmpty(mPhone.getText().toString())){
			status=false;
			mPhone.setError("Enter Your Phone Number");
		}
		
		
		
		if(TextUtils.isEmpty(mEmail.getText().toString())){
			status=false;
			mEmail.setError("Fill Email");
		}
		
		if(TextUtils.isEmpty(mDescription.getText().toString())){
			status=false;
			mDescription.setError("Fill Description");
		}
		
		if(TextUtils.isEmpty(mAddress.getText().toString())){
			status=false;
			mAddress.setError("Fill Address");
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
		
		if( mDescription.getText().length()>45 ){
			mDescription.setError("Please Enter Short Disciption");
			status=false;
		}
		if(mDescription.getText().length()<5  ){
			mDescription.setError("Disciption Too Short");
			status=false;
		}
		
		
		return status;
	}

	public void onFeedback(int statusCode, String statusMsg) {
		Toast.makeText(AddFeedback.this, statusMsg, Toast.LENGTH_LONG).show();
		if(statusCode==AppConstants.ERROR_CODE_SUCCESS)
		{
			clear();
			startActivity(new Intent(AddFeedback.this,UserDash.class));
		}
		
	}

	private void clear() {
		// TODO Auto-generated method stub
		mPhone.setText("");
		mName.setText("");
		mEmail.setText("");
		mDescription.setText("");
		mAddress.setText("");
	}
}
