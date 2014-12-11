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
        <h1>Hello World!</h1>
        
    <%-- start web service invocation --%><hr/>
    <%
        String Name = request.getParameter("usename");
        String sname = request.getParameter("memnam");
        String mesdes = request.getParameter("memdesc");
        String ids = request.getParameter("useid");
        
        int Ida = Integer.parseInt(ids);
    try {
	memorycatcherclient.Memorycatcherclient_Service service = new memorycatcherclient.Memorycatcherclient_Service();
	memorycatcherclient.Memorycatcherclient port = service.getMemorycatcherclientPort();
	 // TODO initialize WS operation arguments here
	java.lang.String sender = Name;
	java.lang.String messageName = sname;
	java.lang.String messageContent = mesdes;
	java.lang.String receiver = ids;
	// TODO process result here
	int result = port.addMessage(sender, messageName, messageContent, receiver);
	out.println("Result = "+result);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>
    </body>
</html>
