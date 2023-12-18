package com.example.template.controller;

import com.example.template.model.Employee;
import com.example.template.repository.EmployeeRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.*;
import java.util.List;

@WebServlet(name = "EmployeeRemoveServlet", value = "/008/EmployeeRemoveServlet")
public class EmployeeRemoveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeeRepository employeeRepository = new EmployeeRepository();
        Integer removeEmployeeId = Integer.parseInt(req.getParameter("removeEmployee"));
        req.setAttribute("message", employeeRepository.delete(removeEmployeeId) ? "Remove Employee ID: " + removeEmployeeId + " successfully!" : "Remove Employee ID: " + removeEmployeeId + " fail.");
        List<Employee> employeeList = employeeRepository.findAll();
        req.setAttribute("employees", employeeList);
        req.getRequestDispatcher("/008/EmployeesView.jsp").forward(req, resp);
    }
}
 
