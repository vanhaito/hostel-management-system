package com.qlktxbackend.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "lan_gui_xe")
public class LanGuiXe implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ma_lan_gui", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maLanGui;

    @Column(name = "thoi_gian_gui", nullable = false)
    private Date thoiGianGui;

    @Column(name = "thoi_gian_lay", nullable = false)
    private Date thoiGianLay;

    @Column(name = "bien_so_xe", nullable = false)
    private String bienSoXe;

    @Column(name = "ma_SV", nullable = false)
    private String maSv;

}
