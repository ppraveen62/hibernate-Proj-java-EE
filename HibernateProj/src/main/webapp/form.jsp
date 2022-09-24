<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Product</title>
</head>
<body>
	<div align="center">
		<h2>ADD PRODUCT DETAILS PORTAL</h2>
		<form action="addServlet" method ="post"><br>
			Product ID  <input type ="number" name="uid" ><br>
			<br>
			Product Name  <input type ="text" name="uname" ><br>
			<br>
			Product Price  <input type ="number" name="uprice" ><br>
			<br>
			Seller Details  <input type ="text" name="usd" ><br>
			<br>
			<input type="submit" name ="add" value="Submit">
		</form>
		
		<% if(request.getParameter("add")!=null) { %>
			<jsp:useBean id="product" class="com.product" scope="request"></jsp:useBean>
			<jsp:setProperty property="*" name="product"/>

			
		<%} %>
		
		
	
		
	</div>
</body>
</html>