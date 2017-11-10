<?php 
	$id = $_REQUEST["id"]; 
	$reg = $_REQUEST["registration_number"];  
	$route= $_REQUEST["route"];  

	
	include_once './db_functions.php';
      
	$db = new DB_Functions();
	$result = $db->editBus($id,$reg,$route);
	if($result){
		$response["status"]["code"]=1;
		$response["status"]["message"]="Bus Updated";	 
        } 
	else{
	$response["status"]["code"]=0;
	$response["status"]["message"]="Not updated"; 
	}
	echo json_encode($response);
	exit(0);
	
?>
