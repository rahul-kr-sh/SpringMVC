<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


<script>
function myFunction() {
    window.print();
}
</script>

<style>
button{
 text-align:center;
 margin-left: 150px;
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


	
<div class="panel panel-default">
    <div class="panel-heading">User name: ${userBeanSession.userName}  <br>  User Email id: ${userBeanSession.userEmailId} </div>
    <div class="panel-body">
        
    </div>

    <div class="table-responsive">
        <table class="table table-bordered">
            <thead>
                <tr>
                	<th>Flight Boking Id</th>
                    <th>Flight Company Name</th>
                    <th>Flight Arrival Time</th>
                    <th>Flight Departure Time</th>
                    <th>Flight Source</th>
                    <th>Flight Destination</th>
                    <th>Flight Booking Date</th>
                    <th>Total Price</th>
                    
                    
                   
                   
                </tr>
            </thead>
         
            <tbody>
                <tr>
                
                    <td><c:out value="${ bookedFlightDetails.get(0)}" /></td>
                    <td><c:out value="${ bookedFlightDetails.get(1)}" /></td>
                    <td><c:out value="${ bookedFlightDetails.get(2)}" /></td>
                     <td><c:out value="${ bookedFlightDetails.get(3)}" /></td>
                      <td><c:out value="${ bookedFlightDetails.get(4)}" /></td>
                       <td><c:out value="${ bookedFlightDetails.get(5)}" /></td>
                       <td><c:out value="${ bookedFlightDetails.get(6)}" /></td>
                       <td><c:out value="${ bookedFlightDetails.get(7)}" /></td>
                       
                 
                </tr>
            </tbody>
           
        </table>
   		
    </div>
  
</div>

<div class="centered">
				<button type="button" class="btn btn-success"   onclick="myFunction()">Print</button>
				
     			
			</div>
</body>
</html>