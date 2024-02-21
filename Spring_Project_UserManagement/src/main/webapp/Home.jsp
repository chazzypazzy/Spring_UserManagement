<%@page import="com.UserDto.UserDetails"%>
<%@page import="com.org.User"%>
<%@page import="java.util.List"%>
<%@page import="com.UserDao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="component/all_css.jsp" %>
</head>
<body>
<%@include file="component/navbar.jsp" %>


<div class="container-fluid p-3">
		<p class="fs-3 text-center">All User Details</p>
		<hr>
		<table class="table">
			<thead>
				<tr>
					<th>Name</th>
					<th>Age</th>
					<th>Email</th>
				</tr>
			</thead>
			<tbody>
			
				<%
				UserDao userDao = new UserDao();
				List<UserDetails> listuser = userDao.fetchAllUser();
				UserDetails user = (UserDetails)session.getAttribute("right");
				if(user!=null){
					for(UserDetails u : listuser)
				 {
					if (user.getId() == u.getId())
						continue;
				%>
				<tr>
					<td><%=u.getName()%></td>
					<td><%=u.getAge()%></td>
					<td><%=u.getEmail()%></td>
				</tr>
				<%
				}}
				else
				{					
					response.sendRedirect("login.jsp");
				}
				%>
			</tbody>
		</table>
	</div>
	<center>
	<form action="logout" method="post">
	<input class="" type="submit" value="Logout">
	</form>
	</center>
</body>
</html>