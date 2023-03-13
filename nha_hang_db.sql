/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

CREATE DATABASE IF NOT EXISTS `nha_hang_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `nha_hang_db`;

CREATE TABLE IF NOT EXISTS `hd_ma` (
  `ma_hd` int NOT NULL,
  `ma_ma` int NOT NULL,
  `so_luong` int NOT NULL,
  `don_gia` int DEFAULT NULL,
  PRIMARY KEY (`ma_hd`,`ma_ma`),
  KEY `FK__mon_an` (`ma_ma`),
  CONSTRAINT `FK__hoa_don` FOREIGN KEY (`ma_hd`) REFERENCES `hoa_don` (`ma_hd`) ON DELETE CASCADE,
  CONSTRAINT `FK__mon_an` FOREIGN KEY (`ma_ma`) REFERENCES `mon_an` (`ma_ma`) ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DELETE FROM `hd_ma`;
/*!40000 ALTER TABLE `hd_ma` DISABLE KEYS */;
INSERT INTO `hd_ma` (`ma_hd`, `ma_ma`, `so_luong`, `don_gia`) VALUES
	(1, 4, 1, 35000),
	(1, 10, 2, 45000),
	(1, 17, 3, 220000),
	(1, 20, 1, 35000),
	(2, 3, 1, 30000),
	(2, 4, 1, 35000),
	(2, 19, 2, 40000),
	(3, 2, 3, 40000),
	(3, 7, 3, 30000),
	(3, 12, 1, 100000),
	(3, 13, 2, 100000),
	(4, 3, 3, 30000),
	(4, 13, 2, 100000),
	(4, 15, 2, 150000),
	(4, 18, 1, 40000),
	(5, 4, 3, 35000),
	(5, 8, 3, 25000),
	(5, 14, 2, 120000),
	(6, 5, 3, 35000),
	(6, 9, 3, 40000),
	(7, 1, 3, 30000),
	(7, 3, 2, 30000),
	(7, 10, 1, 45000),
	(8, 6, 2, 40000),
	(8, 15, 2, 150000),
	(9, 10, 2, 45000),
	(9, 13, 2, 100000),
	(10, 6, 1, 40000),
	(10, 9, 1, 40000),
	(10, 16, 1, 200000),
	(10, 20, 3, 35000),
	(11, 3, 2, 30000),
	(11, 14, 3, 120000),
	(11, 16, 1, 200000),
	(12, 7, 2, 30000),
	(12, 12, 3, 100000),
	(13, 2, 2, 40000),
	(13, 21, 2, 15000),
	(14, 1, 1, 30000),
	(14, 9, 3, 40000),
	(14, 10, 2, 45000),
	(14, 15, 3, 150000),
	(15, 15, 3, 150000),
	(15, 16, 1, 200000),
	(15, 17, 1, 220000),
	(15, 19, 3, 40000),
	(16, 5, 3, 35000),
	(16, 15, 2, 150000),
	(17, 11, 1, 80000),
	(17, 20, 1, 35000),
	(18, 10, 1, 45000),
	(18, 20, 2, 35000),
	(19, 4, 3, 35000),
	(19, 12, 1, 100000),
	(19, 15, 1, 150000),
	(20, 4, 1, 35000),
	(20, 6, 1, 40000),
	(20, 10, 1, 45000),
	(20, 18, 2, 40000),
	(21, 6, 2, 40000),
	(21, 19, 2, 40000),
	(22, 17, 2, 220000),
	(22, 18, 1, 40000),
	(22, 21, 1, 15000),
	(23, 1, 3, 30000),
	(23, 6, 1, 40000),
	(23, 16, 1, 200000),
	(24, 1, 2, 30000),
	(24, 9, 3, 40000),
	(24, 10, 1, 45000),
	(25, 4, 3, 35000),
	(25, 6, 3, 40000),
	(25, 15, 2, 150000),
	(26, 2, 3, 40000),
	(26, 3, 2, 30000),
	(26, 7, 2, 30000),
	(27, 5, 1, 35000),
	(27, 14, 1, 120000),
	(27, 17, 1, 220000),
	(27, 19, 3, 40000),
	(28, 4, 1, 35000),
	(28, 6, 2, 40000),
	(29, 9, 3, 40000),
	(29, 16, 1, 200000),
	(30, 1, 1, 30000),
	(30, 3, 3, 30000),
	(30, 8, 3, 25000),
	(30, 15, 3, 150000),
	(31, 4, 2, 35000),
	(31, 7, 3, 30000),
	(32, 2, 1, 40000),
	(32, 6, 3, 40000),
	(32, 11, 1, 80000),
	(32, 21, 2, 15000),
	(33, 6, 3, 40000),
	(33, 10, 3, 45000),
	(34, 1, 2, 30000),
	(34, 4, 1, 35000),
	(34, 5, 2, 35000),
	(34, 8, 2, 25000),
	(35, 10, 2, 45000),
	(35, 15, 2, 150000),
	(35, 19, 2, 40000),
	(36, 2, 1, 40000),
	(36, 5, 3, 35000),
	(36, 19, 1, 40000),
	(37, 12, 3, 100000),
	(37, 13, 2, 100000),
	(37, 14, 2, 120000),
	(38, 5, 3, 35000),
	(38, 8, 1, 25000),
	(38, 9, 2, 40000),
	(38, 19, 1, 40000),
	(39, 1, 1, 30000),
	(39, 8, 3, 25000),
	(39, 14, 1, 120000),
	(40, 10, 3, 45000),
	(40, 12, 2, 100000),
	(40, 19, 2, 40000),
	(41, 2, 1, 40000),
	(41, 4, 3, 35000),
	(41, 9, 1, 40000),
	(42, 2, 3, 40000),
	(42, 7, 3, 30000),
	(42, 8, 1, 25000),
	(42, 17, 1, 220000),
	(43, 5, 3, 35000),
	(43, 20, 1, 35000),
	(44, 6, 2, 40000),
	(44, 10, 3, 45000),
	(44, 16, 1, 200000),
	(44, 21, 2, 15000),
	(45, 1, 1, 30000),
	(45, 8, 1, 25000),
	(45, 15, 1, 150000);
/*!40000 ALTER TABLE `hd_ma` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `hoa_don` (
  `ma_hd` int NOT NULL AUTO_INCREMENT,
  `ma_kh` int NOT NULL,
  `ngay` date NOT NULL,
  PRIMARY KEY (`ma_hd`),
  KEY `FK_hoa_don_khach_hang` (`ma_kh`),
  CONSTRAINT `FK_hoa_don_khach_hang` FOREIGN KEY (`ma_kh`) REFERENCES `khach_hang` (`ma_kh`) ON DELETE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DELETE FROM `hoa_don`;
/*!40000 ALTER TABLE `hoa_don` DISABLE KEYS */;
INSERT INTO `hoa_don` (`ma_hd`, `ma_kh`, `ngay`) VALUES
	(1, 1, '2021-10-02'),
	(2, 2, '2021-10-02'),
	(3, 3, '2021-10-08'),
	(4, 4, '2021-10-08'),
	(5, 1, '2021-10-09'),
	(6, 3, '2021-10-09'),
	(7, 5, '2021-10-09'),
	(8, 6, '2021-10-09'),
	(9, 7, '2021-10-12'),
	(10, 8, '2021-10-14'),
	(11, 1, '2021-10-15'),
	(12, 6, '2021-10-15'),
	(13, 9, '2021-10-16'),
	(14, 10, '2021-10-17'),
	(15, 5, '2021-10-17'),
	(16, 6, '2021-10-18'),
	(17, 11, '2021-10-18'),
	(18, 12, '2021-10-18'),
	(19, 3, '2021-10-20'),
	(20, 2, '2021-10-20'),
	(21, 13, '2021-10-20'),
	(22, 14, '2021-10-22'),
	(23, 15, '2021-10-22'),
	(24, 16, '2021-10-23'),
	(25, 4, '2021-10-27'),
	(26, 8, '2021-10-27'),
	(27, 12, '2021-10-27'),
	(28, 17, '2021-10-29'),
	(29, 18, '2021-10-29'),
	(30, 13, '2021-10-30'),
	(31, 5, '2021-10-30'),
	(32, 2, '2021-10-31'),
	(33, 19, '2021-11-01'),
	(34, 20, '2021-11-01'),
	(35, 21, '2021-11-01'),
	(36, 2, '2021-11-01'),
	(37, 5, '2021-11-08'),
	(38, 13, '2021-11-10'),
	(39, 2, '2021-11-11'),
	(40, 21, '2021-11-15'),
	(41, 2, '2021-11-15'),
	(42, 8, '2021-11-15'),
	(43, 4, '2021-11-17'),
	(44, 16, '2021-11-17'),
	(45, 5, '2021-11-18');
/*!40000 ALTER TABLE `hoa_don` ENABLE KEYS */;

CREATE TABLE `hoa_don_view` (
	`ma_hd` INT(10) NOT NULL,
	`ma_kh` INT(10) NOT NULL,
	`ngay` DATE NOT NULL,
	`chiet_khau` DECIMAL(44,0) NULL,
	`thanh_tien` DECIMAL(45,0) NULL
) ENGINE=MyISAM;

CREATE TABLE IF NOT EXISTS `khach_hang` (
  `ma_kh` int NOT NULL AUTO_INCREMENT,
  `ho` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `ten_dem` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `ten` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `so_nha` varchar(10) NOT NULL,
  `duong` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `quan_huyen` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `tinh_tp` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`ma_kh`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DELETE FROM `khach_hang`;
/*!40000 ALTER TABLE `khach_hang` DISABLE KEYS */;
INSERT INTO `khach_hang` (`ma_kh`, `ho`, `ten_dem`, `ten`, `so_nha`, `duong`, `quan_huyen`, `tinh_tp`) VALUES
	(1, '', '', '', '', '', '', ''),
	(2, 'Vũ', 'Thị', 'Phương', '48', 'Hàng Bè', 'Hoàn Kiếm', 'Hà Nội'),
	(3, 'Hồ', 'Minh', 'Sang', '11', 'Nguyễn Khoái', 'Hoàng Mai', 'Hà Nội'),
	(4, 'Nguyễn', 'Thái', 'Hà', '66', 'Trần Hữu Dực', 'Nam Từ Liêm', 'Hà Nội'),
	(5, 'Võ', 'Minh', 'Tâm', '57', 'Nguyễn Khuyến', 'Đống Đa', 'Hà Nội'),
	(6, 'Hồ', 'Minh', 'Luân', '96', 'Định Công', 'Thanh Xuân', 'Hà Nội'),
	(7, 'Nguyễn', 'Quốc', 'Nam', '19A', 'Trúc Bạch', 'Ba Đình', 'Hà Nội'),
	(8, 'Diệp', 'Quang', 'Nhân', '71', 'Phố Ao Sen', 'Hà Đông', 'Hà Nội'),
	(9, 'Nguyễn', 'An', 'Khang', '18', 'Tô Hiệu', 'TP. Vĩnh Yên', 'Vĩnh Phúc'),
	(10, 'Trần', 'Minh', 'Châu', '74', 'Trần Quý Kiên', 'Cầu Giấy', 'Hà Nội'),
	(11, 'Dương', 'Công', 'Phi', '54', 'Phú Gia', 'Tây Hồ', 'Hà Nội'),
	(12, 'Nguyễn', 'Lê Trúc', 'Giang', '2', 'Đào Duy Tùng', 'Đông Anh', 'Hà Nội'),
	(13, 'Nguyễn', 'Minh', 'Trí', '30', 'Phùng Khoang', 'Nam Từ Liêm', 'Hà Nội'),
	(14, 'Dương', 'Đức', 'Bình', '68', 'Phạm Văn Đồng', 'Nam Từ Liêm', 'Hà Nội'),
	(15, 'Vũ', 'Thanh', 'Hòa', '52A', 'Nguyễn Văn Trỗi', 'TP. Từ Sơn', 'Bắc Ninh'),
	(16, 'Phạm', 'Như', 'Ý', '84', 'Phố Hoàng Văn Thụ', 'Hà Đông', 'Hà Nội'),
	(17, 'Nguyễn', 'Thanh', 'Toàn', '73', 'Phố Yết Kiêu', 'Hà Đông', 'Hà Nội'),
	(18, 'Đỗ', 'Chiến', 'Thắng', '13', 'Cù Chính Lan', 'Thanh Xuân', 'Hà Nội'),
	(19, 'Lê', 'Thanh', 'Phong', '16', 'Hà Huy Tập', 'Gia Lâm', 'Hà Nội'),
	(20, 'Nguyễn', 'Hồng', 'Khánh', '67', 'Hoàng Ngân', 'Thanh Xuân', 'Hà Nội'),
	(21, 'Huỳnh', 'Hoàng', 'Hiệp', '61', 'Nhân Hòa', 'Thanh Xuân', 'Hà Nội'),
	(22, 'Bùi', 'Công', 'Tuấn', '6', 'Vân Trì', 'Đông Anh', 'Hà Nội');
/*!40000 ALTER TABLE `khach_hang` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `kh_sdt` (
  `ma_kh` int NOT NULL,
  `sdt` varchar(20) NOT NULL,
  PRIMARY KEY (`ma_kh`,`sdt`),
  CONSTRAINT `FK_kh_sdt_khach_hang` FOREIGN KEY (`ma_kh`) REFERENCES `khach_hang` (`ma_kh`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DELETE FROM `kh_sdt`;
/*!40000 ALTER TABLE `kh_sdt` DISABLE KEYS */;
INSERT INTO `kh_sdt` (`ma_kh`, `sdt`) VALUES
	(2, '0716160486'),
	(3, '0906427945'),
	(4, '0865399933'),
	(5, '0934500206'),
	(6, '0325257289'),
	(7, '0735405464'),
	(8, '0304894616'),
	(8, '0761969371'),
	(9, '0747583231'),
	(10, '0399517093'),
	(11, '0755985807'),
	(12, '0504194434'),
	(13, '0560207182'),
	(13, '0925442357'),
	(14, '0923971751'),
	(15, '0846430871'),
	(16, '0994268563'),
	(17, '0396951976'),
	(18, '0957840913'),
	(19, '0995074509'),
	(20, '0352777097'),
	(21, '0802634885'),
	(22, '0518440319');
/*!40000 ALTER TABLE `kh_sdt` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `mon_an` (
  `ma_ma` int NOT NULL AUTO_INCREMENT,
  `ten_mon` varchar(30) NOT NULL,
  `don_gia` int NOT NULL,
  `don_vi` varchar(10) NOT NULL,
  PRIMARY KEY (`ma_ma`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DELETE FROM `mon_an`;
/*!40000 ALTER TABLE `mon_an` DISABLE KEYS */;
INSERT INTO `mon_an` (`ma_ma`, `ten_mon`, `don_gia`, `don_vi`) VALUES
	(1, 'Rau muống luộc', 30000, 'đĩa'),
	(2, 'Rau bí xào tỏi', 40000, 'đĩa'),
	(3, 'Ngồng cải luộc', 30000, 'đĩa'),
	(4, 'Nộm dưa chuột', 35000, 'đĩa'),
	(5, 'Nộm hoa chuối', 35000, 'đĩa'),
	(6, 'Salad rau', 40000, 'đĩa'),
	(7, 'Khoai tây chiên', 30000, 'đĩa'),
	(8, 'Đậu phụ rán', 25000, 'đĩa'),
	(9, 'Nem rán', 40000, 'đĩa'),
	(10, 'Trứng đúc thịt', 45000, 'đĩa'),
	(11, 'Thịt lợn quay', 80000, 'đĩa'),
	(12, 'Sườn nướng', 100000, 'đĩa'),
	(13, 'Sườn xào chua ngọt', 100000, 'đĩa'),
	(14, 'Thịt bò xào', 120000, 'đĩa'),
	(15, 'Bò sốt vang', 150000, 'đĩa'),
	(16, 'Gà hấp lá chanh', 200000, 'nửa con'),
	(17, 'Gà rang muối', 220000, 'nửa con'),
	(18, 'Mỳ xào', 40000, 'đĩa'),
	(19, 'Phở xào', 40000, 'đĩa'),
	(20, 'Cơm rang', 35000, 'đĩa'),
	(21, 'Bún', 15000, 'đĩa'),
	(22, 'Nước ngọt', 15000, 'chai'),
	(23, 'Bia', 20000, 'chai'),
	(24, 'Rượu nếp', 50000, 'chai');
/*!40000 ALTER TABLE `mon_an` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `nhan_vien` (
  `ma_nv` int NOT NULL AUTO_INCREMENT,
  `ho` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `ten_dem` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `ten` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `ngay_sinh` date NOT NULL,
  `email` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `luong` int NOT NULL,
  PRIMARY KEY (`ma_nv`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DELETE FROM `nhan_vien`;
/*!40000 ALTER TABLE `nhan_vien` DISABLE KEYS */;
INSERT INTO `nhan_vien` (`ma_nv`, `ho`, `ten_dem`, `ten`, `ngay_sinh`, `email`, `luong`) VALUES
	(1, 'Nguyễn', '', 'Luân', '1999-10-12', 'luan98nt@gmail.com', 3940000),
	(2, 'Huỳnh', 'Khoa', 'Nguyên', '1991-06-19', 'nguyenhuynh@outlook.com', 6320000),
	(3, 'Vũ', 'Ngọc', 'Hưng', '1992-02-12', 'vnhung789@gmail.com', 5610000),
	(4, 'Nguyễn', 'Gia', 'Huy', '1996-03-16', 'giahuy01@gmail.com', 2470000),
	(5, 'Bùi', 'Đức', 'An', '2003-03-05', 'buiducan_24@gmail.com', 1430000),
	(6, 'Phạm', 'Văn', 'Ngọc', '1998-01-16', 'ngocpham01@outlook.com', 1850000),
	(7, 'Nguyễn', 'Ngọc', 'Thắng', '2001-01-24', 'ngocpv123@outlook.com', 4340000),
	(8, 'Trương', 'Văn', 'Nghĩa', '1997-11-08', 'truongnghia01@gmail.com', 3470000);
/*!40000 ALTER TABLE `nhan_vien` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `nv_sdt` (
  `ma_nv` int NOT NULL,
  `sdt` varchar(20) NOT NULL,
  PRIMARY KEY (`sdt`,`ma_nv`),
  KEY `FK_nv_sdt_nhan_vien` (`ma_nv`),
  CONSTRAINT `FK_nv_sdt_nhan_vien` FOREIGN KEY (`ma_nv`) REFERENCES `nhan_vien` (`ma_nv`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DELETE FROM `nv_sdt`;
/*!40000 ALTER TABLE `nv_sdt` DISABLE KEYS */;
INSERT INTO `nv_sdt` (`ma_nv`, `sdt`) VALUES
	(1, '0311114527'),
	(2, '0535404071'),
	(3, '0889757566'),
	(4, '0377354591'),
	(4, '0912921222'),
	(5, '0935745372'),
	(6, '0798857353'),
	(7, '0948466429'),
	(8, '0945844479');
/*!40000 ALTER TABLE `nv_sdt` ENABLE KEYS */;

DROP TABLE IF EXISTS `hoa_don_view`;
CREATE ALGORITHM=UNDEFINED SQL SECURITY DEFINER VIEW `hoa_don_view` AS select `t`.`ma_hd` AS `ma_hd`,`t`.`ma_kh` AS `ma_kh`,`t`.`ngay` AS `ngay`,if(((`t`.`so_lan` > 0) and ((`t`.`so_lan` % 10) = 0)),floor((`t`.`thanh_tien` * 0.2)),if(((`t`.`so_lan` > 0) and ((`t`.`so_lan` % 5) = 0)),floor((`t`.`thanh_tien` * 0.1)),0)) AS `chiet_khau`,(select (`t`.`thanh_tien` - `chiet_khau`)) AS `thanh_tien` from (select `t1`.`ma_hd` AS `ma_hd`,`t1`.`ma_kh` AS `ma_kh`,`t1`.`ngay` AS `ngay`,sum((`t2`.`so_luong` * `t2`.`don_gia`)) AS `thanh_tien`,(select count(0) from `hoa_don` `t3` where ((`t3`.`ma_kh` = `t1`.`ma_kh`) and (`t1`.`ma_kh` <> 1) and (`t3`.`ma_hd` <= `t1`.`ma_hd`))) AS `so_lan` from (`hoa_don` `t1` join `hd_ma` `t2` on((`t1`.`ma_hd` = `t2`.`ma_hd`))) group by `t1`.`ma_hd`) `t`;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
