package com.example.digibus.adapter;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.example.digibus.R;
import com.example.digibus.UpdateLocation;
import com.example.digibus.parser.AsyncTaskHandler;
import com.example.digibus.utils.AppConstants;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

public class LocationAdapter extends BaseAdapter {

	Activity activity;
	ArrayList<HashMap<String,String>>data=new ArrayList<HashMap<String,String>>();

	LayoutInflater inflater;

	public LocationAdapter(Activity activity,
			ArrayList<HashMap<String,String>>data) {
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
		TextView name;
		Button edit,delete;

	}

	@SuppressWarnings("null")
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		View v = convertView;

		ViewHolder holder;
		if(convertView==null)
		{
			v=inflater.inflate(R.layout.list_item_location, parent, false);
			holder =new ViewHolder();
			holder.name=(TextView)v.findViewById(R.id.txt_name);
			holder.edit=(Button)v.findViewById(R.id.btn_edit);
			holder.delete=(Button)v.findViewById(R.id.btn_delete);

			holder.edit.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					Intent intent=new Intent(activity,UpdateLocation.class);
					intent.putExtra(AppConstants.KEY_ID, data.get(position).get(AppConstants.KEY_ID));
					intent.putExtra(AppConstants.KEY_NAME, data.get(position).get(AppConstants.KEY_NAME));
					activity.startActivity(intent);

				}
			});

			holder.delete.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					ArrayList<NameValuePair>nameValuePair=new ArrayList<NameValuePair>();
					
					nameValuePair.add(new BasicNameValuePair(AppConstants.KEY_ID,data.get(position).get(AppConstants.KEY_ID)));
					AsyncTaskHandler ahandler=new AsyncTaskHandler(activity, nameValuePair, AppConstants.URL_DELETE_LOCATION, AppConstants.MESSAGE_LOADING,AppConstants.PAGE_DELETE_LOCATION);
					ahandler.execute();

				}
			});


			v.setTag(holder);

		}
		else
			holder=(ViewHolder)v.getTag();
		holder.name.setText(data.get(position).get(AppConstants.KEY_NAME));

		return v;

	}



}
