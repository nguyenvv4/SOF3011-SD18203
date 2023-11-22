package com.example.sd18203.repository;

import com.example.sd18203.model.ChucVu;
import com.example.sd18203.model.Lop;
import com.example.sd18203.util.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;

public class LopHocRepository {
    public ArrayList<Lop> getList() {
        ArrayList<Lop> list = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            // truy van
            list = (ArrayList<Lop>) session.createQuery("from Lop ").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
