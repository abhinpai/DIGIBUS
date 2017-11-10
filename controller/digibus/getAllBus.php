<?php 
	
	include_once './db_functions.php';
	$response["data"]["bus"]=array();
	
	$db = new DB_Functions();
	$result = $db->getAllBus();
	if(mysql_affected_rows()>0){
			$response["status"]["code"]=1;
			$response["status"]["message"]="";
			while($row=mysql_fetch_array($result)){
				$bus=array();
				$bus["id"]=$row["bus_id"];   
				$bus["route"]=$row["bus_route_no"];    
				$bus["registration_number"]=$row["reg_num"];                          
				array_push($response["data"]["bus"],$bus);				
			}		
	  }
	  else{
			$response["status"]["code"]=0;
			$response["status"]["message"]="No details"; 
	  }

echo json_encode($response);
			
?>
