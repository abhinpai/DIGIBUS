<?php 
	$username = $_REQUEST["username"]; 
	$password = $_REQUEST["password"];  
	
	include_once './db_functions.php';
        $type='';
	
	$db = new DB_Functions();
	$rescheckUser = $db->getLogin($username,$password);
	if(mysql_affected_rows()>0){
          while($row=mysql_fetch_array($rescheckUser)){
		$response["status"]["code"]=1;
		$response["status"]["message"]="Login Success";	
	}
}
	else{
	$response["status"]["code"]=0;
	$response["status"]["message"]="Not a valid user"; 
	}

        echo json_encode($response);
	exit(0);
	
?>
