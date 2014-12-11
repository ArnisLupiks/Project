<%-- 
    Document   : addmemorypage
    Created on : 11-Dec-2014, 13:37:24
    Author     : Barry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome to the remove memory page</h1>
        <p>Please enter the following details: </p>
        <form action="removeMemory.jsp" method ="post">
            
            Please enter your memory id: <input type="text" name="id"/><br />
            

            <input type="submit" value="remove"/>
            
        </form>
    </body>
</html>
