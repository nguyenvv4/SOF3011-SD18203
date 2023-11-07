package com.example.sd18203.servlet;

import com.example.sd18203.model.SinhVien;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SinhVienServlet", value = {
        "/sinh-vien/hien-thi",
})
public class SinhVienServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<SinhVien> listSinhVien = new ArrayList<>();
        listSinhVien.add(new SinhVien("S1", "Nguyen Van a", "Ha Noi", "Nam", "SD12345"));
        listSinhVien.add(new SinhVien("S2", "Nguyen Van b", "Ha Noi","Nam", "SD12345"));
        listSinhVien.add(new SinhVien("S3", "Nguyen Van c", "Ha Noi","Nam", "SD12345"));
        listSinhVien.add(new SinhVien("S4", "Nguyen Van d", "Ha Noi","Nam", "SD12345"));

        request.setAttribute("listSinhVien", listSinhVien);
        request.getRequestDispatcher("/hien-thi-sinh-vien.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
