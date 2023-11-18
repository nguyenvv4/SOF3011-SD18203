package com.example.sd18203.servlet;

import com.example.sd18203.model.SinhVien;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
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
    ArrayList<SinhVien> listSinhVien = new ArrayList<>();
    ArrayList<String> lop = new ArrayList<>();

    public SinhVienServlet() {
//        listSinhVien.add(new SinhVien("S1", "Nguyen Van a", "Ha Noi", "Nam", 1));
//        listSinhVien.add(new SinhVien("S2", "Nguyen Van b", "Ha Noi", "Nam", "SD12346"));


        lop.add("SD12345");
        lop.add("SD12346");
        lop.add("SD12347");
        lop.add("SD12348");
    }

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
        }else if (uri.contains("/search")){
            this.search(request,response);
        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<SinhVien> list = new ArrayList<>();
        String name = request.getParameter("hoTen");
        System.out.println(name);
        for(SinhVien sinhVien : listSinhVien){
            if (sinhVien.getTen().contains(name)){
                list.add(sinhVien);
            }
        }
        request.setAttribute("listSinhVien", list);
        request.setAttribute("lop", lop);
        request.getRequestDispatcher("/hien-thi-sinh-vien.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int vitri = Integer.parseInt(request.getParameter("vitri"));
        listSinhVien.remove(vitri);
        response.sendRedirect("/sinh-vien/hien-thi");

    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        SinhVien sinhVienDetail = new SinhVien();
        for (SinhVien sinhVien : listSinhVien) {
            if (sinhVien.getId().equals(id)) {
                sinhVienDetail = sinhVien;
            }
        }
        System.out.println(sinhVienDetail.toString());
        request.setAttribute("sinhVien", sinhVienDetail);
        request.setAttribute("lop", lop);
        request.getRequestDispatcher("/detail.jsp").forward(request, response);
    }

    public void getList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listSinhVien", listSinhVien);
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
        String id = request.getParameter("id");
        String hoTen = request.getParameter("hoTen");
        String diachi = request.getParameter("diaChi");
        String gioiTinh = request.getParameter("gioiTinh");
        String lop = request.getParameter("lop");

        for (SinhVien sv : listSinhVien) {
            if (sv.getId().equals(id)) {
                sv.setTen(hoTen);
//                sv.setLop(lop);
                sv.setDiaChi(diachi);
                sv.setGioiTinh(gioiTinh);
            }
        }
        response.sendRedirect("/sinh-vien/hien-thi");
    }


    private void addNew(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String hoTen = request.getParameter("hoTen");
        String diachi = request.getParameter("diaChi");
        String gioiTinh = request.getParameter("gioiTinh");
        String lop = request.getParameter("lop");
//        SinhVien sinhVien = new SinhVien(id, hoTen, diachi, gioiTinh, lop);
//        listSinhVien.add(sinhVien);
        response.sendRedirect("/sinh-vien/hien-thi");
    }
}
