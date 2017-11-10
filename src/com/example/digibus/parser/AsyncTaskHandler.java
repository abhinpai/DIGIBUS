package com.example.digibus.parser;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.http.NameValuePair;
import org.json.JSONException;

import com.example.digibus.AddBus;
import com.example.digibus.AddEmployee;
import com.example.digibus.AddFeedback;
import com.example.digibus.AddLoaction;
import com.example.digibus.AddLocationDetail;
import com.example.digibus.AddTime;
import com.example.digibus.AdminLogin;
import com.example.digibus.BookBus;
import com.example.digibus.Bookings;
import com.example.digibus.BusDetail;
import com.example.digibus.BusSearch;
import com.example.digibus.Employee;
import com.example.digibus.Feedbacks;
import com.example.digibus.Location;
import com.example.digibus.Register;
import com.example.digibus.UpdateBus;
import com.example.digibus.UpdateLocation;
import com.example.digibus.UserLogin;
import com.example.digibus.utils.AppConstants;
import com.example.digibus.utils.CustomProgresssDialog;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;


public class AsyncTaskHandler extends AsyncTask<Void, Void, Void>{
	Activity activity;

	ArrayList<NameValuePair>nameValuePair=new ArrayList<NameValuePair>();
	StatusHandler jhandler=new StatusHandler();
	String url,message;
	String Result;
	int pageCode;

	public AsyncTaskHandler(Activity activity, ArrayList<NameValuePair> nameValuePair, String url, String message, int pageCode) {
		this.activity=activity;
		this.nameValuePair=nameValuePair;
		this.url=url;
		this.message=message;
		this.pageCode=pageCode;
	}


	CustomProgresssDialog cpd=new CustomProgresssDialog();



	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		cpd.showDialog(activity, message);
	}

	@Override
	protected Void doInBackground(Void... params) {
		ConnectionHandler ch=new ConnectionHandler();
		Result=ch.makeConnection(url, this.nameValuePair);
		Log.e("response", ":"+Result);
		try {
			jhandler.getJsonStatus(Result);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	protected void onPostExecute(Void result) {
		cpd.dismissDialog();



		if(pageCode==AppConstants.PAGE_LOGIN){

			AdminLogin adLogin = (AdminLogin)activity; 
			adLogin.onAsynkResult(jhandler.getStatusCode(),jhandler.getStatusMsg());	

		}
		
		if(pageCode==AppConstants.PAGE_ADD_EMPLOYEE){

			AddEmployee adEmployee = (AddEmployee)activity; 
			adEmployee.onAsynkResult(jhandler.getStatusCode(),jhandler.getStatusMsg());	

		}
		
		if(pageCode==AppConstants.PAGE_BOOKINGS){
			
			if(jhandler.getStatusCode()==AppConstants.ERROR_CODE_SUCCESS){
				ArrayList<HashMap<String,String>>data=new ArrayList<HashMap<String,String>>();
				data=DataHandler.getBookings(Result);

				Bookings bookings = (Bookings)activity; 
				bookings.onAsynkResult(data);	


			}
			

	}

		if(pageCode==AppConstants.PAGE_BOOK_BUS){

			BookBus bookbus = (BookBus)activity; 
			bookbus.onAsynkResult(jhandler.getStatusCode(),jhandler.getStatusMsg());	

		}

		if(pageCode==AppConstants.PAGE_FEEDBACKS){
			if(jhandler.getStatusCode()==AppConstants.ERROR_CODE_SUCCESS){
				ArrayList<HashMap<String,String>>data=new ArrayList<HashMap<String,String>>();
				data=DataHandler.getFeedbacks(Result);

				Feedbacks feedback = (Feedbacks)activity; 
				feedback.onAsynkResult(data);	


			}
			
		}

		
		
		if(pageCode==AppConstants.PAGE_EMPLOYEE){
			if(jhandler.getStatusCode()==AppConstants.ERROR_CODE_SUCCESS){
				ArrayList<HashMap<String,String>>data=new ArrayList<HashMap<String,String>>();
				data=DataHandler.getEmployee(Result);

				Employee employee = (Employee)activity; 
				employee.onAsynkResult(data);	


			}
			
		}




		if(pageCode==AppConstants.PAGE_USER_LOGIN){

			if(jhandler.getStatusCode()==AppConstants.ERROR_CODE_SUCCESS){
				DataHandler.getUsername(Result);
			}

			UserLogin adLogin = (UserLogin)activity; 
			adLogin.onAsynkResult(jhandler.getStatusCode(),jhandler.getStatusMsg());	


		}


		if(pageCode==AppConstants.PAGE_REGISTER){
			Register register = (Register)activity; 
			register.onAsynkResult(jhandler.getStatusCode(),jhandler.getStatusMsg());	
		}



		if(pageCode==AppConstants.PAGE_ADDLOCATION){
			AddLoaction adLocation = (AddLoaction)activity; 
			adLocation.onAsynkResult(jhandler.getStatusCode(),jhandler.getStatusMsg());	
		}



		if(pageCode==AppConstants.PAGE_UPDATE_LOCATION){
			UpdateLocation updateLocation = (UpdateLocation)activity; 
			updateLocation.onAsynkResult(jhandler.getStatusCode(),jhandler.getStatusMsg());	
		}

		if(pageCode==AppConstants.PAGE_DELETE_LOCATION){
			Location location = (Location)activity; 
			location.onAsynkResult(jhandler.getStatusCode(),jhandler.getStatusMsg());	
		}

		if(pageCode==AppConstants.PAGE_DELETE_EMPLOYEE){
			Employee employee = (Employee)activity; 
			employee.onAsynkResultdlt(jhandler.getStatusCode(),jhandler.getStatusMsg());	
		}

		if(pageCode==AppConstants.PAGE_LOAD_LOCATIONS){
			if(jhandler.getStatusCode()==AppConstants.ERROR_CODE_SUCCESS){
				ArrayList<String>data=new ArrayList<String>();
				data=DataHandler.getLocation(Result);

				ArrayList<String>bus=new ArrayList<String>();
				bus=DataHandler.getBus(Result);

				AddLocationDetail adLocationdetail = (AddLocationDetail)activity; 
				adLocationdetail.onGetLocation(data,bus);	

			}

		}

		if(pageCode==AppConstants.PAGE_LOCATION_IN_SEARCH){
			if(jhandler.getStatusCode()==AppConstants.ERROR_CODE_SUCCESS){
				ArrayList<String>dataSource=new ArrayList<String>();
				ArrayList<String>dataDest=new ArrayList<String>();
				dataSource=DataHandler.getLocation(Result);

				dataDest=DataHandler.getLocation(Result);
				dataSource.add(0, "-Select Source-");
				dataDest.add(0, "-Select Destination-");

				BusSearch bus = (BusSearch)activity; 
				bus.onGetLocation(dataSource,dataDest);	

			}

		}




		if(pageCode==AppConstants.PAGE_ADDLOCATION){
			if(jhandler.getStatusCode()==AppConstants.ERROR_CODE_SUCCESS){

				AddLoaction adLocation = (AddLoaction)activity; 
				adLocation.onAsynkResult(jhandler.getStatusCode(),jhandler.getStatusMsg());	
			}

		}


		if(pageCode==AppConstants.PAGE_ADD_LOCATIONDETAIL){
			AddLocationDetail adLocationdetail = (AddLocationDetail)activity; 
			adLocationdetail.onResult(jhandler.getStatusCode(),jhandler.getStatusMsg());

		}


		if(pageCode==AppConstants.PAGE_LOAD_LOCATION_TIME){

			ArrayList<String>dataSource=new ArrayList<String>();
			ArrayList<String>dataDest=new ArrayList<String>();
			dataSource=DataHandler.getLocation(Result);

			dataDest=DataHandler.getLocation(Result);
			dataSource.add(0, "-Select Source-");
			dataDest.add(0, "-Select Destination-");
			AddTime addTime = (AddTime)activity;
			addTime.onGetLocation(dataSource,dataDest);



		}

		if(pageCode==AppConstants.PAGE_LOAD_BUS_TIME){


			ArrayList<String>bus=new ArrayList<String>();
			bus=DataHandler.getBus(Result);
			bus.add(0, "-Select Bus-");
			AddTime addTime = (AddTime)activity;
			addTime.onGetBus(bus);


		}


		if(pageCode==AppConstants.PAGE_ADD_FEEDBACK){

			AddFeedback addFeedback = (AddFeedback)activity;
			addFeedback.onFeedback(jhandler.getStatusCode(),jhandler.getStatusMsg());


		}



		if(pageCode==AppConstants.PAGE_LOCATION){
			if(jhandler.getStatusCode()==AppConstants.ERROR_CODE_SUCCESS){
				ArrayList<HashMap<String,String>>data=new ArrayList<HashMap<String,String>>();
				data=DataHandler.getLocations(Result);

				Location location = (Location)activity; 
				location.onGetLocation(data);	

			}

		}




		if(pageCode==AppConstants.PAGE_BUS_DETAILS){
			if(jhandler.getStatusCode()==AppConstants.ERROR_CODE_SUCCESS){
				ArrayList<HashMap<String,String>>data=new ArrayList<HashMap<String,String>>();
				data=DataHandler.getBusDetails(Result);

				BusDetail busdetail = (BusDetail)activity; 
				busdetail.onGetBus(data);	

			}

		}




		if(pageCode==AppConstants.PAGE_ADD_BUS){
			AddBus addBus = (AddBus)activity; 
			addBus.onResult(jhandler.getStatusCode(),jhandler.getStatusMsg());	
		}

		if(pageCode==AppConstants.PAGE_UPDATE_BUS){
			UpdateBus updateBus = (UpdateBus)activity; 
			updateBus.onResult(jhandler.getStatusCode(),jhandler.getStatusMsg());	
		}


		if(pageCode==AppConstants.PAGE_SEARCH_BUS){
			if(jhandler.getStatusCode()==AppConstants.ERROR_CODE_SUCCESS){
				ArrayList<HashMap<String,String>>data=new ArrayList<HashMap<String,String>>();
				data=DataHandler.getBusSearch(Result);

				BusSearch busSearch = (BusSearch)activity; 
				busSearch.onBus(data);	
			}

		}
	}
}
