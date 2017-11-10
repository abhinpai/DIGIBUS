package com.example.digibus;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.example.digibus.parser.AsyncTaskHandler;
import com.example.digibus.utils.AppConstants;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddLoaction extends AppCompatActivity implements OnClickListener{
	Button mAdd;
	EditText mLocation;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_loaction);

		initialisation();
	}

	private void initialisation() {
		mLocation=(EditText)findViewById(R.id.et_location);
		mAdd=(Button)findViewById(R.id.btn_add);
		mAdd.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_add:
			if(isFormvalid()){
				ArrayList<NameValuePair>nameValuePair=new ArrayList<NameValuePair>();
				nameValuePair.add(new BasicNameValuePair(AppConstants.KEY_LOCATION,mLocation.getText().toString()));

				AsyncTaskHandler ahandler=new AsyncTaskHandler(AddLoaction.this, nameValuePair, AppConstants.URL_ADD_LOCATION, AppConstants.MESSAGE_LOADING,AppConstants.PAGE_ADDLOCATION);
				ahandler.execute();
			}
			break;

		default:
			break;
		}
	}

	private boolean isFormvalid() {

		Boolean status=true;

		if(TextUtils.isEmpty(mLocation.getText().toString())){
			mLocation.setError("Fill Location");
			status=false;
		}

		return status;
	}

	public void onAsynkResult(int statusCode, String statusMsg) {
		Toast.makeText(AddLoaction.this, statusMsg, Toast.LENGTH_LONG).show();
		if(statusCode==AppConstants.ERROR_CODE_SUCCESS)
		{
			clear();
			startActivity(new Intent(AddLoaction.this,ManageLocation.class));
		}

	}

	private void clear() {
		// TODO Auto-generated method stub
		mLocation.setText("");
	}
}
