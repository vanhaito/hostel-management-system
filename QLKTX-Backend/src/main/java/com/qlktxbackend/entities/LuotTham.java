package com.qlktxbackend.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "luot_tham")
public class LuotTham implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ma_luot_tham", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maLuotTham;

    @Column(name = "thoi_gian_den", nullable = false)
    private Date thoiGianDen;

    @Column(name = "thoi_gian_di", nullable = false)
    private Date thoiGianDi;

    @Column(name = "ma_sv", nullable = false)
    private String maSv;

    @Column(name = "ma_so_dinh_danh_K", nullable = false)
    private String maSoDinhDanhK;

}
