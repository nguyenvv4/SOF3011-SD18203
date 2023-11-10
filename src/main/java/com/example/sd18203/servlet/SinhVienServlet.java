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
})
public class SinhVienServlet extends HttpServlet {
    ArrayList<SinhVien> listSinhVien = new ArrayList<>();
    ArrayList<String> lop = new ArrayList<>();

    public SinhVienServlet() {
        listSinhVien.add(new SinhVien("S1", "Nguyen Van a", "Ha Noi", "Nam", "SD12345"));
        listSinhVien.add(new SinhVien("S2", "Nguyen Van b", "Ha Noi", "Nam", "SD12346"));
        listSinhVien.add(new SinhVien("S3", "Nguyen Van c", "Ha Noi", "Nu", "SD12347"));
        listSinhVien.add(new SinhVien("S4", "Nguyen Van d", "Ha Noi", "Nam", "SD12348"));
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
        }
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
        }

    }

    private void addNew(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String hoTen = request.getParameter("hoTen");
        String diachi = request.getParameter("diaChi");
        String gioiTinh = request.getParameter("gioiTinh");
        String lop = request.getParameter("lop");
        SinhVien sinhVien = new SinhVien(id, hoTen, diachi, gioiTinh, lop);
        listSinhVien.add(sinhVien);
        response.sendRedirect("/sinh-vien/hien-thi");
    }
}
