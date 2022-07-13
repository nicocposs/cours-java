<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Téléverser un gif</title>
<link href="/css/${sessionScope.utilisateur.theme.nom.toLowerCase()}.css" rel="stylesheet">
</head>
<body>
<h1>Téléverser un gif</h1>
<form action="televerserGif?ID_JOUR=${idJour}" method="post" enctype="multipart/form-data">
    <label>Fichier à téléverser</label><input type="file" name="FICHIER" accept="image/gif" /><br>
    <label>Légende</label><input type="text" name="LEGENDE">
    <input type="submit" value="Envoyer" />
</form>
</body>
</html>