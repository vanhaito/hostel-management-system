package com.qlktxbackend.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;

@Data
@Entity
@Table(name = "hop_dong")
public class HopDong implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ma_hop_dong", nullable = false)
    private String maHopDong;

    @Column(name = "ngay_bat_dau", nullable = false)
    private Date ngayBatDau;

    @Column(name = "ngay_ket_thuc", nullable = false)
    private Date ngayKetThuc;

    @Column(name = "ma_SV", nullable = false)
    private String maSv;

    @Column(name = "ma_so_dinh_danh_N")
    private String maSoDinhDanhN;

    @Column(name = "ten_phong", nullable = false)
    private String tenPhong;

    @Column(name = "ten_ktx", nullable = false)
    private String tenKtx;

}
