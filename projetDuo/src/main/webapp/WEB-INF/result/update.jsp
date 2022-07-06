<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<h1>Editer le conseiller ${conseiller.id}</h1><br>
<form action="ServletUpdate" method="post">
        <label for="nom">Nom : </label> <input type="text" name="nom" value="${conseiller.name}"> <br><br>
        <label for="prenom">prenom : </label> <input type="text" name="prenom" value="${conseiller.firstName}"> <br><br>
        <label for="salaire">Salaire : </label> <input type="number" min="1000" max="10000" step="50" name="salaire" value="${conseiller.salary}"> <br><br>
        <label for="dateDeNaissance">Date de naissance</label> <input type="date" name="dateDeNaissance" value="${conseiller.DOB}"> <br><br>
		<input type="number" value="${conseiller.id}" hidden name="id">

<input type="submit"
    value="Modifier le conseiller">
</form>


</body>
</html>