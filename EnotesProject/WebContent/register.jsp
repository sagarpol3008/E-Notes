<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
<%@include file="all_component/allcss.jsp"%>


</head>
<body>
	<%@include file="all_component/navbar.jsp"%>
	<div class="container-fluid div-color">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card mt-4">
					<div class="card-header text-center text-white bg-custom">
						<i class="fa fa-user-plus fa-3x" aria-hidden="true"></i>
						<h4>Registration</h4>
					</div>



					<%
					String regMsg = (String) session.getAttribute("reg-success");

					if (regMsg != null) {
					%>

					<div class="alert alert-success" role="alert"><%=regMsg%> Login<a href="login.jsp">Click here</a></div>

					<%
					session.removeAttribute("reg-success");
						}
					%>


					<%
					String FailedMsg = (String) session.getAttribute("failed-msg");

					if (FailedMsg != null) {
					%>

					<div class="alert alert-danger" role="alert"><%= FailedMsg %></div>
					<%
					session.removeAttribute("failed-msg");
					
						}
					%>

					<div class="card-body">
						<form action="UserServlet" method="post">
							<div class="form-group">
								<label>Enter Full Name</label> <input type="text"
									class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="fname"
									placeholder="Enter Full Name">

							</div>

							<div class="form-group">
								<label>Enter Email</label> <input type="email"
									class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="uemail"
									placeholder="Enter Email">

							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Enter Password</label> <input
									type="password" class="form-control" id="exampleInputPassword1"
									name="upassword" placeholder="Password">
							</div>

							<button type="submit"
								class="btn btn-primary badge-pill btn-block">Register</button>
						</form>

					</div>
				</div>
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