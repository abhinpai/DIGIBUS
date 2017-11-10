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

public class FeedbackAdapter extends BaseAdapter{


	Activity activity;
	ArrayList<HashMap<String, String>> data=new ArrayList<HashMap<String, String>>();

	LayoutInflater inflater;

	public FeedbackAdapter(Activity activity,
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
		TextView name,email,phone,description,address;

		Button message;


	}

	@SuppressWarnings("null")
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		View v = convertView;

		ViewHolder holder;
		if(convertView==null)
		{
			v=inflater.inflate(R.layout.list_item_feedback, parent, false);
			holder =new ViewHolder();
			holder.name=(TextView)v.findViewById(R.id.txt_username);
			holder.email=(TextView)v.findViewById(R.id.txt_email);
			holder.phone=(TextView)v.findViewById(R.id.txt_phone);
			holder.description=(TextView)v.findViewById(R.id.txt_description);
			holder.address=(TextView)v.findViewById(R.id.txt_address);

			
			
			
			holder.message=(Button)v.findViewById(R.id.btn_message);
			
			
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
		return v;

	}

	protected void sms(String number) {
		Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" +number));
		activity.startActivity(intent);
		
	}
	
	
}
