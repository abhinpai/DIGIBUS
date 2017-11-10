<?php 
	$source = $_REQUEST["source"]; 
	$destination = $_REQUEST["destination"];  
	$reg_num = $_REQUEST["registration_number"];  
	$reg_num=explode(" - ",$reg_num,2);
	
	$sourceId;
	$destinationId;
	$busId;

		include_once './db_functions.php';
		
		$db = new DB_Functions();
		
		$resultSource = $db->getLocationId($source);
		
		if(mysql_affected_rows()>0){
			while($row=mysql_fetch_array($resultSource)){
			$sourceId=$row["location_id"];
			}
		}



		$resultDest = $db->getLocationId($destination);
		
		if(mysql_affected_rows()>0){
			while($row=mysql_fetch_array($resultDest)){
			$destinationId=$row["location_id"];
			}
		}

		
		
		$resultBusId= $db->getBusDetailId($reg_num[0],$reg_num[1]);
		if(mysql_affected_rows()>0){
			while($row=mysql_fetch_array($resultBusId)){
			$busId=$row["bus_id"];
			}
		}

	$result = $db->storeLocationDetail($sourceId,$destinationId,$busId);
	if(mysql_affected_rows()>0){
          
		$response["status"]["code"]=1;
		$response["status"]["message"]="Location details added";	
	}
	else{
	$response["status"]["code"]=0;
	$response["status"]["message"]="Not added"; 
	}

        echo json_encode($response);
	exit(0);
	
?>
