package com.example.digibus;

import java.util.ArrayList;
import java.util.Calendar;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.example.digibus.parser.AsyncTaskHandler;
import com.example.digibus.utils.AppConstants;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

public class AddTime extends AppCompatActivity implements OnClickListener{

	Spinner mSource,mDestination,mBus;
	EditText mIntime,mOutTime;
	Button mAdd;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_time);

		initialisation();

		populateSpinner();

		mDestination.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int position, long id) {
				if(!mSource.getSelectedItem().toString().equals(mDestination.getSelectedItem().toString())
						&& mSource.getSelectedItemPosition()!=0 &&mDestination.getSelectedItemPosition()!=0){

					ArrayList<NameValuePair>nameValuePair=new ArrayList<NameValuePair>();
					nameValuePair.add(new BasicNameValuePair(AppConstants.KEY_SOURCE,mSource.getSelectedItem().toString()));
					nameValuePair.add(new BasicNameValuePair(AppConstants.KEY_DESTINATION,mDestination.getSelectedItem().toString()));
					AsyncTaskHandler ahandler=new AsyncTaskHandler(AddTime.this, nameValuePair, AppConstants.URL_GET_BUS, AppConstants.MESSAGE_LOADING,AppConstants.PAGE_LOAD_BUS_TIME);
					ahandler.execute();
				}

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});
	}

	private void populateSpinner() {
		AsyncTaskHandler ahandler=new AsyncTaskHandler(AddTime.this, null, AppConstants.URL_LOAD_LOCATION, AppConstants.MESSAGE_LOADING,AppConstants.PAGE_LOAD_LOCATION_TIME);
		ahandler.execute();

	}

	private void initialisation() {
		mSource=(Spinner)findViewById(R.id.sp_source);
		mDestination=(Spinner)findViewById(R.id.sp_destination);
		mBus=(Spinner)findViewById(R.id.sp_bus);
		mBus.setVisibility(View.GONE);
		mIntime=(EditText)findViewById(R.id.et_intime);
		mOutTime=(EditText)findViewById(R.id.et_outtime);
		mAdd=(Button)findViewById(R.id.btn_add);
		mAdd.setOnClickListener(this);
		mIntime.setOnClickListener(this);
		mOutTime.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.et_intime:
			getInTime();
			break;


		case R.id.et_outtime:
			getOutTime();
			break;


		case R.id.btn_add:
			if(isFormValid()){
				ArrayList<NameValuePair>nameValuePair=new ArrayList<NameValuePair>();
				nameValuePair.add(new BasicNameValuePair(AppConstants.KEY_SOURCE,mSource.getSelectedItem().toString()));
				nameValuePair.add(new BasicNameValuePair(AppConstants.KEY_DESTINATION,mDestination.getSelectedItem().toString()));
				nameValuePair.add(new BasicNameValuePair(AppConstants.KEY_BUS,mBus.getSelectedItem().toString()));
				nameValuePair.add(new BasicNameValuePair(AppConstants.KEY_INTIME,mIntime.getText().toString()));
				nameValuePair.add(new BasicNameValuePair(AppConstants.KEY_OUTTIME,mOutTime.getText().toString()));
				AsyncTaskHandler ahandler=new AsyncTaskHandler(AddTime.this, nameValuePair, AppConstants.URL_ADD_TIME, AppConstants.MESSAGE_LOADING,AppConstants.PAGE_ADD_TIME);
				ahandler.execute();
			}
			break;

		default:
			break;
		}


	}

	private void getOutTime() {
		Calendar mcurrentTime = Calendar.getInstance();
		int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
		int minute = mcurrentTime.get(Calendar.MINUTE);
		TimePickerDialog mTimePicker;
		mTimePicker = new TimePickerDialog(AddTime.this, new TimePickerDialog.OnTimeSetListener() {
			@Override
			public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {

				mOutTime.setText( selectedHour + ":" + selectedMinute+":00");

			}
		}, hour, minute, true);
		mTimePicker.setTitle("Select Out Time");
		mTimePicker.show();



	}

	private void getInTime() {

		Calendar mcurrentTime = Calendar.getInstance();
		int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
		int minute = mcurrentTime.get(Calendar.MINUTE);
		TimePickerDialog mTimePicker;
		mTimePicker = new TimePickerDialog(AddTime.this, new TimePickerDialog.OnTimeSetListener() {
			@Override
			public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {

				mIntime.setText( selectedHour + ":" + selectedMinute+":00");

			}
		}, hour, minute, true);
		mTimePicker.setTitle("Select in Time");
		mTimePicker.show();



	}

	private boolean isFormValid() {
		boolean status=true;
		if(mSource.getSelectedItemPosition()==0 || mDestination.getSelectedItemPosition()==0 || mBus.getSelectedItemPosition()==0){
			status=false;
			Toast.makeText(AddTime.this, "Select all the fields", Toast.LENGTH_SHORT).show();
		}

		if(mSource.getSelectedItem().toString().equals(mDestination.getSelectedItem().toString())){
			status=false;
			Toast.makeText(AddTime.this, "Source and destination fields same", Toast.LENGTH_SHORT).show();
		}

		return status;
	}

	public void onGetLocation(ArrayList<String> dataSource, ArrayList<String> dataDest) {

		ArrayAdapter<String>adapter1=new ArrayAdapter<String>(AddTime.this, android.R.layout.simple_spinner_dropdown_item, dataDest);
		mDestination.setAdapter(adapter1);
		mDestination.invalidate();
		adapter1.setNotifyOnChange(true);



		ArrayAdapter<String>adapter2=new ArrayAdapter<String>(AddTime.this, android.R.layout.simple_dropdown_item_1line, dataSource);
		mSource.setAdapter(adapter2);
		mSource.invalidate();
		adapter2.setNotifyOnChange(true);


	}

	public void onGetBus(ArrayList<String> bus) {
		mBus.setVisibility(View.VISIBLE);
		ArrayAdapter<String>adapter=new ArrayAdapter<String>(AddTime.this, android.R.layout.simple_dropdown_item_1line, bus);
		mBus.setAdapter(adapter);
		
	}
}
