package com.example.digibus;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.digibus.adapter.LocationAdapter;
import com.example.digibus.parser.AsyncTaskHandler;
import com.example.digibus.utils.AppConstants;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

public class Location extends AppCompatActivity{
	ListView mLv;
	ArrayList<String>data=new ArrayList<String>();

	@Override
	protected void onCreate( Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);

		mLv=(ListView)findViewById(R.id.lv);

		getLocation();

	}

	private void getLocation() {
		AsyncTaskHandler ahandler=new AsyncTaskHandler(Location.this, null, AppConstants.URL_LOCATION, AppConstants.MESSAGE_LOADING,AppConstants.PAGE_LOCATION);
		ahandler.execute();

	}

	public void onGetLocation(ArrayList<HashMap<String, String>> data) {
		LocationAdapter adapter=new LocationAdapter(Location.this, data);
		mLv.setAdapter(adapter);
	}

	public void onAsynkResult(int statusCode, String statusMsg) {
		Toast.makeText(Location.this, statusMsg, Toast.LENGTH_LONG).show();

	}

}
