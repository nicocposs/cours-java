<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Réagir à un Gif</title>
<link href="/css/${sessionScope.utilisateur.theme.nom.toLowerCase()}.css" rel="stylesheet">
</head>
<body>
<h1>Réagir au gif de ${gif.utilisateur.prenom}</h1>
<c:if test="${gif.getClass().simpleName eq 'GifDistant'}">
<img src="${gif.url}" height="200">
</c:if>
<c:if test="${gif.getClass().simpleName eq 'GifTeleverse'}">
<img src="/images/${gif.id}.gif" height="200">
</c:if>
<form action="reagir" method="post">
<input type="hidden" name="ID_GIF" value="${gif.id}">
<select name="ID_EMOTION" required>
<option value="">Merci de choisir une émotion</option>
<c:forEach items="${emotions}" var="emotion">
	<option value="${emotion.id}">${emotion.nom}</option>
</c:forEach>
</select>
<input type="submit" value="Réagir">
</form>
</body>
</html>