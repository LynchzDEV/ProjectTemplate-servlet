package com.example.template.controller;

import com.example.template.model.Employee;
import com.example.template.repository.EmployeeRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.*;
import java.util.List;

@WebServlet(name = "EmployeeListServlet", value = "/008/EmployeeListServlet")
public class EmployeeListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeeRepository employeeRepository = new EmployeeRepository();
        List<Employee> employeeList = employeeRepository.findAll();
        req.setAttribute("employees", employeeList);
        req.getRequestDispatcher("/008/EmployeesView.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
 
