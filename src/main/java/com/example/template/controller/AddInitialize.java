package com.example.template.controller;

import com.example.template.model.Employee;
import com.example.template.model.Office;
import com.example.template.repository.EmployeeRepository;
import com.example.template.repository.OfficeRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.*;
import java.util.List;

@WebServlet(name = "AddInitialize", value = "/008/AddInitialize")
public class AddInitialize extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeeRepository employeeRepository = new EmployeeRepository();
        OfficeRepository officeRepository = new OfficeRepository();
        List<Employee> employeeList = employeeRepository.findAll();
        List<Office> officesList = officeRepository.findAll();
        List<String> jobTitle = employeeRepository.jobTitleList();
        req.setAttribute("employees", employeeList);
        req.setAttribute("offices", officesList);
        req.setAttribute("jobTitles", jobTitle);
        req.getRequestDispatcher("/008/EmployeeAddPage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
 
