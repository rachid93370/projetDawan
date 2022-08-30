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
		<c:url value="/admin/addArticle" context="/springbootProject" var="urlform"/>
			<form:form method="post" action="${urlform}" modelAttribute="formArticle" class="col-md-5 p-5 shadow-sm mb-5 bg-body rounded mx-auto">
				<h1 class="bg-black p-4 rounded text-center text-light h3">Springboot Project</h1>
				<p class="bg-light p-4 rounded text-center h3">Ajoutez un article</p>
				<div class="mb-3">
					<form:label path="nom" for="inputName" class="form-label">Nom</form:label> 
					<form:input path="nom" type="text" class="form-control" id="inputName"/>
					<form:errors path="nom" class="text-danger small" />
				</div>
				<div class="mb-3">
					<form:label path="description" for="inputDescription" class="form-label">Description</form:label> 
					<form:input path="description" type="text" class="form-control" id="inputDescription"/>
					<form:errors path="nom" class="text-danger small" />
				</div>
				<div class="mb-3">
					<form:label path="prix" for="inputPrice" class="form-label">Prix</form:label> 
					<form:input path="prix" type="number" class="form-control" id="inputPrice"/>
					<form:errors path="prix" class="text-danger small" />
				</div>
				<div class="mb-3">
					<form:label path="photo" for="inputImage" class="form-label">Image</form:label> 
					<form:input path="photo" type="file" class="form-control" id="inputImage"/>
					<form:errors path="photo" class="text-danger small" />
				</div>
				<div class="mb-3">
					<form:label class="form-label" path="categorie">Catégories </form:label>
					<form:select class="form-select" path="">
					  <form:option value="JeuxVideo">Jeux Vidéo</form:option>
					  <form:option value="Consoles">Consoles</form:option>
					  <form:option value="Accessoires">Accessoires</form:option>
					</form:select>
				</div>				
				<div class="mb-3">
					<form:label path="marque" for="inputMarque" class="form-label">Marque</form:label> 
					<form:input path="marque" type="text" class="form-control" id="inputMarque"/>
					<form:errors path="marque" class="text-danger small" />
				</div>
				<div class="mb-3">
					<form:label path="quantite" for="inputQuantity" class="form-label">Quantité</form:label> 
					<form:input path="quantite" type="number" class="form-control" id="inputQuantity"/>
					<form:errors path="quantite" class="text-danger small" />
				</div>
				<div class="d-flex justify-content-center flex-column my-4">
					<button type="submit" class="btn btn-primary mb-3">Envoyer</button>
					<a role="button" class="btn btn-secondary text-center" href='<c:url value="/home/" context="/springbootProject"/>'>Retour à l'accueil</a>
				</div>			
			</form:form>
		</div>
	</main>
<c:import url="footer.jsp" />