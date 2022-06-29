<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="scopeVarPage" value="Page Value" scope="page" />

<c:set var="scopeVarRequest" value="Request Value" scope="request" />

<c:set var="scopeVarSession" value="Session Value" scope="session" />

<c:set var="scopeVarApplication" value="Application Value"
	scope="application" />

<html>
<head>
<title>Scope Example</title>

<style>
tr:nth-child(even) {
	background: #aaaaaa;
}
</style>

</head>

<body>
	<h3>Main File: index.jsp</h3>

	<table>
		<tr>
			<th>Scoped Variable </th>

			<th>Current Value</th>
		</tr>

		<tr>
			<td><b>Page Scope</b> (scopeVarPage)</td>

			<td>${scopeVarPage}</td>
		</tr>

		<tr>
			<td><b>Request Scope</b> (scopeVarRequest)</td>

			<td>${scopeVarRequest}</td>
		</tr>

		<tr>
			<td><b>Session Scope</b> (scopeVarSession)</td>

			<td>${scopeVarSession}</td>
		</tr>

		<tr>
			<td><b>Application Scope</b> (applicationVarPage)</td>

			<td>${scopeVarApplication}</td>
		</tr>
	</table>

<!-- Inclue Ã©galement les variable de la page -->
<%-- 	<%@include file="included.jsp" %> --%>

	<jsp:include page="included.jsp" />

	<br />

	<br />

	<a href="linked.jsp">Go to linked page</a>
</body>
</html>