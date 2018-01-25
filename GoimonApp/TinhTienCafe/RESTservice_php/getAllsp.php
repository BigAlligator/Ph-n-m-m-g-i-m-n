<?php
include "Connect.php";

$sql="SELECT * FROM chitietsp";
$data=mysqli_query($conn,$sql);
	$mangsanpham=array();
	while ($row = mysqli_fetch_assoc($data)) {
		array_push($mangsanpham,new Sanpham(
			$row['Id'],
			$row['TenSP'],
			$row['HinhAnhSP'],
			$row['Gia'],
			$row['IdLoai']
			
			));
	}
	echo json_encode($mangsanpham);
class Sanpham
{function Sanpham($id,$tensp,$hinhsp,$giasp,$idloai)
	{
		$this->Id=$id;
		$this->TenSp=$tensp;
		$this->HinhAnhSP=$hinhsp;
		$this->Gia=$giasp;
		$this->IdLoai=$idloai;
		
	}
}
?>