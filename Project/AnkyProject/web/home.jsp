<%@page import="java.sql.ResultSet"%>
<%@page import="package1.JDBC"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>Home</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <link rel="stylesheet" type="text/css" href="home.css">
    <script>
		$(document).ready(function(){
			$("#show-toast").click(function(){
					$("#myToast").toast('show');
			});
	});     
        
	</script>
  </head>
  <body>
    <div class="">
        <nav class="navbar navbar-fixed-top navbar-expand-lg" style="background-color: #519194;">
          <div class="header" style="margin-left: -16px;">
            <div class="progress-container">
              <div class="progress-bar btn-myprimary" id="myBar"></div>
            </div>
          </div>

            <nav class="navbar navbar-light" style="background-color: #519194;">
            <a class="navbar-item">
              <!-- <img src="q.jpg" width="30" height="30" class="d-inline-block align-top" alt="spec"> -->
              <span class="navbar-brand mb-0 h1" style="color: white;">Welcome!</span>
            </a>
          </nav>

          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>

          <div class="collapse navbar-collapse" id="navbarSupportedContent">
              <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="home.jsp" style="color: white; margin-left: 20px;">Home</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="info.html" style="color: white; margin-left: 20px;">About</a>
                </li>
                <li class="nav-item">
                  <a target="_blank" id="show-toast" class="nav-link"><p style="color: white; margin-left: 20px;">Help</p></a>
                </li>

                <li class="nav-item" style="padding-left:900px;">
                  <a class="nav-link" href="Login.html" style="color: white;">LogOut</a>
                </li>
              </ul>
        </div>
      </nav>
      <div aria-live="assertive" aria-atomic="false" class="d-flex justify-content-center align-items-center">
      	<!-- <button type="button" class="btn btn-primary">Show Toast</button> -->
        <div class="toast" role="alert" data-autohide="false" id="myToast" style="position: absolute; left:250px; padding-top:150px;">
        	<div class="toast-header">
          	<!-- <img src="gmail.png" class="rounded mr-2" alt="gmail.png" style="max-height: 20px;"> -->
            <strong class="mr-auto"><i class=""></i>Contact Us...</strong>
            <!-- <small></small> -->
            <button type="button" class="ml-2 mb-1 close" data-dismiss="toast" style="align: right;">
            	<span aria-hidden="true">&times;</span>
            </button>
          </div>
        	<div class="toast-body">
          	<label><p style="color: #000000;"></p><strong style="color: blue; font-size: 110%;">anky@gmail.com</strong></label>
          </div>
      	</div>
      </div>
    </div>

    <div class="myImg">
      <div class="jumbotron container">
        <!-- <div class="row">
                  <div class="col-lg-4 col-md-4 col-xs-4 d-flex align-items-stretch">
                      <button type="button" class="btn btn-secondary btn-lg mybtn">UPLOAD 📤</button>
                  </div>
                  <div class="col-lg-4 col-md-4 col-xs-4 d-flex align-items-stretch">
                      <button type="button" class="btn btn-info btn-lg mybtn">DOWNLOAD 📥 </button>
                  </div>
        </div> -->
        <div class="row">
          <div class="col-lg-4 col-md-4 col-xs-4 d-flex align-items-stretch">
            <div class="">
                <form action="UploadServlet" method="post" enctype="multipart/form-data">
                    <br>
                    <!-- <label for="myfile">Select a file:</label><br> -->
                    <input type="file" id="myfile" name="myfile"><br><br>
                    <!-- <input type="submit" class="btn btn-success"> -->
                    <input type="submit" value="UPLOAD 📤" class="btn btn-secondary btn-lg mybtn">
                    <details>
                        <summary>Details</summary>
                        <p id="iddetails"></p>
                    </details>
                </form>
            </div>
          </div>

          <div class="col-lg-4 col-md-4 col-xs-4 d-flex align-items-stretch">
            <div class="">
                <form action="DownloadServlet" method="get">
                    <p></p>
                    <label for="fname">Enter File Name: </label>
                    <input type="text" id="myfile" name="mytext"><br><br>
                    <!-- <input type="submit" class="btn btn-success"> -->
                    <input type="submit" value="DOWNLOAD 📥" class="btn btn-info btn-lg mybtn">
                </form>
            </div>
          </div>
        </div>
      </div>
        
    <%  JDBC jdbcobj = new JDBC();
    ResultSet ress = jdbcobj.displayData(); 
    int fileCount = 1;%>        
      <div class="container jumbotron myImgTable">
        <table class="table table-hover table-sm">
          <thead class="thead-dark">
            <tr>
              <th scope="col">Sr. No.</th>
              <th scope="col">Available Files</th>
            </tr>
          </thead>
          <tbody style="color: white;">              
            <%  while(ress.next()){ %>
               <tr>
                   <th scope="row"><%=fileCount++%></th>
                   <td> <%=ress.getString(1)%> </td>
               </tr>
            <%  }   %>              
        </tbody>
      </table>
      </div>
    </div>
        
        <div id="footer">
		<div>
			<p>
				&copy; copyright 2020 | all rights reserved.
			</p>
		</div>
	</div>

  </body>
</html>
