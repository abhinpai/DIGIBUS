package com.example.digibus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class AdminDash extends AppCompatActivity implements OnClickListener{
	
	ImageView mBus,mEmployee,mFeedback,mBooking;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_admin_dash);

		initialise();
	}

	private void initialise() {
		mBus=(ImageView)findViewById(R.id.btn_bus);
		mEmployee=(ImageView)findViewById(R.id.btn_employe);
		mFeedback=(ImageView)findViewById(R.id.btn_feedback);
		mBooking=(ImageView)findViewById(R.id.btn_booking);
		
		mBus.setOnClickListener(this);
		mEmployee.setOnClickListener(this);
		mFeedback.setOnClickListener(this);
		mBooking.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_bus:
			onSelectBus();
			break;

		case R.id.btn_employe:
			onSelectEmployee();
			break;

		case R.id.btn_feedback:
			onselectFeedback();
			break;
			
		case R.id.btn_booking:
			onselectBooking();
			break;			

		default:
			break;
		}

	}

	private void onselectFeedback() {
		startActivity(new Intent(AdminDash.this,Feedbacks.class));
	}

	private void onSelectEmployee() {
		startActivity(new Intent(AdminDash.this,ManageEmployee.class));

	}

	private void onSelectBus() {
		startActivity(new Intent(AdminDash.this,ManageBusDetails.class));

	}
	
	private void onselectBooking() {
		startActivity(new Intent(AdminDash.this,Bookings.class));

	}	

}
