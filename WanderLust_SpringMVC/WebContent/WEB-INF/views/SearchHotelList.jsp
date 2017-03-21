<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.mmt.model.bean.Hotel"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Hotels</title>
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
	<th></th>
	<th>Hotel Id</th>
	<th>Hotel Name</th>
	<th>Information</th>
	<th></th>
	</tr>
<c:forEach items="${searchedHotelSet}" var="hotel">
<tr>
	<td><img src="static/images/${hotel.getHotelImage()}"  height="100" width="100"/></td>
	
     <td><c:out value="${hotel.getHotelId()}" /></td>
     <td><c:out value="${hotel.getHotelName()}" /></td>
      <td><c:out value="${hotel.getHotelInfo()}" /></td>
      
      <td>
      <form action="./chooseRoom">
      <c:set var="hotelId" scope="session" value="${hotel.getHotelId()}"/>
      
      <button type="submit" id="book">Choose Room</button>
      </form>
      </td>
 </tr> 
</c:forEach>
</table>

</body>
</html>