<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Past Flight</title>
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

	
<div class="panel panel-default" style="background-image: url('static/images/bg1.jpg'); background-attachment: fixed; border-color: #0d97ba">
    <div class="panel-heading" style="background-image: url('static/images/bg1.jpg'); background-attachment: fixed; border-color: #0d97ba">Details of booked Flights</div>
    <div class="panel-body">
        
    </div>

    <div class="table-responsive" style="border-color: #0d97ba">
        <table class="table table-bordered" style="border-color: #0d97ba" >
            <thead>
                <tr>
                    <th>Flight Booking ID</th>
                    <th>Flight ID</th>
                    <th>Flight Booking Date</th>
                    <th></th>
                   
                </tr>
            </thead>
            <c:forEach items="${bookedFlightList}" var="list">
            <form action="./ViewPastFlight">
            
            <tbody>
                <tr>
                
                    <td><c:out value="${ pastFlightBooking.flightBookingId}" /></td>
                    <td><c:out value="${ pastFlightBooking.flightId}" /></td>
                    <td><c:out value="${ pastFlightBooking.flightBookingDate}" /></td>
                    
                    <c:set var="viewFlightBookingDate" scope="session" value="${ pastFlightBooking.getFlightBookingDate()}"/>
               		 <c:set var="viewFlightId" scope="session" value="${pastFlightBooking.getFlightId()}"/>
                 	<td><button type="submit" class="btn btn-default" id="view">View Details</button></td>
                </tr>
            </tbody>
            </form>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>