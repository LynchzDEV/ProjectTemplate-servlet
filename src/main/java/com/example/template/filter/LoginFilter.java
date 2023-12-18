package com.example.template.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.*;

//@WebFilter(filterName = "LoginFilter", servletNames = {"EmployeeListServlet"}) //replace *(all) with servlet path
@WebFilter(filterName = "LoginFilter", servletNames = {"NOTHING"}) //replace *(all) with servlet path
public class LoginFilter implements Filter {
    private FilterConfig config;

    @Override
    public void init(FilterConfig config) throws ServletException {
        this.config = config;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletReq = (HttpServletRequest) req;
        HttpServletResponse httpServletResp = (HttpServletResponse) resp;
        HttpSession session = httpServletReq.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            req.setAttribute("message", "Please Login First!!");
            req.getRequestDispatcher("/008/index.jsp").forward(req, resp);
        } else {
            chain.doFilter(req, resp);
        }
    }

    @Override
    public void destroy() {

    }
}
 
