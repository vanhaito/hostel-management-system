-- thống kê khách đến thăm sinh viên theo tháng
select lt.ma_sv             maSv,
       sv.lop,
       sv.ma_so_dinh_danh_S maSoDinhDanhS,
       lt.ma_so_dinh_danh_K maSoDinhDanhK,
       k.nghe_nghiep        ngheNghiep,
       n.ho_ten             hoTen,
       n.gioi_tinh          gioiTinh,
       n.ngay_sinh          ngaySinh,
       n.dia_chi_thuong_chu diaChiThuongChu,
       count(*) as          soLuotTham
from (select * from luot_tham where MONTH(thoi_gian_den) = 10 and YEAR(thoi_gian_den) = 2023) lt
         left join sinh_vien sv on sv.ma_sv = lt.ma_sv
         left join khach k on k.ma_so_dinh_danh_K = lt.ma_so_dinh_danh_K
         left join nguoi n on n.ma_so_dinh_danh = lt.ma_so_dinh_danh_K
group by maSv, maSoDinhDanhK;

-- thống kê tiền điện nước phòng theo tháng
select p.ten_ky_tuc_xa tenKyTucXa
     , p.ten_phong tenPhong
     , p.so_SV_hien_co soSvHienCo
     , p.tang
     , p.ma_loai_phong maLoaiPhong
     , IFNULL((hddn.chi_so_dien_cuoi - hddn.chi_so_dien_dau) * hddn.don_gia_dien, 0) as tienDien
     , IFNULL((hddn.chi_so_nuoc_cuoi - hddn.chi_so_nuoc_dau) * hddn.don_gia_nuoc, 0) as tienNuoc
from phong p
         left join(select * from hoa_don_dien_nuoc where MONTH(ngay_ket_thuc) = 9 and YEAR(ngay_ket_thuc) = 2023) hddn
                  on p.ten_ky_tuc_xa = hddn.ten_ktx and p.ten_phong = hddn.ten_phong


