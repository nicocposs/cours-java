<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Hi ${user.login }, do the checkout.
	
	<form action="LogoutServlet" method="POST">
		<input type="submit" value="Logout" name="conf"/>
	</form>
</body>
</html>