package com.example.digibus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class ManageBusDetails extends AppCompatActivity implements OnClickListener{
	Button mManagelocation,mManagebus,mManagelocationDetails,mManagetime;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_manage_bus_details);

		initialisation();
	}

	private void initialisation() {
		mManagelocation=(Button)findViewById(R.id.btn_managelocation);
		mManagebus=(Button)findViewById(R.id.btn_managebus);
		mManagelocationDetails=(Button)findViewById(R.id.btn_managelocationdetails);
		mManagetime=(Button)findViewById(R.id.btn_managestop);

		mManagelocation.setOnClickListener(this);
		mManagebus.setOnClickListener(this);
		mManagelocationDetails.setOnClickListener(this);
		mManagetime.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_managebus:
			startActivity(new Intent(ManageBusDetails.this,ManageBus.class));
			break;

		case R.id.btn_managelocationdetails:
			startActivity(new Intent(ManageBusDetails.this,ManageLocationDetails.class));
			break;

		case R.id.btn_managestop:
			startActivity(new Intent(ManageBusDetails.this,ManageStop.class));
			break;

		case R.id.btn_managelocation:
			startActivity(new Intent(ManageBusDetails.this,ManageLocation.class));
			break;

		default:
			break;
		}
	}
}
