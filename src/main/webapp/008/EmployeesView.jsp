<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html lang="en">
    <head>
        <title>EMPLOYEES</title>
    </head>
    <style>
        body {
            background-color: #313131;
            color: aliceblue;
        }
    </style>
    <body>
        <h1>Employee Management</h1>
        <form action="EmployeeSearchServlet" method="post">
            <label for="searchField">Enter name: </label>
            <input type="text" name="searchField" id="searchField" placeholder="Type here...">
            <input type="submit" value="SUBMIT">
            <p style="color: #ff4e4e"> ${message}</p>
            <hr/>
            <ul>
                <c:forEach items="${employees}" var="employees" varStatus="loop">
                    <li>
                        ID: ${employees.id}, <br/>
                        Name: ${employees.firstName} ${employees.lastName}
                    </li>
                    <br/>
                </c:forEach>
            </ul>
        </form>
    </body>
</html>
