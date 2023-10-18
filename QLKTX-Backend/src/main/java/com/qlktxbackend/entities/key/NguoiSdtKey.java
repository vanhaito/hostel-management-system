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
public class NguoiSdtKey implements Serializable {
    private String maSoDinhDanh;

    private String soDienThoai;
}
