<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Connecté</title>
</head>
<body>
<h1>Hi ${user.login}, your session is : ${pageContext.session.id}</h1>

	<h2>User : </h2> <b>${user.login}</b>
	
	<p>
<br/><a href="loginSuccess.jsp">Direct access to login page</a>
<br/><a href="checkoutPage.jsp">Direct access to checkout</a>
<br/><a href="secret.jsp">Direct access to secret page</a>
</p>
</body>
</html>