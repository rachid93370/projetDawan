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
			<div class="card-body bg-danger">
				<h3 class="card-title text-center text-light">Mon Panier</h3>
			</div>
			<c:choose>
    		<c:when test="${not empty panier}"> 
		    <table class="table">
		    
		        <c:forEach items="${panier}" var="basketline">
		            <tr>
		                <td><c:out value="${basketline.article.description}" /></td>
		                <td>
		                <a class="btn btn-sm btn-secondary" href="<c:url value='/basketdec/${basketline.article.id}' context='/springbootProject/articles'/>">-</a>
		                <c:out value="${basketline.quantity}" />
		                 <a class="btn btn-sm btn-secondary" href="<c:url value='/basketinc/${basketline.article.id}' context='/springbootProject/articles'/>">+</a>
		                <c:set var="total" value="${total= total+ basketline.article.prix * basketline.quantity} "/>
		                </td>
		                <td><p><c:out value="${basketline.article.prix * basketline.quantity}" /></p></td>
		                <td><a class="btn btn-sm btn-danger" href="<c:url value='/basketremove/${basketline.article.id}' context='/springbootProject/articles'/>">X</a></td>
		            </tr>
		        </c:forEach>
		        <tr><td></td><td class="fw-bolder">Total</td><td class="fw-bolder"><c:out value="${total}"/></td><td></td></tr>
		    </table>
		    </c:when>
		    <c:otherwise>
		       <h4 class="text-center my-5 text-secondary">Votre panier est vide.</h4>    
		    </c:otherwise>
		    </c:choose>
			<div class="card-body d-flex justify-content-center">
				<a href='<c:url value="/home/" context="/springbootProject"/>' class="btn btn-secondary mb-2">Retour à l'accueil</a>
			</div>
		</div>
	</div>
</main>
<c:import url="footer.jsp" />