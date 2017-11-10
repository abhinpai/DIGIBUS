package com.example.digibus;

import java.util.ArrayList;
import java.util.HashMap;

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

public class BusSearch extends AppCompatActivity implements OnClickListener{
	Spinner mSource,mDestination,mBus;
	Button mSearch;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bus_search);

		initialisation();

		populateSpinner();
	}

	private void populateSpinner() {
		AsyncTaskHandler ahandler=new AsyncTaskHandler(BusSearch.this, null, AppConstants.URL_LOAD_LOCATION, AppConstants.MESSAGE_LOADING,AppConstants.PAGE_LOCATION_IN_SEARCH);
		ahandler.execute();

	}

	private void initialisation() {
		mSource=(Spinner)findViewById(R.id.sp_source);
		mDestination=(Spinner)findViewById(R.id.sp_destination);
		mBus=(Spinner)findViewById(R.id.sp_bus);
		mSearch=(Button)findViewById(R.id.btn_search);

		mSearch.setOnClickListener(this);

	}

	@Override
	public void onClick(View arg0) {
		if(isFormvalid()){
			ArrayList<NameValuePair>nameValuePair=new ArrayList<NameValuePair>();
			nameValuePair.add(new BasicNameValuePair(AppConstants.KEY_SOURCE,mSource.getSelectedItem().toString()));
			nameValuePair.add(new BasicNameValuePair(AppConstants.KEY_DESTINATION,mDestination.getSelectedItem().toString()));
			
			AsyncTaskHandler ahandler=new AsyncTaskHandler(BusSearch.this, nameValuePair, AppConstants.URL_SEARCH_BUS, AppConstants.MESSAGE_LOADING,AppConstants.PAGE_SEARCH_BUS);
			ahandler.execute();
		}

	}

	private boolean isFormvalid() {
		boolean status=true;

		if(mSource.getSelectedItemPosition()==mDestination.getSelectedItemPosition()){
			status=false;
			Toast.makeText(BusSearch.this, "Both location should not be same", Toast.LENGTH_LONG).show();
		}
		return status;
	}

	public void onGetLocation(ArrayList<String> data, ArrayList<String> dataDest) {
		
		ArrayAdapter<String>adapter=new ArrayAdapter<String>(BusSearch.this, android.R.layout.simple_dropdown_item_1line, data);
		mSource.setAdapter(adapter);
		
		
		ArrayAdapter<String>adapter2=new ArrayAdapter<String>(BusSearch.this, android.R.layout.simple_dropdown_item_1line, dataDest);
		mDestination.setAdapter(adapter2);
	}

	

	

	public void onBus(ArrayList<HashMap<String, String>> data) {
		Intent intent=new Intent(BusSearch.this,BusDetails.class);
		intent.putExtra(AppConstants.KEY_DATA, data);
		startActivity(intent);
		
	}
	

}
