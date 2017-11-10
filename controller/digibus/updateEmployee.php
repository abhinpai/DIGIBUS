<?php 
	$id = $_REQUEST["id"]; 
	$name = $_REQUEST["name"];  
	$email = $_REQUEST["email"];  
	$phone = $_REQUEST["phone"];  
	$address = $_REQUEST["address"];  
	$dob = $_REQUEST["dob"];  
	$doj = $_REQUEST["doj"];  
	$designation = $_REQUEST["designation"];  
	
	include_once './db_functions.php';
      
	$db = new DB_Functions();
	$result = $db->updateEmployee($id,$name,$email,$phone,$address,$dob,$doj,$designation);
	if($result){
		$response["status"]["code"]=1;
		$response["status"]["message"]="Employee details updated";	 
        } 
	else{
	$response["status"]["code"]=0;
	$response["status"]["message"]="Not updated"; 
	}
	echo json_encode($response);
	exit(0);
	
?>
