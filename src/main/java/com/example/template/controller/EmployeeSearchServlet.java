package com.example.template.controller;

import com.example.template.model.Employee;
import com.example.template.repository.EmployeeRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.*;
import java.util.List;

@WebServlet(name = "EmployeeSearchServlet", value = "/008/EmployeeSearchServlet")
public class EmployeeSearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String inputField = req.getParameter("searchField");
        EmployeeRepository employeeRepository = new EmployeeRepository();
        List<Employee> employeeList = employeeRepository.findByName(inputField);
        String msg;
        msg = employeeList.isEmpty() ? "Not Found" : "Search Successfully!";
        req.setAttribute("message", msg);
        req.setAttribute("employees", employeeList);
        req.getRequestDispatcher("/008/EmployeesView.jsp").forward(req, resp);
    }
}
 
