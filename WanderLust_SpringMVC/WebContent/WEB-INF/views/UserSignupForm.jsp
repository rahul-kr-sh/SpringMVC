<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="HomeHeader.jsp"></jsp:include>
	<form:form action="./userRegister" modelAttribute="user" id="myform">
	
	<a href="?lang=en">English</a>|<a href="?lang=de">German</a><br> 
	
	<%--<spring:message code="label.firstname"></spring:message> --%>
		<form:label path="userId"><spring:message code="label.userId"></spring:message></form:label>
		<form:input path="userId" />
		<td><form:errors path="userId"></form:errors></td>
		<br>
		<br>

		<form:label path="userName"><spring:message code="label.userName"></spring:message>Enter user Name</form:label>
		<form:input path="userName" />
		<td><form:errors path="userName"></form:errors></td>
		<br>
		<br>
		
		<form:label path="userPhoneNo"><spring:message code="label.userPhoneNo"></spring:message></form:label>
		<form:input path="userPhoneNo" />
		<td><form:errors path="userPhoneNo"></form:errors></td>
		<br>
		<br>
		<form:label path="userEmailId"><spring:message code="label.userEmailId"></spring:message></form:label>
		<form:input path="userEmailId" />
		<td><form:errors path="userEmailId"></form:errors></td>
		<br>
		<br>
		<form:label path="userAddress"><spring:message code="label.userAddress"></spring:message></form:label>
		<form:input path="userAddress" />
		<td><form:errors path="userAddress"></form:errors></td>
		<br>
		<br>
		<form:label path="userPassword"><spring:message code="label.userPassword"></spring:message></form:label>
		<form:input path="userPassword" />
		<td><form:errors path="userPassword"></form:errors></td>
		<br>
		<br>
		

		<input type="submit" value="Register">

	</form:form>
</body>
</html>