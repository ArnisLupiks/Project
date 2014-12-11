<%-- 
    Document   : registerpage
    Created on : 10-Dec-2014, 16:08:54
    Author     : Arnis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta content="text/html;charset=utf-8" http-equiv="Content-Type">
        <meta content="utf-8" http-equiv="encoding">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
          <link href="http://netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
rel="stylesheet" type="text/css" />
        <link href="css/styling.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class = "login_table">
            <div class="login_heading">
                <h1 class="col-sm-10 login_h1">Register Page</h1>
            </div>
            <form class="form-horizontal"action="register.jsp" method ="post" role="form">
                <div class="form-group">
                  <div class=" col-sm-10">
                    <input type="text" class="form-control input-lg" id="username" name="usr1" placeholder="Enter Your Username">
                  </div>
                </div>
                <div class="form-group">
                  <div class=" col-sm-10">
                    <input type="password" class="form-control input-lg" id="Password"  name="pass1"placeholder="Enter Your Password">
                  </div>
                </div>
                 <div class="form-group">
                  <div class=" col-sm-10">
                    <input type="email" class="form-control input-lg" id="email"  name="mail" placeholder="Enter Your Email">
                  </div>
                </div>
                <div class="form-group">
                  <div class=" col-sm-10">
                    <button type="submit" class="btn btn-primary btn-lg btn-block">Register</button>
                    <a href="index.jsp"class="btn btn-default btn-lg btn-block" >Back</a>
                  </div>
                </div>
            </form>
        </div>
    </body>
</html>
