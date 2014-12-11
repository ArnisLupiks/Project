<%-- 
    Document   : login
    Created on : 10-Dec-2014, 15:28:48
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
    
    <%-- start web service invocation --%><hr/>
    <%
        String name = request.getParameter("usr");
        String passw = request.getParameter("pass");
    try {
	memorycatcherclient.Memorycatcherclient_Service service = new memorycatcherclient.Memorycatcherclient_Service();
	memorycatcherclient.Memorycatcherclient port = service.getMemorycatcherclientPort();
	 // TODO initialize WS operation arguments here
	java.lang.String username = name;
	java.lang.String password = passw;
	// TODO process result here
	int result = port.login(username, password);
        //if the login is successfull, it will rederect to main page of the system.
	if(result>0){
          request.getRequestDispatcher("/mainpage.jsp").forward(request, response);

        }else{
            //else redirect to login page.
            out.println("Result = "+result);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>
    </body>
</html>
