<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calendrier Gif</title>
<link href="css/style.css" rel="stylesheet">
</head>
<body>
<h1>Calendrier Gif</h1>
<c:if test="${param.notification ne null}"><h2>${param.notification}</h2></c:if>
<form action="connexion" method="post">
	<input type="email" name="EMAIL" placeHolder="Email" required><br>
	<input type="password" name="MOT_DE_PASSE" placeHolder="Mot de Passe" required><br>
	<input type="submit" value="Connexion">
</form>
<a href="inscription">S'inscrire</a>
<p><a href="/emotions">Gestion des émotions</a></p>
<p><a href="/h2-console">Console H2</a></p>
<jsp:useBean id="dateFin" class="java.util.Date"/>
<c:set var="msFin" value="${dateFin.getTime()}" scope="page" />
<p>Page générée en ${msFin - msDepart} ms</p>
</body>
</html>