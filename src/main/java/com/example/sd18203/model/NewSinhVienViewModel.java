package com.example.sd18203.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewSinhVienViewModel {

    private String ten;

    private String diaChi;

    private String gioiTinh;

    private Integer lop;

    @Override
    public String toString() {
        return "NewSinhVienViewModel{" +
                "ten='" + ten + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", lop=" + lop +
                '}';
    }
}
