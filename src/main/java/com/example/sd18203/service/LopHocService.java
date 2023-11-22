package com.example.sd18203.service;

import com.example.sd18203.model.Lop;
import com.example.sd18203.repository.LopHocRepository;

import java.util.ArrayList;

public class LopHocService {
    LopHocRepository lopHocRepository = new LopHocRepository();
    public ArrayList<Lop> getList(){
        return lopHocRepository.getList();
    }
}
