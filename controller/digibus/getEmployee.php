<?php 

	include_once './db_functions.php';
	
	$db = new DB_Functions();
	$response["data"]["employee"]=array();

	  $result = $db->getEmployee();
	  if(mysql_affected_rows()>0){
			$response["status"]["code"]=1;
			$response["status"]["message"]="";
			while($row=mysql_fetch_array($result)){
					$employee=array();
					$employee["address"]=$row["address"];
					$employee["designation"]=$row["post"];
					$employee["name"]=$row["name"];
					$employee["phone"]=$row["contact"];
					$employee["email"]=$row["email"];
					$employee["dob"]=$row["dob"];
					$employee["doj"]=$row["doj"];
					$employee["id"]=$row["emp_id"];
				array_push($response["data"]["employee"],$employee);
				
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
