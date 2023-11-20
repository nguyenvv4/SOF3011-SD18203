package com.example.sd18203.service;

import com.example.sd18203.model.SinhVien;
import com.example.sd18203.repository.SinhVienRepository;

import java.util.ArrayList;

public class SinhVienService {

    SinhVienRepository sinhVienRepository = new SinhVienRepository();
    // call repo
    public ArrayList<SinhVien> getList(){
        return sinhVienRepository.getList();
    }
}
