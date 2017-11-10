package com.example.digibus.utils;

public class AppConstants {

	//public static final String DIALOG1="Loading...";

	public static final String RESULT_BUS="result";
	public static final String ALERT_BUS="Alert Message";	

	//keys
	public static final String KEY_STATUS="status";
	
	public static final String KEY_ID="id";
	public static final String KEY_FEEDBACKS="feedback";
	public static final String KEY_DOB="dob";
	public static final String KEY_DOJ="doj";
	public static final String KEY_DESIGNATION="designation";
	public static final String KEY_TYPE="type";
	public static final String KEY_CODE="code";
	public static final String KEY_MESSAGE="message";
	public static final String KEY_DATA="data";
	public static final String KEY_USERNAME="username";
	public static final String KEY_PASSWORD="password";
	public static final String KEY_LOCATION="location";
	public static final String KEY_SOURCE="source";
	public static final String KEY_DESTINATION="destination";
	public static final String KEY_NAME="name";
	public static final String KEY_ROUTE="route";
	public static final String KEY_REG_NUM="registration_number";
	public static final String KEY_BUS="bus";
	public static final String KEY_INTIME="intime";
	public static final String KEY_OUTTIME="outtime";
	public static final String KEY_PHONE="phone";
	public static final String KEY_EMAIL="email";
	public static final String KEY_DESCRIPTION="description";
	public static final String KEY_ADDRESS="address";
	public static final String KEY_FROMDATE="fromdate";
	public static final String KEY_TODATE="todate";
	public static final String KEY_PASSENGERS="passengers";
	public static final String KEY_EMPLOYEE="employee";
	public static final String KEY_DEPOT="depot";
	public static final String KEY_INSURANCE="insurance";
	public static final String KEY_CHESSIS="chessis";
		


	//error codes
	public static  final int ERROR_CODE_SUCCESS=1;
	public static  final int ERROR_CODE_FAIL=0;
	public static  final int ERROR_WRONGUSERNAME=100;
	public static  final int ERROR_WRONGPASSWORD=101;

	public static  int PARAM_CODE;
	public static  String PARAM_MESSAGE;
	public static  String PARAM_USERNAME;
	public static  String PARAM_TYPE;


	public static final  int PAGE_LOGIN=100;
	public static final  int PAGE_ADDLOCATION=200;
	public static final  int PAGE_LOAD_LOCATIONS=300;
	public static final  int PAGE_ADD_LOCATIONDETAIL=400;
	public static final  int PAGE_ADD_BUS=500;
	public static final  int PAGE_SEARCH_BUS=600;
	public static final  int PAGE_ADD_TIME=700;
	public static final  int PAGE_LOAD_LOCATION_TIME=800;
	public static final  int PAGE_LOAD_BUS_TIME=900;
	public static final  int PAGE_LOCATION_IN_SEARCH=1000;
	public static final  int PAGE_ADD_FEEDBACK=1100;
	public static final  int PAGE_LOCATION=1200;
	public static final  int PAGE_UPDATE_LOCATION=1300;
	public static final  int PAGE_DELETE_LOCATION=1400;
	public static final  int PAGE_BUS_DETAILS=1500;
	public static final  int PAGE_UPDATE_BUS=1600;
	public static final  int PAGE_USER_LOGIN=1700;
	public static final  int PAGE_REGISTER=1800;
	public static final  int PAGE_BOOK_BUS=1900;
	public static final  int PAGE_FEEDBACKS=2000;
	public static final  int PAGE_ADD_EMPLOYEE=2100;
	public static final  int PAGE_EMPLOYEE=2200;
	public static final  int PAGE_UPDATE_EMPLOYEE=2300;
 
	public static final  int PAGE_DELETE_EMPLOYEE=2400;
	public static final  int PAGE_BOOKINGS=2500;
	/**
	 * ***********************************************************
	 * Error codes ends here
	 * ***********************************************************
	 */






	/**
	 * ***********************************************************
	 * Strings 
	 * ***********************************************************
	 */

	public static final String MESSAGE_LOADING="Loading...";
	public static final String MESSAGE_REGISTER="Registering...";

	/**
	 * ***********************************************************
	 *Strings ends here
	 * ***********************************************************
	 */







	/**
	 * ***********************************************************
	 * Url 
	 * ***********************************************************
	 */


	/*public static final String URL_LOGIN="http://10.0.2.2/digibus/login.php";
	public static final String URL_ADD_LOCATION="http://10.0.2.2/digibus/addLocation.php";
	public static final String URL_LOAD_LOCATION="http://10.0.2.2/digibus/loadLocation.php";
	public static final String URL_ADD_LOCATION_DETAIL="http://10.0.2.2/digibus/addLocationDetail.php";
	public static final String URL_ADD_BUS="http://10.0.2.2/digibus/addBus.php";
	public static final String URL_SEARCH_BUS="http://10.0.2.2/digibus/searchBus.php";
	public static final String URL_ADD_TIME="http://10.0.2.2/digibus/addTime.php";
	public static final String URL_GET_BUS="http://10.0.2.2/digibus/getBus.php";
	public static final String URL_ADD_FEEDBACK="http://10.0.2.2/digibus/addFeedback.php";
	public static final String URL_LOCATION="http://10.0.2.2/digibus/getLocation.php";
	public static final String URL_UPDATE_LOCATION="http://10.0.2.2/digibus/updateLocation.php";
	public static final String URL_DELETE_LOCATION="http://10.0.2.2/digibus/deleteLocation.php";
	public static final String URL_BUSDETAILS="http://10.0.2.2/digibus/getAllBus.php";
	public static final String URL_UPDATE_BUS="http://10.0.2.2/digibus/updateBus.php";
	public static final String URL_USER_LOGIN="http://10.0.2.2/digibus/userLogin.php";
	public static final String URL_REGISTER="http://10.0.2.2/digibus/register.php";
	public static final String URL_BOOK_BUS="http://10.0.2.2/digibus/booking.php";
	public static final String URL_FEEDBACKS="http://10.0.2.2/digibus/getFeedbacks.php";
	public static final String URL_ADD_EMPLOYEE="http://10.0.2.2/digibus/addEmployee.php";
	public static final String URL_EMPLOYEE="http://10.0.2.2/digibus/getEmployee.php";
	public static final String URL_UPDATE_EMPLOYEE="http://10.0.2.2/digibus/updateEmployee.php";
	public static final String URL_DELETE_EMPLOYEE="http://10.0.2.2/digibus/deleteEmployee.php";
	public static final String URL_BOOKINGS="http://10.0.2.2/digibus/bookings.php";*/
	
	public static final String URL_LOGIN="http://digi.netne.net/login.php";
	public static final String URL_ADD_LOCATION="http://digi.netne.net/addLocation.php";
	public static final String URL_LOAD_LOCATION="http://digi.netne.net/loadLocation.php";
	public static final String URL_ADD_LOCATION_DETAIL="http://digi.netne.net/addLocationDetail.php";
	public static final String URL_ADD_BUS="http://digi.netne.net/addBus.php";
	public static final String URL_SEARCH_BUS="http://digi.netne.net/searchBus.php";
	public static final String URL_ADD_TIME="http://digi.netne.net/addTime.php";
	public static final String URL_GET_BUS="http://digi.netne.net/getBus.php";
	public static final String URL_ADD_FEEDBACK="http://digi.netne.net/addFeedback.php";
	public static final String URL_LOCATION="http://digi.netne.net/getLocation.php";
	public static final String URL_UPDATE_LOCATION="http://digi.netne.net/updateLocation.php";
	public static final String URL_DELETE_LOCATION="http://digi.netne.net/deleteLocation.php";
	public static final String URL_BUSDETAILS="http://digi.netne.net/getAllBus.php";
	public static final String URL_UPDATE_BUS="http://digi.netne.net/updateBus.php";
	public static final String URL_USER_LOGIN="http://digi.netne.net/userLogin.php";
	public static final String URL_REGISTER="http://digi.netne.net/register.php";
	public static final String URL_BOOK_BUS="http://digi.netne.net/booking.php";
	public static final String URL_FEEDBACKS="http://digi.netne.net/getFeedbacks.php";
	public static final String URL_ADD_EMPLOYEE="http://digi.netne.net/addEmployee.php";
	public static final String URL_EMPLOYEE="http://digi.netne.net/getEmployee.php";
	public static final String URL_UPDATE_EMPLOYEE="http://digi.netne.net/updateEmployee.php";
	public static final String URL_DELETE_EMPLOYEE="http://digi.netne.net/deleteEmployee.php";
	public static final String URL_BOOKINGS="http://digi.netne.net/bookings.php";
}

