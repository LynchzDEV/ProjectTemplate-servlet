package com.example.template.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.*;

@WebServlet(name = "AuthenticationHandler", value = "/AuthenticationHandler")
public class AuthenticationHandler extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("enter servlet");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (username.equals("Lynchz") && password.equals("008")) {
            HttpSession session = req.getSession(true);
            session.setAttribute("username", username);
            req.setAttribute("message", "Login Success, enjoy");
        } else {
            req.setAttribute("message", "invalid input");
        }
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
 
