package com.qlktxbackend.entities.key;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PhongKey implements Serializable {
    private String tenKyTucXa;

    private String tenPhong;


}
