<?php 

	$name = $_REQUEST['name']; 
	$username = $_REQUEST['username']; 
	$password = $_REQUEST['password']; 
	$phone = $_REQUEST['phone'];
	$email = $_REQUEST['email'];
   
	include_once './db_functions.php';
	
	$db = new DB_Functions();
	$responsecheckUser = $db->checkUser($username);
	if(mysql_affected_rows()>0){
		  $response["status"]["code"]=0;
		  $response["status"]["message"]="Account already exists";
		  echo json_encode($response);
		  exit(0);
	}
	else{
	
		$responsestoreUser = $db->registerUser($name,$username,$phone,$email,$password);
			if($responsestoreUser){
				
				$responseUser = $db->getUserDetails($username);
				if(mysql_num_rows($responseUser)>0){
					$response["status"]["code"]=1;
				   $response["status"]["message"]="Registration Success";
					
				}
				else{
					$responseponse["status"]["code"]=0;
	                $responseponse["status"]["message"]="Not a valid user";
					
				}
				
				
			}
			else{
				$response["status"]["code"]=0;
				$response["status"]["message"]="Failed to register";
			
			}
		}
	echo json_encode($response);
					exit(0);
?>