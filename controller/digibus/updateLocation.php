<?php 
	$id = $_REQUEST["id"]; 
	$name = $_REQUEST["name"];  
	
	include_once './db_functions.php';
      
	$db = new DB_Functions();
	$result = $db->editLocation($id,$name);
	if($result){
		$response["status"]["code"]=1;
		$response["status"]["message"]="Location Updated";	 
        } 
	else{
	$response["status"]["code"]=0;
	$response["status"]["message"]="Not updated"; 
	}
	echo json_encode($response);
	exit(0);
	
?>
