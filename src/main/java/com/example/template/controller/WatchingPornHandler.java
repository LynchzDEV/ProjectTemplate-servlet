package com.example.template.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.*;

@WebServlet(name = "WatchingPornHandler", value = "/WatchingPornHandler")
public class WatchingPornHandler extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = "https://www.youtube.com/watch?v=pFzeATBlNVI";
        resp.sendRedirect(url);
    }
}

