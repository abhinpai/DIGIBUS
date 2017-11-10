package com.example.digibus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ManageEmployee extends AppCompatActivity implements OnClickListener{

	Button mEdit,mAdd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_manage_employee);
		initialisation();
	}

	private void initialisation() {
		mAdd=(Button)findViewById(R.id.btn_add_employee);
		mEdit=(Button)findViewById(R.id.btn_edit_employee);

		mAdd.setOnClickListener(this);
		mEdit.setOnClickListener(this);


	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_add_employee:
			startActivity(new Intent(ManageEmployee.this,AddEmployee.class));
			break;

		case R.id.btn_edit_employee:
			startActivity(new Intent(ManageEmployee.this,Employee.class));
			break;


		default:
			break;
		}

	}	
}
