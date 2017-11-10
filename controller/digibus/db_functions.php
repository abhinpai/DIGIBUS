<?php
class DB_Functions {
	private $db;
	function __construct() {
		include_once './db_connect.php';
		// connecting to database
		$this->db = new DB_Connect ();
		$this->db->connect ();
	}
	// destructor
	function __destruct() {
	}
	
	/**
	  Check new user
	 */
	public function checkUser($username) {
		$result = mysql_query ( "SELECT * FROM login WHERE username='$username' " ) or die ( mysql_error () );
		return $result;
	}
	
		public function getBookings(){
		$result = mysql_query ( "SELECT * FROM booking " ) or die ( mysql_error () );
		return $result;
	}
	
	
	/**
	  get user data
	 */
	public function getUserDetails($username) {
		$result = mysql_query ( "SELECT * FROM login WHERE username='$username'" );
			return $result ;
	}
	
	
	
	/**
	  Check new login
	 */
	public function checkLogin($username, $password) {
		$result = mysql_query ( "SELECT * FROM login WHERE username='$username' AND password='$password' " ) or die ( mysql_error () );
		return $result;
	}
	

	
	
	public function getFeedbacks() {
		$result = mysql_query ( "SELECT * FROM feedback " ) or die ( mysql_error () );
		return $result;
	}
	
	
	
	public function getEmployee() {
		$result = mysql_query ( "SELECT * FROM employee " ) or die ( mysql_error () );
		return $result;
	}
	

	/**
	 * Check new login
	 */
	public function	checkUserLogin($username,$password) {
		$result = mysql_query ( "SELECT * FROM login WHERE username='$username' AND password='$password' AND type='user' " ) or die ( mysql_error () );
		return $result;
	}
	

	
	/**
	 * Check new login
	 */
	public function getLogin($username,$password) {
		$result = mysql_query ( "SELECT * FROM login WHERE username='$username' AND password='$password' AND type='admin' " ) or die ( mysql_error () );
		return $result;
	}
	
		public function registerUser($name,$username,$phone,$email,$password){
		
		$result= mysql_query ("INSERT INTO login(name,username,password,phone,email,type) VALUES('$name','$username',
		'$password','$phone','$email','user')" );
		
		if ($result) {
		return true;
		} else {
		return false;
		}
		}	
	
	
	
	
	
		public function storeEmployee($id,$name,$email,$phone,$address,$dob,$doj,$designation){
		
		$result= mysql_query ("INSERT INTO employee(emp_id,name,email,contact,address,dob,doj,post) 
		VALUES('$id','$name','$email','$phone','$address','$dob','$doj','$designation')" );
		
		if ($result) {
		return true;
		} else {
		return false;
		}
		}	
	


/**
	 * get location id
	 */
	public function getLocationId($location) {
		$result = mysql_query ( "SELECT location_id FROM location_master WHERE location_name='$location' " ) or die ( mysql_error () );
		return $result;
	}



/**
	 * get location id
	 */
	public function getBusDetailId($route,$reg){
		$result = mysql_query ( "SELECT `bus_id` FROM `bus_detail` WHERE bus_route_no='$route' AND reg_num='$reg' " ) or die ( mysql_error () );
		return $result;
	}
	
	
	
	
	public function getLocDetailId($sourceId,$destinationId,$busId){
		$result = mysql_query ( "SELECT * FROM location_detail WHERE bus_id='$busId' AND source_id='$sourceId' AND destination_id='$destinationId'" ) or die ( mysql_error () );
		return $result;
	}
	
	




        /**
	 * get bus id
	 */
	public function getBusId($reg_num) {
		$result = mysql_query ( "SELECT bus_id FROM bus_detail WHERE reg_num='$reg_num' " ) or die ( mysql_error () );
		return $result;
	}
	
	
	
	
	


         /**
	 * Storing location data
	 */

	public function storeLocation($location){

		$result= mysql_query ("INSERT INTO location_master(location_name) VALUES('$location')" );

		if ($result) {
			return true;
		} else {
			return false;
		}
	}	
	
	
	
	public function BookBus($phone,$email,$address,$description,$username,$fromdate,$todate,$passengers,$source,$destination){

		$result= mysql_query ("INSERT INTO booking(phone,email,address,description,username,fromdate,todate,passengers,source,destination
		) VALUES('$phone','$email','$address','$description','$username','$fromdate','$todate','$passengers','$source','$destination')" );

		if ($result) {
			return true;
		} else {
			return false;
		}
	}	
	
	
	public function storeFeedBack($phone,$email,$address,$description,$username){

		$result= mysql_query ("INSERT INTO feedback(phone,email,address,description,username) VALUES('$phone','$email','$address','$description','$username')" );

		if ($result) {
			return true;
		} else {
			return false;
		}
	}	
	
	
	
	
	


          /**
	 * Storing location detail data
	 */

	public function storeLocationDetail($source,$destination,$bus){

		$result= mysql_query ("INSERT INTO location_detail(source_id,destination_id,bus_id) VALUES('$source','$destination','$bus')" );

		if ($result) {
			return true;
		} else {
			return false;
		}
	}





         /**
	 * Storing bus data
	 */

	public function storeBus($routenum,$regnum,$chessis,$insurance,$depot){

		$result= mysql_query ("INSERT INTO bus_detail(bus_route_no,reg_num,chessis,insurance,depot) VALUES('$routenum','$regnum','$chessis','$insurance','$depot')" );

		if ($result) {
			return true;
		} else {
			return false;
		}
	}	
	


 /**
	 * Storing bus data
	 */

	public function storeTime($location_detail_id,$intime,$reg_num,$outtime){
		$result= mysql_query ("INSERT INTO stop_detail(location_detail_id,in_time,out_time,bus_id) VALUES('$location_detail_id','$intime','$outtime','$reg_num')" );

		if ($result) {
			return true;
		} else {
			return false;
		}
	}	

	
	      /**
	 * get feedbacks
	 */
        public function searchBus($sourceId,$destinationId){
		$result = mysql_query ( "SELECT b.bus_route_no,b.reg_num,sd.in_time,sd.out_time FROM bus_detail b,location_detail ld,stop_detail 
		sd WHERE b.bus_id=sd.bus_id AND sd.location_detail_id=ld.location_detail_id AND ld.source_id='$sourceId' AND 
		ld.destination_id='$destinationId'" );
		return $result ;
	}


          /**
	 * get bus
	 */
        public function getBus(){
		$result = mysql_query ( "SELECT concat(bus_route_no,' - ',reg_num) as reg_num FROM bus_detail");
                return $result ;
	}


    /**
	 * get bus
	 */
        public function getSelectedBus($source,$destination){
		$result = mysql_query ( "SELECT concat(b.bus_route_no,' - ',b.reg_num) as reg_num FROM bus_detail b,location_detail ld WHERE source_id='$source' AND destination_id='$destination' AND b.bus_id=ld.bus_id");
                return $result ;
	}




         /**
	 * 
	 */
        public function getLocation(){
		$result = mysql_query ( "SELECT * FROM location_master" );
		return $result ;
	}
	
	
	
	
         /**
	 * 
	 */
        public function getAllBus(){
		$result = mysql_query ( "SELECT * FROM bus_detail" );
		return $result ;
	}
	
	
	
	
	  /**
	 * 
	 */
        public function deleteLocation($id){
		$result = mysql_query ( "DELETE FROM location_master WHERE location_id='$id'" );
		return $result ;
	}
	
	
	  /**
	 * 
	 */
        public function deleteEmployee($id){
		$result = mysql_query ( "DELETE FROM employee WHERE emp_id='$id'" );
		return $result ;
	}
	

    /**
	 * edit 
	 */
         public function editLocation($id,$name){

		$result= mysql_query ("UPDATE location_master SET location_name='$name' WHERE location_id='$id'" );

		if (mysql_affected_rows()>0) {
			return true;
		} else {
			return false;
		}
	}	
	
	
	
	
	 /**
	 * edit 
	 */
         public function updateEmployee($id,$name,$email,$phone,$address,$dob,$doj,$designation){

		$result= mysql_query("UPDATE employee SET name='$name',emp_id='$id',email='$email',contact='$phone', address='$address',
		dob='$dob', doj='$doj',post='$designation' WHERE emp_id='$id'" );

		if (mysql_affected_rows()>0) {
			return true;
		} else {
			return false;
		}
	}	
	
	
	 /**
	 * edit 
	 */
         public function editBus($id,$reg,$route){

		$result= mysql_query ("UPDATE bus_detail SET bus_route_no='$route', reg_num='$reg' WHERE bus_id='$id'" );

		if (mysql_affected_rows()>0) {
			return true;
		} else {
			return false;
		}
	}	     
}

?>
