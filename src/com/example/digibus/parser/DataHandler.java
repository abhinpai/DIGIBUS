package com.example.digibus.parser;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.digibus.utils.AppConstants;

import android.util.Log;



public class DataHandler {

	public static ArrayList<String> getLocation(String result) {
		ArrayList<String>data=new ArrayList<String>();
		try {
			JSONObject jo = new JSONObject(result);
			JSONObject jd=jo.getJSONObject(AppConstants.KEY_DATA);
			JSONArray ja=jd.getJSONArray(AppConstants.KEY_LOCATION);
			for(int i=0;i<ja.length();i++){
				JSONObject jdata=ja.getJSONObject(i);
				data.add(jdata.getString(AppConstants.KEY_NAME));
			}

		} catch (JSONException e) {

			e.printStackTrace();
		}
		return data;
	}
	
	public static void getUsername(String result) {
		try {
			JSONObject jo = new JSONObject(result);
			JSONObject jdata=jo.getJSONObject(AppConstants.KEY_DATA);
			
			AppConstants.PARAM_USERNAME=jdata.getString(AppConstants.KEY_USERNAME);
			AppConstants.PARAM_TYPE=jdata.getString(AppConstants.KEY_TYPE);
			

		} catch (JSONException e) {

			e.printStackTrace();
		}
		
	}

	public static ArrayList<String> getBus(String result) {
		ArrayList<String>data=new ArrayList<String>();
		try {
			JSONObject jo = new JSONObject(result);
			JSONObject jd=jo.getJSONObject(AppConstants.KEY_DATA);
			JSONArray ja=jd.getJSONArray(AppConstants.KEY_BUS);
			for(int i=0;i<ja.length();i++){
				JSONObject jdata=ja.getJSONObject(i);
				data.add(jdata.getString(AppConstants.KEY_REG_NUM));
			}

		} catch (JSONException e) {

			e.printStackTrace();
		}
		return data;
	}

	public static ArrayList<HashMap<String,String>> getBusSearch(String result) {
		ArrayList<HashMap<String,String>>data=new ArrayList<HashMap<String,String>>();
		try {
			JSONObject jo = new JSONObject(result);
			JSONObject jd=jo.getJSONObject(AppConstants.KEY_DATA);
			JSONArray ja=jd.getJSONArray(AppConstants.KEY_BUS);
			for(int i=0;i<ja.length();i++){
				JSONObject jdata=ja.getJSONObject(i);
				HashMap<String,String> map=new HashMap<String,String>();
				map.put(AppConstants.KEY_REG_NUM, jdata.getString(AppConstants.KEY_REG_NUM));
				map.put(AppConstants.KEY_ROUTE, jdata.getString(AppConstants.KEY_ROUTE));
				map.put(AppConstants.KEY_INTIME, jdata.getString(AppConstants.KEY_INTIME));		
				map.put(AppConstants.KEY_OUTTIME, jdata.getString(AppConstants.KEY_OUTTIME));
				
				data.add(map);
				
			}

		} catch (JSONException e) {

			e.printStackTrace();
		}
		return data;
	}
	
	
	public static ArrayList<HashMap<String,String>> getLocations(String result) {
		ArrayList<HashMap<String,String>>data=new ArrayList<HashMap<String,String>>();
		try {
			JSONObject jo = new JSONObject(result);
			JSONObject jd=jo.getJSONObject(AppConstants.KEY_DATA);
			JSONArray ja=jd.getJSONArray(AppConstants.KEY_LOCATION);
			for(int i=0;i<ja.length();i++){
				JSONObject jdata=ja.getJSONObject(i);
				HashMap<String,String> map=new HashMap<String,String>();
				map.put(AppConstants.KEY_ID, jdata.getString(AppConstants.KEY_ID));
				map.put(AppConstants.KEY_NAME, jdata.getString(AppConstants.KEY_NAME));
				
				data.add(map);
				
			}

		} catch (JSONException e) {

			e.printStackTrace();
		}
		return data;
	}

	public static ArrayList<HashMap<String, String>> getBusDetails(String result) {
		ArrayList<HashMap<String,String>>data=new ArrayList<HashMap<String,String>>();
		try {
			JSONObject jo = new JSONObject(result);
			JSONObject jd=jo.getJSONObject(AppConstants.KEY_DATA);
			JSONArray ja=jd.getJSONArray(AppConstants.KEY_BUS);
			for(int i=0;i<ja.length();i++){
				JSONObject jdata=ja.getJSONObject(i);
				HashMap<String,String> map=new HashMap<String,String>();
				map.put(AppConstants.KEY_ID, jdata.getString(AppConstants.KEY_ID));
				map.put(AppConstants.KEY_ROUTE, jdata.getString(AppConstants.KEY_ROUTE));
				map.put(AppConstants.KEY_REG_NUM, jdata.getString(AppConstants.KEY_REG_NUM));
				
				data.add(map);
				
			}

		} catch (JSONException e) {

			e.printStackTrace();
		}
		return data;
	}

	public static ArrayList<HashMap<String, String>> getFeedbacks(String result) {
		ArrayList<HashMap<String,String>>data=new ArrayList<HashMap<String,String>>();
		try {
			JSONObject jo = new JSONObject(result);
			JSONObject jd=jo.getJSONObject(AppConstants.KEY_DATA);
			JSONArray ja=jd.getJSONArray(AppConstants.KEY_FEEDBACKS);
			for(int i=0;i<ja.length();i++){
				JSONObject jdata=ja.getJSONObject(i);
				HashMap<String,String> map=new HashMap<String,String>();
				map.put(AppConstants.KEY_USERNAME, jdata.getString(AppConstants.KEY_USERNAME));
				map.put(AppConstants.KEY_DESCRIPTION, jdata.getString(AppConstants.KEY_DESCRIPTION));
				map.put(AppConstants.KEY_PHONE, jdata.getString(AppConstants.KEY_PHONE));
				map.put(AppConstants.KEY_EMAIL, jdata.getString(AppConstants.KEY_EMAIL));
				map.put(AppConstants.KEY_ADDRESS, jdata.getString(AppConstants.KEY_ADDRESS));
				
				data.add(map);
				
			}

		} catch (JSONException e) {

			e.printStackTrace();
		}
		return data;
	}

	public static ArrayList<HashMap<String, String>> getEmployee(String result) {
		ArrayList<HashMap<String,String>>data=new ArrayList<HashMap<String,String>>();
		try {
			JSONObject jo = new JSONObject(result);
			JSONObject jd=jo.getJSONObject(AppConstants.KEY_DATA);
			JSONArray ja=jd.getJSONArray(AppConstants.KEY_EMPLOYEE);
			for(int i=0;i<ja.length();i++){
				JSONObject jdata=ja.getJSONObject(i);
				HashMap<String,String> map=new HashMap<String,String>();
				map.put(AppConstants.KEY_ID, jdata.getString(AppConstants.KEY_ID));
				map.put(AppConstants.KEY_DESIGNATION, jdata.getString(AppConstants.KEY_DESIGNATION));
				map.put(AppConstants.KEY_PHONE, jdata.getString(AppConstants.KEY_PHONE));
				map.put(AppConstants.KEY_EMAIL, jdata.getString(AppConstants.KEY_EMAIL));
				map.put(AppConstants.KEY_ADDRESS, jdata.getString(AppConstants.KEY_ADDRESS));
				map.put(AppConstants.KEY_DOB, jdata.getString(AppConstants.KEY_DOB));
				map.put(AppConstants.KEY_DOJ, jdata.getString(AppConstants.KEY_DOJ));
				map.put(AppConstants.KEY_NAME, jdata.getString(AppConstants.KEY_NAME));
				
				data.add(map);
				
			}

		} catch (JSONException e) {

			e.printStackTrace();
		}
		return data;
	}

	
	public static ArrayList<HashMap<String, String>> getBookings(String result) {
		ArrayList<HashMap<String,String>>data=new ArrayList<HashMap<String,String>>();
		try {
			JSONObject jo = new JSONObject(result);
			JSONObject jd=jo.getJSONObject(AppConstants.KEY_DATA);
			JSONArray ja=jd.getJSONArray("bookings");
			for(int i=0;i<ja.length();i++){
				JSONObject jdata=ja.getJSONObject(i);
				HashMap<String,String> map=new HashMap<String,String>();
				map.put(AppConstants.KEY_USERNAME, jdata.getString(AppConstants.KEY_USERNAME));
				map.put(AppConstants.KEY_DESCRIPTION, jdata.getString(AppConstants.KEY_DESCRIPTION));
				map.put(AppConstants.KEY_PHONE, jdata.getString(AppConstants.KEY_PHONE));
				map.put(AppConstants.KEY_EMAIL, jdata.getString(AppConstants.KEY_EMAIL));
				map.put(AppConstants.KEY_ADDRESS, jdata.getString(AppConstants.KEY_ADDRESS));
				map.put(AppConstants.KEY_SOURCE, jdata.getString(AppConstants.KEY_SOURCE));
				map.put(AppConstants.KEY_DESTINATION, jdata.getString(AppConstants.KEY_DESTINATION));
				map.put(AppConstants.KEY_FROMDATE, jdata.getString(AppConstants.KEY_FROMDATE));
				map.put(AppConstants.KEY_TODATE, jdata.getString(AppConstants.KEY_TODATE));
				map.put(AppConstants.KEY_PASSENGERS, jdata.getString(AppConstants.KEY_PASSENGERS));
				
				data.add(map);
				
			}

		} catch (JSONException e) {

			e.printStackTrace();
		}
		return data;
	}
	
}
