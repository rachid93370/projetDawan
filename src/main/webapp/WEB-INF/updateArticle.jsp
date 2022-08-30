<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<c:url value="/webjars/bootstrap/5.1.3/css/bootstrap.min.css" context="/springbootProject" var="urlBootstrap" />
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet" href="${urlBootstrap}">

<link rel="stylesheet" href="../assets/css/style.css" type="text/css">

<title><c:out
		value='${empty param.titre?"Spring Boot Project":param.titre}' /></title>
</head>
<body>
	<main>
		<div class="container my-5">
		<c:url value="/admin/updateArticle" context="/springbootProject" var="urlform"/>
			<form:form method="post" action="${urlform}" modelAttribute="formArticle" class="col-md-5 p-5 shadow-sm mb-5 bg-body rounded mx-auto">
				<h1 class="bg-black p-4 rounded text-center text-light h3">Springboot Project</h1>
				<p class="bg-light p-4 rounded text-center h3">Modifiez un article</p>
				<div class="mb-3">
					<form:label path="" for="inputName" class="form-label">Nom</form:label> 
					<form:input path="" type="text" class="form-control" id="inputName" value=""/>
				</div>
				<div class="mb-3">
					<form:label path="" for="inputDescription" class="form-label">Description</form:label> 
					<form:input path="" type="text" class="form-control" id="inputDescription" value=""/>
				</div>
				<div class="mb-3">
					<form:label path="" for="inputPrice" class="form-label">Prix</form:label> 
					<form:input path="" type="number" class="form-control" id="inputPrice" value="1200.00"/>
				</div>
				<div class="mb-3">
					<form:label path="" for="inputImage" class="form-label">Image</form:label> 
					<form:input path="" type="file" class="form-control" id="inputImage" value=""/>
				</div>
				<div class="mb-3">
					<form:label class="form-label" path="">Catégories </form:label>
					<form:select class="form-select" path="">
					  <form:option value="JeuxVideo">Jeux Vidéo</form:option>
					  <form:option value="Consoles">Consoles</form:option>
					  <form:option value="Accessoires">Accessoires</form:option>
					</form:select>
				</div>				
				<div class="mb-3">
					<form:label path="" for="inputMarque" class="form-label">Marque</form:label> 
					<form:input path="" type="text" class="form-control" id="inputMarque" value=""/>
				</div>
				<div class="mb-3">
					<form:label path="" for="inputQuantity" class="form-label">Quantité</form:label> 
					<form:input path="" type="number" class="form-control" id="inputQuantity" value=""/>
				</div>
				<div class="d-flex justify-content-center flex-column my-4">
					<button type="submit" class="btn btn-primary mb-3">Envoyer les modifications</button>
					<a role="button" class="btn btn-secondary text-center" href='<c:url value="/home/" context="/springbootProject"/>'>Retour à l'accueil</a>
				</div>			
			</form:form>
		</div>
	</main>
<c:import url="footer.jsp" />