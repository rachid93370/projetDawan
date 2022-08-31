<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="header.jsp">
	<c:param name="titre" value="home" />
	
</c:import>
<c:url value="/webjars/bootstrap/5.1.3/css/bootstrap.min.css" context="/springbootProject" var="urlBootstrap" />
<link rel="stylesheet" href="${urlBootstrap}">

<link rel="stylesheet" href="../assets/css/style.css" type="text/css">
<main>
	<div class="container-fluid row">
		<div class="card col-md-8 mx-auto p-3 mt-5">
			<c:if test="${empty article}">
			<h2 class="text-center mb-5 bg-dark rounded text-light p-3">Liste des articles</h2>
			<div class="alert alert-danger text-center h3">Vous n'avez pas d'articles</div>
			</c:if>
			<c:if test="${!empty article}">			
			<table class="table">
			    <thead>
			        <tr>
<!-- 			        	<th>Id</th> -->
			        	<th>Nom</th>
			        	<th>Description</th>
			        	<th>Prix</th>
			        	<th>Promo</th>
				        <th>Photo</th>
				        <th>Catégorie</th>
				        <th>Marque</th>
				        <th>Quantité</th>
				        <th>Action</th>
			        </tr>
			    </thead>
			    <tbody>
			     <c:forEach items="${article}" var ="ar">
				     <tr>
<%-- 				        <td><c:out value="${ar.id}"/></td> --%>
				        <td><c:out value="${ar.nom}"/></td>
				        <td><c:out value="${ar.description}"/></td>
				        <td><c:out value="${ar.prix}"/></td>
				        <td>
				        <c:if test="${ar.promo != \"0.0\" }">
				        
				        <c:out value="${ar.promo}"/>
				        </c:if>
				        </td>
				        <td><c:out value="${ar.photo}"/></td>
				        <td><c:out value="${ar.categorie.nom}"/></td>
				        <td><c:out value="${ar.marque.nom}"/></td>
				        <td><c:out value="${ar.quantite}"/></td>      
				        <c:url value='/articles/${ar.id}' context="/springbootProject" var="urlAfficher"/>
        				<td><a class="btn btn-primary" href="${urlAfficher}">Voir</a></td>				           
				     </tr>
			     </c:forEach>
			    </tbody>
			</table>
			</c:if>
		</div>
	</div>
</main>
<c:import url="footer.jsp" />