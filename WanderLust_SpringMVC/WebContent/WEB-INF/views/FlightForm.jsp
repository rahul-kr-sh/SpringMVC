


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<%@ page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Flights</title>
<script>
	$(function() {
		var today = new Date();
		var dd = today.getDate();
		var mm = today.getMonth() + 1; //January is 0!
		var yyyy = today.getFullYear();
		if (dd < 10) {
			dd = '0' + dd
		}
		if (mm < 10) {
			mm = '0' + mm
		}
		today = yyyy + '-' + mm + '-' + dd;
		document.getElementById("departureDate").setAttribute("min", today);

	});
	function check() {
		var source = document.getElementById("source").value;
		var destination = document.getElementById("destination").value;
		if (source == destination) {
			alert("Source and Destination cannot be same");
			document.getElementById("source").value = " ";
			document.getElementById("destination").value = " ";
		}
	}
</script>
<style>
#submit {
	border-style: solid;
	border-width: 1px;
	border-color: black;
	background-color: black;
	color: white;
	padding: 5px;
	font: bold;
	text-align: center;
}

#form1 {
	text-align: left;
	font-family: serif;
	font-weight: 400;
}

td {
	height: 50px;
	vertical-align: bottom;
}

body {
	color: maroon;
}
</style>
</head>



<c:choose>
  <c:when test="${sessionScope.userBeanSession == null}">
    <jsp:include page="HomeHeader.jsp"></jsp:include>
  </c:when>
 
  <c:otherwise>
     <jsp:include page="UserLoginHeader.jsp"></jsp:include>
  </c:otherwise>
</c:choose>




<body>
	<form:form action="./selectFlight" modelAttribute="flight">
	
	
	<form:label path="flightSource">Source</form:label>
	<form:select path="flightSource">
		<form:option value="flightSource">Select Source</form:option>
		<form:options items="${flightSourceList}"/>
	</form:select><br><br>
	
	<form:label path="flightDestination">Destination</form:label>
	<form:select path="flightDestination">
		<form:option value="flightDestination">Select Destination</form:option>
		<form:options items="${flightDestList}"/>
	</form:select><br><br>
	
	
	
	
	Depature-Date: <input id="departureDate" name="departureDate" type="date" placeholder="dd/mm/yyyy" min="" required/>
	<br><br>
	Number of Seats :<input type="number" name="seats" value="1" min="1"/>
	<br><br>
	<input type="submit" value="Search" id="submit" onclick="check()"/>
                    
	</form:form>
</body>
</html>