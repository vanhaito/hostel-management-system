-- hop dong----------
INSERT INTO hop_dong (ma_hop_dong, ngay_bat_dau, ngay_ket_thuc, ma_SV, ma_so_dinh_danh_N, ten_phong, ten_ktx)
SELECT CONCAT('HD', LPAD(FLOOR(RAND() * 1000), 5, '0')),
       (SELECT CURRENT_DATE() - INTERVAL FLOOR(RAND() * 14 * 24) DAY),
       CURRENT_DATE(),
       (SELECT ma_SV FROM sinh_vien ORDER BY RAND() LIMIT 1),
       (SELECT ma_so_dinh_danh_N FROM nhan_vien_ql ORDER BY RAND() LIMIT 1),
       (SELECT ten_phong FROM phong, ky_tuc_xa where ky_tuc_xa.ten_ky_tuc_xa = phong.ten_ky_tuc_xa ORDER BY RAND() LIMIT 1),
       (SELECT ten_ky_tuc_xa FROM ky_tuc_xa ORDER BY RAND() LIMIT 1);
       
-- ----hoa don dien nuoc----------
insert into hoa_don_dien_nuoc(na_hoa_don, ngay_lap_hoa_don, chi_so_dien_dau, chi_so_dien_cuoi, 
chi_so_nuoc_dau, chi_so_nuoc_cuoi, don_gia_dien, don_gia_nuoc, ngay_bat_dau, ngay_ket_thuc, ten_ktx, ten_phong)
select concat('HDDN', lpad(floor(rand()*1000), 5, '0')),
current_date(),
round(rand() * (300-100) + 100),
round(rand() * (600-301) + 301),
round(rand() * (300-250) + 250),
round(rand() * (400-301) + 301),
'2500',
'25000', 
'2023-09-01',
'2023-09-30',
(select ten_ktx from hop_dong order by rand() limit 1),
(select phong.ten_phong from phong, hop_dong 
where phong.ten_phong = hop_dong.ten_phong and phong.ten_ky_tuc_xa = hop_dong.ten_ktx order by rand() limit 1);

-- ----ve xe----------

insert into ve_xe (bien_so_xe, loai_xe, mau_xe, trang_thai, ma_sv)
values(
	concat ('29A', (1 + floor(rand() * 9)), '-', lpad(floor(rand()*1000), 5, '0')),
	(case
		when rand() <= 0.25 then 'vision'
		when rand() <= 0.5 then 'airblade'
		when rand() <= 0.75 then 'wave'
        else "yamaha"
	end),
	(case
		when rand() <= 0.25 then 'đỏ'
		when rand() <= 0.5 then 'đen'
		when rand() <= 0.75 then 'trắng'
        else "xanh"
	end),
	round(rand()),
	(select sinh_vien.ma_sv from hop_dong, sinh_vien
		where sinh_vien.ma_SV = hop_dong.ma_SV
		order by rand()
		limit 1)
	);
    
-- ----lan gui xe----------
insert into lan_gui_xe ( thoi_gian_gui, thoi_gian_lay, bien_so_xe, ma_SV)
values(
current_timestamp() - interval floor(rand() * 14 * 24 * 60 * 60) minute_second,
current_timestamp(),
(select bien_so_xe from ve_xe order by rand() limit 1),
(select sinh_vien.ma_sv from sinh_vien, ve_xe
	where sinh_vien.ma_sv = ve_xe.ma_sv order by rand() limit 1));


-- ----lan giat----------
insert into lan_giat(don_gia, khoi_luong, ngay_giat, ma_SV)
values (
'15000',
(1 + floor(rand() * 9)),
(select current_date() - interval floor(rand() * 14 * 24) day),
(select sinh_vien.ma_sv from sinh_vien, hop_dong where hop_dong.ma_SV = sinh_vien.ma_sv order by rand() limit 1)
);


-- ----luot tham----------
insert into luot_tham (thoi_gian_den, thoi_gian_di, ma_sv, ma_so_dinh_danh_K)
select
	current_timestamp() - interval floor(rand() * 14 * 24 * 60 * 60) minute_second,
    current_timestamp(),
	(select sinh_vien.ma_sv from sinh_vien, hop_dong where hop_dong.ma_SV = sinh_vien.ma_sv order by rand() limit 1), 
    (select ma_so_dinh_danhh_K from khach order by rand() limit 1);
		