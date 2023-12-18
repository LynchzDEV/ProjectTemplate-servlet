<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html lang="en">
    <head>
        <title>UPDATE EMPLOYEE</title>
    </head>
    <style>
        body {
            background-color: #313131;
            color: aliceblue;
        }
    </style>
    <body>
        <h1>EDITING EMPLOYEE ID: <%= session.getAttribute("currId") %>
        </h1>
        <form action="EmployeeEditServlet" method="post">
            <label for="FirstName">Firstname: </label>
            <input type="text" name="FirstName" id="FirstName" placeholder="">
            <label for="useOldFN" style="font-size: smaller">Use old Firstname </label>
            <input type="checkbox" name="useOldFN" id="useOldFN"> <br/>

            <label for="LastName">Lastname: </label>
            <input type="text" name="LastName" id="LastName" placeholder="">
            <label for="useOldLN" style="font-size: smaller">Use old Lastname </label>
            <input type="checkbox" name="useOldLN" id="useOldLN"> <br/>

            <label for="extension">Extension: </label>
            <input type="text" name="extension" id="extension" placeholder="">
            <label for="useOldET" style="font-size: smaller">Use old Extension </label>
            <input type="checkbox" name="useOldET" id="useOldET"> <br/>

            <label for="email">Email: </label>
            <input type="email" name="email" id="email" placeholder="">
            <label for="useOldEM" style="font-size: smaller">Use old Email </label>
            <input type="checkbox" name="useOldEM" id="useOldEM"> <br/>

            <label for="officeCode">Office Code: </label>
            <select name="officeCode" id="officeCode">
                <option value="NC">not changing</option>
                <c:forEach items="${offices}" var="offices" varStatus="loop">
                    <option value="${offices.officeCode}">${offices.officeCode}</option>
                </c:forEach>
            </select> <br/>

            <label for="reportsTo">Reports to: </label>
            <select name="reportsTo" id="reportsTo">
                <option value="NC">not changing</option>
                <option value="NULL">null</option>
                <c:forEach items="${employees}" var="employees" varStatus="loop">
                    <option value="${employees.id}">${employees.id}</option>
                </c:forEach>
            </select> <br/>

            <label for="jobTitle">Job Title: </label>
            <select name="jobTitle" id="jobTitle">
                <option value="NC">not changing</option>
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
