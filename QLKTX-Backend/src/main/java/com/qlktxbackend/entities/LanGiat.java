package com.qlktxbackend.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "lan_giat")
public class LanGiat implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ma_luot_giat", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maLuotGiat;

    @Column(name = "don_gia", nullable = false)
    private Double donGia;

    @Column(name = "khoi_luong", nullable = false)
    private Double khoiLuong;

    @Column(name = "ngay_giat", nullable = false)
    private Date ngayGiat;

    @Column(name = "ma_SV", nullable = false)
    private String maSv;

}
