<?php 

	$phone = $_REQUEST['phone']; 
	$username = $_REQUEST['username']; 
	$email = $_REQUEST['email']; 
	$address = $_REQUEST['address']; 
	$description = $_REQUEST['description'];
	

	
	include_once './db_functions.php';
	
	$db = new DB_Functions();

		$result = $db->storeFeedBack($phone,$email,$address,$description,$username);
		if($result){
			$response["status"]["code"]=1;
			$response["status"]["message"]="Feedback Sent";
			echo json_encode($response);
			exit(0);
			
		}else{
			$response["status"]["code"]=0;
			$response["status"]["message"]="Not sent";
			echo json_encode($response);
			exit(0);
		}
	
?>
