<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Promotions</title>
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


	
	
	<form:form action="./applyHotelPromo" modelAttribute="promotion">
	
	
	<form:label path="promotionName">Select a Promo Code</form:label>
	<form:select path="promotionId">
		<form:option value="-------">Select promo</form:option>
		<form:options items="${hotelPromoList}"/>
	</form:select><br><br>
	
	
	<input type="submit" id="continue" value="Apply" />
	</form:form>

</body>
</html>