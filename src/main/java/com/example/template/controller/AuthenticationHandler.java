package com.example.template.controller;

import com.example.template.repository.EmployeeRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.*;

@WebServlet(name = "AuthenticationHandler", value = "/008/AuthenticationHandler")
public class AuthenticationHandler extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        EmployeeRepository employeeRepository = new EmployeeRepository();
        if (employeeRepository.combinedChecker(password, username)) {
            HttpSession session = req.getSession(true);
            session.setAttribute("username", username);
            req.setAttribute("message", "Login Success, enjoy");
        } else {
            req.setAttribute("message", "invalid input");
        }
        req.getRequestDispatcher("/008/index.jsp").forward(req, resp);
    }
}