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

public class UpdateEmployee extends AppCompatActivity implements OnClickListener{
	EditText mName,mAddress,mEmail,mDesig,mDob,mDoj,mPhone,mEmpId;
	Button mSend;
	Bundle bundle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_update_employee);

		initialisation();
		
		getIntentData();
	}

	private void getIntentData() {
		
		bundle=getIntent().getExtras();
		mName.setText(bundle.getString(AppConstants.KEY_NAME));
		mAddress.setText(bundle.getString(AppConstants.KEY_ADDRESS));
		mEmail.setText(bundle.getString(AppConstants.KEY_EMAIL));
		mDesig.setText(bundle.getString(AppConstants.KEY_DESIGNATION));
		mDob.setText(bundle.getString(AppConstants.KEY_DOB));
		mDoj.setText(bundle.getString(AppConstants.KEY_DOJ));
		mPhone.setText(bundle.getString(AppConstants.KEY_PHONE));
		mEmpId.setText(bundle.getString(AppConstants.KEY_ID));
	}

	private void initialisation() {
		mName=(EditText)findViewById(R.id.et_name);
		mAddress=(EditText)findViewById(R.id.et_address);
		mDesig=(EditText)findViewById(R.id.et_design);
		mDob=(EditText)findViewById(R.id.et_dob);
		mDoj=(EditText)findViewById(R.id.et_doj);
		mPhone=(EditText)findViewById(R.id.et_phone);
		mEmpId=(EditText)findViewById(R.id.et_emp_id);
		mEmail=(EditText)findViewById(R.id.et_email);

		mSend=(Button)findViewById(R.id.btn_send);

		mSend.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_send:
			if(isFormValid()){
				ArrayList<NameValuePair>nameValuePair=new ArrayList<NameValuePair>();
				nameValuePair.add(new BasicNameValuePair(AppConstants.KEY_ID,mEmpId.getText().toString()));
				nameValuePair.add(new BasicNameValuePair(AppConstants.KEY_NAME,mName.getText().toString()));
				nameValuePair.add(new BasicNameValuePair(AppConstants.KEY_EMAIL,mEmail.getText().toString()));
				nameValuePair.add(new BasicNameValuePair(AppConstants.KEY_PHONE,mPhone.getText().toString()));
				nameValuePair.add(new BasicNameValuePair(AppConstants.KEY_ADDRESS,mAddress.getText().toString()));
				nameValuePair.add(new BasicNameValuePair(AppConstants.KEY_DOB,mDob.getText().toString()));
				nameValuePair.add(new BasicNameValuePair(AppConstants.KEY_DOJ,mDoj.getText().toString()));
				nameValuePair.add(new BasicNameValuePair(AppConstants.KEY_DESIGNATION,mDesig.getText().toString()));
				AsyncTaskHandler ahandler=new AsyncTaskHandler(UpdateEmployee.this, nameValuePair, AppConstants.URL_UPDATE_EMPLOYEE, AppConstants.MESSAGE_LOADING,AppConstants.PAGE_UPDATE_EMPLOYEE);
				ahandler.execute();
			}
			break;

		default:
			break;
		}

	}

	private boolean isFormValid() {
		Boolean status=true;
		String MobilePattern = "[0-9]{10}";
		String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";


		if(TextUtils.isEmpty(mName.getText().toString())){
			status=false;
			mName.setError("Fill Name");
		}

		if(TextUtils.isEmpty(mAddress.getText().toString())){
			status=false;
			mAddress.setError("Fill Address");
		}

		if(TextUtils.isEmpty(mPhone.getText().toString())){
			status=false;
			mPhone.setError("Fill Phone");
		}

		if(TextUtils.isEmpty(mEmail.getText().toString())){
			status=false;
			mEmail.setError("Fill Email");
		}
		if(TextUtils.isEmpty(mDob.getText().toString())){
			status=false;
			mDob.setError("Fill DOB");
		}
		if(TextUtils.isEmpty(mDoj.getText().toString())){
			status=false;
			mDoj.setError("Fill DOJ");
		}
		if(TextUtils.isEmpty(mDesig.getText().toString())){
			status=false;
			mDesig.setError("Fill Designation");
		}
		if(TextUtils.isEmpty(mEmpId.getText().toString())){
			status=false;
			mEmpId.setError("Fill Employee id");
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

		if(mEmpId.length() > 15){
			mEmpId.setError("Please enter less than 15 character in Employee ID");
			status=false;
	    }

		return status;
	}

	public void onAsynkResult(int statusCode, String statusMsg) {
		Toast.makeText(UpdateEmployee.this, statusMsg, Toast.LENGTH_LONG).show();
		//if(statusCode==AppConstants.ERROR_CODE_SUCCESS){
			//clear();
			startActivity(new Intent(UpdateEmployee.this,ManageEmployee.class));
		//}
	}

	private void clear() {
		// TODO Auto-generated method stub
	
	}
}
