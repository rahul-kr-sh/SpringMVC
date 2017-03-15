<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="./userRegister" modelAttribute="user" id="myform">
		<form:label path="userId">Enter User id</form:label>
		<form:input path="userId" />
		<td><form:errors path="userId"></form:errors></td>
		<br>
		<br>

		<form:label path="userName">Enter user Name</form:label>
		<form:input path="userName" />
		<td><form:errors path="userName"></form:errors></td>
		<br>
		<br>
		
		<form:label path="userPhoneNo">Enter User Phone No</form:label>
		<form:input path="userPhoneNo" />
		<td><form:errors path="userPhoneNo"></form:errors></td>
		<br>
		<br>
		<form:label path="userEmailId">Enter User Email Id</form:label>
		<form:input path="userEmailId" />
		<td><form:errors path="userEmailId"></form:errors></td>
		<br>
		<br>
		<form:label path="userAddress">Enter User Address</form:label>
		<form:input path="userAddress" />
		<td><form:errors path="userAddress"></form:errors></td>
		<br>
		<br>
		<form:label path="userPassword">Enter User Password</form:label>
		<form:input path="userPassword" />
		<td><form:errors path="userPassword"></form:errors></td>
		<br>
		<br>
		

		<input type="submit" value="Register">

	</form:form>
</body>
</html>