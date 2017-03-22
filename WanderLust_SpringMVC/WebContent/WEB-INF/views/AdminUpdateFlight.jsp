<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <jsp:include page="AdminLoginHeader.jsp"></jsp:include>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Flight</title>
</head>
<body>
<c:set var="option" scope="session" value="${option}"/>
<c:out value="${option}"></c:out>
<form action="./AdminFlight">
<fieldset>
<legend>Fill Flight Details</legend><br><br>
<input type="hidden" name="option" value="update"/>
<table>
<tr><td>Old Flight ID</td><td><input type="text" name="oldflightId" placeholder="Enter Id" value="${flightId}"required/></td></tr>
<tr><td>New Flight ID</td><td><input type="text" name="newflightId" placeholder="Enter Id" value="${flightId}" required/></td></tr>
<tr><td>New Company Name</td><td><input type="text" name="flightCompanyName" placeholder="Enter CompanyName" value="${flightCompanyName}" required/></td></tr>
<tr><td>New Source</td><td><input type="text" name="flightSource" placeholder="Enter Source"  value="${Source} "required/></td></tr>
<tr><td>New Destination</td><td><input type="text" name="flightDestination" placeholder="Enter Destination" value="${Destination}"required/></td></tr>
<tr><td>New Depart</td><td><input type="text" name="flightDepartureTime" placeholder="Enter DepartureTime" value="${departureTime}" required/></td></tr>
<tr><td>New Arrive</td><td><input type="text" name="flightArrivalTime" placeholder="Enter ArrivalTime" value="${arrivalTime}" required/></td></tr>
<tr><td>New Ticket Price</td><td><input type="text" name="flightTicketPrice" placeholder="Enter TicketPrice" value="${flightTicketPrice}" required/></td></tr>
<tr><td>New Total Seats</td><td><input type="number" name="availableSeats" placeholder="Enter Total Seats" value="${flightAvailableSeat }" required/></td></tr>
</table>
<input type="submit" value="Update"/>
</fieldset>
</form>
</body>
</html>