package com.example.sd18203.servlet;

import com.example.sd18203.model.SinhVien;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "SinhVienServlet", value = {
        "/sinh-vien/hien-thi",
})
public class SinhVienServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SinhVien sinhVien = new SinhVien();
        sinhVien.setTen("Nguyen Van A");
        sinhVien.setLop("SD18203");
        sinhVien.setDiaChi("Thai Nguyen");
        request.setAttribute("sinhVien", sinhVien);
        request.getRequestDispatcher("/hien-thi-sinh-vien.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
