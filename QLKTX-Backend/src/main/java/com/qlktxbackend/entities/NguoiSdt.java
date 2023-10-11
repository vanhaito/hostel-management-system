package com.qlktxbackend.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "nguoi_sdt")
public class NguoiSdt implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ma_so_dinh_danh", nullable = false)
    private String maSoDinhDanh;

    @Id
    @Column(name = "so_dien_thoai", nullable = false)
    private String soDienThoai;

}
