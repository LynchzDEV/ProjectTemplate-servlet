<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html lang="en">
    <head>
        <title>OFFICE</title>
    </head>
    <body>
        <h1>OFFICE LIST</h1>
        <hr/>
        <div class="body-main">
            <ul>
                <c:forEach items="${offices}" var="office" varStatus="loop">
                    <li>
                        ID: ${office.officeCode}, Country: ${office.country}, City: ${office.city},
                        Territory: ${office.territory}, Address 1: ${office.addressLine1}, Contact: ${office.phone}
                    </li>
                </c:forEach>
            </ul>
        </div>
    </body>
</html>
