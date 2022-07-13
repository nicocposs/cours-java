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
<h1>Emotions</h1>
<c:forEach items="${emotions}" var="emotion">
	<div><h2 style="display:inline">${emotion.code} : ${emotion.nom}</h2> <a href="supprimer?id=${emotion.id}">Supprimer</a></div>
</c:forEach>
<a href="emotion">Ajouter une émotion</a>
</body>
</html>