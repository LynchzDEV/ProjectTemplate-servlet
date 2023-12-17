<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html lang="en">
    <head>
        <title>PRODUCT</title>
    </head>
    <style>
        body {
            background-color: #313131;
            color: aliceblue;
        }
    </style>
    <body>
        <h1>PRODUCT LIST</h1>
        <hr/>
        <div class="body-main">
            <form action="ProductSearchServlet" method="post">
                <label for="keyword">Search Product here: </label>
                <input type="text" name="keyword" id="keyword" placeholder="Typing here...">
                <input type="submit" value="submit">
            </form>
            <ul>
                <c:forEach items="${products}" var="products" varStatus="loop">
                    <li>
                        ID: ${products.productCode} Name: ${products.productName} <br/>
                        Des: ${products.productDescription} <br/>
                        Quantity: ${products.quantityInStock} Price: ${products.MSRP}
                    </li>
                    <br/>
                </c:forEach>
            </ul>
        </div>
    </body>
</html>
