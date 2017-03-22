<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="AdminLoginHeader.jsp"></jsp:include>

	
<div class="container">
  
  <div class="panel panel-primary">
    <div class="panel-heading">Profile details</div>
    <div class="panel-body">
    userId: ${admin.getAdminId() } <br>
	userName: ${admin.getAdminName()} <br>
	userPhoneNo: ${admin.getAdminPhoneNo() } <br>
	userEmailId: ${admin.getAdminEmailId() } <br>
	userAddress: ${admin.getAdminAddress() }<br>
    
    </div>
  </div>
</div>

</body>
</html>