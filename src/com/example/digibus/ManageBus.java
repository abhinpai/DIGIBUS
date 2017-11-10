package com.example.digibus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ManageBus extends AppCompatActivity implements OnClickListener{
	Button mAdd,mEdit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_manage_bus);

		initialisation();
	}

	private void initialisation() {
		mAdd=(Button)findViewById(R.id.btn_addbus);
		mEdit=(Button)findViewById(R.id.btn_editbus);

		mAdd.setOnClickListener(this);
		mEdit.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_addbus:
			startActivity(new Intent(ManageBus.this,AddBus.class));
			break;

		case R.id.btn_editbus:
			startActivity(new Intent(ManageBus.this,BusDetail.class));
			break;


		default:
			break;
		}	

	}


}
