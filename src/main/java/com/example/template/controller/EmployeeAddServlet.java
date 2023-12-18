package com.example.template.controller;

import com.example.template.model.Employee;
import com.example.template.model.Office;
import com.example.template.repository.EmployeeRepository;
import com.example.template.repository.OfficeRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.*;

@WebServlet(name = "EmployeeAddServlet", value = "/008/EmployeeAddServlet")
public class EmployeeAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OfficeRepository officeRepository = new OfficeRepository();
        EmployeeRepository employeeRepository = new EmployeeRepository();
        Integer id = Integer.parseInt(req.getParameter("id"));
        String firstName = req.getParameter("FirstName");
        String lastName = req.getParameter("LastName");
        String extension = req.getParameter("extension");
        String email = req.getParameter("email");
        String officeCode = req.getParameter("officeCode");
        Integer reportsTo = "NULL".equals(req.getParameter("reportsTo")) ? null : Integer.parseInt(req.getParameter("reportsTo"));
        String jobTitle = req.getParameter("jobTitle");
        Office newOffice = officeRepository.findById(officeCode);
        Employee newEmployee = new Employee(id, firstName, lastName, extension, email, officeCode, reportsTo, jobTitle, newOffice);
        req.setAttribute("message", employeeRepository.insert(newEmployee) ? "Added successfully!" : "Added fail.");
        req.getRequestDispatcher("/008/EmployeeAddPage.jsp").forward(req, resp);
    }
}
 
