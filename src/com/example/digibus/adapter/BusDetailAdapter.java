package com.example.digibus.adapter;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.digibus.R;
import com.example.digibus.utils.AppConstants;

public class BusDetailAdapter extends BaseAdapter {

	Activity activity;
	ArrayList<HashMap<String, String>> data=new ArrayList<HashMap<String, String>>();

	LayoutInflater inflater;

	public BusDetailAdapter(Activity activity,
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
		TextView bus,route,intime,outtime;
		
	}

	@SuppressWarnings("null")
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		View v = convertView;

		ViewHolder holder;
		if(convertView==null)
		{
			v=inflater.inflate(R.layout.list_items_bus, parent, false);
			holder =new ViewHolder();
			holder.bus=(TextView)v.findViewById(R.id.txt_bus);
			holder.route=(TextView)v.findViewById(R.id.txt_route);
			holder.intime=(TextView)v.findViewById(R.id.txt_intime);
			holder.outtime=(TextView)v.findViewById(R.id.txt_outTime);

			
			v.setTag(holder);

		}
		else
			holder=(ViewHolder)v.getTag();
		holder.bus.setText(data.get(position).get(AppConstants.KEY_REG_NUM));
		holder.route.setText(data.get(position).get(AppConstants.KEY_ROUTE));
		holder.intime.setText(data.get(position).get(AppConstants.KEY_INTIME));
		holder.outtime.setText(data.get(position).get(AppConstants.KEY_OUTTIME));
		return v;

	}

	

}
