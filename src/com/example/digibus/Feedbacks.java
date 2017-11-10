package com.example.digibus;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.digibus.adapter.FeedbackAdapter;
import com.example.digibus.parser.AsyncTaskHandler;
import com.example.digibus.utils.AppConstants;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class Feedbacks extends AppCompatActivity{
	ListView mLv;
	ArrayList<String>data=new ArrayList<String>();

	@Override
	protected void onCreate( Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);

		mLv=(ListView)findViewById(R.id.lv);

		getFeedBacks();

	}

	private void getFeedBacks() {
		AsyncTaskHandler ahandler=new AsyncTaskHandler(Feedbacks.this, null, AppConstants.URL_FEEDBACKS, AppConstants.MESSAGE_LOADING,AppConstants.PAGE_FEEDBACKS);
		ahandler.execute();

	}




	public void onAsynkResult(ArrayList<HashMap<String, String>> data) {
		FeedbackAdapter adapter=new FeedbackAdapter(Feedbacks.this, data);
		mLv.setAdapter(adapter);

	}
}
