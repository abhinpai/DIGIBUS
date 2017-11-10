<?php 
	$username = $_REQUEST["username"]; 
	$password = $_REQUEST["password"];  
	
	include_once './db_functions.php';
        $type='';
	
	$db = new DB_Functions();
	$rescheckUser = $db->checkUserLogin($username,$password);
	if(mysql_affected_rows()>0){
		
				$resUser = $db->getUserDetails($username);
					if(mysql_num_rows($resUser)>0){
						$response["status"]["code"]=1;
						$response["status"]["message"]="Login Success";
							while($row=mysql_fetch_array($resUser)){
							$response["data"]["username"]=$row['username'];
                            $response["data"]["type"]=$row['type'];
							}
						echo json_encode($response);
						exit(0);
					}
					else{
						$response["status"]["code"]=0;
						$response["status"]["message"]="Not details found";
						echo json_encode($response);
						exit(0);
					}
        }
		else{
		$response["status"]["code"]=0;
		$response["status"]["message"]="Not a valid user";
		echo json_encode($response);
		exit(0);
		}
		
	
?>