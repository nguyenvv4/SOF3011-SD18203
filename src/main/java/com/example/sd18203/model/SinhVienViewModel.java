package com.example.sd18203.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SinhVienViewModel {

    private String tenSinhVien;

    private String tenLop;

    @Override
    public String toString() {
        return tenSinhVien + " === " + tenLop;
    }
}
