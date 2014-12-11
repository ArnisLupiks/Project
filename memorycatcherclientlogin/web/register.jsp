<%-- 
    Document   : register
    Created on : 10-Dec-2014, 15:36:35
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
        
        
        <form
    <%-- start web service invocation --%><hr/>
    <%
         String name = request.getParameter("usr1");
        String passw = request.getParameter("pass1");
         String mails = request.getParameter("mail");
        
    try {
	memorycatcherclient.Memorycatcherclient_Service service = new memorycatcherclient.Memorycatcherclient_Service();
	memorycatcherclient.Memorycatcherclient port = service.getMemorycatcherclientPort();
	 // TODO initialize WS operation arguments here
	java.lang.String username = name;
	java.lang.String password = passw;
	java.lang.String email = mails;
	// TODO process result here
	int result = port.register(username, password, email);
	if(result>=0){
          request.getRequestDispatcher("/index.jsp").forward(request, response);

        }else{
            //else redirect to login page.
            out.println("Result = "+result);
            request.getRequestDispatcher("/registerpage.jsp").forward(request, response);
        }
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>
    </body>
</html>
