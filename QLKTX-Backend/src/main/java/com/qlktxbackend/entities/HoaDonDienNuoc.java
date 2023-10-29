package com.qlktxbackend.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Data
@Entity
@Table(name = "hoa_don_dien_nuoc")
public class HoaDonDienNuoc implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ma_hoa_don", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String maHoaDon;

    @Column(name = "ngay_lap_hoa_don", nullable = false)
    private Date ngayLapHoaDon;

    @Column(name = "chi_so_dien_dau", nullable = false)
    private Integer chiSoDienDau;

    @Column(name = "chi_so_dien_cuoi", nullable = false)
    private Integer chiSoDienCuoi;

    @Column(name = "chi_so_nuoc_dau", nullable = false)
    private Integer chiSoNuocDau;

    @Column(name = "chi_so_nuoc_cuoi", nullable = false)
    private Integer chiSoNuocCuoi;

    @Column(name = "don_gia_dien", nullable = false)
    private Double donGiaDien;

    @Column(name = "don_gia_nuoc", nullable = false)
    private Double donGiaNuoc;

    @Column(name = "ngay_bat_dau", nullable = false)
    private Date ngayBatDau;

    @Column(name = "ngay_ket_thuc", nullable = false)
    private Date ngayKetThuc;

    @Column(name = "ten_ktx", nullable = false)
    private String tenKtx;

    @Column(name = "ten_phong", nullable = false)
    private String tenPhong;

}
