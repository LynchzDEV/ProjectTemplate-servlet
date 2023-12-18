package com.example.template.controller;

import com.example.template.model.Employee;
import com.example.template.repository.EmployeeRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.*;
import java.util.Optional;

@WebServlet(name = "EmployeeEditServlet", value = "/008/EmployeeEditServlet")
public class EmployeeEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        EmployeeRepository employeeRepository = new EmployeeRepository();
        Integer editEmployeeCode = Integer.parseInt(session.getAttribute("currId").toString());
        Employee employeeToEdit = employeeRepository.find(editEmployeeCode);

        String officeCodeParam = "NC".equals(req.getParameter("officeCode")) ? null : "NULL".equals(req.getParameter("officeCode")) ? null : req.getParameter("officeCode");
        String officeCode = officeCodeParam != null ? officeCodeParam : employeeToEdit.getOfficeCode();

        Integer reportsToParameter = "NC".equals(req.getParameter("reportsTo")) ? null : "NULL".equals(req.getParameter("reportsTo")) ? null : Integer.parseInt(req.getParameter("reportsTo"));
        Integer reportsTo = reportsToParameter != null ? reportsToParameter : employeeToEdit.getReportsTo();

        String jobTitleParam = "NC".equals(req.getParameter("jobTitle")) ? null : "NULL".equals(req.getParameter("jobTitle")) ? null : req.getParameter("jobTitle");
        String jobTitle = jobTitleParam != null ? jobTitleParam : employeeToEdit.getJobTitle();

        if (req.getParameter("useOldFN") == null) {
            employeeToEdit.setFirstName(req.getParameter("FirstName"));
        }

        if (req.getParameter("useOldLN") == null) {
            employeeToEdit.setLastName(req.getParameter("LastName"));
        }

        if (req.getParameter("useOldET") == null) {
            employeeToEdit.setExtension(req.getParameter("extension"));
        }

        if (req.getParameter("useOldEM") == null) {
            employeeToEdit.setEmail(req.getParameter("email"));
        }

        employeeToEdit.setOfficeCode(officeCode);
        employeeToEdit.setReportsTo(reportsTo);
        employeeToEdit.setJobTitle(jobTitle);

        req.setAttribute("message", employeeRepository.update(employeeToEdit) ? "Edit Successfully!" : "Edit Fail!");
        req.getRequestDispatcher("/008/EmployeeUpdater.jsp").forward(req, resp);
    }
}
 
