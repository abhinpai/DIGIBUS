package com.example.digibus;


import com.example.digibus.utils.AppConstants;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class UserDash extends Activity implements OnClickListener 
{

	ImageView route,book,contact,feedbcak,admin,about;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.user_dash);

		route= (ImageView)findViewById(R.id.route_button);
		book=(ImageView)findViewById(R.id.bus_booking_button);
		contact= (ImageView)findViewById(R.id.contact_button);
		feedbcak=(ImageView)findViewById(R.id.feedback_button);
		admin= (ImageView)findViewById(R.id.admin_login_button);
		about=(ImageView)findViewById(R.id.about_us_button);

		route.setOnClickListener(this);
		book.setOnClickListener(this);
		contact.setOnClickListener(this);
		feedbcak.setOnClickListener(this);
		admin.setOnClickListener(this);
		about.setOnClickListener(this);		
	}


	@Override
	public void onClick(View v) 
	{
		switch (v.getId())
		{
		case R.id.route_button:		
			Intent i = new Intent(UserDash.this, BusSearch.class);

			startActivity(i);		
			break;
		case R.id.bus_booking_button:	

			if(AppConstants.PARAM_USERNAME==null){
				startActivity(new Intent(UserDash.this,UserLogin.class));
			}
			else{
			Intent j = new Intent(UserDash.this, BookingOption.class);
			startActivity(j);	
			}
			break;	
			
			case R.id.contact_button:		
			Intent m = new Intent(UserDash.this, ContactActivity.class);
			startActivity(m);		
				break;	
				
		case R.id.feedback_button:	

			/*if(AppConstants.PARAM_USERNAME==null){
				startActivity(new Intent(UserDash.this,UserLogin.class));
			}
			else{
				Intent k = new Intent(UserDash.this, AddFeedback.class);

				startActivity(k);	
			}*/
			Intent k = new Intent(UserDash.this, AddFeedback.class);
			startActivity(k);	
			break;	
			
		case R.id.admin_login_button:		
			Intent l = new Intent(UserDash.this, AdminLogin.class);
			startActivity(l);		
			break;	
			
		case R.id.about_us_button:		
			Intent z = new Intent(UserDash.this, AboutActivity.class);
			startActivity(z);	
				break;			
				
		default:
			break;
		}

	}

}
