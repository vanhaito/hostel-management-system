package com.qlktxbackend.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "sinh_vien")
public class SinhVien implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "ma_so_dinh_danh_S", nullable = false)
    private String maSoDinhDanhS;

    @Id
    @Column(name = "ma_sv", nullable = false)
    private String maSv;

    @Column(name = "lop", nullable = false)
    private String lop;

}
