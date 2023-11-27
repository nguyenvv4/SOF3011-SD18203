package com.example.sd18203.servlet;

import com.example.sd18203.model.Lop;
import com.example.sd18203.model.NewSinhVienViewModel;
import com.example.sd18203.model.SinhVien;
import com.example.sd18203.service.LopHocService;
import com.example.sd18203.service.SinhVienService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

@WebServlet(name = "SinhVienServlet", value = {
        "/sinh-vien/hien-thi", // GET
        "/sinh-vien/detail", // GET
        "/sinh-vien/add", //POST
        "/sinh-vien/delete", //GET
        "/sinh-vien/update",
        "/sinh-vien/search", //GET
})
public class SinhVienServlet extends HttpServlet {
    // call service => repo
    SinhVienService sinhVienService = new SinhVienService();

    LopHocService lopHocService = new LopHocService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uri = request.getRequestURI();
        System.out.println(uri);
        if (uri.contains("/hien-thi")) {
            getList(request, response);
        } else if (uri.contains("/detail")) {
            detail(request, response);
        } else if (uri.contains("/delete")) {
            this.delete(request, response);
        } else if (uri.contains("/search")) {
            this.search(request, response);
        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<SinhVien> list = new ArrayList<>();
        String name = request.getParameter("hoTen");
        System.out.println(name);
//        for(SinhVien sinhVien : listSinhVien){
//            if (sinhVien.getTen().contains(name)){
//                list.add(sinhVien);
//            }
//        }
        request.setAttribute("listSinhVien", list);
//        request.setAttribute("lop", lop);
        request.getRequestDispatcher("/hien-thi-sinh-vien.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
//        listSinhVien.remove(vitri);
        sinhVienService.delete(id);
        response.sendRedirect("/sinh-vien/hien-thi");

    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        SinhVien sinhVienDetail = sinhVienService.detail(id);

        System.out.println(sinhVienDetail.toString());
        request.setAttribute("sinhVien", sinhVienDetail);
        ArrayList<Lop> lop = lopHocService.getList();
        request.setAttribute("lop", lop);
        request.getRequestDispatcher("/detail.jsp").forward(request, response);
    }

    public void getList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<SinhVien> listSinhVien = sinhVienService.getList();
        request.setAttribute("listSinhVien", listSinhVien);
        ArrayList<Lop> lop = lopHocService.getList();
        request.setAttribute("lop", lop);
        request.getRequestDispatcher("/hien-thi-sinh-vien.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/add")) {
            this.addNew(request, response);
        } else if (uri.contains("/update")) {
            this.update(request, response);
        }

    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String hoTen = request.getParameter("hoTen");
        String diachi = request.getParameter("diaChi");
        String gioiTinh = request.getParameter("gioiTinh");
        Integer idLop = Integer.parseInt(request.getParameter("lop"));
        SinhVien sinhVien = new SinhVien();
        sinhVien.setId(id);
        sinhVien.setTen(hoTen);
        sinhVien.setDiaChi(diachi);
        Lop lop = new Lop();
        lop.setId(idLop);
        sinhVien.setLop(lop);
        sinhVien.setGioiTinh(gioiTinh);
        sinhVienService.update(sinhVien);
        response.sendRedirect("/sinh-vien/hien-thi");
    }


    private void addNew(HttpServletRequest request, HttpServletResponse response) throws IOException {

//        String hoTen = request.getParameter("ten");
//        String diachi = request.getParameter("diaChi");
//        String gioiTinh = request.getParameter("gioiTinh");
//        Integer idLop = Integer.parseInt(request.getParameter("lop"));
        SinhVien sinhVien = new SinhVien();
//        sinhVien.setGioiTinh(gioiTinh);
//        sinhVien.setTen(hoTen);
//        sinhVien.setDiaChi(diachi);
//        Lop lop = new Lop();
//        lop.setId(idLop);
//        sinhVien.setLop(lop);
        NewSinhVienViewModel newSinhVienViewModel = new NewSinhVienViewModel();
        try {
            BeanUtils.populate(newSinhVienViewModel, request.getParameterMap());
//            BeanUtils.copyProperties(sinhVien, newSinhVienViewModel);
            sinhVienService.addNew(sinhVien);
            response.sendRedirect("/sinh-vien/hien-thi");
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
