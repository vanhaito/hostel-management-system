-- In thông tin sinh viên trong KTX cùng số tiền mà họ phải trả cho tất cả các dịch vụ (bao gồm cả tiền phòng, trừ dịch vụ điện nước) đã sử dụng trong mỗi tháng. Thông tin này có thể in theo danh sách (theo phòng, theo KTX) hoặc theo từng người. 
SET @start_date = '2023-01-01';
SET @end_date = '2023-12-01';
SELECT
    sv.ma_sv AS MaSinhVien,
    ng.ho_ten AS HoTen,
    sv.lop as LOP,
    SUM(IFNULL(lp.gia, 0) + IFNULL(gx.gia_tien, 0) + IFNULL(vx.gia_tien, 0) + IFNULL(lg.tien_giat, 0)) AS TongTien
FROM
    sinh_vien sv
LEFT JOIN
    nguoi ng ON sv.ma_so_dinh_danh_S = ng.ma_so_dinh_danh
LEFT JOIN
    hop_dong hd ON sv.ma_sv = hd.ma_SV
LEFT JOIN
    phong p ON hd.ten_phong = p.ten_phong AND hd.ten_ktx = p.ten_ky_tuc_xa
LEFT JOIN
    loai_phong lp ON p.ma_loai_phong = lp.ma_loai_phong
LEFT JOIN
    (SELECT ma_sv, COUNT(*) * 3000 AS gia_tien
    FROM lan_gui_xe
    WHERE thoi_gian_gui BETWEEN @start_date AND @end_date
    GROUP BY ma_sv) gx ON sv.ma_sv = gx.ma_SV
LEFT JOIN
    (SELECT ma_sv, COUNT(*) * 100000 AS gia_tien
    FROM ve_xe
    GROUP BY ma_sv) vx ON sv.ma_sv = vx.ma_sv
LEFT JOIN
    (SELECT ma_SV, SUM(don_gia * khoi_luong) AS tien_giat
    FROM lan_giat
    WHERE ngay_giat BETWEEN @start_date AND @end_date
    GROUP BY ma_SV) lg ON sv.ma_sv = lg.ma_SV
GROUP BY sv.ma_sv ;


-- In thông tin sinh viên cùng tên dịch vụ, tổng giá mỗi dịch vụ mà họ sử dụng trong khoảng thời gian từ ngày bắt đầu đến ngày kết thúc.  
SET @start_date = '2023-01-01'; 
SET @end_date = '2023-12-01';  
SELECT
    sv.ma_sv AS MaSinhVien,
	ng.ho_ten AS HoTen,
	sv.lop as LOP,
    SUM(IFNULL(lp.gia, 0)) AS TienPhong,
    SUM(IFNULL(gx.gia_tien, 0)) AS TienGuiXe,
    SUM(IFNULL(vx.gia_tien, 0)) AS TienVeXe,
    SUM(IFNULL(lg.tien_giat, 0)) AS TienGiat
FROM
    sinh_vien sv
LEFT JOIN
	nguoi ng ON sv.ma_so_dinh_danh_S = ng.ma_so_dinh_danh
LEFT JOIN
    hop_dong hd ON sv.ma_sv = hd.ma_SV
LEFT JOIN
    phong p ON hd.ten_phong = p.ten_phong AND hd.ten_ktx = p.ten_ky_tuc_xa
LEFT JOIN
    loai_phong lp ON p.ma_loai_phong = lp.ma_loai_phong
LEFT JOIN
    (SELECT ma_sv, COUNT(*) * 3000 AS gia_tien
    FROM lan_gui_xe
    WHERE thoi_gian_gui BETWEEN @start_date AND @end_date
    GROUP BY ma_sv) gx ON sv.ma_sv = gx.ma_sv
LEFT JOIN
    (SELECT ma_sv, COUNT(*) * 100000 AS gia_tien
    FROM ve_xe
    GROUP BY ma_sv) vx ON sv.ma_sv = vx.ma_sv
LEFT JOIN
    (SELECT ma_SV, SUM(don_gia * khoi_luong) AS tien_giat
    FROM lan_giat
    WHERE ngay_giat BETWEEN @start_date AND @end_date
    GROUP BY ma_SV) lg ON sv.ma_sv = lg.ma_SV
GROUP BY sv.ma_sv;


-- In danh mục các dịch vụ cùng doanh thu của mỗi dịch vụ trong KTX trong mỗi tháng.  
SET @start_date = '2023-01-01'; 
SET @end_date = '2023-12-01';   
SELECT
    'ThuePhong' AS DichVu,
    SUM(IFNULL(lp.gia, 0)) AS DoanhThu
FROM
    phong p
LEFT JOIN
    loai_phong lp ON p.ma_loai_phong = lp.ma_loai_phong
LEFT JOIN
    hop_dong hd ON p.ten_phong = hd.ten_phong AND p.ten_ky_tuc_xa = hd.ten_ktx
WHERE
    hd.ngay_bat_dau BETWEEN @start_date AND @end_date
    AND hd.ngay_ket_thuc BETWEEN @start_date AND @end_date
UNION
SELECT
    'GuiXe' AS DichVu,
    SUM(IFNULL(gx.gia_tien, 0)) AS DoanhThu
FROM
    (SELECT ma_sv, COUNT(*) * 3000 AS gia_tien
    FROM lan_gui_xe
    WHERE thoi_gian_gui BETWEEN @start_date AND @end_date
    GROUP BY ma_sv) gx
UNION
SELECT
    'VeXe' AS DichVu,
    SUM(IFNULL(vx.gia_tien, 0)) AS DoanhThu
FROM
    (SELECT ma_sv, COUNT(*) * 100000 AS gia_tien
    FROM ve_xe
    GROUP BY ma_sv) vx
UNION
SELECT
    'GiatDo' AS DichVu,
    SUM(IFNULL(lg.tien_giat, 0)) AS DoanhThu
FROM
    (SELECT ma_SV, SUM(don_gia * khoi_luong) AS tien_giat
    FROM lan_giat
    WHERE ngay_giat BETWEEN @start_date AND @end_date
    GROUP BY ma_SV) lg;
