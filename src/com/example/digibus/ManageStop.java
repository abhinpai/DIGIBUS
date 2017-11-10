package com.example.digibus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ManageStop extends AppCompatActivity implements OnClickListener{
	Button mAdd,mEdit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_manage_stop);

		initialisation();
	}

	private void initialisation() {
		mAdd=(Button)findViewById(R.id.btn_addtime);
		mEdit=(Button)findViewById(R.id.btn_edittime);

		mAdd.setOnClickListener(this);
		mEdit.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_addtime:
			startActivity(new Intent(ManageStop.this,AddTime.class));
			break;

		case R.id.btn_editbus:

			break;


		default:
			break;
		}	// TODO Auto-generated method stub

	}


}
