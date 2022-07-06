<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>
Création d'un conseiller :
</h1>

<br><br><br>

<form action="ServletAdd" method="post">
		<label for="nom">Nom : </label> <input type="text" name="nom"> <br><br>
		<label for="prenom">prenom : </label> <input type="text" name="prenom"> <br><br>
		<label for="salaire">Salaire : </label> <input type="number" min="1000" max="10000" step="50" name="salaire"> <br><br>
		<label for="dateDeNaissance">Date de naissance</label> <input type="date" name="dateDeNaissance"> <br><br>
		

<input type="submit"
	value="Créer le conseiller">
</form>

</body>
</html>