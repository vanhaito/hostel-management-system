package com.qlktxbackend.entities;

import com.qlktxbackend.entities.key.PhongKey;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@IdClass(PhongKey.class)
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
