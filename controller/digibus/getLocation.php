<?php 
	
	include_once './db_functions.php';
	$response["data"]["location"]=array();
	
	$db = new DB_Functions();
	$result = $db->getLocation();
	if(mysql_affected_rows()>0){
			$response["status"]["code"]=1;
			$response["status"]["message"]="";
			while($row=mysql_fetch_array($result)){
				$location=array();
				$location["id"]=$row["location_id"];   
				$location["name"]=$row["location_name"];                          
				array_push($response["data"]["location"],$location);				
			}		
	  }
	  else{
			$response["status"]["code"]=0;
			$response["status"]["message"]="No details"; 
	  }

echo json_encode($response);
			
?>
