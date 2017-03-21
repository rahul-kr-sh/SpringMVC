<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <!DOCTYPE html > 

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Money</title>
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


<form action="./addMoney" >

  Enter Amount:<input type="number" required="required" placeholder="Enter Amount" name="amount" />
  
  <input type="submit" value="Add">
</form>

</body>
</html>