<?php 
	$id = $_REQUEST["id"]; 
	
	include_once './db_functions.php';
      
	$db = new DB_Functions();
	$result = $db->deleteEmployee($id);
	if($result){
		$response["status"]["code"]=1;
		$response["status"]["message"]="Employee Deleted";	 
        } 
	else{
	$response["status"]["code"]=0;
	$response["status"]["message"]="Not Deleted"; 
	}
	echo json_encode($response);
	exit(0);
	
?>