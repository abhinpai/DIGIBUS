package com.example.digibus;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.example.digibus.parser.AsyncTaskHandler;
import com.example.digibus.utils.AppConstants;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class AddLocationDetail extends AppCompatActivity implements OnClickListener{
	Spinner mSource,mDestination,mBus;
	Button mAdd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_locationdetail);

		initialisation();

		populateSpinner();
	}

	private void populateSpinner() {
		AsyncTaskHandler ahandler=new AsyncTaskHandler(AddLocationDetail.this, null, AppConstants.URL_LOAD_LOCATION, AppConstants.MESSAGE_LOADING,AppConstants.PAGE_LOAD_LOCATIONS);
		ahandler.execute();

	}

	private void initialisation() {
		mSource=(Spinner)findViewById(R.id.sp_source);
		mDestination=(Spinner)findViewById(R.id.sp_destination);
		mBus=(Spinner)findViewById(R.id.sp_bus);
		mAdd=(Button)findViewById(R.id.btn_add);

		mAdd.setOnClickListener(this);

	}

	@Override
	public void onClick(View arg0) {
		if(isFormvalid()){
			ArrayList<NameValuePair>nameValuePair=new ArrayList<NameValuePair>();
			nameValuePair.add(new BasicNameValuePair(AppConstants.KEY_SOURCE,mSource.getSelectedItem().toString()));
			nameValuePair.add(new BasicNameValuePair(AppConstants.KEY_DESTINATION,mDestination.getSelectedItem().toString()));
			nameValuePair.add(new BasicNameValuePair(AppConstants.KEY_REG_NUM,mBus.getSelectedItem().toString()));

			AsyncTaskHandler ahandler=new AsyncTaskHandler(AddLocationDetail.this, nameValuePair, AppConstants.URL_ADD_LOCATION_DETAIL, AppConstants.MESSAGE_LOADING,AppConstants.PAGE_ADD_LOCATIONDETAIL);
			ahandler.execute();
		}

	}

	private boolean isFormvalid() {
		boolean status=true;

		if(mSource.getSelectedItemPosition()==mDestination.getSelectedItemPosition()){
			status=false;
			Toast.makeText(AddLocationDetail.this, "Both location should not be same", Toast.LENGTH_LONG).show();
		}
		return status;
	}

	public void onGetLocation(ArrayList<String> data, ArrayList<String> bus) {
		ArrayAdapter<String>adapter=new ArrayAdapter<String>(AddLocationDetail.this, android.R.layout.simple_dropdown_item_1line, data);
		mSource.setAdapter(adapter);
		mDestination.setAdapter(adapter);
		
		ArrayAdapter<String>adapter2=new ArrayAdapter<String>(AddLocationDetail.this, android.R.layout.simple_dropdown_item_1line, bus);
		mBus.setAdapter(adapter2);
	}

	public void onResult(int statusCode, String statusMsg) {
		Toast.makeText(AddLocationDetail.this, statusMsg, Toast.LENGTH_LONG).show();
		if(statusCode==AppConstants.ERROR_CODE_SUCCESS)
		{
			clear();
			startActivity(new Intent(AddLocationDetail.this,ManageLocationDetails.class));
		}
	}

	private void clear() {
		// TODO Auto-generated method stub
		
	}

}
