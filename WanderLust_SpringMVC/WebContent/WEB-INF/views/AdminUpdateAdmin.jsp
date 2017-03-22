<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <jsp:include page="AdminLoginHeader.jsp"></jsp:include>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Admin</title>
<script>
  function phonenumber(inputtxt)  
  {  
    var phoneno = /^\d{10}$/;  
    if(inputtxt.value.match(phoneno))  
    {  
        return true;  
    }  
    else  
    {  
       alert("Enter 10 digit Phone Number");  
       return false;  
    }  
    }  
  </script>
</head>
<body>
<c:set var="option" scope="session" value="${option}"/>
<c:out value="${option}"></c:out>
<form  name="form1" action="./AdminProfile">
<fieldset>
<legend>Fill Flight Details</legend><br><br>
<input type="hidden" name="option" value="update"/>
<table>
<tr><td>Old Admin ID</td><td><input type="text" name="oldadminId" placeholder="Enter Id" required/></td></tr>
<tr><td>Admin ID</td><td><input type="text" name="adminId" placeholder="Enter New Admin Id" required/></td></tr>
<tr><td>Admin Name</td><td><input type="text" name="adminName" placeholder="Enter New Admin Name" required/></td></tr>
<tr><td>Admin Phone No</td><td><input type="tel"  name="adminPhoneNo" placeholder="Enter New Phone No" onblur="phonenumber(document.form1.adminPhoneNo)" required/></td></tr>
<tr><td>Admin EmailId</td><td><input type="email" name="adminEmailId" placeholder="Enter New EmailId" required/></td></tr>
<tr><td>Admin Address</td><td><input type="text" name="adminAddress" placeholder="Enter New Address" required/></td></tr>
<tr><td>Admin Password</td><td><input type="text" name="adminPassword" placeholder="Enter New Password" required/></td></tr>

</table>
<input type="submit" value="Update"/>
</fieldset>
</form>
</body>
</html>