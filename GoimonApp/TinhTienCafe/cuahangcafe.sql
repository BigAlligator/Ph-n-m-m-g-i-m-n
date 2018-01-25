-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th1 16, 2018 lúc 09:46 AM
-- Phiên bản máy phục vụ: 10.1.25-MariaDB
-- Phiên bản PHP: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `cuahangcafe`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietsp`
--

CREATE TABLE `chitietsp` (
  `Id` int(11) NOT NULL,
  `TenSP` varchar(300) NOT NULL,
  `HinhAnhSP` varchar(300) NOT NULL,
  `Gia` int(11) NOT NULL,
  `IdLoai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `chitietsp`
--

INSERT INTO `chitietsp` (`Id`, `TenSP`, `HinhAnhSP`, `Gia`, `IdLoai`) VALUES
(1, 'Americano', 'http://localhost/hinhanh/TV-3.png', 29000, 1),
(2, 'Cafe Latte', 'http://localhost/hinhanh/TV-4.png', 35000, 1),
(3, 'Cafe Ice Latte', 'http://localhost/hinhanh/TV-5.png', 40000, 1),
(4, 'Cafe Mocha', 'http://localhost/hinhanh/TV-6.png', 39000, 1),
(5, 'Cappucino', 'http://localhost/hinhanh/TV-7.png', 35000, 1),
(6, 'Cappucino Viennese', 'http://localhost/hinhanh/TV-8.png', 35000, 1),
(7, 'Hot Chocolate', 'http://localhost/hinhanh/TV-9.png', 39000, 1),
(8, 'Chocolate', 'http://localhost/hinhanh/TV-10.png', 39000, 1),
(9, 'Espresso', 'http://localhost/hinhanh/TV-11.png', 29000, 1),
(10, 'Iced Coffe', 'http://localhost/hinhanh/TV-12.png', 25000, 1),
(11, 'Iced White Coffee', 'http://localhost/hinhanh/TV-13.png', 25000, 1),
(12, 'Cookie\'n Cream', 'http://localhost/hinhanh/TV-22.png', 39000, 2),
(13, 'Match Green Tea', 'http://localhost/hinhanh/TV-23.png', 49000, 2),
(14, 'Passiopuccino', 'http://localhost/hinhanh/TV-24.png', 39000, 2),
(15, 'Passiopuccio Mocha', 'http://localhost/hinhanh/TV-27.png', 39000, 2),
(16, 'Passion Soda', 'http://localhost/hinhanh/TV-30.png', 42000, 3),
(17, 'Pineapple Soda', 'http://localhost/hinhanh/TV-31.png', 42000, 3),
(18, 'Raspberry Soda', 'http://localhost/hinhanh/TV-32.png', 42000, 3),
(19, 'Soursop Soda', 'http://localhost/hinhanh/TV-33.png', 42000, 3),
(20, 'Blackcurrant Chiller', 'http://localhost/hinhanh/TV-42.png', 42000, 4),
(21, 'Blueberry Chiller', 'http://localhost/hinhanh/TV-43.png', 42000, 4),
(22, 'Mango Chiller', 'http://localhost/hinhanh/TV-44.png', 39000, 4),
(23, 'Lime Tea', 'http://localhost/hinhanh/TV-47.png', 42000, 5),
(24, 'Mango Tea', 'http://localhost/hinhanh/TV-48.png', 42000, 5),
(25, 'Orange Tea', 'http://localhost/hinhanh/TV-49.png', 42000, 5),
(26, 'Strawberry Tea', 'http://localhost/hinhanh/TV-50.png', 42000, 5),
(27, 'Hot Lipton', 'http://localhost/hinhanh/TV-52.png', 35000, 6),
(28, 'Iced Lipton', 'http://localhost/hinhanh/TV-53.png', 40000, 6),
(29, 'Hot Earl Grey', 'http://localhost/hinhanh/TV-54.png', 35000, 6),
(30, 'Iced Earl Grey', 'http://localhost/hinhanh/TV-55.png', 40000, 6),
(31, 'White Tea', 'http://localhost/hinhanh/TV-56.png', 39000, 6),
(32, 'Mojito Tea', 'http://localhost/hinhanh/TV-57.png', 39000, 6),
(33, 'Peach Tea', 'http://localhost/hinhanh/TV-58.png', 39000, 6),
(34, 'Croissant', 'http://localhost/hinhanh/TV-17.png', 22000, 7),
(35, 'Chocolate Croissant', 'http://localhost/hinhanh/TV-18.png', 22000, 7),
(36, 'Danish', 'http://localhost/hinhanh/TV-19.png', 29000, 7),
(37, 'Muffin', 'http://localhost/hinhanh/TV-20.png', 17000, 7),
(38, 'Caesar Chicken Panini', 'http://localhost/hinhanh/TV-37.png', 39000, 8),
(39, 'Ham & Cheese Panini', 'http://localhost/hinhanh/TV-38.png', 29000, 8),
(40, 'Thai Chicken Panini', 'http://localhost/hinhanh/TV-39.png', 39000, 8),
(41, 'Tuna Panini', 'http://localhost/hinhanh/TV-40.png', 39000, 8);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoadon`
--

CREATE TABLE `hoadon` (
  `Idhd` int(11) NOT NULL,
  `Ngay` varchar(300) NOT NULL,
  `Noidung` varchar(2000) NOT NULL,
  `Ban` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `hoadon`
--

INSERT INTO `hoadon` (`Idhd`, `Ngay`, `Noidung`, `Ban`) VALUES
(1, '14/01/2018', 'Americano : 1 : Giá: 29,000 Đ\nCafe Latte : 1 : Giá: 35,000 Đ\nCafe Ice Latte : 1 : Giá: 40,000 Đ\nTổng tiền thanh toán :     Giá: 104,000 Đ\n', 1),
(2, '14/01/2018', 'Americano : 1 : Giá: 29,000 Đ\nCafe Latte : 1 : Giá: 35,000 Đ\nCaesar Chicken Panini : 1 : Giá: 39,000 Đ\nHam & Cheese Panini : 1 : Giá: 29,000 Đ\nTổng tiền thanh toán :     Giá: 132,000 Đ\n', 1),
(3, '14/01/2018', 'Blackcurrant Chiller : 1 : Giá: 42,000 Đ\nBlueberry Chiller : 1 : Giá: 42,000 Đ\nCroissant : 1 : Giá: 22,000 Đ\nChocolate Croissant : 1 : Giá: 22,000 Đ\nDanish : 1 : Giá: 29,000 Đ\nTổng tiền thanh toán :     Giá: 157,000 Đ\n', 1),
(4, '15/01/2018', 'Match Green Tea : 3 : Giá: 147,000 Đ\nTổng tiền thanh toán :     Giá: 147,000 Đ\n', 1),
(5, '15/01/2018', 'Americano : 1 : Giá: 29,000 Đ\nCafe Latte : 1 : Giá: 35,000 Đ\nLime Tea : 1 : Giá: 42,000 Đ\nMango Tea : 1 : Giá: 42,000 Đ\nTổng tiền thanh toán :     Giá: 148,000 Đ\n', 9),
(6, '15/01/2018', 'Cafe Latte : 2 : Giá: 70,000 Đ\nCafe Ice Latte : 2 : Giá: 80,000 Đ\nCafe Mocha : 2 : Giá: 78,000 Đ\nTổng tiền thanh toán :     Giá: 228,000 Đ\n', 9);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loaisp`
--

CREATE TABLE `loaisp` (
  `Id` int(11) NOT NULL,
  `TenLoaiSP` varchar(300) NOT NULL,
  `HinhAnhLoaiSP` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `loaisp`
--

INSERT INTO `loaisp` (`Id`, `TenLoaiSP`, `HinhAnhLoaiSP`) VALUES
(1, 'Italian Coffee', 'http://localhost/hinhanh/TV-2.png'),
(2, 'Special Drinks', 'http://localhost/hinhanh/TV-21.png'),
(3, 'Juicy Soda', 'http://localhost/hinhanh/TV-29.png'),
(4, 'Fruit Chiller', 'http://localhost/hinhanh/TV-41.png'),
(5, 'Juicy Tea', 'http://localhost/hinhanh/TV-46.png'),
(6, 'Tea', 'http://localhost/hinhanh/TV-51.png'),
(7, 'French Cake', 'http://localhost/hinhanh/TV-16.png'),
(8, 'Italian Panini', 'http://localhost/hinhanh/TV-36.png');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `chitietsp`
--
ALTER TABLE `chitietsp`
  ADD PRIMARY KEY (`Id`);

--
-- Chỉ mục cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`Idhd`);

--
-- Chỉ mục cho bảng `loaisp`
--
ALTER TABLE `loaisp`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `chitietsp`
--
ALTER TABLE `chitietsp`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;
--
-- AUTO_INCREMENT cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  MODIFY `Idhd` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT cho bảng `loaisp`
--
ALTER TABLE `loaisp`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
