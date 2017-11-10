package com.example.digibus;

import java.util.ArrayList;
import java.util.HashMap;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.example.digibus.adapter.EmployeeAdapter;
import com.example.digibus.parser.AsyncTaskHandler;
import com.example.digibus.utils.AppConstants;

public class Employee extends AppCompatActivity{
	ListView mLv;
	ArrayList<String>data=new ArrayList<String>();

	@Override
	protected void onCreate( Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);

		mLv=(ListView)findViewById(R.id.lv);

		getEmployees();

	}

	private void getEmployees() {
		AsyncTaskHandler ahandler=new AsyncTaskHandler(Employee.this, null, AppConstants.URL_EMPLOYEE, AppConstants.MESSAGE_LOADING,AppConstants.PAGE_EMPLOYEE);
		ahandler.execute();

	}




	public void onAsynkResult(ArrayList<HashMap<String, String>> data) {
		EmployeeAdapter adapter=new EmployeeAdapter(Employee.this, data);
		mLv.setAdapter(adapter);

	}

	public void onAsynkResultdlt(int statusCode, String statusMsg) {
		// TODO Auto-generated method stub
		Toast.makeText(Employee.this, statusMsg, Toast.LENGTH_LONG).show();

	}

}
