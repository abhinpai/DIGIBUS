package com.example.digibus;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.digibus.adapter.BusAdapter;
import com.example.digibus.adapter.BusDetailAdapter;
import com.example.digibus.adapter.LocationAdapter;
import com.example.digibus.parser.AsyncTaskHandler;
import com.example.digibus.utils.AppConstants;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

public class BusDetail extends AppCompatActivity{
	ListView mLv;
	ArrayList<String>data=new ArrayList<String>();

	@Override
	protected void onCreate( Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);

		mLv=(ListView)findViewById(R.id.lv);

		getBus();

	}

	private void getBus() {
		AsyncTaskHandler ahandler=new AsyncTaskHandler(BusDetail.this, null, AppConstants.URL_BUSDETAILS, AppConstants.MESSAGE_LOADING,AppConstants.PAGE_BUS_DETAILS);
		ahandler.execute();

	}


	public void onAsynkResult(int statusCode, String statusMsg) {
		Toast.makeText(BusDetail.this, statusMsg, Toast.LENGTH_LONG).show();

	}

	public void onGetBus(ArrayList<HashMap<String, String>> data) {
		BusAdapter adapter=new BusAdapter(BusDetail.this, data);
		mLv.setAdapter(adapter);
	}

}
