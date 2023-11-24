package com.example.sd18203.service;

import com.example.sd18203.model.SinhVien;
import com.example.sd18203.repository.SinhVienRepository;

import java.util.ArrayList;

public class SinhVienService {

    SinhVienRepository sinhVienRepository = new SinhVienRepository();

    // call repo
    public ArrayList<SinhVien> getList() {
        return sinhVienRepository.getList();
    }

    public void addNew(SinhVien sinhVien) {
        sinhVienRepository.addNew(sinhVien);
    }

    public SinhVien detail(Integer id){
        return sinhVienRepository.getById(id);
    }

    public void update(SinhVien sinhVien) {
        sinhVienRepository.update(sinhVien);
    }
}
