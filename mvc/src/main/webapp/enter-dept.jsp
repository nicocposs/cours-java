<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Recherche</title>
</head>
<body>
	<h1>Recherche de département</h1>
	<fieldset>
		<legend>Recherche de département</legend>
		<center>
			<form action="showDept" method="GET">
				<input type="text" placeholder="Entrez un numéro de département"
					name="dept" /><br /> <input type="submit" value="Envoyer" />
			</form>
		</center>
	</fieldset>
</body>
</html>