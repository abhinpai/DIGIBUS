<?php 
	
	include_once './db_functions.php';
       $response["data"]["location"]=array();
       $response["data"]["bus"]=array();
	
	$db = new DB_Functions();
	$result = $db->getLocation();
	if(mysql_affected_rows()>0){
			$response["status"]["code"]=1;
			$response["status"]["message"]="";
			while($row=mysql_fetch_array($result)){
				$location=array();
				$location["name"]=$row["location_name"];                          
				array_push($response["data"]["location"],$location);				
			}
			
	  }
	  else{
		        $response["status"]["code"]=0;
			$response["status"]["message"]="No details"; 
			
	  }



$result2 = $db->getBus();
	if(mysql_affected_rows()>0){
			
			while($row=mysql_fetch_array($result2)){
				$bus=array();
				$bus["registration_number"]=$row['reg_num'];                          
				array_push($response["data"]["bus"],$bus);				
			}
			
	  }
	  else{
		       
			
	  }

echo json_encode($response);
			
?>
