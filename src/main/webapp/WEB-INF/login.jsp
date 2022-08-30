<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<c:url value="/webjars/bootstrap/5.1.3/css/bootstrap.min.css" context="/springbootProject" var="urlBootstrap" />
<link rel="stylesheet" href="${urlBootstrap}">

<link rel="stylesheet" href="../assets/css/style.css" type="text/css">

<title><c:out
		value='${empty param.titre?"Spring Boot Project":param.titre}' /></title>
</head>
<body>
	<main>
		<div class="container my-5">
		<c:url value="/login" context="/springbootProject" var="urlLogin"/>
			<form:form method="post" action="${urlLogin}" modelAttribute="formLogin" class="col-lg-6 p-3 shadow-sm mb-5 bg-body rounded mx-auto">
				<h2 class="bg-black p-4 rounded text-center text-light h3">Springboot Project</h2>
				<p class="bg-light p-4 rounded text-center h3">Identifiez-vous</p>
				<div class="mb-3">
					<form:label path="" for="inputEmail1" class="form-label">Email</form:label> 
					<form:input path="" type="email" class="form-control" id="inputEmail1" aria-describedby="emailHelp"/>
					<div id="emailHelp" class="form-text">We'll never share your
						email with anyone else.</div>
				</div>
				<div class="mb-3">
					<form:label path="" for="inputPassword1" class="form-label">Mot de passe</form:label>
					<form:input path="" type="password" class="form-control" id="inputPassword1"/>
				</div>
				<div class="d-flex justify-content-center flex-column my-4">
					<button type="submit" class="btn btn-primary mb-3">Envoyer</button>
					<p class="form-text text-center me-3">Pas de compte ?</p>
					<a role="button" class="btn btn-secondary text-center mb-3" href='<c:url value="/home/signIn" context="/springbootProject"/>'>Créer un compte</a>
					<a role="button" class="btn btn-dark text-center" href='<c:url value="/home/" context="/springbootProject"/>'>Retour à l'accueil</a>
				</div>
			</form:form>
		</div>
	</main>
<c:import url="footer.jsp" />