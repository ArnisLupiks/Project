<%-- 
    Document   : registerpage
    Created on : 10-Dec-2014, 16:08:54
    Author     : Arnis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome to register page</h1>
        <p>Please enter the following details: </p>
        <form action="register.jsp" method ="post">
            
            Please enter you username: <input type="text" name="usr1"/><br />
            Please enter your password: <input type="text" name ="pass1"/><br />
            Please enter your email: <input type="text" name ="mail"/>

            <input type="submit" value="register"/>
            
        </form>
    </body>
</html>
