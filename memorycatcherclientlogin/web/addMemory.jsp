<html>
    <head>
        <meta content="text/html;charset=utf-8" http-equiv="Content-Type">
        <meta content="utf-8" http-equiv="encoding">
        <title>This is add memory</title>
        <link href="http://netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
rel="stylesheet" type="text/css" />
        <link href="css/styling.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
          <div class="navbar navbar-inverse navbar-fixed-top">
                <div class="container">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="mainpage.jsp">Memory Catcher</a>
                    </div>
                    <div class="navbar-collapse collapse">
                        <ul class="nav navbar-nav">
                            <li><a href="mainpage.jsp">Home</a></li>
                            <li class="dropdown active">
                                <a class ="dropdown-toggle" data-toggle = "dropdown">Memories <b class = "caret"></b></a>
                                <ul class = "dropdown-menu">
                                  <li><a href="addMemory.jsp">New Memories</a></li>
                                  <li><a href="viewallmemory.jsp">All Memories</a></li>
                                  <li><a href="removeMemory.jsp">Remove Memory</a></li>
                                </ul>
                            </li>
                            <li class="dropdown ">
                                <a class ="dropdown-toggle"  data-toggle = "dropdown">Resources <b class = "caret"></b></a>
                                <ul class = "dropdown-menu">
                                  <li><a href="addresources.jsp">Add Resources</a></li>
                                  <li><a href="viewresources.jsp">View Resource</a></li>
                                  <li><a href="shareresources.jsp">Share Resources</a></li>
                                </ul>
                            </li>
                             <li class="dropdow">
                                <a class ="dropdown-toggle" data-toggle = "dropdown">Messages <b class = "caret"></b></a>
                                <ul class = "dropdown-menu">
                                  <li><a href="viewallmessages.jsp">Inbox</a></li>
                                  <li><a href="addmessagepage.jsp">Send Message</a></li>
                                </ul>
                            </li>
                        <li><a href="index.jsp">Logout</a></li>
                        </ul>
                    </div>
                </div>
        </div>
        <div class = "login_table">
            <div class="login_heading">
                <h1 class="col-sm-10 login_h1">Add Memory</h1>
            </div>
            <form class="form-horizontal"action="addnewmemory.jsp" method="post" role="form">
                <div class="form-group">
                  <div class=" col-sm-10">
                    <input type="text" class="form-control input-lg"  name="memname" placeholder="Enter Memory Name">
                  </div>
                </div>
                <div class="form-group">
                  <div class=" col-sm-10">
                    <input type="text" class="form-control input-lg"   name="memcont"placeholder="Enter Your Memory Content">
                  </div>
                </div>
                <div class="form-group">
                  <div class=" col-sm-10">
                    <button type="submit" class="btn btn-primary btn-lg btn-block">Add Memory</button>
                  </div>
                </div>
            </form>
        </div>
         <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    </body>
</html>