<%-- 
    Document   : viewnewresources
    Created on : 11-Dec-2014, 17:19:48
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
    try {
	memorycatcherclient.Memorycatcherclient_Service service = new memorycatcherclient.Memorycatcherclient_Service();
	memorycatcherclient.Memorycatcherclient port = service.getMemorycatcherclientPort();
	// TODO process result here
	int result = port.viewResources();
	out.println("Result = "+result);
                  //request.getRequestDispatcher("/viewnewresources.jsp").forward(request, response);

    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>
    </body>
</html>
