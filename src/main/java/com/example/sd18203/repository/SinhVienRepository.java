package com.example.sd18203.repository;

import com.example.sd18203.model.SinhVien;
import com.example.sd18203.model.SinhVienViewModel;
import com.example.sd18203.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class SinhVienRepository {

    public ArrayList<SinhVien> getList() {
        ArrayList<SinhVien> list = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            // truy van
            list = (ArrayList<SinhVien>) session.createQuery("from SinhVien ").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public SinhVien getById(Integer id) {
        SinhVien sinhVien = new SinhVien();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            // truy van HQL
            Query query = session.createQuery("from SinhVien where id = :id");
            query.setInteger("id", id);
            sinhVien = (SinhVien) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sinhVien;
    }


    public void addNew(SinhVien sinhVien) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(sinhVien);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void update(SinhVien sinhVien) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(sinhVien);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public ArrayList<SinhVienViewModel> getViewModel() {
        ArrayList<SinhVienViewModel> sinhVienViewModels = new ArrayList<>();
        String sql = "select new com.example.sd18203.model.SinhVienViewModel(s.ten,l.ten) " +
                " from com.example.sd18203.model.SinhVien s " +
                " join com.example.sd18203.model.Lop l" +
                " on s.lop.id = l.id";
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            // truy van HQL
            Query query = session.createQuery(sql);
            sinhVienViewModels = (ArrayList<SinhVienViewModel>) query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sinhVienViewModels;
    }

    public void delete(SinhVien sinhVien){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(sinhVien);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }


    public static void main(String[] args) {
        SinhVienRepository sinhVienRepository = new SinhVienRepository();
        ArrayList<SinhVien> list = sinhVienRepository.getList();
        for (SinhVien sinhVien : list) {
            System.out.println(sinhVien.getTen() + " --- " + sinhVien.getLop().getTen());
        }
        System.out.println("==========");
        ArrayList<SinhVienViewModel> sinhVienViewModels = sinhVienRepository.getViewModel();
        for (SinhVienViewModel sinhVienViewModel:sinhVienViewModels){
            System.out.println(sinhVienViewModel.toString());
        }
     }

}
