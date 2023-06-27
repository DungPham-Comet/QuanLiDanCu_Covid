-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 27, 2023 lúc 11:58 AM
-- Phiên bản máy phục vụ: 10.4.24-MariaDB
-- Phiên bản PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `cnpm2023`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `cachly`
--

CREATE TABLE `cachly` (
  `IdCachLy` int(11) NOT NULL,
  `ThoiGian` date DEFAULT NULL,
  `MucDo` varchar(20) DEFAULT NULL,
  `DiaDiem` varchar(50) DEFAULT NULL,
  `IdNguoiCachLy` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `cccd`
--

CREATE TABLE `cccd` (
  `IdCccd` varchar(15) NOT NULL,
  `NgayCap` date DEFAULT NULL,
  `NoiCap` varchar(50) DEFAULT NULL,
  `NgayHetHan` date DEFAULT NULL,
  `DacDiem` varchar(50) DEFAULT NULL,
  `IdNhanKhau` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `cccd`
--

INSERT INTO `cccd` (`IdCccd`, `NgayCap`, `NoiCap`, `NgayHetHan`, `DacDiem`, `IdNhanKhau`) VALUES
('030202001234', '2020-01-02', 'Công an tỉnh Bắc Giang', '2026-03-02', 'nốt ruồi cạnh mắt trái', 1),
('030202001237', '2021-03-05', 'Công an tỉnh Bắc Giang', '2026-04-02', 'nốt ruồi son gần môi', 5),
('030202001238', '2021-03-05', 'Công an TP Hà Nội', '2026-04-02', 'nốt ruồi cạnh mắt phải', 6),
('030202001239', '2021-03-05', 'Công an TP Hà Nội', '2026-04-02', 'mũi có sẹo', 7),
('030202001241', '2020-01-02', 'Công an TP Hà Nội', '2027-12-05', 'nốt ruồi ở vành tai', 8),
('030202001242', '2020-01-02', 'Công an TP Hà Nội', '2027-12-05', 'nốt ruồi trên mũi', 9),
('030202001243', '2020-01-02', 'Công an TP Hà Nội', '2027-12-05', 'sẹo trên mi mắt trái', 10),
('030202001244', '2021-03-02', 'Công an TP Hà Nội', '2027-12-05', 'nốt ruồi ở mi mắt phải', 13),
('030202001245', '2021-03-02', 'Công an tỉnh Bắc Giang', '2028-01-01', 'nốt ruồi cạnh mắt trái', 14),
('030202001246', '2021-03-02', 'Công an tỉnh Bắc Giang', '2028-01-01', 'sẹo cạnh mắt trái', 15),
('030202001247', '2021-03-02', 'Công an tỉnh Bắc Giang', '2028-01-01', 'sẹo khoé mắt', 16),
('030202001248', '2021-03-02', 'Công an tỉnh Bắc Giang', '2028-01-01', 'nốt ruồi son gần môi', 17),
('030202001249', '2023-04-06', 'Công an tỉnh Nghệ An', '2028-01-01', 'nốt ruồi cạnh mắt phải', 18),
('030202001250', '2023-04-06', 'Công an tỉnh Thái Bình', '2028-01-01', 'cằm có sẹo', 21),
('030202001251', '2023-04-06', 'Công an TP Hà Nội', '2028-01-01', 'nốt ruồi ở vành tai', 22),
('030202001252', '2023-04-06', 'Công an tỉnh Thanh Hoá', '2025-03-02', 'nốt ruồi trên mũi', 23),
('030202001253', '2023-04-06', 'Công an TP Hà Nội', '2025-03-02', 'sẹo trên mi mắt trái', 24),
('030202001254', '2021-08-07', 'Công an TP Hà Nội', '2025-03-02', 'nốt ruồi ở mi mắt phải', 25),
('030202001255', '2021-08-07', 'Công an tỉnh Hải Dương', '2025-03-02', 'nốt ruồi cạnh mắt trái', 26),
('030202001256', '2021-08-07', 'Công an TP Hà Nội', '2025-03-02', 'sẹo cạnh mắt trái', 27),
('030202001257', '2021-08-07', 'Công an TP Hà Nội', '2025-03-02', 'sẹo khoé mắt', 28),
('030202001258', '2021-08-07', 'Công an TP Hải Phòng', '2025-03-02', 'nốt ruồi son gần môi', 29),
('030202001259', '2021-08-07', 'Công an TP Hà Nội', '2025-03-02', 'nốt ruồi cạnh mắt phải', 30),
('030202001260', '2021-08-07', 'Công an TP Hà Nội', '2026-07-08', 'sẹo trên má trái', 31),
('030202001261', '2021-08-07', 'Công an TP Hà Nội', '2026-07-08', 'nốt ruồi ở vành tai', 32),
('030202001262', '2023-10-11', 'Công an tỉnh Nam Định', '2026-07-08', 'nốt ruồi dưới cằm', 33),
('030202001263', '2023-10-11', 'Công an tỉnh Yên Bái', '2026-07-08', 'sẹo trên mi mắt trái', 34),
('030202001264', '2023-10-11', 'Công an tỉnh Nam Định', '2026-07-08', 'nốt ruồi ở mi mắt phải', 35),
('030202001265', '2023-10-11', 'Công an tỉnh Lạng Sơn', '2026-07-08', 'nốt ruồi cạnh mắt trái', 36),
('030202001266', '2023-10-11', 'Công an TP Hà Nội', '2026-07-08', 'sẹo cạnh mắt trái', 37),
('030202001267', '2023-10-11', 'Công an tỉnh Lạng Sơn', '2026-07-08', 'sẹo khoé mắt', 38),
('030202001268', '2022-04-07', 'Công an tỉnh Lạng Sơn', '2026-07-08', 'nốt ruồi son gần môi', 39),
('030202001269', '2022-04-07', 'Công an tỉnh Bắc Giang', '2026-07-08', 'nốt ruồi cạnh mắt phải', 41),
('030202001270', '2022-04-07', 'Công an TP Hà Nội', '2026-07-08', 'mũi có sẹo', 42),
('030202001271', '2022-04-07', 'Công an TP Đà Nẵng', '2026-07-08', 'sẹo cạnh mắt trái', 43),
('030202001272', '2022-04-07', 'Công an tỉnh Cao Bằng', '2026-07-08', 'nốt ruồi vành tai trái', 44),
('030202001273', '2022-04-07', 'Công an tỉnh Thái Bình', '2026-07-08', 'có sẹo ở cằm', 45);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khaitu`
--

CREATE TABLE `khaitu` (
  `IdKhaiTu` int(11) NOT NULL,
  `NgayChet` date DEFAULT NULL,
  `LyDoChet` varchar(500) COLLATE utf8mb4_bin DEFAULT NULL,
  `NgayKhai` date DEFAULT NULL,
  `IdNguoiChet` int(11) DEFAULT NULL,
  `IdNguoiKhai` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Đang đổ dữ liệu cho bảng `khaitu`
--

INSERT INTO `khaitu` (`IdKhaiTu`, `NgayChet`, `LyDoChet`, `NgayKhai`, `IdNguoiChet`, `IdNguoiKhai`) VALUES
(1, '2022-04-05', 'Covid', '2022-04-05', 38, 35),
(2, '2021-03-10', 'Bệnh tật', '2021-03-10', 13, 14),
(4, '2022-12-12', 'Bệnh tật', '2022-12-12', 11, 9);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `lichtrinh`
--

CREATE TABLE `lichtrinh` (
  `IdLichTrinh` int(11) NOT NULL,
  `IdNguoiKhai` int(11) NOT NULL,
  `TenLichTrinh` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `lichtrinh`
--

INSERT INTO `lichtrinh` (`IdLichTrinh`, `IdNguoiKhai`, `TenLichTrinh`) VALUES
(11, 11, 'Hà Nội - Hải Phòng'),
(12, 25, 'Hà Nội - Quảng Ninh'),
(13, 6, 'Hải Dương - Nghệ An'),
(14, 38, 'Tp Hồ Chí Minh - Hà Nội');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhankhau`
--

CREATE TABLE `nhankhau` (
  `IdNhanKhau` int(11) NOT NULL,
  `TonGiao` varchar(50) DEFAULT NULL,
  `NguyenQuan` varchar(100) DEFAULT NULL,
  `ThuongTru` varchar(100) DEFAULT NULL,
  `GioiTinh` tinyint(1) NOT NULL,
  `HoTen` varchar(50) NOT NULL,
  `DOB` date DEFAULT NULL,
  `DanToc` varchar(30) DEFAULT NULL,
  `NgheNghiep` varchar(50) DEFAULT NULL,
  `QuocTich` varchar(50) DEFAULT NULL,
  `MaCccd` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `nhankhau`
--

INSERT INTO `nhankhau` (`IdNhanKhau`, `TonGiao`, `NguyenQuan`, `ThuongTru`, `GioiTinh`, `HoTen`, `DOB`, `DanToc`, `NgheNghiep`, `QuocTich`, `MaCccd`) VALUES
(1, 'Không', 'Đông Hưng, Lục Nam, Bắc Giang', 'Bách Khoa, Hai Bà Trưng, Hà Nội', 0, 'Nguyễn Văn Thanh', '1975-12-07', 'Kinh', 'Giáo Viên', 'Việt Nam', '030202001234'),
(5, 'Không', 'Bách Khoa, Hai Bà Trưng, Hà Nội', 'Bách Khoa, Hai Bà Trưng, Hà Nội', 1, 'Phạm Duy Anh', '1983-10-20', 'Tày', 'Kỹ Sư', 'Việt Nam', '030202001237'),
(6, 'Không', 'Phú Cường, Sóc Sơn, Hà Nội', 'Bách Khoa, Hai Bà Trưng, Hà Nội', 0, 'Lê Thị Linh', '1987-04-08', 'Kinh', 'Giáo Viên', 'Việt Nam', '030202001238'),
(7, 'Không', 'Bách Khoa, Hai Bà Trưng, Hà Nội', 'Bách Khoa, Hai Bà Trưng, Hà Nội', 1, 'Phạm Thành Long', '2003-03-05', 'Tày', 'Học Sinh', 'Việt Nam', '030202001239'),
(8, 'Không', 'Bách Khoa, Hai Bà Trưng, Hà Nội', 'Bách Khoa, Hai Bà Trưng, Hà Nội', 0, 'Phạm Thị Hải Yến', '2007-08-04', 'Tày', 'Học Sinh', 'Việt Nam', '030202001241'),
(9, 'Không', 'Kim Sơn, Gia Lâm, Hà Nội', 'Bách Khoa, Hai Bà Trưng, Hà Nội', 1, 'Lê Hoàng Long', '1995-06-06', 'Kinh', 'Kế Toán', 'Việt Nam', '030202001242'),
(10, 'Không', 'An Khánh, Hoài Đức, Hà Nội', 'Bách Khoa, Hai Bà Trưng, Hà Nội', 0, 'Phạm Huyền Linh', '1995-01-04', 'Kinh', 'Công Nhân', 'Việt Nam', '030202001243'),
(11, 'Không', 'Kim Sơn, Gia Lâm, Hà Nội', 'Bách Khoa, Hai Bà Trưng, Hà Nội', 1, 'Lê Văn Luyện', '2016-01-01', 'Kinh', 'Học Sinh', 'Việt Nam', ''),
(12, 'Không', 'Kim Sơn, Gia Lâm, Hà Nội', 'Bách Khoa, Hai Bà Trưng, Hà Nội', 0, 'Lê Thị Thu Hoài', '2018-03-02', 'Kinh', 'Học Sinh', 'Việt Nam', ''),
(13, 'Không', 'Cao Thượng, Tân Yên, Bắc Giang', 'Bách Khoa, Hai Bà Trưng, Hà Nội', 1, 'Nguyễn Duy Tùng', '1965-04-04', 'Kinh', 'Cán Bộ', 'Việt Nam', '030202001244'),
(14, 'Không', 'Cao Thượng, Tân Yên, Bắc Giang', 'Bách Khoa, Hai Bà Trưng, Hà Nội', 0, 'Phạm Thu Huyền', '1970-05-02', 'Kinh', 'Nông dân', 'Việt Nam', '030202001245'),
(15, 'Không', 'Cao Thượng, Tân Yên, Bắc Giang', 'Bách Khoa, Hai Bà Trưng, Hà Nội', 1, 'Nguyễn Việt Anh', '1994-06-09', 'Kinh', 'Kỹ Sư', 'Việt Nam', '030202001246'),
(16, 'Không', 'Cao Thượng, Tân Yên, Bắc Giang', 'Bách Khoa, Hai Bà Trưng, Hà Nội', 0, 'Nguyễn Văn Quang', '1997-11-12', 'Kinh', 'Luật Sư', 'Việt Nam', '030202001247'),
(17, 'Không', 'Thái Sơn, Đô Lương, Nghệ An', 'Bách Khoa, Hai Bà Trưng, Hà Nội', 1, 'Trần Hữu An', '1989-12-03', 'Dao', 'Nhà Báo', 'Việt Nam', '030202001248'),
(18, 'Không', 'Hoà Tân, Thái Thuỵ, Thái Bình', 'Bách Khoa, Hai Bà Trưng, Hà Nội', 0, 'Phạm Thị Thảo', '1991-01-06', 'Kinh', 'Nhiếp Ảnh', 'Việt Nam', '030202001249'),
(19, 'Không', 'Thái Sơn, Đô Lương, Nghệ An', 'Bách Khoa, Hai Bà Trưng, Hà Nội', 0, 'Trần Hồng Nhung', '2011-05-03', 'Dao', 'Học Sinh', 'Việt Nam', ''),
(20, 'Không', 'Thái Sơn, Đô Lương, Nghệ An', 'Bách Khoa, Hai Bà Trưng, Hà Nội', 1, 'Trần Thăng Đức', '2015-06-09', 'Dao', 'Học Sinh', 'Việt Nam', ''),
(21, 'Không', 'Bách Khoa, Hai Bà Trưng, Hà Nội', 'Bách Khoa, Hai Bà Trưng, Hà Nội', 1, 'Ngô Văn Nam', '1983-11-16', 'Kinh', 'Kỹ Sư', 'Việt Nam', '030202001250'),
(22, 'Không', 'Hồng Đức, Nông Cống, Thanh Hoá', 'Bách Khoa, Hai Bà Trưng, Hà Nội', 0, 'Trần Thị Thu Trang', '1984-01-04', 'Kinh', 'Giáo Viên', 'Việt Nam', '030202001251'),
(23, 'Không', 'Bách Khoa, Hai Bà Trưng, Hà Nội', 'Bách Khoa, Hai Bà Trưng, Hà Nội', 1, 'Ngô Việt Bách', '2002-02-02', 'Kinh', 'Sinh Viên', 'Việt Nam', '030202001252'),
(24, 'Không', 'Bách Khoa, Hai Bà Trưng, Hà Nội', 'Bách Khoa, Hai Bà Trưng, Hà Nội', 1, 'Nguyễn Mạnh Trường', '1998-07-21', 'Kinh', 'Thạc Sĩ', 'Việt Nam', '030202001253'),
(25, 'Không', 'Hoàng Hà, Tứ Kỳ, Hải Dương', 'Bách Khoa, Hai Bà Trưng, Hà Nội', 0, 'Trần Mai Lê', '1998-04-03', 'Nùng', 'Kinh Doanh', 'Việt Nam', '030202001254'),
(26, 'Không', 'Bách Khoa, Hai Bà Trưng, Hà Nội', 'Bách Khoa, Hai Bà Trưng, Hà Nội', 1, 'Nguyễn Mạnh Tiến', '2018-12-10', 'Nùng', 'Học Sinh', 'Việt Nam', '030202001255'),
(27, 'Không', 'Bách Khoa, Hai Bà Trưng, Hà Nội', 'Bách Khoa, Hai Bà Trưng, Hà Nội', 1, 'Đặng Văn Trị', '1981-05-05', 'Thái', 'Bác Sĩ', 'Việt Nam', '030202001256'),
(28, 'Không', 'Tam Dị, Tiên Lãng, Hải Phòng', 'Bách Khoa, Hai Bà Trưng, Hà Nội', 0, 'Nguyễn Thị Như Ngọc', '1984-06-06', 'Mường', 'Cán Bộ', 'Việt Nam', '030202001257'),
(29, 'Không', 'Bách Khoa, Hai Bà Trưng, Hà Nội', 'Bách Khoa, Hai Bà Trưng, Hà Nội', 1, 'Đặng Quốc Đạt', '2005-01-01', 'Thái', 'Sinh Viên', 'Việt Nam', '030202001258'),
(30, 'Không', 'Bách Khoa, Hai Bà Trưng, Hà Nội', 'Bách Khoa, Hai Bà Trưng, Hà Nội', 1, 'Đặng Quốc Trung', '2007-08-04', 'Thái', 'Học Sinh', 'Việt Nam', '030202001259'),
(31, 'Không', 'Bách Khoa, Hai Bà Trưng, Hà Nội', 'Bách Khoa, Hai Bà Trưng, Hà Nội', 0, 'Đặng Thị Trang', '2010-10-10', 'Thái', 'Học Sinh', 'Việt Nam', '030202001260'),
(32, 'Không', 'Trường Sơn, Hải Hậu, Nam Định', 'Bách Khoa, Hai Bà Trưng, Hà Nội', 1, 'Bùi Trọng Tùng', '1982-06-08', 'Kinh', 'Giáo Viên', 'Việt Nam', '030202001261'),
(33, 'Không', 'Lục Yên, Yên Bình, Yên Bái', 'Bách Khoa, Hai Bà Trưng, Hà Nội', 0, 'Hoàng Thị Linh', '1984-01-01', 'Kinh', 'Nhà Báo', 'Việt Nam', '030202001262'),
(34, 'Không', 'Trường Sơn, Hải Hậu, Nam Định', 'Bách Khoa, Hai Bà Trưng, Hà Nội', 0, 'Bùi Thị Ly', '2009-12-16', 'Kinh', 'Học Sinh', 'Việt Nam', '030202001263'),
(35, 'Không', 'Yên Thành, Chi Lăng, Lạng Sơn', 'Bách Khoa, Hai Bà Trưng, Hà Nội', 1, 'Trịnh Tuấn Đạt', '1980-08-15', 'Tày', 'Giáo Viên', 'Việt Nam', '030202001264'),
(36, 'Không', 'Bạch Mai, Hai Bà Trưng, Hà Nội', 'Bách Khoa, Hai Bà Trưng, Hà Nội', 1, 'Phạm Huyền Trang', '1985-12-16', 'Kinh', 'Bác Sĩ', 'Việt Nam', '030202001265'),
(37, 'Không', 'Yên Thành, Chi Lăng, Lạng Sơn', 'Bách Khoa, Hai Bà Trưng, Hà Nội', 0, 'Trịnh Thị Ngọc Mai', '2010-04-04', 'Tày', 'Học Sinh', 'Việt Nam', '030202001266'),
(38, 'Không', 'Yên Thành, Chi Lăng, Lạng Sơn', 'Bách Khoa, Hai Bà Trưng, Hà Nội', 1, 'Trịnh Trần Phương Tuấn', '2012-12-03', 'Tày', 'Học Sinh', 'Việt Nam', '030202001267'),
(39, 'Không', 'Phú Minh, Sóc Sơn, Hà Nội', 'Bách Khoa, Hai Bà Trưng, Hà Nội', 1, 'Lê Quang Liêm', '1994-07-08', 'Kinh', 'Kỳ Thủ', 'Việt Nam', '030202001268'),
(41, 'Không', 'Thọ Quang, Sơn Trà, Đà Nẵng', 'Bách Khoa, Hai Bà Trưng, Hà Nội', 1, 'Phan Tấn Trung', '2002-03-02', 'Kinh', 'Sinh Viên', 'Việt Nam', '030202001269'),
(42, 'Không', 'tp Cao Bằng, tỉnh Cao Bằng', 'Bách Khoa, Hai Bà Trưng, Hà Nội', 1, 'Đàm Vĩnh Hưng', '2003-01-01', 'Kinh', 'Sinh Viên', 'Việt Nam', '030202001270'),
(43, 'Không', 'Mỹ Lộc, Thái Thuỵ, Thái Bình', 'Bách Khoa, Hai Bà Trưng, Hà Nội', 1, 'Nguyễn Thanh Tùng', '1999-07-21', 'Kinh', 'Ca Sĩ', 'Việt Nam', '030202001271'),
(44, 'Không', 'Quận 1, tp Hồ Chí Minh', 'Bách Khoa, Hai Bà Trưng, Hà Nội', 0, 'Lê Ánh Nhật', '1991-05-06', 'kinh', 'Ca Sĩ', 'Việt Nam', '030202001272'),
(45, 'Không', 'Tứ Kỳ, Hải Dương', 'Bách Khoa, Hai Bà Trưng, Hà Nội', 1, 'Phạm Trung Dũng', '2002-01-01', 'Kinh', 'Sinh Viên', 'Việt Nam', '030202001273'),
(46, 'dsfadsfasdf', 'sdfadsfads', 'dsfadsfadsf', 0, 'Nguyen Van A', '2023-06-06', 'adsfadsf', 'dsfadsf', 'dsfadsfasd', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sohokhau`
--

CREATE TABLE `sohokhau` (
  `IdHoKhau` int(11) NOT NULL,
  `NgayTao` date DEFAULT NULL,
  `DiaChi` varchar(70) DEFAULT NULL,
  `IdChuHo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `sohokhau`
--

INSERT INTO `sohokhau` (`IdHoKhau`, `NgayTao`, `DiaChi`, `IdChuHo`) VALUES
(1, '2001-03-01', '10 Lê Thanh Nghị, Bách Khoa, Hai Bà Trưng', 1),
(2, '2004-06-20', '5 ngõ 30 Tạ Quang Bửu, Bách Khoa, Hai Bà Trưng', 5),
(3, '2015-04-16', '8 ngõ 42 Tạ Quang Bửu, Bách Khoa, Hai Bà Trưng', 9),
(4, '2002-04-05', '32 Trần Đại Nghĩa, Bách Khoa, Hai Bà Trưng', 13),
(5, '2010-06-08', '15 Đại Cồ Việt, Bách Khoa, Hai Bà Trưng', 17),
(6, '2000-06-03', '21 Tạ Quang Bửu, Bách Khoa, Hai Bà Trưng', 21),
(7, '2020-06-09', '2 Nguyễn Hiền, Bách Khoa, Hai Bà Trưng', 24),
(8, '2006-08-24', '61 Đại Cồ Việt, Bách Khoa, Hai Bà Trưng', 27),
(9, '2012-08-12', '3 ngõ 33 Lê Thanh Nghị, Bách Khoa, Hai Bà Trưng', 32),
(10, '2021-07-06', '15 ngõ 29 Ttaj Quang Bửu, Bách Khoa, Hai Bà Trưng', 35),
(11, '2022-03-02', '75 Trần Đại Nghĩa, Bách Khoa, Hai Bà Trưng', 39),
(13, '2023-06-27', 'asdfasdfadsf', 7);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tamtru`
--

CREATE TABLE `tamtru` (
  `IdTamTru` int(11) NOT NULL,
  `NgayTao` date DEFAULT NULL,
  `NgayKetThuc` date DEFAULT NULL,
  `IdNguoiTamTru` int(11) DEFAULT NULL,
  `IdHoKhau` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `tamtru`
--

INSERT INTO `tamtru` (`IdTamTru`, `NgayTao`, `NgayKetThuc`, `IdNguoiTamTru`, `IdHoKhau`) VALUES
(1, '2022-02-03', '2024-02-03', 41, 1),
(2, '2022-04-01', '2024-10-01', 42, 1),
(3, '2022-10-28', '2024-05-01', 43, 3),
(4, '2021-07-15', '2023-07-15', 44, 5);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tamvang`
--

CREATE TABLE `tamvang` (
  `IdTamVang` int(11) NOT NULL,
  `NgayTao` date DEFAULT NULL,
  `NgayKetThuc` date DEFAULT NULL,
  `IdNguoiTamVang` int(11) NOT NULL,
  `DiaDiem` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `tamvang`
--

INSERT INTO `tamvang` (`IdTamVang`, `NgayTao`, `NgayKetThuc`, `IdNguoiTamVang`, `DiaDiem`) VALUES
(2, '2023-05-01', '2024-01-11', 23, 'sadfsadfasfsdfsadf'),
(3, '2023-06-14', '2025-06-14', 28, 'gasgrevawgvasdg'),
(4, '2023-04-01', '2023-01-11', 17, 'dsafaawefsdfaefwefdsf'),
(5, '2022-03-10', '2023-10-10', 37, 'dsfwaevewafedcwfwvwe'),
(6, '2023-06-20', '2023-06-27', 9, 'ádfadfasdfasedfasef');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thanhvienho`
--

CREATE TABLE `thanhvienho` (
  `IdNhanKhau` int(11) NOT NULL,
  `IdHoKhau` int(11) NOT NULL,
  `QuanHeChuHo` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `thanhvienho`
--

INSERT INTO `thanhvienho` (`IdNhanKhau`, `IdHoKhau`, `QuanHeChuHo`) VALUES
(1, 1, 'chủ hộ'),
(5, 2, 'chủ hộ'),
(6, 2, 'vợ'),
(7, 2, 'con'),
(7, 13, 'Chủ hộ'),
(8, 2, 'con'),
(9, 3, 'chủ hộ'),
(10, 3, 'vợ'),
(11, 3, 'con'),
(12, 3, 'con'),
(13, 4, 'chủ hộ'),
(14, 4, 'vợ'),
(15, 4, 'con'),
(16, 4, 'con'),
(17, 5, 'chủ hộ'),
(18, 5, 'vợ'),
(19, 5, 'con'),
(20, 5, 'con'),
(26, 6, 'Chủ hộ'),
(32, 1, 'abc');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thongtindichuyen`
--

CREATE TABLE `thongtindichuyen` (
  `IdThongTin` int(11) NOT NULL,
  `PhuongTien` varchar(50) DEFAULT NULL,
  `ThoiGian` datetime NOT NULL,
  `DiaDiem` varchar(50) DEFAULT NULL,
  `IdLichTrinh` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `thongtindichuyen`
--

INSERT INTO `thongtindichuyen` (`IdThongTin`, `PhuongTien`, `ThoiGian`, `DiaDiem`, `IdLichTrinh`) VALUES
(1, 'xe máy', '2023-11-06 00:00:00', 'Bệnh viện Nhiệt Đới Trung Ương, Hà Nội', 11),
(2, 'xe bus', '2023-11-07 00:00:00', 'Đồ Sơn, Hải Phòng', 11),
(3, 'ô tô', '2023-04-06 00:00:00', 'Đại học Bách Khoa Hà Nội', 12),
(4, 'ô tô', '2023-04-08 00:00:00', 'Cẩm Phả, Quảng Ninh', 12),
(5, 'xe máy', '2023-06-15 00:00:00', 'Cẩm Giàng, Hải Dương', 13),
(6, 'xe khách', '2023-06-16 00:00:00', 'Kim Sơn, Nghệ An', 13),
(7, 'xe máy', '2023-06-18 00:00:00', 'Hưng Hòa, Nghệ An', 13),
(8, 'xe bus', '2023-04-04 00:00:00', 'Quận 1, Tp Hồ Chí Minh', 14),
(9, 'xe bus', '2023-04-04 00:00:00', 'Đại học Bách Khoa Hà Nội', 14);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `userId` int(11) NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `role` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`userId`, `username`, `password`, `role`) VALUES
(11, 'phamtrungdung', 'dung12345', 1),
(13, 'machungthanh', 'thanh12344', 0),
(18, 'letheky', 'kybruh1234', 1),
(21, 'hoangtheanh', 'superidol', 0),
(22, 'nguyenvanhao', 'haodeptrai123', 1),
(23, 'test', '123', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `xetnghiem`
--

CREATE TABLE `xetnghiem` (
  `IdXetNghiem` int(11) NOT NULL,
  `HinhThuc` varchar(50) DEFAULT NULL,
  `ThoiGian` datetime DEFAULT NULL,
  `KetQua` varchar(50) DEFAULT NULL,
  `IdNguoiXetNghiem` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `cachly`
--
ALTER TABLE `cachly`
  ADD PRIMARY KEY (`IdCachLy`),
  ADD KEY `CachLy_ibfk_1` (`IdNguoiCachLy`);

--
-- Chỉ mục cho bảng `cccd`
--
ALTER TABLE `cccd`
  ADD PRIMARY KEY (`IdCccd`),
  ADD KEY `CCCD_ibfk_1` (`IdNhanKhau`);

--
-- Chỉ mục cho bảng `khaitu`
--
ALTER TABLE `khaitu`
  ADD PRIMARY KEY (`IdKhaiTu`),
  ADD KEY `KhaiTu_ibfk_1` (`IdNguoiChet`),
  ADD KEY `KhaiTu_ibfk_2` (`IdNguoiKhai`);

--
-- Chỉ mục cho bảng `lichtrinh`
--
ALTER TABLE `lichtrinh`
  ADD PRIMARY KEY (`IdLichTrinh`),
  ADD KEY `LichTrinh_ibfk_1` (`IdNguoiKhai`);

--
-- Chỉ mục cho bảng `nhankhau`
--
ALTER TABLE `nhankhau`
  ADD PRIMARY KEY (`IdNhanKhau`);

--
-- Chỉ mục cho bảng `sohokhau`
--
ALTER TABLE `sohokhau`
  ADD PRIMARY KEY (`IdHoKhau`),
  ADD KEY `SoHoKhau_ibfk_1` (`IdChuHo`);

--
-- Chỉ mục cho bảng `tamtru`
--
ALTER TABLE `tamtru`
  ADD PRIMARY KEY (`IdTamTru`),
  ADD KEY `TamTru_ibfk_1` (`IdNguoiTamTru`),
  ADD KEY `TamTru_ibfk_2` (`IdHoKhau`);

--
-- Chỉ mục cho bảng `tamvang`
--
ALTER TABLE `tamvang`
  ADD PRIMARY KEY (`IdTamVang`),
  ADD KEY `temporarilyabsent_ibfk_1` (`IdNguoiTamVang`);

--
-- Chỉ mục cho bảng `thanhvienho`
--
ALTER TABLE `thanhvienho`
  ADD PRIMARY KEY (`IdNhanKhau`,`IdHoKhau`),
  ADD KEY `ThanhVienHo_ibfk_2` (`IdHoKhau`);

--
-- Chỉ mục cho bảng `thongtindichuyen`
--
ALTER TABLE `thongtindichuyen`
  ADD PRIMARY KEY (`IdThongTin`),
  ADD KEY `ThongTinDiChuyen_ibfk_1` (`IdLichTrinh`);

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`userId`);

--
-- Chỉ mục cho bảng `xetnghiem`
--
ALTER TABLE `xetnghiem`
  ADD PRIMARY KEY (`IdXetNghiem`),
  ADD KEY `XetNghiem_ibfk_1` (`IdNguoiXetNghiem`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `cachly`
--
ALTER TABLE `cachly`
  MODIFY `IdCachLy` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `lichtrinh`
--
ALTER TABLE `lichtrinh`
  MODIFY `IdLichTrinh` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT cho bảng `nhankhau`
--
ALTER TABLE `nhankhau`
  MODIFY `IdNhanKhau` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;

--
-- AUTO_INCREMENT cho bảng `sohokhau`
--
ALTER TABLE `sohokhau`
  MODIFY `IdHoKhau` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT cho bảng `tamtru`
--
ALTER TABLE `tamtru`
  MODIFY `IdTamTru` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `tamvang`
--
ALTER TABLE `tamvang`
  MODIFY `IdTamVang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `thongtindichuyen`
--
ALTER TABLE `thongtindichuyen`
  MODIFY `IdThongTin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT cho bảng `user`
--
ALTER TABLE `user`
  MODIFY `userId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT cho bảng `xetnghiem`
--
ALTER TABLE `xetnghiem`
  MODIFY `IdXetNghiem` int(11) NOT NULL AUTO_INCREMENT;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `cachly`
--
ALTER TABLE `cachly`
  ADD CONSTRAINT `CachLy_ibfk_1` FOREIGN KEY (`IdNguoiCachLy`) REFERENCES `nhankhau` (`IdNhanKhau`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `cccd`
--
ALTER TABLE `cccd`
  ADD CONSTRAINT `CCCD_ibfk_1` FOREIGN KEY (`IdNhanKhau`) REFERENCES `nhankhau` (`IdNhanKhau`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `khaitu`
--
ALTER TABLE `khaitu`
  ADD CONSTRAINT `KhaiTu_ibfk_1` FOREIGN KEY (`IdNguoiChet`) REFERENCES `nhankhau` (`IdNhanKhau`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `KhaiTu_ibfk_2` FOREIGN KEY (`IdNguoiKhai`) REFERENCES `nhankhau` (`IdNhanKhau`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `lichtrinh`
--
ALTER TABLE `lichtrinh`
  ADD CONSTRAINT `LichTrinh_ibfk_1` FOREIGN KEY (`IdNguoiKhai`) REFERENCES `nhankhau` (`IdNhanKhau`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `sohokhau`
--
ALTER TABLE `sohokhau`
  ADD CONSTRAINT `SoHoKhau_ibfk_1` FOREIGN KEY (`IdChuHo`) REFERENCES `nhankhau` (`IdNhanKhau`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `tamtru`
--
ALTER TABLE `tamtru`
  ADD CONSTRAINT `TamTru_ibfk_1` FOREIGN KEY (`IdNguoiTamTru`) REFERENCES `nhankhau` (`IdNhanKhau`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `TamTru_ibfk_2` FOREIGN KEY (`IdHoKhau`) REFERENCES `sohokhau` (`IdHoKhau`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `tamvang`
--
ALTER TABLE `tamvang`
  ADD CONSTRAINT `temporarilyabsent_ibfk_1` FOREIGN KEY (`IdNguoiTamVang`) REFERENCES `nhankhau` (`IdNhanKhau`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `thanhvienho`
--
ALTER TABLE `thanhvienho`
  ADD CONSTRAINT `ThanhVienHo_ibfk_1` FOREIGN KEY (`IdNhanKhau`) REFERENCES `nhankhau` (`IdNhanKhau`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ThanhVienHo_ibfk_2` FOREIGN KEY (`IdHoKhau`) REFERENCES `sohokhau` (`IdHoKhau`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `thongtindichuyen`
--
ALTER TABLE `thongtindichuyen`
  ADD CONSTRAINT `ThongTinDiChuyen_ibfk_1` FOREIGN KEY (`IdLichTrinh`) REFERENCES `lichtrinh` (`IdLichTrinh`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `xetnghiem`
--
ALTER TABLE `xetnghiem`
  ADD CONSTRAINT `XetNghiem_ibfk_1` FOREIGN KEY (`IdNguoiXetNghiem`) REFERENCES `nhankhau` (`IdNhanKhau`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
