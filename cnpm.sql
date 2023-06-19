-- MySQL Script generated by MySQL Workbench
-- Sun Jun  4 15:36:04 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema cnpm2023
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema cnpm2023
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cnpm2023` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `cnpm2023` ;

-- -----------------------------------------------------
-- Table `cnpm2023`.`NhanKhau`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cnpm2023`.`NhanKhau` (
  `IdNhanKhau` INT  NOT NULL AUTO_INCREMENT,
  `TonGiao` VARCHAR(50) NULL DEFAULT NULL,
  `NguyenQuan` VARCHAR(100) NULL DEFAULT NULL,
  `ThuongTru` VARCHAR(100) NULL DEFAULT NULL,
  `GioiTinh` BOOLEAN NOT NULL,
  `HoTen` VARCHAR(50) NOT NULL,
  `DOB` DATE NULL,
  `DanToc` VARCHAR(30) NULL DEFAULT NULL,
  `NgheNghiep` VARCHAR(50) NULL DEFAULT NULL,
  `QuocTich` VARCHAR(50) NULL DEFAULT NULL,
  `MaCccd` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`IdNhanKhau`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- insert NhanKhau -- 
INSERT INTO `nhankhau` (`IdNhanKhau`, `HoTen`, `DOB`, `NgheNghiep`, `DanToc`, `TonGiao`, `QuocTich`, `GioiTinh`, `MaCccd`, `NguyenQuan`, `ThuongTru`) VALUES 
(001, 'Nguyễn Văn Thanh', '1975-12-07', 'Giáo Viên', 'Kinh', 'Không', 'Việt Nam', TRUE, '030202001234', 'Đông Hưng, Lục Nam, Bắc Giang', 'Bách Khoa, Hai Bà Trưng, Hà Nội'),
(002, 'Nguyễn Thị Diệu Linh', '1981-01-30', 'Giáo Viên', 'Kinh', 'Không', 'Việt Nam', FALSE, '030202001235', 'Liên Hà, Đông Anh, Hà Nội', 'Bách Khoa, Hai Bà Trưng, Hà Nội'),
(003, 'Nguyễn Duy Chiến', '2002-07-06', 'Sinh Viên', 'Kinh', 'Không', 'Việt Nam', TRUE, '030202001236', 'Đông Hưng, Lục Nam, Bắc Giang', 'Bách Khoa, Hai Bà Trưng, Hà Nội'),
(004, 'Nguyễn Khắc Duy', '2007-05-10', 'Học Sinh', 'Kinh', 'Không', 'Việt Nam', TRUE, '', 'Đông Hưng, Lục Nam, Bắc Giang', 'Bách Khoa, Hai Bà Trưng, Hà Nội'),
(005, 'Phạm Duy Anh', '1983-10-20', 'Kỹ Sư', 'Tày', 'Không', 'Việt Nam', TRUE, '030202001237', 'Bách Khoa, Hai Bà Trưng, Hà Nội', 'Bách Khoa, Hai Bà Trưng, Hà Nội'),
(006, 'Lê Thị Linh', '1987-04-06', 'Giáo Viên', 'Kinh', 'Không', 'Việt Nam', FALSE, '030202001238', 'Phú Cường, Sóc Sơn, Hà Nội', 'Bách Khoa, Hai Bà Trưng, Hà Nội'),
(007, 'Phạm Thành Long', '2003-03-05', 'Học Sinh', 'Tày', 'Không', 'Việt Nam', TRUE, '030202001239', 'Bách Khoa, Hai Bà Trưng, Hà Nội', 'Bách Khoa, Hai Bà Trưng, Hà Nội'),
(008, 'Phạm Thị Hải Yến', '2007-08-04', 'Học Sinh', 'Tày', 'Không', 'Việt Nam', FALSE, '030202001241', 'Bách Khoa, Hai Bà Trưng, Hà Nội', 'Bách Khoa, Hai Bà Trưng, Hà Nội'),
(009, 'Lê Hoàng Long', '1995-06-06', 'Kế Toán', 'Kinh', 'Không', 'Việt Nam', TRUE, '030202001242', 'Kim Sơn, Gia Lâm, Hà Nội', 'Bách Khoa, Hai Bà Trưng, Hà Nội'),
(010, 'Phạm Huyền Linh', '1995-01-04', 'Công Nhân', 'Kinh', 'Không', 'Việt Nam', FALSE, '030202001243', 'An Khánh, Hoài Đức, Hà Nội', 'Bách Khoa, Hai Bà Trưng, Hà Nội'),
(011, 'Lê Văn Luyện', '2016-01-01', 'Học Sinh', 'Kinh', 'Không', 'Việt Nam', TRUE, '', 'Kim Sơn, Gia Lâm, Hà Nội', 'Bách Khoa, Hai Bà Trưng, Hà Nội'),
(012, 'Lê Thị Thu Hoài', '2018-03-02', 'Học Sinh', 'Kinh', 'Không', 'Việt Nam', FALSE, '', 'Kim Sơn, Gia Lâm, Hà Nội', 'Bách Khoa, Hai Bà Trưng, Hà Nội'),
(013, 'Nguyễn Duy Tùng', '1965-04-04', 'Cán Bộ', 'Kinh', 'Không', 'Việt Nam', TRUE, '030202001244', 'Cao Thượng, Tân Yên, Bắc Giang', 'Bách Khoa, Hai Bà Trưng, Hà Nội'),
(014, 'Phạm Thu Huyền',	 '1970-05-02', 'Nông dân', 'Kinh', 'Không', 'Việt Nam', FALSE, '030202001245', 'Cao Thượng, Tân Yên, Bắc Giang', 'Bách Khoa, Hai Bà Trưng, Hà Nội'),
(015, 'Nguyễn Việt Anh', '1994-06-09', 'Kỹ Sư', 'Kinh', 'Không', 'Việt Nam', TRUE, '030202001246', 'Cao Thượng, Tân Yên, Bắc Giang', 'Bách Khoa, Hai Bà Trưng, Hà Nội'),
(016, 'Nguyễn Văn Quang', '1997-11-12', 'Luật Sư',  'Kinh', 'Không', 'Việt Nam', FALSE, '030202001247', 'Cao Thượng, Tân Yên, Bắc Giang', 'Bách Khoa, Hai Bà Trưng, Hà Nội'),
(017, 'Trần Hữu An', '1989-12-03', 'Nhà Báo', 'Dao', 'Không', 'Việt Nam', TRUE, '030202001248', 'Thái Sơn, Đô Lương, Nghệ An', 'Bách Khoa, Hai Bà Trưng, Hà Nội'),
(018, 'Phạm Thị Thảo', '1991-01-06', 'Nhiếp Ảnh', 'Kinh', 'Không', 'Việt Nam', FALSE, '030202001249', 'Hoà Tân, Thái Thuỵ, Thái Bình', 'Bách Khoa, Hai Bà Trưng, Hà Nội'),
(019, 'Trần Hồng Nhung', '2011-05-03', 'Học Sinh', 'Dao', 'Không', 'Việt Nam', FALSE, '', 'Thái Sơn, Đô Lương, Nghệ An', 'Bách Khoa, Hai Bà Trưng, Hà Nội'),
(020, 'Trần Thăng Đức', '2015-06-09', 'Học Sinh', 'Dao', 'Không', 'Việt Nam', TRUE, '', 'Thái Sơn, Đô Lương, Nghệ An', 'Bách Khoa, Hai Bà Trưng, Hà Nội'),
(021, 'Ngô Văn Nam', '1983-11-16', 'Kỹ Sư', 'Kinh', 'Không', 'Việt Nam', TRUE, '030202001250', 'Bách Khoa, Hai Bà Trưng, Hà Nội', 'Bách Khoa, Hai Bà Trưng, Hà Nội'),
(022, 'Trần Thị Thu Trang', '1984-01-04', 'Giáo Viên', 'Kinh', 'Không', 'Việt Nam', FALSE, '030202001251', 'Hồng Đức, Nông Cống, Thanh Hoá', 'Bách Khoa, Hai Bà Trưng, Hà Nội'),
(023, 'Ngô Việt Bách', '2002-02-02', 'Sinh Viên', 'Kinh', 'Không', 'Việt Nam', TRUE, '030202001252', 'Bách Khoa, Hai Bà Trưng, Hà Nội', 'Bách Khoa, Hai Bà Trưng, Hà Nội'),
(024, 'Nguyễn Mạnh Trường', '1998-07-21', 'Thạc Sĩ', 'Kinh', 'Không', 'Việt Nam', TRUE, '030202001253', 'Bách Khoa, Hai Bà Trưng, Hà Nội', 'Bách Khoa, Hai Bà Trưng, Hà Nội'),
(025, 'Trần Mai Lê', '1998-04-03', 'Kinh Doanh', 'Nùng', 'Không', 'Việt Nam', FALSE, '030202001254', 'Hoàng Hà, Tứ Kỳ, Hải Dương', 'Bách Khoa, Hai Bà Trưng, Hà Nội'),
(026, 'Nguyễn Mạnh Tiến', '2018-12-10', 'Học Sinh', 'Nùng', 'Không', 'Việt Nam', TRUE, '030202001255', 'Bách Khoa, Hai Bà Trưng, Hà Nội', 'Bách Khoa, Hai Bà Trưng, Hà Nội'),
(027, 'Đặng Văn Trị', '1981-05-05', 'Bác Sĩ', 'Thái', 'Không', 'Việt Nam', TRUE, '030202001256', 'Bách Khoa, Hai Bà Trưng, Hà Nội', 'Bách Khoa, Hai Bà Trưng, Hà Nội'),
(028, 'Nguyễn Thị Như Ngọc', '1984-06-06', 'Cán Bộ', 'Mường','Không', 'Việt Nam', FALSE, '030202001257', 'Tam Dị, Tiên Lãng, Hải Phòng', 'Bách Khoa, Hai Bà Trưng, Hà Nội'),
(029, 'Đặng Quốc Đạt', '2005-01-01', 'Sinh Viên', 'Thái', 'Không', 'Việt Nam', TRUE, '030202001258', 'Bách Khoa, Hai Bà Trưng, Hà Nội', 'Bách Khoa, Hai Bà Trưng, Hà Nội'),
(030, 'Đặng Quốc Trung', '2007-08-04', 'Học Sinh', 'Thái', 'Không', 'Việt Nam', TRUE, '030202001259', 'Bách Khoa, Hai Bà Trưng, Hà Nội', 'Bách Khoa, Hai Bà Trưng, Hà Nội'),
(031, 'Đặng Thị Trang', '2010-10-10', 'Học Sinh', 'Thái', 'Không', 'Việt Nam', FALSE, '030202001260', 'Bách Khoa, Hai Bà Trưng, Hà Nội', 'Bách Khoa, Hai Bà Trưng, Hà Nội'),
(032, 'Bùi Trọng Tùng', '1982-06-08', 'Giáo Viên', 'Kinh', 'Không', 'Việt Nam', TRUE, '030202001261', 'Trường Sơn, Hải Hậu, Nam Định', 'Bách Khoa, Hai Bà Trưng, Hà Nội'),
(033, 'Hoàng Thị Linh', '1984-01-01', 'Nhà Báo', 'Kinh', 'Không', 'Việt Nam', FALSE, '030202001262', 'Lục Yên, Yên Bình, Yên Bái', 'Bách Khoa, Hai Bà Trưng, Hà Nội'),
(034, 'Bùi Thị Ly', '2009-12-16', 'Học Sinh', 'Kinh', 'Không', 'Việt Nam', FALSE, '030202001263', 'Trường Sơn, Hải Hậu, Nam Định', 'Bách Khoa, Hai Bà Trưng, Hà Nội'),
(035, 'Trịnh Tuấn Đạt', '1980-08-15', 'Giáo Viên', 'Tày', 'Không', 'Việt Nam', TRUE, '030202001264', 'Yên Thành, Chi Lăng, Lạng Sơn', 'Bách Khoa, Hai Bà Trưng, Hà Nội'),
(036, 'Phạm Huyền Trang', '1985-12-16', 'Bác Sĩ', 'Kinh', 'Không', 'Việt Nam', TRUE, '030202001265', 'Bạch Mai, Hai Bà Trưng, Hà Nội', 'Bách Khoa, Hai Bà Trưng, Hà Nội'),
(037, 'Trịnh Thị Ngọc Mai', '2010-04-04', 'Học Sinh', 'Tày', 'Không', 'Việt Nam', FALSE, '030202001266', 'Yên Thành, Chi Lăng, Lạng Sơn', 'Bách Khoa, Hai Bà Trưng, Hà Nội'),
(038, 'Trịnh Trần Phương Tuấn', '2012-12-03', 'Học Sinh', 'Tày', 'Không', 'Việt Nam', TRUE, '030202001267', 'Yên Thành, Chi Lăng, Lạng Sơn', 'Bách Khoa, Hai Bà Trưng, Hà Nội'),
(039, 'Lê Quang Liêm', '1994-07-08', 'Kỳ Thủ', 'Kinh', 'Không', 'Việt Nam', TRUE, '030202001268', 'Phú Minh, Sóc Sơn, Hà Nội', 'Bách Khoa, Hai Bà Trưng, Hà Nội'),
(041, 'Phan Tấn Trung', '2002-03-02', 'Sinh Viên', 'Kinh', 'Không', 'Việt Nam', TRUE, '030202001269', 'Thọ Quang, Sơn Trà, Đà Nẵng', 'Bách Khoa, Hai Bà Trưng, Hà Nội'),
(042, 'Đàm Vĩnh Hưng', '2003-01-01', 'Sinh Viên', 'Kinh', 'Không', 'Việt Nam', TRUE, '030202001270', 'tp Cao Bằng, tỉnh Cao Bằng', 'Bách Khoa, Hai Bà Trưng, Hà Nội'),
(043, 'Nguyễn Thanh Tùng', '1999-07-21', 'Ca Sĩ'	, 'Kinh', 'Không', 'Việt Nam', TRUE, '030202001271', 'Mỹ Lộc, Thái Thuỵ, Thái Bình', 'Bách Khoa, Hai Bà Trưng, Hà Nội'),
(044, 'Lê Ánh Nhật', '1991-05-06', 'Ca Sĩ', 'kinh', 'Không', 'Việt Nam', FALSE, '030202001272', 'Quận 1, tp Hồ Chí Minh', 'Bách Khoa, Hai Bà Trưng, Hà Nội'),
(045, 'Phạm Trung Dũng', '2002-01-01', 'Sinh Viên', 'Kinh', 'Không', 'Việt Nam', TRUE, '030202001273', 'Tứ Kỳ, Hải Dương', 'Bách Khoa, Hai Bà Trưng, Hà Nội');

-- -----------------------------------------------------
-- Table `cnpm2023`.`CCCD`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cnpm2023`.`CCCD` (
  `IdCccd` VARCHAR(15) NOT NULL,
  `NgayCap` DATE NULL,
  `NoiCap` VARCHAR(50) NULL DEFAULT NULL,
  `NgayHetHan` DATE NULL DEFAULT NULL,
  `DacDiem` VARCHAR(50) NULL DEFAULT NULL,
  `IdNhanKhau` int NULL DEFAULT NULL,
  PRIMARY KEY (`IdCccd`),
--   INDEX `IdNhanKhau` (`IdNhanKhau` ASC) VISIBLE,
  CONSTRAINT `CCCD_ibfk_1`
    FOREIGN KEY (`IdNhanKhau`)
    REFERENCES `cnpm2023`.`NhanKhau` (`IdNhanKhau`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

INSERT INTO `CCCD` (`IdCccd`, `NgayCap`, `NoiCap`, `NgayHetHan`, `DacDiem`,`IdNhanKhau`) VALUES
('030202001234', '2020-01-02', 'Công an tỉnh Bắc Giang', '2026-03-02', 'nốt ruồi cạnh mắt trái', 001),
('030202001235', '2021-01-01', 'Công an TP Hà Nội', '2026-12-10', 'sẹo cạnh mắt trái', 002),
('030202001236', '2021-03-02', 'Công an tỉnh Bắc Giang', '2027-06-08', 'sẹo khoé mắt', 003),
('030202001237', '2021-03-05', 'Công an tỉnh Bắc Giang', '2026-04-02', 'nốt ruồi son gần môi', 005),
('030202001238', '2021-03-05', 'Công an TP Hà Nội', '2026-04-02', 'nốt ruồi cạnh mắt phải', 006),
('030202001239',	'2021-03-05', 'Công an TP Hà Nội', '2026-04-02', 'mũi có sẹo', 007),
('030202001241',	'2020-01-02', 'Công an TP Hà Nội', '2027-12-05', 'nốt ruồi ở vành tai', 008),
('030202001242',	'2020-01-02', 'Công an TP Hà Nội', '2027-12-05', 'nốt ruồi trên mũi', 009),
('030202001243',	'2020-01-02', 'Công an TP Hà Nội', '2027-12-05', 'sẹo trên mi mắt trái', 010),
('030202001244',	'2021-03-02', 'Công an TP Hà Nội', '2027-12-05', 'nốt ruồi ở mi mắt phải', 013),
('030202001245',	'2021-03-02', 'Công an tỉnh Bắc Giang', '2028-01-01', 'nốt ruồi cạnh mắt trái', 014),
('030202001246',	'2021-03-02', 'Công an tỉnh Bắc Giang', '2028-01-01', 'sẹo cạnh mắt trái', 015),
('030202001247',	'2021-03-02', 'Công an tỉnh Bắc Giang', '2028-01-01', 'sẹo khoé mắt', 016),
('030202001248',	'2021-03-02', 'Công an tỉnh Bắc Giang', '2028-01-01', 'nốt ruồi son gần môi', 017),
('030202001249',	'2023-04-06', 'Công an tỉnh Nghệ An', '2028-01-01', 'nốt ruồi cạnh mắt phải', 018),
('030202001250',	'2023-04-06', 'Công an tỉnh Thái Bình', '2028-01-01', 'cằm có sẹo' , 021),
('030202001251',	'2023-04-06', 'Công an TP Hà Nội', '2028-01-01', 'nốt ruồi ở vành tai', 022),
('030202001252',	'2023-04-06', 'Công an tỉnh Thanh Hoá', '2025-03-02', 'nốt ruồi trên mũi', 023),
('030202001253',	'2023-04-06', 'Công an TP Hà Nội', '2025-03-02', 'sẹo trên mi mắt trái', 024),
('030202001254',	'2021-08-07', 'Công an TP Hà Nội', '2025-03-02', 'nốt ruồi ở mi mắt phải', 025),
('030202001255',	'2021-08-07', 'Công an tỉnh Hải Dương', '2025-03-02', 'nốt ruồi cạnh mắt trái', 026),
('030202001256',	'2021-08-07', 'Công an TP Hà Nội', '2025-03-02', 'sẹo cạnh mắt trái', 027),
('030202001257',	'2021-08-07', 'Công an TP Hà Nội', '2025-03-02', 'sẹo khoé mắt', 028),
('030202001258',	'2021-08-07', 'Công an TP Hải Phòng',	'2025-03-02', 'nốt ruồi son gần môi', 029),
('030202001259',	'2021-08-07', 'Công an TP Hà Nội', '2025-03-02', 'nốt ruồi cạnh mắt phải', 030),
('030202001260',	'2021-08-07', 'Công an TP Hà Nội', '2026-07-08', 'sẹo trên má trái', 031),
('030202001261',	'2021-08-07', 'Công an TP Hà Nội', '2026-07-08', 'nốt ruồi ở vành tai', 032),
('030202001262',	'2023-10-11', 'Công an tỉnh Nam Định', '2026-07-08', 'nốt ruồi dưới cằm', 033),
('030202001263',	'2023-10-11', 'Công an tỉnh Yên Bái',	'2026-07-08', 'sẹo trên mi mắt trái', 034),
('030202001264',	'2023-10-11', 'Công an tỉnh Nam Định', '2026-07-08', 'nốt ruồi ở mi mắt phải', 035),
('030202001265',	'2023-10-11', 'Công an tỉnh Lạng Sơn', '2026-07-08', 'nốt ruồi cạnh mắt trái', 036),
('030202001266',	'2023-10-11', 'Công an TP Hà Nội', '2026-07-08', 'sẹo cạnh mắt trái', 037),
('030202001267',	'2023-10-11', 'Công an tỉnh Lạng Sơn', '2026-07-08', 'sẹo khoé mắt', 038),
('030202001268',	'2022-04-07', 'Công an tỉnh Lạng Sơn', '2026-07-08', 'nốt ruồi son gần môi', 039),
('030202001269',	'2022-04-07', 'Công an tỉnh Bắc Giang', '2026-07-08', 'nốt ruồi cạnh mắt phải', 041),
('030202001270',	'2022-04-07', 'Công an TP Hà Nội', '2026-07-08', 'mũi có sẹo', 042),
('030202001271',	'2022-04-07', 'Công an TP Đà Nẵng', '2026-07-08', 'sẹo cạnh mắt trái', 043),
('030202001272',	'2022-04-07', 'Công an tỉnh Cao Bằng', '2026-07-08', 'nốt ruồi vành tai trái', 044),
('030202001273',	'2022-04-07', 'Công an tỉnh Thái Bình', '2026-07-08', 'có sẹo ở cằm', 045);

-- -----------------------------------------------------
-- Table `cnpm2023`.`KhaiTu`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cnpm2023`.`KhaiTu` (
  `IdKhaiTu` int NOT NULL ,
  `NgayChet` DATE NULL,
  `LyDoChet` VARCHAR(500) NULL DEFAULT NULL,
  `NgayKhai` DATE NULL,
  `IdNguoiChet`int NULL,
  `IdNguoiKhai` int NULL,
  PRIMARY KEY (`IdKhaiTu`),
  CONSTRAINT `KhaiTu_ibfk_1`
    FOREIGN KEY (`IdNguoiChet`)
    REFERENCES `cnpm2023`.`NhanKhau` (`IdNhanKhau`),
  CONSTRAINT `KhaiTu_ibfk_2`
    FOREIGN KEY (`IdNguoiKhai`)
    REFERENCES `cnpm2023`.`NhanKhau` (`IdNhanKhau`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_bin;

INSERT INTO `KhaiTu` (`IdKhaiTu`, `NgayChet`, `LyDoChet`, `NgayKhai`, `IdNguoiChet`,`IdNguoiKhai`) VALUES

(001, '2022-04-05', 'Covid',	'2022-04-05', 038, 035),
(002, '2021-03-10', 'Bệnh tật',	'2021-03-10', 013, 014),
(003, '2022-07-15', 'Tai nạn',	'2022-07-15', 004, 001),
(004, '2022-12-12', 'Bệnh tật',	'2022-12-12', 011, 009);

-- -----------------------------------------------------
-- Table `cnpm2023`.`SoHoKhau`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cnpm2023`.`SoHoKhau` (
  `IdHoKhau` int NOT NULL AUTO_INCREMENT,
  `NgayTao` DATE NULL,
  `DiaChi` VARCHAR(70) NULL,
  `IdChuHo` int NOT NULL,
  PRIMARY KEY (`IdHoKhau`),
  INDEX `IdChuHo` (`IdChuHo` ASC) VISIBLE,
  CONSTRAINT `SoHoKhau_ibfk_1`
    FOREIGN KEY (`IdChuHo`)
    REFERENCES `cnpm2023`.`NhanKhau` (`IdNhanKhau`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;
-- insert SoHoKhau
INSERT INTO `SoHoKhau` (`IdHoKhau`, `NgayTao`, `IdChuHo`, `DiaChi`) VALUES
(1, '2001-03-01', 1, '10 Lê Thanh Nghị, Bách Khoa, Hai Bà Trưng'),
(2, '2004-06-20', 5, '5 ngõ 30 Tạ Quang Bửu, Bách Khoa, Hai Bà Trưng'),
(3, '2015-04-16', 9, '8 ngõ 42 Tạ Quang Bửu, Bách Khoa, Hai Bà Trưng'),
(4, '2002-04-05', 13, '32 Trần Đại Nghĩa, Bách Khoa, Hai Bà Trưng'),
(5, '2010-06-08', 17, '15 Đại Cồ Việt, Bách Khoa, Hai Bà Trưng'),
(6, '2000-06-03', 21, '21 Tạ Quang Bửu, Bách Khoa, Hai Bà Trưng'),
(7, '2020-06-09', 24, '2 Nguyễn Hiền, Bách Khoa, Hai Bà Trưng'),
(8, '2006-08-24', 27, '61 Đại Cồ Việt, Bách Khoa, Hai Bà Trưng'),
(9, '2012-08-12', 32, '3 ngõ 33 Lê Thanh Nghị, Bách Khoa, Hai Bà Trưng'),
(10, '2021-07-06', 35, '15 ngõ 29 Ttaj Quang Bửu, Bách Khoa, Hai Bà Trưng'),
(11, '2022-03-02', 39, '75 Trần Đại Nghĩa, Bách Khoa, Hai Bà Trưng');

-- -----------------------------------------------------
-- Table `cnpm2023`.`ThanhVienHo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cnpm2023`.`ThanhVienHo` (
  `IdNhanKhau` int NOT NULL,
  `IdHoKhau` int NOT NULL,
  `QuanHeChuHo` VARCHAR(50) NULL,
  PRIMARY KEY (`IdNhanKhau`,`IdHoKhau`),
  INDEX `IdNhanKhau` (`IdNhanKhau` ASC) VISIBLE,
  INDEX `IdHoKhau` (`IdHoKhau` ASC) VISIBLE,
  CONSTRAINT `ThanhVienHo_ibfk_1`
    FOREIGN KEY (`IdNhanKhau`)
    REFERENCES `cnpm2023`.`NhanKhau` (`IdNhanKhau`),
  CONSTRAINT `ThanhVienHo_ibfk_2`
    FOREIGN KEY (`IdHoKhau`)
    REFERENCES `cnpm2023`.`SoHoKhau` (`IdHoKhau`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;
-- insert ThanhVienHo
INSERT INTO `ThanhVienHo` (`IdHoKhau`, `IdNhanKhau`, `QuanHeChuHo`) VALUES
(1, 001, 'chủ hộ'),
(1, 002, 'vợ'),
(1, 003, 'con'),
(1, 004, 'con'),
(2, 005, 'chủ hộ'),
(2, 006, 'vợ'),
(2, 007, 'con'),
(2, 008, 'con'),
(3, 009, 'chủ hộ'),
(3, 010, 'vợ'),
(3, 011, 'con'),
(3, 012, 'con'),
(4, 013, 'chủ hộ'),
(4, 014, 'vợ'),
(4, 015, 'con'),
(4, 016, 'con'),
(5, 017, 'chủ hộ'),
(5, 018, 'vợ'),
(5, 019, 'con'),
(5, 020, 'con'),
(6, 021, 'chủ hộ'),
(6, 022, 'vợ'),
(6, 023, 'con'),
(7, 024, 'chủ hộ'),
(7, 025, 'vợ'),
(7, 026, 'con'),
(8, 027, 'chủ hộ'),
(8, 028, 'vợ'),
(8, 029, 'con'),
(8, 030, 'con'),
(8, 031, 'con'),
(9, 032, 'chủ hộ'),
(9, 033, 'vợ'),
(9, 034, 'con'),
(10, 035, 'chủ hộ'),
(10, 036, 'vợ'),
(10, 037, 'con'),
(10, 038, 'con'),
(11, 039, 'chủ hộ'),
(11, 040, 'vợ'),
(1, 041, 'thuê trọ'),
(1, 042, 'thuê trọ'),
(3, 043, 'thuê trọ'),
(5, 044, 'thuê trọ');


-- -----------------------------------------------------
-- Table `cnpm2023`.`CachLy`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cnpm2023`.`CachLy` (
  `IdCachLy` int NOT NULL AUTO_INCREMENT,
  `ThoiGian` DATE NULL,
  `MucDo` VARCHAR(20) NULL,
  `DiaDiem` VARCHAR(50) NULL DEFAULT NULL,
  `IdNguoiCachLy` int NULL,
  PRIMARY KEY (`IdCachLy`),
  INDEX `IdNguoiCachLy` (`IdNguoiCachLy` ASC) VISIBLE,
  CONSTRAINT `CachLy_ibfk_1`
    FOREIGN KEY (`IdNguoiCachLy`)
    REFERENCES `cnpm2023`.`NhanKhau` (`IdNhanKhau`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- insert CachLy
INSERT INTO `CachLy` (`IdCachLy`, `ThoiGian`, `MucDo`, `DiaDiem`, `IdNguoiCachLy`) VALUES
(1, '2023-11-06', 'F1', 'tại nhà', 011),
(2, '2023-04-06', 'F2', 'trung tâm y tế phường Bách Khoa', 025),
(3, '2023-06-15', 'F1', 'trung tâm y tế phường Bách Khoa', 006),
(4, '2023-04-15', 'F0', 'bệnh viện Bạch Mai', 038),
(5, '2023-03-07', 'F1',	'tại nhà', 020),
(6, '2023-04-04', 'F1', 'trung tâm y tế phường Bách Khoa', 040);

-- -----------------------------------------------------
-- Table `cnpm2023`.`LichTrinh`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cnpm2023`.`LichTrinh` (
  `IdLichTrinh` int NOT NULL AUTO_INCREMENT,
  `IdNguoiKhai` int NOT NULL,
  `TenLichTrinh` VARCHAR(50) NULL,
  PRIMARY KEY (`IdLichTrinh`),
  INDEX `IdNguoiKhai` (`IdNguoiKhai` ASC) VISIBLE,
  CONSTRAINT `LichTrinh_ibfk_1`
    FOREIGN KEY (`IdNguoiKhai`)
    REFERENCES `cnpm2023`.`NhanKhau` (`IdNhanKhau`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;
-- insert LichTrinh
INSERT INTO `LichTrinh` (`IdLichTrinh`, `IdNguoiKhai`,`TenLichTrinh`) VALUES
(11, 011, 'Hà Nội - Hải Phòng'),	
(12, 025, 'Hà Nội - Quảng Ninh'),	
(13, 006, 'Hải Dương - Nghệ An'),	
(14, 038, 'Tp Hồ Chí Minh - Hà Nội');

-- -----------------------------------------------------
-- Table `cnpm2023`.`ThongTinDiChuyen`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cnpm2023`.`ThongTinDiChuyen` (
  `IdThongTin` int NOT NULL AUTO_INCREMENT,
  `PhuongTien` VARCHAR(50) NULL DEFAULT NULL,
  `ThoiGian` DATETIME NOT NULL,
  `DiaDiem` VARCHAR(50) NULL DEFAULT NULL,
  `IdLichTrinh` int NOT NULL,
  PRIMARY KEY (`IdThongTin`),
  INDEX `IdLichTrinh` (`IdLichTrinh` ASC) VISIBLE,
  CONSTRAINT `ThongTinDiChuyen_ibfk_1`
    FOREIGN KEY (`IdLichTrinh`)
    REFERENCES `cnpm2023`.`LichTrinh` (`IdLichTrinh`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;
-- insert ThongTinDiChuyen
INSERT INTO `ThongTinDiChuyen` (`IdThongTin`, `PhuongTien`, `ThoiGian`, `DiaDiem`, `IdLichTrinh`) VALUES

(1, 'xe máy', '2023-11-06', 'Bệnh viện Nhiệt Đới Trung Ương, Hà Nội', 11),
(2, 'xe bus', '2023-11-07', 'Đồ Sơn, Hải Phòng', 11),
(3, 'ô tô', '2023-04-06', 'Đại học Bách Khoa Hà Nội', 12),
(4, 'ô tô', '2023-04-08', 'Cẩm Phả, Quảng Ninh', 12),
(5, 'xe máy', '2023-06-15', 'Cẩm Giàng, Hải Dương', 13),
(6, 'xe khách', '2023-06-16', 'Kim Sơn, Nghệ An', 13),
(7, 'xe máy', '2023-06-18', 'Hưng Hòa, Nghệ An', 13),
(8, 'xe bus', '2023-04-04', 'Quận 1, Tp Hồ Chí Minh',14),
(9, 'xe bus', '2023-04-04', 'Đại học Bách Khoa Hà Nội',14);


-- -----------------------------------------------------
-- Table `cnpm2023`.`TamTru`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cnpm2023`.`TamTru` (
  `IdTamTru` int NOT NULL AUTO_INCREMENT,
  `NgayTao` DATE NULL DEFAULT NULL,
  `NgayKetThuc` DATE NULL DEFAULT NULL,
  `IdNguoiTamTru` int NULL DEFAULT NULL,
  `IdHoKhau` int NULL DEFAULT NULL,
  PRIMARY KEY (`IdTamTru`),
  INDEX `IdNguoiTamTru` (`IdNguoiTamTru` ASC) VISIBLE,
  INDEX `IdHoKhau` (`IdHoKhau` ASC) VISIBLE,
  CONSTRAINT `TamTru_ibfk_1`
    FOREIGN KEY (`IdNguoiTamTru`)
    REFERENCES `cnpm2023`.`NhanKhau` (`IdNhanKhau`),
  CONSTRAINT `TamTru_ibfk_2`
    FOREIGN KEY (`IdHoKhau`)
    REFERENCES `cnpm2023`.`SoHoKhau` (`IdHoKhau`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;
-- insert tamtru
INSERT INTO `TamTru` (`IdTamTru`, `NgayTao`, `NgayKetThuc`, `IdNguoiTamTru`, `IdHoKhau`) VALUES
(1, '2022-02-03', '2024-02-03',	041, 1),
(2, '2022-04-01', '2024-10-01',	042, 1),
(3, '2022-10-28', '2024-05-01',	043, 3),
(4, '2021-07-15', '2023-07-15',	044, 5);


-- -----------------------------------------------------
-- Table `cnpm2023`.`TamVang`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cnpm2023`.`TamVang` (
  `IdTamVang` int NOT NULL AUTO_INCREMENT,
  `NgayTao` DATE NULL,
  `NgayKetThuc` DATE NULL DEFAULT NULL,
  `IdNguoiTamVang` int NOT NULL,
  PRIMARY KEY (`IdTamVang`),
  INDEX `IdNguoiTamVang` (`IdNguoiTamVang` ASC) VISIBLE,
  CONSTRAINT `temporarilyabsent_ibfk_1`
    FOREIGN KEY (`IdNguoiTamVang`)
    REFERENCES `cnpm2023`.`NhanKhau` (`IdNhanKhau`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;
-- insert TamVang
INSERT INTO `TamVang` (`IdTamVang`, `NgayTao`, `NgayKetThuc`, `IdNguoiTamVang`) VALUES
(1, '2023-02-02', '2024-02-02',	003),
(2, '2023-05-01', '2024-01-11',	023),
(3, '2023-06-14', '2025-06-14',	028),
(4, '2023-04-01', '2023-01-11',	017),
(5, '2022-03-10', '2023-10-10',	037);

-- -----------------------------------------------------
-- Table `cnpm2023`.`XetNghiem`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cnpm2023`.`XetNghiem` (
  `IdXetNghiem` int NOT NULL AUTO_INCREMENT,
  `HinhThuc` VARCHAR(50) NULL DEFAULT NULL,
  `ThoiGian` DATETIME NULL DEFAULT NULL,
  `KetQua` VARCHAR(50) NULL DEFAULT NULL,
  `IdNguoiXetNghiem` int NULL DEFAULT NULL,
  PRIMARY KEY (`IdXetNghiem`),
  INDEX `IdNguoiXetNghiem` (`IdNguoiXetNghiem` ASC) VISIBLE,
  CONSTRAINT `XetNghiem_ibfk_1`
    FOREIGN KEY (`IdNguoiXetNghiem`)
    REFERENCES `cnpm2023`.`NhanKhau` (`IdNhanKhau`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- insert Xetnghiem
INSERT INTO `XetNghiem` (`IdXetNghiem`, `HinhThuc`, `ThoiGian`, `KetQua`, `IdNguoiXetNghiem`) VALUES
(1, 'Test Nhanh', '2023-06-11 14:22:43', 'TRUE', 11),
(2, 'PCR', '2023-06-04 20:00:00', 'TRUE', 25),
(3, 'PCR', '2023-06-15 08:15:50', 'TRUE', 6),
(4, 'Test Nhanh', '2023-05-14 10:00:20', 'TRUE', 38),
(5, 'Test Nhanh', '2023-07-03 23:30:00', 'FALSE', 20),
(6, 'Test Nhanh', '2023-04-04 20:15:10', 'FALSE', 40);


-- -----------------------------------------------------
-- Table `cnpm2023`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cnpm2023`.`user` (
  `userId` int NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(50) NULL DEFAULT NULL,
  `password` VARCHAR(50) NULL DEFAULT NULL,
  `role` BOOLEAN NOT NULL,
  PRIMARY KEY (`userId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;
-- insert User
INSERT INTO `User` (`userId`, `username`, `password`, `role`) VALUES
(11, 'phamtrungdung', 'dung12345', 1),
(13, 'machungthanh', 'thanh12344', 0),
(18, 'letheky', 'kybruh1234', 1),
(21, 'hoangtheanh', 'superidol', 0),
(22, 'nguyenvanhao', 'haodeptrai123', 1);

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;