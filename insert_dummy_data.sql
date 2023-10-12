INSERT INTO nguoi(ma_so_dinh_danh, ngay_sinh, ho_ten, gioi_tinh, dia_chi_thuong_chu, loai)
VALUES
	('034200001001', '2000-01-01', 'Kim Van Anh', 'Nu', 'Ha Tay', 'Sinh vien'),
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
    
INSERT INTO nguoi_sdt(ma_so_dinh_danh, so_dien_thoai)
SELECT ma_so_dinh_danh, CONCAT('0', LPAD(FLOOR(RAND() * 1000000000), 9, '0'))
FROM nguoi;

INSERT INTO sinh_vien(ma_so_dinh_danh_S, ma_sv, lop)
SELECT ma_so_dinh_danh, 
       CONCAT('B18DCCN', LPAD(FLOOR(RAND() * 1000), 3, '0')), 
       CONCAT('D18CQCN0', (1 + FLOOR(RAND() * 9)))
FROM nguoi
WHERE loai = 'Sinh vien';

INSERT INTO khach(ma_so_dinh_danhh_K, nghe_nghiep)
SELECT ma_so_dinh_danh,
       CASE
           WHEN RAND() <= 0.25 THEN 'Ky su'
           WHEN RAND() <= 0.5 THEN 'Bac sy'
           WHEN RAND() <= 0.75 THEN 'Giang vien'
           ELSE 'Ke toan'
       END
FROM nguoi
WHERE loai = 'Khach';

INSERT INTO ky_tuc_xa(ten_ky_tuc_xa, so_luong_phong, dia_chi)
VALUES
    ('KTX A1', 10, 'So 10 Tran Phu, Ha Noi'),
    ('KTX A2', 12, 'So 10 Tran Phu, Ha Noi'),
    ('KTX A3', 15, 'So 10 Tran Phu, Ha Noi');

INSERT INTO nhan_vien_ql (ma_so_dinh_danh_N, trinh_do, ten_ky_tuc_xa)
SELECT ma_so_dinh_danh, 'Cu nhan', (
    SELECT ten_ky_tuc_xa 
    FROM ky_tuc_xa
    WHERE ten_ky_tuc_xa NOT IN (
        SELECT ten_ky_tuc_xa
        FROM nhan_vien_ql
    )
    ORDER BY RAND()
    LIMIT 1
)
FROM nguoi
WHERE loai = 'Nhan vien';

INSERT INTO loai_phong(ma_loai_phong, ten_loai_phong, dien_tich, gia, so_SV_toi_da)
VALUES
    ('L001', 'VIP', 70, 1000000, 6),
    ('L002', 'Cao cap', 60, 800000, 8),
    ('L003', 'Thuong', 50, 600000, 10);

INSERT INTO phong(ten_ky_tuc_xa, ten_phong, so_SV_hien_co, tang, ma_loai_phong)
VALUES 
	('KTX A1', 'P101', 4, 1, 'L001'),
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
	('KTX A3', 'P101', 4, 1, 'L001'),
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
    