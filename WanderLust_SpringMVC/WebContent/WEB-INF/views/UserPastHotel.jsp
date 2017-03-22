<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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

	
<div class="panel panel-default" style="background-image: url('images/bg1.jpg'); background-attachment: fixed; border-color: #0d97ba">
    <div class="panel-heading" style="background-image: url('images/bg1.jpg'); background-attachment: fixed;">Details of booked hotels</div>
    <div class="panel-body">
        
    </div>

    <div class="table-responsive" style="border-color: #0d97ba">
        <table class="table table-bordered" style="background-image: url('images/bg1.jpg'); background-attachment: fixed; "border-color: #0d97ba;">
            <thead>
                <tr>
                    <th>Hotel Booking ID</th>
                    <th>Hotel ID</th>
                    <th>Room No</th>
                    <th>Check In</th>
                    <th>Check Out</th>
                    <th>StayDuration (Days)</th>
                   
                </tr>
            </thead>
            <c:forEach items="${bookedHotelList}" var="list">
            <tbody>
                <tr>
                
                    <td><c:out value="${ list.getHotelBookingId()}" /></td>
                    <td><c:out value="${ list.getHotelId()}" /></td>
                    <td><c:out value="${ list.getRoomNo()}" /></td>
                     <td><c:out value="${ list.getHotelCheckInDate()}" /></td>
                      <td><c:out value="${ list.getHotelCheckOutDate()}" /></td>
                       <td><c:out value="${ list.getStayDuration()}" /></td>
                 
                </tr>
            </tbody>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>