<?php 
	$regnum = $_REQUEST["registration_number"]; 
	$routenum = $_REQUEST["route"];  
	$chessis = $_REQUEST["chessis"]; 
	$insurance = $_REQUEST["insurance"]; 
	$depot = $_REQUEST["depot"]; 
	
	/*$regnum = 'KA30Q2501'; 
	$routenum = '1111';  
	$chessis ='CBZ12344'; 
	$insurance = 'IID1234'; 
	$depot = 'ANKOLA'; */
	
	include_once './db_functions.php';
      
	$db = new DB_Functions();
	$result = $db->storeBus($routenum,$regnum,$chessis,$insurance,$depot);
	if($result){
		$response["status"]["code"]=1;
		$response["status"]["message"]="Bus details added";	 
        } 
	else{
	$response["status"]["code"]=0;
	$response["status"]["message"]="Not added"; 
	}
	echo json_encode($response);
	exit(0);
	
?>
