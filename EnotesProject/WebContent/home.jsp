<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
UserDetails user2 = (UserDetails) session.getAttribute("userD");

if (user2 == null) {

	response.sendRedirect("login.jsp");
	session.setAttribute("Login-error", "Please Login.....");
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<%@include file="all_component/allcss.jsp"%>
</head>
<body>

	<div class="container-fluid">
		<%@include file="all_component/navbar.jsp"%>

		<div class="card py-5">
			<div class="card-body text-center">
				<img alt="" src="img/paper.jpg" class="img-fluid mx-auto"
					style="max-width: 300px">
				<h1>START TAKING YOUR NOTES</h1>
				<a href="addNotes.jsp" class="btn btn-outline-primary">Start
					Here</a>


			</div>


		</div>
	</div>

	<div class="container-fluid bg-dark mt-1">
<p class="text-center text-white"> Note: Any errors occurs then contact on +918668234463. Designed and devloped by Sagar Pol</p>

<p class="text-center text-white"> All Right Reserved @SagarPol 2021-22</p>
<p class="text-center text-white"> You can also contact on email: sagarpol2000@gmail.com</p>

</div>
</body>
</html>