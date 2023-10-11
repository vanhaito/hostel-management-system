package com.qlktxbackend.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "phong")
public class Phong implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ten_ky_tuc_xa", nullable = false)
    private String tenKyTucXa;

    @Id
    @Column(name = "ten_phong", nullable = false)
    private String tenPhong;

    @Column(name = "so_SV_hien_co", nullable = false)
    private Integer soSvHienCo;

    @Column(name = "tang", nullable = false)
    private Integer tang;

    @Column(name = "ma_loai_phong", nullable = false)
    private String maLoaiPhong;

}
