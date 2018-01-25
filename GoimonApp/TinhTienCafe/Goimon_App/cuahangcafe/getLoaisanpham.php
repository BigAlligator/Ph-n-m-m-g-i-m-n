<?php

include "Connect.php";
	$sql="SELECT * FROM loaisp";
	$data=mysqli_query($conn,$sql);
	$mangloaisanpham=array();
	while ($row = mysqli_fetch_assoc($data)) {
		array_push($mangloaisanpham,new LoaiSp(
			$row['Id'],
			$row['TenLoaiSP'],
			$row['HinhAnhLoaiSP']
			));
	}
	echo json_encode($mangloaisanpham);

class LoaiSp
{

	function LoaiSp($id,$tenloasp,$hinhanhloaisp)
	{
		$this->Id=$id;
		$this->TenLoaiSP=$tenloasp;
		$this->HinhAnhLoaiSP=$hinhanhloaisp;
	}
}
?>