<?php
include "Connect.php";

$sql="SELECT * FROM hoadon";
$data=mysqli_query($conn,$sql);
	$manghoadon=array();
	while ($row = mysqli_fetch_assoc($data)) {
		array_push($manghoadon,new Hoadon(
			$row['Idhd'],
			$row['Ngay'],
			$row['Noidung'],
			$row['Ban']
			
			
			));
	}
	echo json_encode($manghoadon);
class Hoadon
{function Hoadon($idhd,$ngay,$noidung,$ban)
	{
		$this->Idhd=$idhd;
		$this->Ngay=$ngay;
		$this->Noidung=$noidung;
		$this->Ban=$ban;
	
		
	}
}
?>