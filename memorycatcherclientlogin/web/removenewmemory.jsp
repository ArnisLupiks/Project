<%-- 
    Document   : removenewmemory
    Created on : 11-Dec-2014, 18:38:45
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
        String ids = request.getParameter("id");
        
        int Ida = Integer.parseInt(ids);
    try {
	memorycatcherclient.Memorycatcherclient_Service service = new memorycatcherclient.Memorycatcherclient_Service();
	memorycatcherclient.Memorycatcherclient port = service.getMemorycatcherclientPort();
	 // TODO initialize WS operation arguments here
	int memoryID = Ida;
	// TODO process result here
	boolean result = port.removeMemory(memoryID);
	          request.getRequestDispatcher("/viewallmemory.jsp").forward(request, response);

    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>
    </body>
</html>
