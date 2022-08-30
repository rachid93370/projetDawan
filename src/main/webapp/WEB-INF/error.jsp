<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<c:url value="/webjars/bootstrap/5.1.3/css/bootstrap.min.css" context="/springbootProject" var="urlBootstrap" />
<link rel="stylesheet" href="${urlBootstrap}">

<link rel="stylesheet" href="../assets/css/style.css" type="text/css">

<title><c:out value='${empty param.titre?"Spring Boot Project":param.titre}' /></title>
</head>
<body>
<main>
	<div class="container-fluid row">
		<div class="card col-md-6 mx-auto mt-5 p-5">
			<h2 class="bg-black p-4 rounded text-center text-light text-center">Springboot Project</h2>
			<div class="display-1 h1 text-danger text-center my-5 border"><c:out value="${codeErreur}"/></div>
			<div class="h2 text-center my-5"><c:out value="${msgErreur}"/></div>
		</div>
	</div>
</main>
<c:import url="footer.jsp"/>
