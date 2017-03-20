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


<form action="./confirmFlightBooking" >
<table border="1">
<tr><td>Company name:</td><td>${selectedFlightBeanSession.flightCompanyName}</td></tr>
<tr><td>Source:</td><td>${selectedFlightBeanSession.flightSource}</td></tr>
<tr> <td>Destination:</td><td>${selectedFlightBeanSession.flightDestination}</td></tr>

 <%--<tr><td>Date of Flight:</td><td>${selectedFlightBeanSession.}</td></tr> --%> 
 <tr><td>Departure Time:</td><td>${selectedFlightBeanSession.flightDepartureTime}</td></tr>
 <tr><td>Arrival Time:</td><td>${selectedFlightBeanSession.flightArrivalTime}</td></tr>
 <tr><td>No. of seats:</td><td>${flightSeat}</td></tr>
 <tr><td>Amount to be paid:</td><td>${flightTicketPrice }</td></tr>
 

</table>
<input type="submit" value="Confirm Flight Booking">
</form>

</body>
</html>