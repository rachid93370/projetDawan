<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<c:url value="/webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	context="/springbootProject" var="urlBootstrap" />
<link rel="stylesheet" href="${urlBootstrap}">

<link rel="stylesheet" href="../assets/css/style.css" type="text/css">

<title><c:out
		value='${empty param.titre?"Spring Boot Project":param.titre}' /></title>
</head>
<body>
	<main>
		<div class="container-fluid row">
			<div class="card col-md-6 mx-auto mt-5">
				<h1 class="bg-black p-4 rounded text-center text-light h3 text-center">Springboot Project</h1>
				<div class="card-body bg-light">
					<h2 class="card-title text-center">Vos Informations</h2>
				</div>
				<ul class="list-group list-group-flush">
					<li class="list-group-item"><strong>Nom: </strong>${isConnected.nom }</li>
					<li class="list-group-item"><strong>Prénom: </strong>${isConnected.prenom }</li>
					<li class="list-group-item"><strong>Email: </strong>${isConnected.email }</li>
					<li class="list-group-item"><strong>Adresse de facturation: </strong>
						<ul class="list-group list-group-numbered">
							<c:forEach items="${isConnected.adresseFacturation}" var="af">
								<li class="list-group-item"><c:out value='${af.numero} ${af.rue} ${af.codePostal} ${af.ville}' />
									<a class="btn btn-sm btn-primary float-end" href='<c:url value="/adresse/updateF/'<c:out value='${al.numero} ${al.rue} ${al.codePostal} ${al.ville}'/>'>Mofifier</a></li>
			    			 </c:forEach>
			   			</ul>
			    	</li>
			    	<li class="list-group-item">		    		
			    		<strong>Adresse de livraison: </strong>
			    		<ul class="list-group list-group-numbered">
			    		<c:forEach items="${isConnected.adresseLivraison}" var ="al">
			    			<li class="list-group-item"><c:out value='${al.numero} ${al.rue} ${al.codePostal} ${al.ville}'/> <a class="btn btn-sm btn-primary float-end"/>'>Modifier</a></li>
			    		</c:forEach>
			   			</ul>
			    	</li>	
				<li class="list-group-item"><strong>Téléphone: </strong>${isConnected.telephone }</li>	
			</ul>
			<div class="card-body">
				<a href='<c:url value="/user/update" context="/springbootProject"/>' class="btn btn-primary mb-2">Modifier mes informations</a> 
				<a href="#" class="btn btn-danger mb-2">Supprimer mon compte</a>
				<a href='<c:url value="/home/" context="/springbootProject"/>' class="btn btn-secondary mb-2">Retour à l'accueil</a>
			</div>
		</div>
	</div>
</main>
<c:import url="footer.jsp" />