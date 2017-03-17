<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
background-repeat: no-repeat; !important;
background-attachment: fixed;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>UserDashBoard</title>

<body>

<%@ page errorPage="Logout.jsp" %>

<%

if(session==null || !request.isRequestedSessionIdValid() || session.getAttribute("user")==null || session.getAttribute("admin")==null )
{
	response.sendRedirect("login.jsp");

}

%>
<h2><span><center>WanderLust</center></span></h2>
<!--  <div class="jumbotron text-center">
  <h1>Wander Lust</h1> 
  <p>...................................</p> 
</div>
-->
	
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">

		<ul class="nav navbar-nav">
			<li><a href="LoogedInFlightForm.jsp">Flight</a></li>


			<li><a href="LoggInHotelForm.jsp">Hotel</a></li>


			<li><a href="./UserPastFlight">Past Flight Bookings</a></li>
			<li><a href="./UserPastHotel">Past Hotel Bookings</a></li>
			<li><a href="Wallet.jsp"> Wallet</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">

			<c:set var="userName" scope="session" value="${user.getUserName()}" />


			<li><a href="./UserProfile"><span
					class="glyphicon glyphicon-user"></span> ${user.getUserName()} </a></li>
			<li><a href="./Logout"><span
					class="glyphicon glyphicon-log-out"></span>Logout </a></li>
		</ul>
	</div>
	</nav>



</body>
</html>