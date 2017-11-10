package com.example.digibus.models;

public class JsonStatus {
	String mMsg;
	int mCode = 0;
	
	//setter
	public void setStatusMsg(String mMsg) {
		this.mMsg = mMsg;
	}
	
	public void setError(int mCode) {
		this.mCode = mCode;
	}
	
	
	//getter
	public String getStatusMsg() {
		return mMsg;
	}
	
	public int getError() {
		return mCode;
	}

}