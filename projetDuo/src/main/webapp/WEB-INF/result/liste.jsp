<%@page import="org.formation.hibernate.entity.Conseiller"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Liste des conseillers :</h1>

	<br>
	<br>
	<br>
	<br>

<table>
<c:forEach items="${list}" var="c">
    <tr>
        ID : ${c.id} - ${c.name} ${c.firstName} - <a href="ServletDisplay?id=${c.id}">Afficher</a>      -      <a href="ServletUpdate?id=${c.id}">Editer</a>    -     <a href="ServletDelete?id=${c.id}">Supprimer</a> <br>
    </tr>
</c:forEach>
</table>

</body>
</html>