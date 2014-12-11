<html>
    <head>
        <meta content="text/html;charset=utf-8" http-equiv="Content-Type">
        <meta content="utf-8" http-equiv="encoding">
        <title>This is login to memorycatcher</title>
        <link href="http://netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
rel="stylesheet" type="text/css" />
        <link href="css/styling.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class = "login_table">
            <div class="login_heading">
                <h1 class="col-sm-10 login_h1">Memory Catcher</h1>
            </div>
            <form class="form-horizontal"action="login.jsp" method="post" role="form">
                <div class="form-group">
                  <div class=" col-sm-10">
                    <input type="text" class="form-control input-lg" id="username" name="usr" placeholder="Enter Your Username">
                  </div>
                </div>
                <div class="form-group">
                  <div class=" col-sm-10">
                    <input type="password" class="form-control input-lg" id="Password"  name="pass"placeholder="Enter Your Password">
                  </div>
                </div>
                <div class="form-group">
                  <div class=" col-sm-10">
                    <button type="submit" class="btn btn-primary btn-lg btn-block">Login</button>
                    <a href="registerpage.jsp"class="btn btn-default btn-lg btn-block" >Register</a>
                  </div>
                </div>
            </form>
        </div>
    </body>
</html>