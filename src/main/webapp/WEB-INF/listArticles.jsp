<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="header.jsp">
	<c:param name="titre" value="home" />
</c:import>
<main>
	<div class="container-fluid row">
		<div class="card col-md-8 mx-auto p-3 mt-5">
			<c:if test="${empty articles}">
			<h2 class="text-center mb-5 bg-dark rounded text-light p-3">Liste des articles</h2>
			<div class="alert alert-danger text-center h3">Vous n'avez pas d'articles</div>
			</c:if>
			<c:if test="${!empty articles}">			
			<table class="table">
			    <thead>
			        <tr>
			        	<th>Id</th>
			        	<th>Nom</th>
			        	<th>Description</th>
			        	<th>Prix</th>
				        <th>Photo</th>
				        <th>Catégorie</th>
				        <th>Marque</th>
				        <th>Quantité</th>
				        <th>Disponible</th>
				        <th>Action</th>
			        </tr>
			    </thead>
			    <tbody>
			     <c:forEach items="${articles}" var ="ar">
				     <tr>
				        <td><c:out value="${ar.id}"/></td>
				        <td><c:out value="${ar.nom}"/></td>
				        <td><c:out value="${ar.descrition}"/></td>
				        <td><c:out value="${ar.prix}"/></td>
				        <td><c:out value="${ar.photo}"/></td>
				        <td><c:out value="${ar.categorie}"/></td>
				        <td><c:out value="${ar.marque}"/></td>
				        <td><c:out value="${ar.quantite}"/></td>      
				        <td><c:out value="${ar.disponible}"/></td>   
				        <c:url value='/admin/articles/delete/${ar.id}' context="/springmvc" var="urlDelete"/>
				        <c:url value='/admin/articles/update/${ar.id}' context="/springmvc" var="urlUpdate"/>
        				<td><a class="btn btn-danger me-3" href="${urlUpdate}">Modifier</a><a class="btn btn-danger" href="${urlDelete}">Supprimer</a></td>				           
				     </tr>
			     </c:forEach>
			    </tbody>
			</table>
			</c:if>
			<a role="button" class="btn btn-secondary text-center my-3" href='<c:url value="/admin/addArticle" context="/springbootProject"/>'>Ajouter un article</a>
		</div>
	</div>
</main>
<c:import url="footer.jsp" />