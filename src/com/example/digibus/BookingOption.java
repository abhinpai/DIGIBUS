package com.example.digibus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class BookingOption extends  AppCompatActivity implements OnClickListener{
	Button mAdvance,mcasual;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_booking_option);
		initialisation();
	}
	
	private void initialisation() {
		// TODO Auto-generated method stub
		mAdvance=(Button)findViewById(R.id.btn_advance_book);
		mcasual=(Button)findViewById(R.id.btn_casual_book);

		mAdvance.setOnClickListener(this);
		mcasual.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_advance_book:
			startActivity(new Intent(BookingOption.this,AdvanceBooking.class));
			break;

		case R.id.btn_casual_book:
			startActivity(new Intent(BookingOption.this,BookBus.class));
			break;


		default:
			break;
		}	// TODO Auto-generated method stub

	}

	
}
