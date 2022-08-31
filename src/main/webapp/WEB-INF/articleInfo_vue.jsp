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
		<div class="card col-md-6 mx-auto mt-5">
		<h1 class="bg-black p-4 rounded text-center text-light h3 text-center">Springboot Project</h1>
			<div class="card-body bg-light">
				<h2 class="card-title text-center">Les détails de l'article</h2>
			</div>
			<ul class="list-group list-group-flush">
				<li class="list-group-item"><strong>Nom: </strong><c:out value="${articles.nom}"/></li>
				<li class="list-group-item"><strong>Description: </strong><c:out value="${articles.description}"/></li>
				<li class="list-group-item"><strong>Prix: </strong><c:out value="${articles.prix}"/></li>
				<li class="list-group-item"><strong>Promotion: </strong>
				<c:if test="${articles.promo == 0.0 || empty articles.promo }">Pas de promotion sur cet article</c:if>
				<c:if test="${articles.promo != 0.0}"><c:out value="${articles.promo}"></c:out></c:if>
				</li>
				<li class="list-group-item"><strong>Catégorie: </strong><c:out value="${articles.categories.nom}"/></li>	
				<li class="list-group-item"><strong>Marque: </strong><c:out value="${articles.marques.nom}"/></li>	
				<li class="list-group-item"><strong>Photo: </strong><img src="data:image/jpg; base64,${articles.photo}"/></li>	
				<li class="list-group-item"><strong>Avis: </strong><c:out value="${articles.avis.size()}"/> avis sur cet article</li>	
				<li class="list-group-item"><strong>Quantité: </strong><c:out value="${articles.quantite}"/></li>	
			</ul>
			<div class="card-body">
				<a href='<c:url value="/categories/${articles.categories.id}" context="/springbootProject"/>' class="btn btn-primary mb-2">Retour à la liste</a> 
				<a href='<c:url value="/home/" context="/springbootProject"/>' class="btn btn-secondary mb-2">Retour à l'accueil</a>
			</div>
		</div>
	</div>
</main>
<c:import url="footer.jsp" />