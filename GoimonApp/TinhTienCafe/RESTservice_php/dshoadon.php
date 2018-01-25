<?php
include "Connect.php";

$ngay=$_POST['Ngay'];
$noidung=$_POST['Noidung'];
$ban=$_POST['Ban'];
if( strlen($ngay)>0 && strlen($noidung)>0 && strlen($ban)>0){
	$query="INSERT INTO hoadon(Idhd,Ngay,Noidung,Ban) VALUES(null,'$ngay','$noidung','$ban')";
	mysqli_query($conn,$query);
	}
?>