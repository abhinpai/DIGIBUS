package com.example.digibus.adapter;

import java.util.ArrayList;
import java.util.HashMap;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.example.digibus.R;
import com.example.digibus.utils.AppConstants;

public class BookingAdapter extends BaseAdapter{


	Activity activity;
	ArrayList<HashMap<String, String>> data=new ArrayList<HashMap<String, String>>();

	LayoutInflater inflater;

	public BookingAdapter(Activity activity,
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
		TextView name,email,phone,description,address,source,destination,fromdate,todate,passengers;
		Button message;
	}

	@SuppressWarnings("null")
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		View v = convertView;

		ViewHolder holder;
		if(convertView==null)
		{
			v=inflater.inflate(R.layout.list_item_bookings, parent, false);
			holder =new ViewHolder();
			holder.name=(TextView)v.findViewById(R.id.txt_username);
			holder.email=(TextView)v.findViewById(R.id.txt_email);
			holder.phone=(TextView)v.findViewById(R.id.txt_phone);
			holder.description=(TextView)v.findViewById(R.id.txt_description);
			holder.address=(TextView)v.findViewById(R.id.txt_address);
			holder.source=(TextView)v.findViewById(R.id.txt_source);
			holder.destination=(TextView)v.findViewById(R.id.txt_destination);
			holder.fromdate=(TextView)v.findViewById(R.id.txt_from_date);
			holder.todate=(TextView)v.findViewById(R.id.txt_to_date);
			holder.passengers=(TextView)v.findViewById(R.id.txt_passengers);
			
			holder.message=(Button)v.findViewById(R.id.btn_response);

			holder.message.setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View arg0) {
							sms(data.get(position).get(AppConstants.KEY_PHONE));
						}
					});

			v.setTag(holder);

		}
		else
			holder=(ViewHolder)v.getTag();
		holder.name.setText(data.get(position).get(AppConstants.KEY_USERNAME));
		holder.email.setText(data.get(position).get(AppConstants.KEY_EMAIL));
		holder.phone.setText(data.get(position).get(AppConstants.KEY_PHONE));
		holder.description.setText(data.get(position).get(AppConstants.KEY_DESCRIPTION));
		holder.address.setText(data.get(position).get(AppConstants.KEY_ADDRESS));
		holder.source.setText(data.get(position).get(AppConstants.KEY_SOURCE));
		holder.destination.setText(data.get(position).get(AppConstants.KEY_DESTINATION));
		holder.fromdate.setText(data.get(position).get(AppConstants.KEY_FROMDATE));
		holder.todate.setText(data.get(position).get(AppConstants.KEY_TODATE));
		holder.passengers.setText(data.get(position).get(AppConstants.KEY_PASSENGERS));
		return v;

	}
	
	protected void sms(String number) {
		Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" +number));
		activity.startActivity(intent);
		
	}

}
