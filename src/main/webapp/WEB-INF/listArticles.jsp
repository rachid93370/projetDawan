<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="header.jsp">
	<c:param name="titre" value="home" />
</c:import>
<main>
	<div class="container-fluid row">
		<div class="card col-md-8 mx-auto p-3 mt-5">
			<h2 class="text-center mb-5 bg-dark rounded text-light p-3">Liste
				des articles</h2>
			<table class="table">
				<thead>
					<tr>
						<!-- 						<th>Id</th> -->
						<th>Nom</th>
						<th>Description</th>
						<th>Prix</th>
						<th>Photo</th>
						<th>Catégorie</th>
						<th>Marque</th>
						<th>Quantité</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${article}" var="a">
						<tr>
							<%--	<td><c:out value="${a.id}" /></td> --%>
							<td><c:out value="${a.nom}" /></td>
							<td><c:out value="${a.description}" /></td>
							<td><c:out value="${a.prix}" /></td>
							<td>
							<c:if test="${not empty a.photo}">
								<img width="150" src="data:image/jpg; base64, ${a.photoBase64}"/>
							</c:if>
							</td>
							<td><c:out value="${a.categorie.nom}" /></td>
							<td><c:out value="${a.marque.nom}" /></td>
							<td><c:out value="${a.quantite}" /></td>
							<c:url value='/admin/updateArticle/${a.id}'
								context="/springbootProject" var="urlUpdate" />
							<c:url value='/admin/deleteArticle/${a.id}'
								context="/springbootProject" var="urlDelete" />
							<td><a class="btn btn-danger me-3" href="${urlUpdate}">Modifier</a>
							<a class="btn btn-danger" href="${urlDelete}">Supprimer</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<a role="button" class="btn btn-secondary text-center my-3"
				href='<c:url value="/admin/addArticle" context="/springbootProject"/>'>Ajouter
				un article</a>
		</div>
	</div>
</main>
<c:import url="footer.jsp" />