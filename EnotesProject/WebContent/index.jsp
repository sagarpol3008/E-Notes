


<%@page import="com.Db.DBConnect"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.back-img {
background: url("img/n7.jpg");
width: 100%;
height: 80vh;
background-repeat: no-repeat;
background-size: cover;

}

</style>


<meta charset="ISO-8859-1">
<title>Home Page</title>
<%@include file="all_component/allcss.jsp" %>
</head>
<body>
	<%@include file="all_component/navbar.jsp" %>
	
	
	
	<div class="container-fluid back-img">
	<div class="text-center">
	<h1 class="text-white"> <i class="fa fa-book" aria-hidden="true"> E-Notes: Save Your Notes</h1>
	<a href="login.jsp" class="btn btn-light"> <i class="fa fa-user-circle-o" aria-hidden="true"></i> Login</a>
	<a href="register.jsp" class="btn btn-light"> <i class="fa fa-user-plus" aria-hidden="true"></i>Register</a>
	
	</div>
	</div>
	
<div class="container-fluid bg-dark ">
<p class="text-center text-white"> Note: Any errors occurs then contact on +918668234463. Designed and devloped by Sagar Pol</p>

<p class="text-center text-white"> All Right Reserved @SagarPol 2021-22</p>
<p class="text-center text-white"> You can also contact on email: sagarpol2000@gmail.com</p>

</div>
</body>
</html>