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
@Table(name = "nguoi")
public class Nguoi implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ma_so_dinh_danh", nullable = false)
    private String maSoDinhDanh;

    @Column(name = "ngay_sinh", nullable = false)
    private Date ngaySinh;

    @Column(name = "ho_ten", nullable = false)
    private String hoTen;

    @Column(name = "gioi_tinh", nullable = false)
    private String gioiTinh;

    @Column(name = "dia_chi_thuong_chu", nullable = false)
    private String diaChiThuongChu;

    @Column(name = "loai", nullable = false)
    private String loai;

}
