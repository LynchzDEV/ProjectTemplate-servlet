package com.example.template.controller;

import com.example.template.model.Office;
import com.example.template.repository.OfficeRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.*;
import java.util.List;

@WebServlet(name = "OfficeListServlet", value = "/OfficeListServlet")
public class OfficeListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OfficeRepository officeRepository = new OfficeRepository();
        List<Office> officeList = officeRepository.findAll();
        System.out.println();
        req.setAttribute("offices", officeList);
        req.getRequestDispatcher("/officeView.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
 
