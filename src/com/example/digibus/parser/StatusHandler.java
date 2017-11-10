package com.example.digibus.parser;

import org.json.JSONException;
import org.json.JSONObject;

import com.example.digibus.models.JsonStatus;
import com.example.digibus.utils.AppConstants;

public  class StatusHandler  {

	String mResult;
	JSONObject jo;
	JsonStatus js=new JsonStatus();

	public StatusHandler(){}
	public void getJsonStatus(String result) throws JSONException {
		this.mResult=result;
		jo=new JSONObject(mResult);
		JSONObject jstatus=jo.getJSONObject(AppConstants.KEY_STATUS);
		js.setError(jstatus.getInt(AppConstants.KEY_CODE));

		js.setStatusMsg(jstatus.getString(AppConstants.KEY_MESSAGE));
	}

	public String getStatusMsg() {
		return js.getStatusMsg();
	}

	public int getStatusCode() {
		return js.getError();
	}


}


