package com.example.template.controller;

import com.example.template.model.Product;
import com.example.template.repository.ProductRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.*;
import java.util.List;

@WebServlet(name = "ProductSearchServlet", value = "/ProductSearchServlet")
public class ProductSearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductRepository productRepository = new ProductRepository();
        String filterValue = req.getParameter("keyword");
        List<Product> productsList = productRepository.findByDes(filterValue);
        req.setAttribute("products", productsList);
        req.getRequestDispatcher("/productsView.jsp").forward(req, resp);

    }
}
 
