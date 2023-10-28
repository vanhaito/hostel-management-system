-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.19 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Dumping data for table quan_ly_ktx.hoa_don_dien_nuoc: ~0 rows (approximately)
/*!40000 ALTER TABLE `hoa_don_dien_nuoc` DISABLE KEYS */;
INSERT INTO `hoa_don_dien_nuoc` (`ma_hoa_don`, `ngay_lap_hoa_don`, `chi_so_dien_dau`, `chi_so_dien_cuoi`, `chi_so_nuoc_dau`, `chi_so_nuoc_cuoi`, `don_gia_dien`, `don_gia_nuoc`, `ngay_bat_dau`, `ngay_ket_thuc`, `ten_ktx`, `ten_phong`) VALUES
	(1, '2023-10-18', 244, 487, 297, 387, 2500, 25000, '2023-09-01', '2023-09-30', 'KTX A3', 'P102');
/*!40000 ALTER TABLE `hoa_don_dien_nuoc` ENABLE KEYS */;

-- Dumping data for table quan_ly_ktx.hop_dong: ~3 rows (approximately)
/*!40000 ALTER TABLE `hop_dong` DISABLE KEYS */;
INSERT INTO `hop_dong` (`ma_hop_dong`, `ngay_bat_dau`, `ngay_ket_thuc`, `ma_SV`, `ma_so_dinh_danh_N`, `ten_phong`, `ten_ktx`) VALUES
	(1, '2023-03-21', '2024-10-17', 'B18DCCN471', '034500002004', 'P101', 'KTX A3'),
	(2, '2023-02-13', '2024-10-17', 'B18DCCN144', '034500002004', 'P301', 'KTX A2'),
	(3, '2023-10-10', '2024-10-17', 'B18DCCN102', '034500002004', 'P101', 'KTX A3');
/*!40000 ALTER TABLE `hop_dong` ENABLE KEYS */;

-- Dumping data for table quan_ly_ktx.khach: ~5 rows (approximately)
/*!40000 ALTER TABLE `khach` DISABLE KEYS */;
INSERT INTO `khach` (`ma_so_dinh_danh_K`, `nghe_nghiep`) VALUES
	('034600002001', 'Ky su'),
	('034600002002', 'Ky su'),
	('034600002003', 'Giang vien'),
	('034600002004', 'Giang vien'),
	('034600002005', 'Bac sy');
/*!40000 ALTER TABLE `khach` ENABLE KEYS */;

-- Dumping data for table quan_ly_ktx.ky_tuc_xa: ~3 rows (approximately)
/*!40000 ALTER TABLE `ky_tuc_xa` DISABLE KEYS */;
INSERT INTO `ky_tuc_xa` (`ten_ky_tuc_xa`, `so_luong_phong`, `dia_chi`) VALUES
	('KTX A1', 10, 'So 10 Tran Phu, Ha Noi'),
	('KTX A2', 12, 'So 10 Tran Phu, Ha Noi'),
	('KTX A3', 15, 'So 10 Tran Phu, Ha Noi');
/*!40000 ALTER TABLE `ky_tuc_xa` ENABLE KEYS */;

-- Dumping data for table quan_ly_ktx.lan_giat: ~2 rows (approximately)
/*!40000 ALTER TABLE `lan_giat` DISABLE KEYS */;
INSERT INTO `lan_giat` (`ma_luot_giat`, `don_gia`, `khoi_luong`, `ngay_giat`, `ma_SV`) VALUES
	(1, 15000, 7, '2023-08-26 00:00:00', 'B18DCCN471'),
	(2, 4999, 5, '2023-10-21 07:00:00', 'B18DCCN102');
/*!40000 ALTER TABLE `lan_giat` ENABLE KEYS */;

-- Dumping data for table quan_ly_ktx.lan_gui_xe: ~0 rows (approximately)
/*!40000 ALTER TABLE `lan_gui_xe` DISABLE KEYS */;
INSERT INTO `lan_gui_xe` (`ma_lan_gui`, `thoi_gian_gui`, `thoi_gian_lay`, `bien_so_xe`, `ma_SV`) VALUES
	(1, '2023-10-05 14:29:43', '2023-10-18 00:12:09', '29A5-00866', 'B18DCCN144');
/*!40000 ALTER TABLE `lan_gui_xe` ENABLE KEYS */;

-- Dumping data for table quan_ly_ktx.loai_phong: ~3 rows (approximately)
/*!40000 ALTER TABLE `loai_phong` DISABLE KEYS */;
INSERT INTO `loai_phong` (`ma_loai_phong`, `ten_loai_phong`, `dien_tich`, `gia`, `so_SV_toi_da`) VALUES
	('L001', 'VIP', '70', 1000000, 6),
	('L002', 'Cao cap', '60', 800000, 8),
	('L003', 'Thuong', '50', 600000, 10);
/*!40000 ALTER TABLE `loai_phong` ENABLE KEYS */;

-- Dumping data for table quan_ly_ktx.luot_tham: ~2 rows (approximately)
/*!40000 ALTER TABLE `luot_tham` DISABLE KEYS */;
INSERT INTO `luot_tham` (`ma_luot_tham`, `thoi_gian_den`, `thoi_gian_di`, `ma_sv`, `ma_so_dinh_danh_K`) VALUES
	(3, '2023-10-19 01:14:54', '2023-10-20 01:14:58', 'B18DCCN042', '034600002002'),
	(4, '2023-10-24 01:15:54', '2023-10-24 03:14:58', 'B18DCCN042', '034600002005'),
	(5, '2023-10-25 01:15:54', '2023-10-25 03:14:58', 'B18DCCN042', '034600002005');
/*!40000 ALTER TABLE `luot_tham` ENABLE KEYS */;

-- Dumping data for table quan_ly_ktx.nguoi: ~40 rows (approximately)
/*!40000 ALTER TABLE `nguoi` DISABLE KEYS */;
INSERT INTO `nguoi` (`ma_so_dinh_danh`, `ngay_sinh`, `ho_ten`, `gioi_tinh`, `dia_chi_thuong_chu`, `loai`) VALUES
	('034200001001', '2000-01-01', 'Kim Van Anh', 'Nu', 'Hà Tây', 'Sinh vien'),
	('034200001002', '2000-01-02', 'Nguyen Quynh Anh', 'Nu', 'Ha Noi', 'Sinh vien'),
	('034200001003', '2000-01-03', 'Quan Van Chung', 'Nam', 'Ha Tay', 'Sinh vien'),
	('034200001004', '2000-01-04', 'Do Trong Duc', 'Nam', 'Hung Yen', 'Sinh vien'),
	('034200001005', '2000-01-05', 'Nguyen Van Duy', 'Nam', 'Nam Dinh', 'Sinh vien'),
	('034200001006', '2000-02-05', 'Do Van Trung', 'Nam', 'Ha Tay', 'Sinh vien'),
	('034200001007', '2000-02-06', 'Nguyen Van Duc', 'Nam', 'Lao Cai', 'Sinh vien'),
	('034200001008', '2000-02-07', 'Lai Van Ha', 'Nam', 'Ha Tinh', 'Sinh vien'),
	('034200001009', '2000-02-08', 'Nguyen Sy Hai', 'Nam', 'Phu Tho', 'Sinh vien'),
	('034300001005', '2000-03-05', 'Do Thanh Long', 'Nam', 'Ha Noi', 'Sinh vien'),
	('034300001006', '2000-03-06', 'Do Viet Long', 'Nam', 'Nam Dinh', 'Sinh vien'),
	('034300001007', '2000-03-08', 'Pham Duc Minh', 'Nam', 'Ninh Binh', 'Sinh vien'),
	('034300001008', '2000-03-09', 'Bui Phuong Ngoc Mai', 'Nu', 'Ha Noi', 'Sinh vien'),
	('034300001010', '2000-03-10', 'Vo Minh Manh', 'Nam', 'Ha Tinh', 'Sinh vien'),
	('034300001011', '2000-03-11', 'Bui Quang Minh', 'Nam', 'Hai Phong', 'Sinh vien'),
	('034300001012', '2000-03-12', 'Nguyen Huu Mung', 'Nam', 'Bac Ninh', 'Sinh vien'),
	('034300001013', '2000-03-13', 'Nguyen Anh Tuan', 'Nam', 'Ha Noi', 'Sinh vien'),
	('034300001014', '2000-03-14', 'Nguyen Hong Thai', 'Nam', 'Ha Noi', 'Sinh vien'),
	('034300001015', '2000-03-15', 'Pham Van Thanh', 'Nam', 'Nam Dinh', 'Sinh vien'),
	('034400001001', '2000-04-01', 'Nguyen Ngoc Thanh', 'Nam', 'Bac Giang', 'Sinh vien'),
	('034400001002', '2000-04-02', 'Tran Thanh Duong', 'Nam', 'Ha Tay', 'Sinh vien'),
	('034400001003', '2000-04-03', 'Nguyen Duy Dat', 'Nam', 'Ha Tay', 'Sinh vien'),
	('034400001004', '2000-04-04', 'Vu Thi Thu Hang', 'Nu', 'Ninh Binh', 'Sinh vien'),
	('034400001005', '2000-04-05', 'Pham Huy Hoang', 'Nam', 'Ha Noi', 'Sinh vien'),
	('034400001006', '2000-04-06', 'Nguyen Cong Huy', 'Nam', 'Ha Noi', 'Sinh vien'),
	('034400001007', '2000-04-07', 'Dao Quang Hung', 'Nam', 'Hai Duong', 'Sinh vien'),
	('034400001008', '2000-04-08', 'Nguyen Ngoc Khanh', 'Nam', 'Ha Tay', 'Sinh vien'),
	('034400001009', '2000-04-08', 'Ho Sy Lam', 'Nam', 'Nghe An', 'Sinh vien'),
	('034400001010', '2000-04-09', 'Nguyen Thanh Long', 'Nam', 'Thai Binh', 'Sinh vien'),
	('034400001011', '2000-04-10', 'Vu Bao Long', 'Nam', 'Ha Tay', 'Sinh vien'),
	('034500002001', '1995-01-01', 'Tran Do Minh', 'Nam', 'Ha Noi', 'Nhan vien'),
	('034500002002', '1995-01-02', 'Nguyen Viet Nam', 'Nam', 'Ha Giang', 'Nhan vien'),
	('034500002003', '1995-01-03', 'Tran Xuan Nghiep', 'Nam', 'Ha Nam', 'Nhan vien'),
	('034500002004', '1995-01-04', 'Vu Minh Quang', 'Nam', 'Ha Tay', 'Nhan vien'),
	('034500002005', '1995-01-05', 'Dinh Thai Son', 'Nam', 'Ha Noi', 'Nhan vien'),
	('034600002001', '1999-10-01', 'Phung Dinh Son', 'Nam', 'Vinh Phuc', 'Khach'),
	('034600002002', '1999-10-02', 'Dinh Dieu Thu', 'Nu', 'Quang Ninh', 'Khach'),
	('034600002003', '1999-10-03', 'Lai Thi Duyen', 'Nu', 'Thai Binh', 'Khach'),
	('034600002004', '1999-10-04', 'Nguyen Manh Truong', 'Nam', 'Ha Noi', 'Khach'),
	('034600002005', '1999-10-05', 'Truong Van Thang', 'Nam', 'Thanh Hoa', 'Khach');
/*!40000 ALTER TABLE `nguoi` ENABLE KEYS */;

-- Dumping data for table quan_ly_ktx.nguoi_sdt: ~40 rows (approximately)
/*!40000 ALTER TABLE `nguoi_sdt` DISABLE KEYS */;
INSERT INTO `nguoi_sdt` (`ma_so_dinh_danh`, `so_dien_thoai`) VALUES
	('034200001001', '0644819480'),
	('034200001002', '0321464537'),
	('034200001003', '0672864272'),
	('034200001004', '0399927784'),
	('034200001005', '0981046132'),
	('034200001006', '0705447341'),
	('034200001007', '0584098342'),
	('034200001008', '0804149716'),
	('034200001009', '0268453588'),
	('034300001005', '0929818820'),
	('034300001006', '0843733367'),
	('034300001007', '0429210407'),
	('034300001008', '0614851964'),
	('034300001010', '0786628630'),
	('034300001011', '0088587291'),
	('034300001012', '0083050596'),
	('034300001013', '0149491138'),
	('034300001014', '0498303935'),
	('034300001015', '0043046291'),
	('034400001001', '0720319679'),
	('034400001002', '0472459556'),
	('034400001003', '0201338771'),
	('034400001004', '0589315222'),
	('034400001005', '0342559825'),
	('034400001006', '0944853493'),
	('034400001007', '0696588022'),
	('034400001008', '0648379660'),
	('034400001009', '0152134267'),
	('034400001010', '0815532387'),
	('034400001011', '0621259162'),
	('034500002001', '0659698683'),
	('034500002002', '0434715959'),
	('034500002003', '0194483778'),
	('034500002004', '0668271044'),
	('034500002005', '0757903919'),
	('034600002001', '0784706492'),
	('034600002002', '0649820736'),
	('034600002003', '0894984234'),
	('034600002004', '0525458992'),
	('034600002005', '0942342288');
/*!40000 ALTER TABLE `nguoi_sdt` ENABLE KEYS */;

-- Dumping data for table quan_ly_ktx.nhan_vien_ql: ~5 rows (approximately)
/*!40000 ALTER TABLE `nhan_vien_ql` DISABLE KEYS */;
INSERT INTO `nhan_vien_ql` (`ma_so_dinh_danh_N`, `trinh_do`, `ten_ky_tuc_xa`) VALUES
	('034500002001', 'Cu nhan', 'KTX A2'),
	('034500002002', 'Cu nhan', 'KTX A3'),
	('034500002003', 'Cu nhan', 'KTX A1'),
	('034500002004', 'Cu nhan', 'KTX A3'),
	('034500002005', 'Cu nhan', 'KTX A1');
/*!40000 ALTER TABLE `nhan_vien_ql` ENABLE KEYS */;

-- Dumping data for table quan_ly_ktx.phong: ~37 rows (approximately)
/*!40000 ALTER TABLE `phong` DISABLE KEYS */;
INSERT INTO `phong` (`ten_ky_tuc_xa`, `ten_phong`, `so_SV_hien_co`, `tang`, `ma_loai_phong`) VALUES
	('KTX A1', 'P101', 4, 2, 'L001'),
	('KTX A1', 'P102', 3, 1, 'L001'),
	('KTX A1', 'P103', 5, 1, 'L002'),
	('KTX A1', 'P104', 6, 1, 'L002'),
	('KTX A1', 'P105', 2, 1, 'L002'),
	('KTX A1', 'P201', 1, 2, 'L003'),
	('KTX A1', 'P202', 7, 2, 'L003'),
	('KTX A1', 'P203', 6, 2, 'L003'),
	('KTX A1', 'P204', 4, 2, 'L003'),
	('KTX A1', 'P205', 2, 2, 'L003'),
	('KTX A2', 'P101', 2, 1, 'L001'),
	('KTX A2', 'P102', 4, 1, 'L001'),
	('KTX A2', 'P103', 5, 1, 'L001'),
	('KTX A2', 'P104', 5, 1, 'L001'),
	('KTX A2', 'P105', 6, 1, 'L002'),
	('KTX A2', 'P201', 1, 2, 'L002'),
	('KTX A2', 'P202', 7, 2, 'L002'),
	('KTX A2', 'P203', 3, 2, 'L002'),
	('KTX A2', 'P204', 5, 2, 'L003'),
	('KTX A2', 'P205', 6, 2, 'L003'),
	('KTX A2', 'P301', 3, 3, 'L003'),
	('KTX A2', 'P302', 6, 3, 'L003'),
	('KTX A3', 'P101', 5, 1, 'L001'),
	('KTX A3', 'P102', 5, 1, 'L001'),
	('KTX A3', 'P103', 6, 1, 'L001'),
	('KTX A3', 'P104', 2, 1, 'L001'),
	('KTX A3', 'P105', 4, 1, 'L001'),
	('KTX A3', 'P201', 5, 2, 'L002'),
	('KTX A3', 'P202', 3, 2, 'L002'),
	('KTX A3', 'P203', 6, 2, 'L002'),
	('KTX A3', 'P204', 7, 2, 'L002'),
	('KTX A3', 'P205', 8, 2, 'L002'),
	('KTX A3', 'P301', 3, 3, 'L003'),
	('KTX A3', 'P302', 5, 3, 'L003'),
	('KTX A3', 'P303', 9, 3, 'L003'),
	('KTX A3', 'P304', 6, 3, 'L003'),
	('KTX A3', 'P305', 1, 3, 'L003');
/*!40000 ALTER TABLE `phong` ENABLE KEYS */;

-- Dumping data for table quan_ly_ktx.sinh_vien: ~30 rows (approximately)
/*!40000 ALTER TABLE `sinh_vien` DISABLE KEYS */;
INSERT INTO `sinh_vien` (`ma_so_dinh_danh_S`, `ma_sv`, `lop`) VALUES
	('034400001004', 'B18DCCN037', 'D18CQCN05'),
	('034200001003', 'B18DCCN042', 'D18CQCN04'),
	('034300001010', 'B18DCCN051', 'D18CQCN08'),
	('034300001011', 'B18DCCN102', 'D18CQCN09'),
	('034400001006', 'B18DCCN144', 'D18CQCN06'),
	('034400001002', 'B18DCCN145', 'D18CQCN01'),
	('034200001005', 'B18DCCN177', 'D18CQCN06'),
	('034300001013', 'B18DCCN215', 'D18CQCN05'),
	('034400001010', 'B18DCCN266', 'D18CQCN03'),
	('034200001008', 'B18DCCN296', 'D18CQCN07'),
	('034300001008', 'B18DCCN320', 'D18CQCN08'),
	('034400001008', 'B18DCCN337', 'D18CQCN06'),
	('034200001006', 'B18DCCN371', 'D18CQCN02'),
	('034400001011', 'B18DCCN398', 'D18CQCN03'),
	('034400001005', 'B18DCCN446', 'D18CQCN07'),
	('034200001007', 'B18DCCN454', 'D18CQCN09'),
	('034200001002', 'B18DCCN471', 'D18CQCN03'),
	('034300001012', 'B18DCCN480', 'D18CQCN05'),
	('034200001009', 'B18DCCN538', 'D18CQCN06'),
	('034200001004', 'B18DCCN555', 'D18CQCN07'),
	('034300001005', 'B18DCCN556', 'D18CQCN08'),
	('034400001001', 'B18DCCN662', 'D18CQCN03'),
	('034300001015', 'B18DCCN716', 'D18CQCN04'),
	('034400001007', 'B18DCCN717', 'D18CQCN07'),
	('034300001006', 'B18DCCN725', 'D18CQCN09'),
	('034300001014', 'B18DCCN771', 'D18CQCN04'),
	('034300001007', 'B18DCCN781', 'D18CQCN09'),
	('034400001003', 'B18DCCN807', 'D18CQCN09'),
	('034400001009', 'B18DCCN963', 'D18CQCN01'),
	('034200001001', 'B18DCCN991', 'D18CQCN07');
/*!40000 ALTER TABLE `sinh_vien` ENABLE KEYS */;

-- Dumping data for table quan_ly_ktx.ve_xe: ~0 rows (approximately)
/*!40000 ALTER TABLE `ve_xe` DISABLE KEYS */;
INSERT INTO `ve_xe` (`bien_so_xe`, `loai_xe`, `mau_xe`, `trang_thai`, `ma_sv`) VALUES
	('17n2378443', 'sdvfv', 'sfrv', 1, 'B18DCCN144'),
	('29A5-00866', 'airblade', 'đen', 1, 'B18DCCN144');
/*!40000 ALTER TABLE `ve_xe` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
