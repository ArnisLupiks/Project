<%-- 
    Document   : sharenewresources
    Created on : 11-Dec-2014, 17:09:35
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
       String username = request.getParameter("usrname");
        String shaamount = request.getParameter("amount");
        
        int resourceamount = Integer.parseInt(shaamount);

    try {
	memorycatcherclient.Memorycatcherclient_Service service = new memorycatcherclient.Memorycatcherclient_Service();
	memorycatcherclient.Memorycatcherclient port = service.getMemorycatcherclientPort();
	 // TODO initialize WS operation arguments here
	java.lang.String name = username;
	int resources = resourceamount;
        request.getRequestDispatcher("/viewresources.jsp").forward(request, response);

	// TODO process result here
	int result = port.shareResources(name, resources);
	out.println("Result = "+result);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>
    </body>
</html>
