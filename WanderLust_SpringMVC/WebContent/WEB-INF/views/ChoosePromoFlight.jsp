<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="UserLoginHeader.jsp"></jsp:include>
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
	<form action="./Payment">


		<p>
			<b>Select a Promo Code</b>&nbsp; &nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <select id="promoflight"
				name="promoflight">

				<!--<c:set var="flightPromo" scope="session" value="${arrayListPromoFlight}"/>-->
				<c:forEach items="${arrayListPromoFlight}" var="flightPromo">
					
					<option value="${flightPromo.getPromotionId()}">${flightPromo.getPromotionName()}</option>

					<c:set var="pidFlight" scope="session" value="${flightPromo.getPromotionId()}"/>
					<c:set var="pdiscountFlight" scope="session" value="${flightPromo.getPromotionDiscount()}"/>

					<c:set var="pidFlight" scope="application" value="${flightPromo.getPromotionId()}"/>
					<c:set var="pdiscountFlight" scope="application" value="${flightPromo.getPromotionDiscount()}"/>

				</c:forEach>
				 
			</select> &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; <input type="button"
				id="applyPromo" value="Apply"      onclick="loadDoc();" />
		</p>
		<p id="demo"></p>

		<p>
			<input type="submit" id="continue" value="Pay Now" />
		</p>

	</form>
</body>
</html>