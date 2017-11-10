package com.example.digibus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ManageLocation extends AppCompatActivity implements OnClickListener{
	Button mAdd,mEdit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_manage_location);

		initialisation();
	}

	private void initialisation() {
		mAdd=(Button)findViewById(R.id.btn_addlocation);
		mEdit=(Button)findViewById(R.id.btn_editlocation);

		mAdd.setOnClickListener(this);
		mEdit.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_addlocation:
			startActivity(new Intent(ManageLocation.this,AddLoaction.class));
			break;

		case R.id.btn_editlocation:
			startActivity(new Intent(ManageLocation.this,Location.class));
			break;


		default:
			break;
		}	// TODO Auto-generated method stub

	}


}
