<%-- 
    Document   : addmessage
    Created on : 11-Dec-2014, 19:36:21
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
        
    <%-- start web service invocation --%><hr/>
    <%
  
    try {
	memorycatcherclient.Memorycatcherclient_Service service = new memorycatcherclient.Memorycatcherclient_Service();
	memorycatcherclient.Memorycatcherclient port = service.getMemorycatcherclientPort();
	 // TODO initialize WS operation arguments here
	
	java.lang.String messageName = request.getParameter("memnam");
	java.lang.String messageContent = request.getParameter("memdesc");;
	java.lang.String receiver = request.getParameter("useid");
	// TODO process result here
	int result = port.addMessage(messageName, messageContent, receiver);
        request.getRequestDispatcher("/mainpage.jsp").forward(request, response);
	out.println("Result = "+result);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>
    </body>
</html>
