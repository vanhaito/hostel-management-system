package com.qlktxbackend.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "ky_tuc_xa")
public class KyTucXa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ten_ky_tuc_xa", nullable = false)
    private String tenKyTucXa;

    @Column(name = "so_luong_phong", nullable = false)
    private Integer soLuongPhong;

    @Column(name = "dia_chi", nullable = false)
    private Integer diaChi;

}
