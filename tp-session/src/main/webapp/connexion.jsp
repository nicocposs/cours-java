<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Page de connexion</title>
</head>
<body>

<form action="LoginServlet" method="post">
Username: <input type="text" name="login">
<br>
Password: <input type="password" name="pwd">
<br>
<input type="submit" value="Login">
</form>
<p>
<br/><a href="loginSuccess.jsp">Direct access to login page</a>
<br/><a href="checkoutPage.jsp">Direct access to checkout</a>
<br/><a href="secret.jsp">Direct access to secret page</a>
</p>
</body>
</html>