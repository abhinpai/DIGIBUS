<?php 

	$phone = $_REQUEST['phone']; 
	$username = $_REQUEST['username']; 
	$email = $_REQUEST['email']; 
	$address = $_REQUEST['address']; 
	$fromdate = $_REQUEST['fromdate']; 
	$todate = $_REQUEST['todate']; 
	$passengers = $_REQUEST['passengers']; 
	$source = $_REQUEST['source']; 
	$destination = $_REQUEST['destination']; 
	$description = $_REQUEST['description']; 
	include_once './db_functions.php';
	
	$db = new DB_Functions();

		$result = $db->BookBus($phone,$email,$address,$description,$username,$fromdate,$todate,$passengers,$source,$destination);
		if($result){
			$response["status"]["code"]=1;
			$response["status"]["message"]="Booking Done";
			echo json_encode($response);
			exit(0);
			
		}else{
			$response["status"]["code"]=0;
			$response["status"]["message"]="Not Done";
			echo json_encode($response);
			exit(0);
		}
	
?>
