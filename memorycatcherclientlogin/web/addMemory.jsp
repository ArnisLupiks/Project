<%-- 
    Document   : addMemory
    Created on : 11-Dec-2014, 13:16:47
    Author     : Barry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="http://code.jquery.com/jquery-latest.js"></script>
	<style> img{height:200px; float: left}</style>
	<script>
		$(document).ready(function(){
		
			$("#button").click(function(){
			$("#images").empty();
				$.getJSON("http://api.flickr.com/services/feeds/photos_public.gne?jsoncallback=?",
			{
				tags: "christmas",
				tagmode:"any",
				format: "json"
			}, function(data){
				$.each(data.items, function(i,item){
					$('<img/>').attr("src", item.media.m).appendTo('#images');
					if(i==3) return false;
				});
			});
			
		});
	});

	</script>
        
    </head>
    <body>
        <h1>Memory has been added!</h1>
        <input type="button" id = "button" value="view memory added!" /><p>
        <div id="images"></div>
        
    <%-- start web service invocation --%><hr/>
     <%
         String mname = request.getParameter("nme");
        String mdescription = request.getParameter("des");
         
    
    try {
	memorycatcherclient.Memorycatcherclient_Service service = new memorycatcherclient.Memorycatcherclient_Service();
	memorycatcherclient.Memorycatcherclient port = service.getMemorycatcherclientPort();
	 // TODO initialize WS operation arguments here
	java.lang.String memoryName = mname;
	java.lang.String memoryDescription = mdescription;
	// TODO process result here
	int result = port.addMemory(memoryName, memoryDescription);
	out.println("Result = "+result);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>
    </body>
</html>
