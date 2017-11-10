package com.example.digibus;

import java.util.ArrayList;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.widget.DatePicker;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;


import com.example.digibus.parser.AsyncTaskHandler;
import com.example.digibus.utils.AppConstants;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddEmployee extends AppCompatActivity implements OnClickListener{
	EditText mName,mAddress,mEmail,mDesig,mDob,mDoj,mPhone,mEmpId;
	Button mSend;
	Calendar myCalendar1,myCalendar2;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_employee);

		initialisation();
		
		myCalendar1 = Calendar.getInstance();
		
		final DatePickerDialog.OnDateSetListener date1 = new DatePickerDialog.OnDateSetListener() 
		{

			@Override
			public void onDateSet(DatePicker view, int year, int monthOfYear,
					int dayOfMonth) 
			{
				// TODO Auto-generated method stub
				myCalendar1.set(Calendar.YEAR, year);
				myCalendar1.set(Calendar.MONTH, monthOfYear);
				myCalendar1.set(Calendar.DAY_OF_MONTH, dayOfMonth);
				updateDOB();
				
			}

		};
		
		myCalendar2 = Calendar.getInstance();
		
		final DatePickerDialog.OnDateSetListener date2 = new DatePickerDialog.OnDateSetListener() 
		{

			@Override
			public void onDateSet(DatePicker view, int year, int monthOfYear,
					int dayOfMonth) 
			{
				// TODO Auto-generated method stub
				myCalendar2.set(Calendar.YEAR, year);
				myCalendar2.set(Calendar.MONTH, monthOfYear);
				myCalendar2.set(Calendar.DAY_OF_MONTH, dayOfMonth);
				
				updateDOJ();
			}

		};
		
		mDob.setOnClickListener(new OnClickListener() 
		{

			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
				new DatePickerDialog(AddEmployee.this, date1, myCalendar1
						.get(Calendar.YEAR), myCalendar1.get(Calendar.MONTH),
						myCalendar1.get(Calendar.DAY_OF_MONTH)).show();
			}
		});
		
		mDoj.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				new DatePickerDialog(AddEmployee.this, date2, myCalendar2
						.get(Calendar.YEAR), myCalendar2.get(Calendar.MONTH),
						myCalendar2.get(Calendar.DAY_OF_MONTH)).show();
			}
		});
	}

	
	
	protected void updateDOB() {
		String myFormat = "yyyy-MM-dd"; 
		SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

		mDob.setText(sdf.format(myCalendar1.getTime()));

	}
	
	protected void updateDOJ() {
		String myFormat = "yyyy-MM-dd"; 
		SimpleDateFormat sdf1 = new SimpleDateFormat(myFormat, Locale.US);

		mDoj.setText(sdf1.format(myCalendar2.getTime()));

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
				AsyncTaskHandler ahandler=new AsyncTaskHandler(AddEmployee.this, nameValuePair, AppConstants.URL_ADD_EMPLOYEE, AppConstants.MESSAGE_LOADING,AppConstants.PAGE_ADD_EMPLOYEE);
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
			mDob.setError("Fill Date Of Birth");
		}
		if(TextUtils.isEmpty(mDoj.getText().toString())){
			status=false;
			mDoj.setError("Fill Date Of Joining");
		}
		if(TextUtils.isEmpty(mDesig.getText().toString())){
			status=false;
			mDesig.setError("Fill Designation");
		}
		if(TextUtils.isEmpty(mEmpId.getText().toString())){
			status=false;
			mEmpId.setError("Fill Employee id");
		}

		
		if(mDob.getText().toString()==mDoj.getText().toString())
		{
			status=false;
			mDob.setError("Check date of birth and date of Joining");
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
		Toast.makeText(AddEmployee.this, statusMsg, Toast.LENGTH_LONG).show();
		if(statusCode==AppConstants.ERROR_CODE_SUCCESS)
		{
			clear();
			startActivity(new Intent(AddEmployee.this,ManageEmployee.class));
		}
	}



	private void clear() {
		// TODO Auto-generated method stub
		mName.setText("");
		mAddress.setText("");
		mEmail.setText("");
		mDesig.setText("");
		mDob.setText("");
		mDoj.setText("");
		mPhone.setText("");
		mEmpId.setText("");
	}
}
