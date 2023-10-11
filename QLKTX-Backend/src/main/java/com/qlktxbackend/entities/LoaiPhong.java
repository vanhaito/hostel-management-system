package com.qlktxbackend.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "loai_phong")
public class LoaiPhong implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ma_loai_phong", nullable = false)
    private String maLoaiPhong;

    @Column(name = "ten_loai_phong", nullable = false)
    private String tenLoaiPhong;

    @Column(name = "dien_tich", nullable = false)
    private String dienTich;

    @Column(name = "gia", nullable = false)
    private Double gia;

    @Column(name = "so_SV_toi_da", nullable = false)
    private Integer soSvToiDa;

}
