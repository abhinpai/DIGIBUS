<?php 

	include_once './db_functions.php';
	
	$db = new DB_Functions();
	$response["data"]["bookings"]=array();

	  $result = $db->getBookings();
	  if(mysql_affected_rows()>0){
			$response["status"]["code"]=1;
			$response["status"]["message"]="";
			while($row=mysql_fetch_array($result)){
				$bookings=array();
				$bookings["address"]=$row["address"];
				$bookings["description"]=$row["description"];
				$bookings["username"]=$row["username"];
				$bookings["phone"]=$row["phone"];
                $bookings["email"]=$row["email"];
				$bookings["source"]=$row["source"];
				$bookings["destination"]=$row["destination"];
				$bookings["fromdate"]=$row["fromdate"];
				$bookings["todate"]=$row["todate"];
				$bookings["passengers"]=$row["passengers"];
				array_push($response["data"]["bookings"],$bookings);
				
			}
			echo json_encode($response);
			exit(0);
	  }
	  else{
		        $response["status"]["code"]=0;
			$response["status"]["message"]="No details"; 
			echo json_encode($response);
			exit(0);
	  }
?>
