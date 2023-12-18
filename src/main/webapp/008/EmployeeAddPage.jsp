<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html lang="en">
    <head>
        <title>ADD EMPLOYEE</title>
    </head>
    <style>
        body {
            background-color: #313131;
            color: aliceblue;
        }
    </style>
    <body>
        <h1>Please fill information</h1>
        <form action="EmployeeAddServlet" method="post">
            <label for="id">ID: </label>
            <input type="number" name="id" id="id" placeholder="" required> <br/>
            <label for="FirstName">Firstname: </label>
            <input type="text" name="FirstName" id="FirstName" placeholder="" required> <br/>
            <label for="LastName">Lastname: </label>
            <input type="text" name="LastName" id="LastName" placeholder="" required> <br/>
            <label for="extension">Extension: </label>
            <input type="text" name="extension" id="extension" placeholder="" required> <br/>
            <label for="email">Email: </label>
            <input type="email" name="email" id="email" placeholder="" required> <br/>
            <label for="officeCode">Office Code: </label>
            <select name="officeCode" id="officeCode">
                <c:forEach items="${offices}" var="offices" varStatus="loop">
                    <option value="${offices.officeCode}">${offices.officeCode}</option>
                </c:forEach>
            </select> <br/>
            <label for="reportsTo">Reports to: </label>
            <select name="reportsTo" id="reportsTo">
                <option value="NULL">null</option>
                <c:forEach items="${employees}" var="employees" varStatus="loop">
                    <option value="${employees.id}">${employees.id}</option>
                </c:forEach>
            </select> <br/>
            <label for="jobTitle">Job Title: </label>
            <select name="jobTitle" id="jobTitle">
                <c:forEach items="${jobTitles}" var="jobTitle" varStatus="loop">
                    <option value="${jobTitle}">${jobTitle}</option>
                </c:forEach>
                <%--            &nbsp;or&nbsp;--%>
                <%--            <input type="text" name="jobTitle" id="jobTitle">--%>
            </select>
            <br/>
            ${message}
            <input type="submit" value="SUBMIT">
            <a href="EmployeeListServlet"><input type="button" value="GO BACK"></a>
        </form>
    </body>
</html>
