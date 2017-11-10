<?php 
	$source = $_REQUEST["source"]; 
	$destination = $_REQUEST["destination"]; 
	$intime = $_REQUEST["intime"];  
	$reg_num = $_REQUEST["bus"];  
	$reg_num=explode(" - ",$reg_num,2);
	$outtime = $_REQUEST["outtime"];  
	
		$sourceId;
		$destinationId;
		$busId;
		$locId;
		$route;
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
		
		//$response["route"]=$reg_num[0];
		//$response["reg"]=$reg_num[1];
		
		
		$resultBusId= $db->getBusDetailId($reg_num[0],$reg_num[1]);
		if(mysql_affected_rows()>0){
			while($row=mysql_fetch_array($resultBusId)){
			$busId=$row["bus_id"];
			}
		}
		
		$resultLocDetailId= $db->getLocDetailId($sourceId,$destinationId,$busId);
		if(mysql_affected_rows()>0){
			while($row=mysql_fetch_array($resultLocDetailId)){
			$locId=$row["location_detail_id"];
			}
		}
 
 
	
	
	$result = $db->storeTime($locId,$intime,$busId,$outtime);
	if($result){
		$response["status"]["code"]=1;
		$response["status"]["message"]="Time details added";	 
        } 
	else{
	$response["status"]["code"]=0;
	$response["status"]["message"]="Not added"; 
	}
	echo json_encode($response);
	exit(0);
	
?>
