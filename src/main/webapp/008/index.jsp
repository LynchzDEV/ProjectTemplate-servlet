<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE>
<html lang="en">
    <head>
        <title>Login</title>
    </head>
    <style>
        * {
            font-family: "SF Pro", "SF Pro Text", "SF Pro Icons", "Helvetica Neue", "Helvetica", "Arial", sans-serif;
            /*background-color: #313131;*/
            /*color: aliceblue;*/
        }

        form {
            margin: 0 auto;
            width: 25vw;
            padding: 1em;
            border: 1px solid #CCC;
            border-radius: 1em;
        }

        form div + div {
            margin-top: 1em;
        }

        label {
            display: inline-block;
            width: 90px;
            text-align: right;
        }

        input, textarea {
            font: 1em sans-serif;
            width: 100%;
            box-sizing: border-box;
            border: 1px solid #999;
        }

        input:focus, textarea:focus {
            border-color: #000;
            font-weight: lighter;
            font-size: smaller;
        }

        input[type="submit"]:hover {
            background-color: #000;
            color: #FFF;
        }

        input[type="button"]:hover {
            background-color: #000;
            color: #FFF;
        }

        textarea {
            vertical-align: top;
            height: 5em;
            resize: vertical;
        }

        .button {
            padding-left: 90px;
        }

        button {
            margin-left: .5em;
        }
    </style>
    <body>
        <form action="AuthenticationHandler" method="post">
            <label>Username : </label>
            <input type="text" name="username"/>
            <br>
            <label>Password : </label>
            <input type="password" name="password"/>
            <h3 style="color: red">${message}</h3>
            <input type="submit" value="Submit">
        </form>
        <br>
        <form action="EmployeeListServlet" method="get">
            <input type="submit" value="Click to continue">
        </form>
    </body>
</html>