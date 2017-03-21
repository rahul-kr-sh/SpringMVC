<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Rooms</title>
<style>
#book{
	border-style: solid;
    border-width: 1px;
    border-color: red;
    background-color: red;
    color: white;
    padding:5px;
    font: bold;
    text-align:center; }
table {
    border-collapse: collapse;
    width: 100%;
}

th, td {
    padding: 19px;
    text-align: left;
    border-bottom: 1px solid #ddd;
}

tr:hover{background-color:#f5f5f5}
th {
    background-color: black;
    color: white;
}
</style>
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

<table border="1">
	<tr>
	
	<th>HotelRoomNo</th>
	<th>HotelRoomType</th>
	<th>HotelRoomPrice</th>
	
	<th></th>
	</tr>
<c:forEach items="${arrayListHotelRoom}" var="hotelRoom">
<tr>
	<!--<td><img src="images/hotelroom.jpg"  height="100" width="100"/></td>-->
	<!-- <c:set var="hotelId" scope="session" value="${hotel.getHotelId()}"/>-->
     <td><c:out value="${hotelRoom.getHotelRoomNo()}" /></td>
     <td><c:out value="${hotelRoom.getHotelRoomType()}" /></td>
     <td><c:out value="${hotelRoom.getHotelRoomPrice()}" /></td>
      <td>
      <form action="./bookHotel">
      <c:set var="hotelRoomNo" scope="session" value="${hotelRoom.getHotelRoomNo()}"/>
      <c:set var="RoomPrice" scope="session" value="${hotelRoom.getHotelRoomPrice()}"/>
      <!--<c:set var="hotelId" scope="session" value="${hotel.getHotelId()}"/>-->
      <button type="submit" id="book">Book Now</button>
      </form>
      </td>
 </tr> 
</c:forEach>
</table>
</body>
</html>