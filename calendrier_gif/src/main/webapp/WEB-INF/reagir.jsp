<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Réagir à un Gif</title>
<link
    href="/css/${sessionScope.utilisateur.theme.nom.toLowerCase()}.css"
    rel="stylesheet">
</head>
<body>
    <h1>Réagir au gif de ${gif.utilisateur.prenom}</h1>
    <c:if test="${gif.getClass().simpleName eq 'GifDistant'}">
        <img src="${gif.url}" height="200">
    </c:if>
    <c:if test="${gif.getClass().simpleName eq 'GifTeleverse'}">
        <img src="/images/${gif.nomFichierOriginal}" height="200">
    </c:if>
    <!-- <form action="reagir" method="post"> -->
    <%-- <input type="hidden" name="ID_GIF" value="${gif.id}"> --%>
    <!-- <select name="ID_EMOTION" required> -->
    <!-- <option value="">Merci de choisir une émotion</option> -->
    <%-- <c:forEach items="${emotions}" var="emotion"> --%>
    <%--     <option value="${emotion.id}">${emotion.nom}</option> --%>
    <%-- </c:forEach> --%>

    <!-- </select> -->
    <!-- <input type="submit" value="Réagir"> -->
    <!-- </form> -->

    <form:form modelAttribute="reaction" action="reagir" method="post">
        <form:hidden path="gif" />
        <form:select path="emotion">
            <form:option value="">Merci de choisir une émotion</form:option>
            <c:forEach items="${emotions}" var="emotion">
                <option value="${emotion.id}">${emotion.nom}</option>
            </c:forEach>
        </form:select>
        <form:errors path= "emotion" cssClass= "erreur"></form:errors>
        <form:button>Réagir</form:button>
    </form:form>

</body>
</html>