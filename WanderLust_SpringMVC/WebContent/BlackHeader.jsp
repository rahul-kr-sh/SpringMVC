<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<style >
h2 span{
color: dark grey; 
   font: bold 24px/45px Helvetica, Sans-Serif; 
   font-size:100px;
   letter-spacing: -1px;  
   padding: 10px;
}
</style>
<style >
body {
background-image: url(images/img.jpg); /*You will specify your image path here.*/

-moz-background-size: cover;
-webkit-background-size: cover;
background-size: cover;
background-position: top center !important;
background-repeat: no-repeat !important;
background-attachment: fixed;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Wander Lust</title>
</head>
<body>
<form action="">
<h2><span><center>WanderLust</center></span></h2>

 <nav class="navbar navbar-inverse"> 
  <div class="container-fluid">
    
    <ul class="nav navbar-nav">
      <li ><a href="FlightForm.jsp">Flight</a></li>
      
      
      <li><a href="HotelForm.jsp">Hotel</a>  </li>
        
     
      <li><a href="ContactUs.jsp">Contact</a></li>
      <li><a href="AboutUs.jsp">About us</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="Signup.jsp"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="login.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
  </nav>
 </form>
</body>
</html>