<?php 

	$location = $_REQUEST['location']; 
   
	include_once './db_functions.php';
	
	$db = new DB_Functions();
	
	$donorId=0;
	
		$result = $db->storeLocation($location);
		if($result){
			$response["status"]["code"]=1;
			$response["status"]["message"]="Location information stored";
			echo json_encode($response);
			exit(0);
			
		}else{
			$response["status"]["code"]=0;
			$response["status"]["message"]="Not sent";
			echo json_encode($response);
			exit(0);
		}
	
?>
