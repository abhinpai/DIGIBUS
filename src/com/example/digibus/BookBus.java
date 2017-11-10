package com.example.digibus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

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
import android.support.design.widget.Snackbar.Duration;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BookBus extends AppCompatActivity implements OnClickListener{
	EditText mPhone,mEmail,mAddress,mSource,mDestination,mPassengers,mFromDate,mTodate,mDescription;
	Button mBook;

	Calendar myCalendar1,myCalendar2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_book_bus);

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
				updateFROM();
				updateTO();
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
				updateFROM();
				updateTO();
			}

		};
		mFromDate.setOnClickListener(new OnClickListener() 
		{

			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				new DatePickerDialog(BookBus.this, date1, myCalendar1
						.get(Calendar.YEAR), myCalendar1.get(Calendar.MONTH),
						myCalendar1.get(Calendar.DAY_OF_MONTH)).show();
			}
		});
		
		mTodate.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				new DatePickerDialog(BookBus.this, date2, myCalendar2
						.get(Calendar.YEAR), myCalendar2.get(Calendar.MONTH),
						myCalendar2.get(Calendar.DAY_OF_MONTH)).show();
			}
			
			
		});
		
		
		
	}

	
	protected void updateFROM() {
		String myFormat = "yyyy-MM-dd"; 
		SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

		mFromDate.setText(sdf.format(myCalendar1.getTime()));

	}
	
	protected void updateTO() {
		String myFormat = "yyyy-MM-dd"; 
		SimpleDateFormat sdf1 = new SimpleDateFormat(myFormat, Locale.US);

		mTodate.setText(sdf1.format(myCalendar2.getTime()));

	}
	
	
	private void initialisation() {
		mPhone=(EditText)findViewById(R.id.et_phone);
		mEmail=(EditText)findViewById(R.id.et_email);
		mAddress=(EditText)findViewById(R.id.et_address);
		mSource=(EditText)findViewById(R.id.et_source);
		mDestination=(EditText)findViewById(R.id.et_destination);
		mPassengers=(EditText)findViewById(R.id.et_passenger);
		mFromDate=(EditText)findViewById(R.id.et_fromdate);
		mTodate=(EditText)findViewById(R.id.et_todate);
		mDescription=(EditText)findViewById(R.id.et_description);

		mBook=(Button)findViewById(R.id.btn_book);
		mBook.setOnClickListener(this);

	}

	@Override
	public void onClick(View arg0) {
		if(isFormvalid()){
			ArrayList<NameValuePair>nameValuePair=new ArrayList<NameValuePair>();
			nameValuePair.add(new BasicNameValuePair(AppConstants.KEY_USERNAME,AppConstants.PARAM_USERNAME));
			nameValuePair.add(new BasicNameValuePair(AppConstants.KEY_PHONE,mPhone.getText().toString()));
			nameValuePair.add(new BasicNameValuePair(AppConstants.KEY_EMAIL,mEmail.getText().toString()));
			nameValuePair.add(new BasicNameValuePair(AppConstants.KEY_ADDRESS,mAddress.getText().toString()));
			nameValuePair.add(new BasicNameValuePair(AppConstants.KEY_SOURCE,mSource.getText().toString()));
			nameValuePair.add(new BasicNameValuePair(AppConstants.KEY_DESTINATION,mDestination.getText().toString()));
			nameValuePair.add(new BasicNameValuePair(AppConstants.KEY_FROMDATE,mFromDate.getText().toString()));
			nameValuePair.add(new BasicNameValuePair(AppConstants.KEY_TODATE,mTodate.getText().toString()));
			nameValuePair.add(new BasicNameValuePair(AppConstants.KEY_PASSENGERS,mPassengers.getText().toString()));
			nameValuePair.add(new BasicNameValuePair(AppConstants.KEY_DESCRIPTION,mDescription.getText().toString()));

			AsyncTaskHandler ahandler=new AsyncTaskHandler(BookBus.this, nameValuePair, AppConstants.URL_BOOK_BUS, AppConstants.MESSAGE_REGISTER,AppConstants.PAGE_BOOK_BUS);
			ahandler.execute();
		}

	}

	private boolean isFormvalid() {
		Boolean status=true;
		String MobilePattern = "[0-9]{10}";
		String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
		

		if(TextUtils.isEmpty(mPhone.getText().toString())){
			status=false;
			mPhone.setError("Fill Phone");
		}

		if(TextUtils.isEmpty(mEmail.getText().toString())){
			status=false;
			mEmail.setError("Fill Email");
		}

		if(TextUtils.isEmpty(mAddress.getText().toString())){
			status=false;
			mAddress.setError("Fill Address");
		}

		if(TextUtils.isEmpty(mSource.getText().toString())){
			status=false;
			mSource.setError("Fill Source");
		}

		if(TextUtils.isEmpty(mDestination.getText().toString())){
			status=false;
			mDestination.setError("Fill Destination");
		}

		if(TextUtils.isEmpty(mPassengers.getText().toString())){
			status=false;
			mPassengers.setError("Fill Passengers");
		}

		if(TextUtils.isEmpty(mFromDate.getText().toString())){
			status=false;
			mFromDate.setError("Fill From date");
		}

		if(TextUtils.isEmpty(mTodate.getText().toString())){
			status=false;
			mTodate.setError("Fill To date");
		}

		if(TextUtils.isEmpty(mDescription.getText().toString())){
			status=false;
			mDescription.setError("Fill description");
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
		
		if(mSource.equals(mDestination))
		{
			Toast.makeText(null, "Source and destination can not be same",Toast.LENGTH_LONG).show();
		}
		
		if(mTodate.equals(mFromDate)==true)
		{
			Toast.makeText(null, "From date and From date cann't be same",Toast.LENGTH_LONG).show();
		}
		

		
		
		return status;
	}

	public void onAsynkResult(int statusCode, String statusMsg) {
		Toast.makeText(BookBus.this, statusMsg, Toast.LENGTH_LONG).show();
		if(statusCode==AppConstants.ERROR_CODE_SUCCESS){
			clear();
			startActivity(new Intent(BookBus.this,UserDash.class));
		}
	}


	private void clear() {
		// TODO Auto-generated method stub
		mPhone.setText("");
		mEmail.setText("");
		mAddress.setText("");
		mSource.setText("");
		mDestination.setText("");
		mPassengers.setText("");
		mFromDate.setText("");
		mTodate.setText("");
		mDescription.setText("");
	}
}
