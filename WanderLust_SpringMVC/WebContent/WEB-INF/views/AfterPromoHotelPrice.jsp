<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Details Flight</title>

<style>
td {
    height: 30px;
    vertical-align: bottom;
}
th, td {
    padding: 5px;
    text-align: left;
}
body{
color:maroon;
}</style>
</head>
<body>
<c:choose>
  <c:when test="${sessionScope.userBeanSession == null}">
    <jsp:include page="HomeHeader.jsp"></jsp:include>
  </c:when>
 
  <c:otherwise>
     <jsp:include page="UserLoginHeader.jsp"></jsp:include>
  </c:otherwise>
</c:choose>




${flightTicketPrice }


<form action="./confirmHotelBooking" >
<table border="1">
<tr><td>Hotel name:</td><td>${bookedHotelDetails.get(0)}</td></tr>
<tr><td>Room number:</td><td>${bookedHotelDetails.get(2)}</td></tr>
<tr> <td>Hotel location:</td><td>${bookedHotelDetails.get(3)}</td></tr>

 <%--<tr><td>Date of Flight:</td><td>${selectedFlightBeanSession.}</td></tr> --%> 
 <tr><td>Check In date:</td><td>${bookedHotelDetails.get(4)}</td></tr>
 <tr><td>Check Out date:</td><td>${bookedHotelDetails.get(5)}</td></tr>

 <tr><td>Amount to be paid:</td><td>${bookedHotelDetails.get(6)}</td></tr>
 

</table>
<input type="submit" value="Confirm Flight Booking">
</form>

</body>
</html>