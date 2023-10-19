package com.qlktxbackend.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "khach")
public class Khach implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ma_so_dinh_danh_K", nullable = false)
    private String maSoDinhDanhK;

    @Column(name = "nghe_nghiep", nullable = false)
    private String ngheNghiep;

}
