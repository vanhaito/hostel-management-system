package com.qlktxbackend.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "ve_xe")
public class VeXe implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "bien_so_xe", nullable = false)
    private String bienSoXe;

    @Column(name = "loai_xe", nullable = false)
    private String loaiXe;

    @Column(name = "mau_xe", nullable = false)
    private String mauXe;

    @Column(name = "trang_thai", nullable = false)
    private Integer trangThai;

    @Column(name = "ma_sv", nullable = false)
    private String maSv;

}
