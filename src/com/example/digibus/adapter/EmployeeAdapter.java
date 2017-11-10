package com.example.digibus.adapter;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.digibus.R;
import com.example.digibus.UpdateBus;
import com.example.digibus.UpdateEmployee;
import com.example.digibus.parser.AsyncTaskHandler;
import com.example.digibus.utils.AppConstants;

public class EmployeeAdapter extends BaseAdapter{


	Activity activity;
	ArrayList<HashMap<String, String>> data=new ArrayList<HashMap<String, String>>();

	LayoutInflater inflater;

	public EmployeeAdapter(Activity activity,
			ArrayList<HashMap<String, String>> data) {
		this.activity=activity;
		this.data=data;
		inflater=(LayoutInflater)activity.getSystemService(activity.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	public static class ViewHolder{
		TextView name,email,phone,desig,address,dob,doj,id;
		Button edit,delete;

	}

	@SuppressWarnings("null")
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		View v = convertView;

		ViewHolder holder;
		if(convertView==null)
		{
			v=inflater.inflate(R.layout.list_item_employee, parent, false);
			holder =new ViewHolder();
			holder.name=(TextView)v.findViewById(R.id.txt_name);
			holder.email=(TextView)v.findViewById(R.id.txt_email);
			holder.phone=(TextView)v.findViewById(R.id.txt_phone);
			holder.desig=(TextView)v.findViewById(R.id.txt_desig);
			holder.address=(TextView)v.findViewById(R.id.txt_address);
			holder.dob=(TextView)v.findViewById(R.id.txt_dob);
			holder.doj=(TextView)v.findViewById(R.id.txt_doj);
			holder.id=(TextView)v.findViewById(R.id.txt_id);

			holder.delete=(Button)v.findViewById(R.id.btn_delete);
			holder.edit=(Button)v.findViewById(R.id.btn_edit);

			v.setTag(holder);

		}
		else
			holder=(ViewHolder)v.getTag();
		holder.name.setText(data.get(position).get(AppConstants.KEY_NAME));
		holder.email.setText(data.get(position).get(AppConstants.KEY_EMAIL));
		holder.phone.setText(data.get(position).get(AppConstants.KEY_PHONE));
		holder.desig.setText(data.get(position).get(AppConstants.KEY_DESIGNATION));
		holder.address.setText(data.get(position).get(AppConstants.KEY_ADDRESS));
		holder.dob.setText(data.get(position).get(AppConstants.KEY_DOB));
		holder.doj.setText(data.get(position).get(AppConstants.KEY_DOJ));
		holder.id.setText(data.get(position).get(AppConstants.KEY_ID));

		holder.delete.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

			}
		});

		holder.edit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent(activity,UpdateEmployee.class);
				intent.putExtra(AppConstants.KEY_ID, data.get(position).get(AppConstants.KEY_ID));
				intent.putExtra(AppConstants.KEY_NAME, data.get(position).get(AppConstants.KEY_NAME));
				intent.putExtra(AppConstants.KEY_EMAIL, data.get(position).get(AppConstants.KEY_EMAIL));
				intent.putExtra(AppConstants.KEY_PHONE, data.get(position).get(AppConstants.KEY_PHONE));
				intent.putExtra(AppConstants.KEY_ADDRESS, data.get(position).get(AppConstants.KEY_ADDRESS));
				intent.putExtra(AppConstants.KEY_DESIGNATION, data.get(position).get(AppConstants.KEY_DESIGNATION));
				intent.putExtra(AppConstants.KEY_DOB, data.get(position).get(AppConstants.KEY_DOB));
				intent.putExtra(AppConstants.KEY_DOJ, data.get(position).get(AppConstants.KEY_DOJ));
				
				activity.startActivity(intent);
			}
		});

		holder.delete.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				ArrayList<NameValuePair>nameValuePair=new ArrayList<NameValuePair>();
				
				nameValuePair.add(new BasicNameValuePair(AppConstants.KEY_ID,data.get(position).get(AppConstants.KEY_ID)));
				AsyncTaskHandler ahandler=new AsyncTaskHandler(activity, nameValuePair, AppConstants.URL_DELETE_EMPLOYEE, AppConstants.MESSAGE_LOADING,AppConstants.PAGE_DELETE_EMPLOYEE);
				ahandler.execute();

			}
		});
		
		v.setTag(holder);

	
		return v;

	}

}
