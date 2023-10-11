package com.qlktxbackend.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "nhan_vien_ql")
public class NhanVienQl implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ma_so_dinh_danh_N", nullable = false)
    private String maSoDinhDanhN;

    @Column(name = "trinh_do", nullable = false)
    private String trinhDo;

    @Column(name = "ten_ky_tuc_xa", nullable = false)
    private String tenKyTucXa;

}
