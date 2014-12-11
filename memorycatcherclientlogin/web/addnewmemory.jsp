<%-- 
    Document   : addnewmemory
    Created on : 11-Dec-2014, 18:21:33
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
        <h1>Hello World!</h1>
    <%-- start web service invocation --%><hr/>
    <%
         String Name = request.getParameter("memname");
        String content = request.getParameter("memcont");
    try {
	memorycatcherclient.Memorycatcherclient_Service service = new memorycatcherclient.Memorycatcherclient_Service();
	memorycatcherclient.Memorycatcherclient port = service.getMemorycatcherclientPort();
	 // TODO initialize WS operation arguments here
	java.lang.String memoryName = Name;
	java.lang.String memoryDescription = content;
	// TODO process result here
	int result = port.addMemory(memoryName, memoryDescription);
	out.println("Result = "+result);
                    request.getRequestDispatcher("/mainpage.jsp").forward(request, response);

    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>
    </body>
</html>
