<?php 
	
		include_once './db_functions.php';
		$source=$_REQUEST["source"];
		$destination=$_REQUEST["destination"];
		$response["data"]["bus"]=array();
		$sourceId;
		$destinationId;
	
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

	
	
		$result = $db->getSelectedBus($sourceId,$destinationId);
		if(mysql_affected_rows()>0){
				$response["status"]["code"]=1;
				$response["status"]["message"]="";
					while($row=mysql_fetch_array($result)){
						$bus=array();
						$bus["registration_number"]=$row['reg_num'];                          
						array_push($response["data"]["bus"],$bus);				
					}
			
		}
				else{
				$response["status"]["code"]=0;
				$response["status"]["message"]="No details"; 
				
				}
		echo json_encode($response);

?>