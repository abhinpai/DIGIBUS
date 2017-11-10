package com.example.digibus;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.digibus.adapter.BookingAdapter;
import com.example.digibus.parser.AsyncTaskHandler;
import com.example.digibus.utils.AppConstants;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class Bookings extends AppCompatActivity{
	ListView mLv;
	ArrayList<String>data=new ArrayList<String>();

	@Override
	protected void onCreate( Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);

		mLv=(ListView)findViewById(R.id.lv);

		getBookings();

	}

	private void getBookings() {
		AsyncTaskHandler ahandler=new AsyncTaskHandler(Bookings.this, null, AppConstants.URL_BOOKINGS, AppConstants.MESSAGE_LOADING,AppConstants.PAGE_BOOKINGS);
		ahandler.execute();

	}



	public void onAsynkResult(ArrayList<HashMap<String, String>> data) {
		BookingAdapter adapter=new BookingAdapter(Bookings.this, data);
		mLv.setAdapter(adapter);
		
	}

}
