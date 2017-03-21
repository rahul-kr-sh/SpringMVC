<%@page import="com.mmt.model.bl.HotelBlMMT"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.text.SimpleDateFormat"%>

<%@ page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Hotels</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
 <script>
$(document).ready(function() {
	var today = new Date();
	var tomorrow = new Date();
	var dd = today.getDate();
	var mm = today.getMonth()+1; //January is 0!
	var yyyy = today.getFullYear();
	var dd1 = today.getDate()+1;
	var mm1 = today.getMonth()+1; 
	
	if(mm==2 && dd==28){
		mm1=3;
		dd1=1;
			}
	 if(dd<10){
	        dd='0'+dd
	        
	    } 
	    if(mm<10){
	        mm='0'+mm
	    } 
	    if(dd1<10){
	        dd1='0'+dd1
	        
	    } 
	    if(mm1<10){
	        mm1='0'+mm1
	    } 

	today = yyyy+'-'+mm+'-'+dd;
	tomorrow=yyyy+'-'+mm1+'-'+dd1;
	document.getElementById("from").setAttribute("min", today);
	document.getElementById("to").setAttribute("min", tomorrow);
   $("#to").blur(function(){
	var checkin = new Date($("#from").val());
	var checkout =new Date($("#to").val());

	    if(checkin >= checkout){
	   		alert("Check-Out should be greater than Check-In date");
	   		
	   		$("#to").val(" ");
	    }
	    
	    });
   $("#from").blur(function(){
		var checkin = new Date($("#from").val());
		var checkout =new Date($("#to").val());

		    if(checkin >= checkout){
		   		alert("Check-Out should be greater than Check-In date");
		   		
		   		$("#from").val(" ");
		    }
		    
		    });
	  });
  
  </script>
  <style>
  #submit{
	border-style: solid;
    border-width: 1px;
    border-color: black;
    background-color: black;
    color: white;
    padding:5px;
    font: bold;
    text-align:center; }
    
#form1{
	text-align:left;
	font-family:serif;
	font-weight: 400;

}
body{
color:maroon;}
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

<form id="form1" action="./selectHotel" >
<fieldset>


<%-- "${new HotelBlMMT().getHotelLocationList()}"  
<c:set var="hotelLocationList"   value=<%= new HotelBlMMT().getHotelLocationList() %>/>
<c:forEach items="${ hotelLocationList}" var="location">
<c:out value="${location}" />

</c:forEach>

--%>
<p>
<b>Place</b>&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select id="places" name="place">


	<c:forEach items="${hotelList}" var="place">
        <option value="${place }">${place }</option>
      </c:forEach>


</select></p>

<%--
<p>
<b>Place</b>&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select id="places" name="place">
   <option value="delhi">New Delhi</option>
    <option value="mumbai">Mumbai</option>
    <option value="jaipur">Jaipur</option>
    <option value="chennai">Chennai</option>
    <option value="goa">Goa</option>
</select></p>

--%>

<p><b>Check-In</b>&nbsp; &nbsp;&nbsp; <input type="date" name="from" id="from" placeholder="dd-mm-yyyy" min="" required/></p>
<p><b>Check-Out</b> &nbsp;<input type="date" id="to" name="to" placeholder="dd-mm-yyyy" min="" required/></p> 
<p><b>Room</b>&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="number" name="room" value="1" min="1"/></p>
<p><input type="submit" id="submit" value="Search"/></p>


</fieldset>
</form>
</body>
</html>