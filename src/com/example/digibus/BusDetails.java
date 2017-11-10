package com.example.digibus;

import java.util.ArrayList;
import java.util.HashMap;
import com.example.digibus.adapter.BusAdapter;
import com.example.digibus.adapter.BusDetailAdapter;
import com.example.digibus.utils.AppConstants;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class BusDetails extends AppCompatActivity {
	ListView mLv;
	ArrayList<HashMap<String,String>>data=new ArrayList<HashMap<String,String>>();

	@SuppressWarnings("unchecked")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bus_details);
		mLv=(ListView)findViewById(R.id.lv_bus);
		
		data = ((ArrayList)getIntent().getSerializableExtra(AppConstants.KEY_DATA));
		
		BusDetailAdapter adapter=new BusDetailAdapter(BusDetails.this, data);
		mLv.setAdapter(adapter);
		
		
	}
}
