<%-- 
    Document   : Login
    Created on : Dec 5, 2020, 9:06:34 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>login</h1>
        <form action="LoginControl" method="post">
            Username: <input type="text" name="username" /> <BR>
            Password: <input type="password" name="password" /> <BR>
            <input type="submit" value="Login"/>
        </form>
    </body>
</html>
