package com.example.sd18203.repository;

import com.example.sd18203.model.ChucVu;
import com.example.sd18203.model.SinhVien;
import com.example.sd18203.util.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;

public class ChucVuRepository {
    public ArrayList<ChucVu> getList() {
        ArrayList<ChucVu> list = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            // truy van
            list = (ArrayList<ChucVu>) session.createQuery("from ChucVu ").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        ArrayList<ChucVu> list = new ChucVuRepository().getList();
        for (ChucVu cv : list) {
            System.out.println(cv.getTen() + " - " + cv.getMa());
        }
    }
}
