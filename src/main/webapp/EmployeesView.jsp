<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html lang="en">
    <head>
        <title>EMPLOYEES</title>
    </head>
    <body>
        <h1>Employee Management</h1>
        <form action="">
            <label for="searchField">Enter name: </label>
            <input type="text" name="searchField" id="searchField" placeholder="Type here...">
            ${message}
            <hr/>
            <ul>
                <c:forEach items="${employees}" var="employees" varStatus="loop">
                    <li>
                        ID: ${employees.employeeNumber},
                        Name: ${employees.firstname} ${employees.lastname}
                    </li>
                    <br/>
                </c:forEach>
            </ul>
        </form>
    </body>
</html>
