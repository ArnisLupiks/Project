<%-- 
    Document   : addnewresources
    Created on : 11-Dec-2014, 15:55:24
    Author     : Arnis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>add resources Page</title>
    </head>
    <body>
        
    </body>
</html>
 <%
        String resp = request.getParameter("res");
        int resource = Integer.parseInt(resp);
    try {
	memorycatcherclient.Memorycatcherclient_Service service = new memorycatcherclient.Memorycatcherclient_Service();
	memorycatcherclient.Memorycatcherclient port = service.getMemorycatcherclientPort();
	 // TODO initialize WS operation arguments here
	int resources = resource;
	// TODO process result here
	int result = port.addResources(resources);
	if(result>=0){
          request.getRequestDispatcher("/viewresources.jsp").forward(request, response);

        }else{
            //else redirect to login page.
            out.println("added resources = "+result);
            request.getRequestDispatcher("/addresources.jsp").forward(request, response);
        }
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>