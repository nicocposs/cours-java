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
	<h2>${emotion.code} : ${emotion.nom}</h2>
</c:forEach>
</body>
</html>