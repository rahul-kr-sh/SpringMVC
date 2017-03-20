<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Choose Promo</title>
<script>
	function loadDoc() {
	/*	var xhttp;
		if (window.XMLHttpRequest) {
			// code for modern browsers
			xhttp = new XMLHttpRequest();
		} else {
			// code for IE6, IE5
			xhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				document.getElementById("demo").innerHTML = this.responseText;
			}
		};
		xhttp.open("GET", "flightPromo.txt", true);
		xhttp.send();*/
		
		document.getElementById("demo").innerHTML="Congrats! You got a discount of "+'${pdiscountFlight}' +"%<br>Your Promotion ID is "+ ' ${pidFlight}';
	}
</script>
<style>
#applyPromo, #continue {
	border-style: solid;
	border-width: 1px;
	border-color: red;
	background-color: red;
	color: white;
	padding: 5px;
	font: bold;
	text-align: center;
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


	
	
	<form:form action="./applyFlightPromo" modelAttribute="promotion">
	
	
	<form:label path="promotionName">Select a Promo Code</form:label>
	<form:select path="promotionId">
		<form:option value="-------">Select promo</form:option>
		<form:options items="${flightPromoList}"/>
	</form:select><br><br>
	
	
	<input type="submit" id="continue" value="Apply" />
	</form:form>
</body>
</html>