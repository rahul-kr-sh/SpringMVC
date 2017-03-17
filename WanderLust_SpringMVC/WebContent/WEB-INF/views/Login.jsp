<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>


<jsp:include page="HomeHeader.jsp"></jsp:include>
<body>



<div class="container">
  <h2 style="color:#53e8e5;margin-left:2000px;">Login here</h2>
  <form action="./loginCheck">
    <div class="form-group">
      <label for="email">Enter User Id:</label>
      <input type="text" class="form-control" id="userId"  name= "userId" placeholder="Enter User Id">
    </div>
    <div class="form-group">
      <label for="pwd">Enter Password:</label>
      <input type="password" class="form-control" id="password" name="password" placeholder="Enter password">
    </div>
    <h3 style="color:red;margin-left:0px;">${loginErrMessage}</h3>
    <button type="submit" class="btn btn-default">Submit</button>
    
  </form>
</div>

</body>
</html>