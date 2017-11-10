package com.example.digibus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AdvanceBooking extends AppCompatActivity implements OnClickListener  {
	Button mBook,mCancel,mView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_advance_booking);
		initialisation();
	}
	private void initialisation() {
		// TODO Auto-generated method stub
		mBook=(Button)findViewById(R.id.btn_book_ticket);
		mCancel=(Button)findViewById(R.id.btn_cancel_ticket);
		mView=(Button)findViewById(R.id.btn_view_ticke);

		mBook.setOnClickListener(this);
		mCancel.setOnClickListener(this);
		mView.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		
		case R.id.btn_book_ticket:
			startActivity(new Intent(AdvanceBooking.this,BookTicket.class));
			break;

		case R.id.btn_cancel_ticket:
			startActivity(new Intent(AdvanceBooking.this,CancelTicket.class));
			break;

		case R.id.btn_view_ticke:
			startActivity(new Intent(AdvanceBooking.this,ViewTicket.class));
			break;


		default:
			break;
		}	// TODO Auto-generated method stub

	}

	
}
