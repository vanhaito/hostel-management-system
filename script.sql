create table ky_tuc_xa
(
    ten_ky_tuc_xa  varchar(100) not null
        primary key,
    so_luong_phong int          not null,
    dia_chi        varchar(100) not null
);

create table loai_phong
(
    ma_loai_phong  varchar(20)  not null
        primary key,
    ten_loai_phong varchar(100) not null,
    dien_tich      varchar(100) not null,
    gia            double       not null,
    so_SV_toi_da   int          not null
);

create table nguoi
(
    ma_so_dinh_danh    varchar(20)  not null
        primary key,
    ngay_sinh          date         not null,
    ho_ten             varchar(100) not null,
    gioi_tinh          varchar(10)  not null,
    dia_chi_thuong_chu varchar(250) not null,
    loai               varchar(50)  not null
);

create table khach
(
    ma_so_dinh_danhh_K varchar(20)  not null
        primary key,
    nghe_nghiep        varchar(100) not null,
    constraint khach_nguoi_ma_so_dinh_danh_fk
        foreign key (ma_so_dinh_danhh_K) references nguoi (ma_so_dinh_danh)
);

create table nguoi_sdt
(
    ma_so_dinh_danh varchar(20) not null,
    so_dien_thoai   varchar(11) not null,
    primary key (ma_so_dinh_danh, so_dien_thoai),
    constraint nguoi_sdt_nguoi_ma_so_dinh_danh_fk
        foreign key (ma_so_dinh_danh) references nguoi (ma_so_dinh_danh)
);

create table nhan_vien_ql
(
    ma_so_dinh_danh_N varchar(20)  not null
        primary key,
    trinh_do          varchar(50)  not null,
    ten_ky_tuc_xa     varchar(100) not null,
    constraint nhan_vien_QL_nguoi_ma_so_dinh_danh_fk
        foreign key (ma_so_dinh_danh_N) references nguoi (ma_so_dinh_danh),
    constraint nhan_vien_ql_ky_tuc_xa_ten_ky_tuc_xa_fk
        foreign key (ten_ky_tuc_xa) references ky_tuc_xa (ten_ky_tuc_xa)
);

create table phong
(
    ten_ky_tuc_xa varchar(100) not null,
    ten_phong     varchar(100) not null,
    so_SV_hien_co int          not null,
    tang          int          not null,
    ma_loai_phong varchar(20)  not null,
    primary key (ten_ky_tuc_xa, ten_phong),
    constraint phong_ten_ky_tuc_xa_ten_phong_uindex
        unique (ten_ky_tuc_xa, ten_phong),
    constraint phong_ky_tuc_xa_ten_ky_tuc_xa_fk
        foreign key (ten_ky_tuc_xa) references ky_tuc_xa (ten_ky_tuc_xa),
    constraint phong_loai_phong_ma_loai_phong_fk
        foreign key (ma_loai_phong) references loai_phong (ma_loai_phong)
);

create table hoa_don_dien_nuoc
(
    na_hoa_don       varchar(20)  not null
        primary key,
    ngay_lap_hoa_don date         not null,
    chi_so_dien_dau  int          not null,
    chi_so_dien_cuoi int          not null,
    chi_so_nuoc_dau  int          not null,
    chi_so_nuoc_cuoi int          not null,
    don_gia_dien     double       not null,
    don_gia_nuoc     double       not null,
    ngay_bat_dau     date         not null,
    ngay_ket_thuc    date         not null,
    ten_ktx          varchar(100) not null,
    ten_phong        varchar(100) not null,
    constraint hoa_don_dien_nuoc_phong_ten_ky_tuc_xa_ten_phong_fk
        foreign key (ten_ktx, ten_phong) references phong (ten_ky_tuc_xa, ten_phong)
);

create table sinh_vien
(
    ma_so_dinh_danh_S varchar(20)  not null,
    ma_sv             varchar(20)  not null
        primary key,
    lop               varchar(100) not null,
    constraint sinh_vien_nguoi_ma_so_dinh_danh_fk
        foreign key (ma_so_dinh_danh_S) references nguoi (ma_so_dinh_danh)
);

create table hop_dong
(
    ma_hop_dong       varchar(20)  not null
        primary key,
    ngay_bat_dau      date         not null,
    ngay_ket_thuc     date         not null,
    ma_SV             varchar(20)  not null,
    ma_so_dinh_danh_N varchar(20)  null,
    ten_phong         varchar(100) not null,
    ten_ktx           varchar(100) not null,
    constraint hop_dong_nhan_vien_ql_ma_so_dinh_danh_N_fk
        foreign key (ma_so_dinh_danh_N) references nhan_vien_ql (ma_so_dinh_danh_N),
    constraint hop_dong_phong_ten_phong_ten_ky_tuc_xa_fk
        foreign key (ten_ktx, ten_phong) references phong (ten_ky_tuc_xa, ten_phong),
    constraint hop_dong_sinh_vien_ma_sv_fk
        foreign key (ma_SV) references sinh_vien (ma_sv)
);

create table lan_giat
(
    ma_luot_giat int auto_increment
        primary key,
    don_gia      double      not null,
    khoi_luong   double      not null,
    ngay_giat    datetime    not null,
    ma_SV        varchar(20) not null,
    constraint lan_giat_sinh_vien_ma_sv_fk
        foreign key (ma_SV) references sinh_vien (ma_sv)
);

create table luot_tham
(
    ma_luot_tham      int auto_increment
        primary key,
    thoi_gian_den     datetime    not null,
    thoi_gian_di      datetime    not null,
    ma_sv             varchar(20) not null,
    ma_so_dinh_danh_K varchar(20) not null,
    constraint luot_tham_khach_ma_so_dinh_danhh_K_fk
        foreign key (ma_so_dinh_danh_K) references khach (ma_so_dinh_danhh_K),
    constraint luot_tham_sinh_vien_ma_sv_fk
        foreign key (ma_sv) references sinh_vien (ma_sv)
);

create table ve_xe
(
    bien_so_xe varchar(20)  not null
        primary key,
    loai_xe    varchar(100) not null,
    mau_xe     varchar(100) not null,
    trang_thai tinyint(1)   not null,
    ma_sv      varchar(20)  not null,
    constraint ve_xe_sinh_vien_ma_sv_fk
        foreign key (ma_sv) references sinh_vien (ma_sv)
);

create table lan_gui_xe
(
    ma_lan_gui    int auto_increment
        primary key,
    thoi_gian_gui datetime    not null,
    thoi_gian_lay datetime    not null,
    bien_so_xe    varchar(20) not null,
    ma_SV         varchar(20) not null,
    constraint lan_gui_xe_sinh_vien_ma_sv_fk
        foreign key (ma_SV) references sinh_vien (ma_sv),
    constraint lan_gui_xe_ve_xe_bien_so_xe_fk
        foreign key (bien_so_xe) references ve_xe (bien_so_xe)
);


