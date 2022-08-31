<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
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
	<nav class="navbar navbar-expand-lg">
		<div class="container-fluid">
			<a class="navbar-brand bg-dark p-4 rounded text-light h1" href='<c:url value="/home/" context="/springbootProject"/>'>SpringBoot Project</a>
			<a id="responsiveBasket" type="button" href='<c:url value="/articles/basket" context="/springbootProject"/>' class="btn btn-danger">Mon Panier <span class="badge text-bg-secondary">4</span>
			</a>
			<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      			<span class="navbar-toggler-icon"></span>
   			 </button>  			 
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item mx-md-3"><a class="nav-link active"
						aria-current="page" href="#">Jeux Vidéo</a></li>
					<li class="nav-item mx-md-3"><a class="nav-link" href='<c:url value="/categories/1" context="/springbootProject"/>'>Consoles</a></li>
					<li class="nav-item dropdown mx-md-3"><a
						class="nav-link dropdown-toggle" href="#" role="button"
						data-bs-toggle="dropdown" aria-expanded="false">Accessoires</a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="#">Manettes</a></li>
							<li><a class="dropdown-item" href="#">Câbles</a></li>
							<li><a class="dropdown-item" href="#">Adaptateurs</a></li>
						</ul>
					</li>
				</ul>
				<div class="d-flex flex-md-row flex-column me-md-2">
				<c:choose>
        		<c:when test="${empty sessionScope.isConnected}">				
					<a class="btn btn-outline-dark me-md-3" href='<c:url value="/login" context="/springbootProject"/>'>Se Connecter</a>
				</c:when>
        		<c:otherwise>				
					<div class="btn-group me-md-3">
					  <button type="button" class="btn btn-secondary"><c:out value="Bonjour ${isConnected.prenom}"/></button>
					  <button type="button" class="btn btn-dark dropdown-toggle dropdown-toggle-split" data-bs-toggle="dropdown" aria-expanded="false">
					    <span class="visually-hidden">Toggle Dropdown</span>
					  </button>
					  <ul class="dropdown-menu">
					    <li><a class="dropdown-item" href='<c:url value="/user/infos" context="/springbootProject"/>'>Mes informations</a></li>
					    <li><a class="dropdown-item" href="#">Mes commandes</a></li>
					    <li><a class="dropdown-item" href='<c:url value="/admin/users" context="/springbootProject"/>'>liste des utilisateurs</a></li>
					    <li><a class="dropdown-item" href='<c:url value="/admin/articles" context="/springbootProject"/>'>liste des articles</a></li>
					    <li><a class="dropdown-item" href="#">liste des commandes</a></li>
					    <li><hr class="dropdown-divider"></li>
					    <li><a class="dropdown-item" href='<c:url value="/users/logout" context="/springbootProject"/>'>Se déconnecter</a></li>
					  </ul>
					</div>
				</c:otherwise>
        		</c:choose>		
<%-- 					<a class="btn btn-outline-dark me-md-3" href='<c:url value="/login" context="/springbootProject"/>'>Se Connecter</a> --%>
					<a id="basket" type="button" href='<c:url value="/articles/basket" context="/springbootProject"/>' class="btn btn-danger text-light">
						Mon Panier <span class="badge text-bg-secondary">4</span>
					</a>
				</div>
			</div>
		</div>
	</nav>
	