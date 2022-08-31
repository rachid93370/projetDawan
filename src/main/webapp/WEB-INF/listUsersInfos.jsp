<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="header.jsp">
	<c:param name="titre" value="home" />
</c:import>
<main>
	<div class="container-fluid row">
		<div class="card  mx-auto p-5 mt-5">
			<h2 class="text-center mb-5 bg-dark rounded text-light p-3">Liste
				des utilisateurs</h2>
			<c:if test="${empty users}">
				<div class="alert alert-danger text-center h3">Vous n'avez pas
					d'utilisateurs</div>
			</c:if>
			<c:if test="${!empty users}">
				<table class="table">
					<thead>
						<tr>
							<!-- 			        	<th>Id</th> -->
							<th>Nom</th>
							<th>Prénom</th>
							<th>Email</th>
							<th>Adresse de facturation</th>
							<th>Adresse de livraison</th>
							<th>Téléphone</th>
							<th>Date de naissance</th>
							<th>Date d'inscription</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${users}" var="u">
							<tr>
								<%-- 			        <td><c:out value="${u.id}"/></td> --%>
								<td><c:out value="${u.nom}" /></td>
								<td><c:out value="${u.prenom}" /></td>
								<td><c:out value="${u.email}" /></td>
								<td>
									<ul class="list-group">
										<c:forEach items="${u.adresseFacturation}" var="af">
											<li class="list-group-item"><c:out
													value='${af.numero} ${af.rue} ${af.codePostal} ${af.ville}' /></li>
										</c:forEach>
									</ul>
								</td>
								<td>
									<ul class="list-group">
										<c:forEach items="${u.adresseLivraison}" var="al">
											<li class="list-group-item"><c:out
													value='${al.numero} ${al.rue} ${al.codePostal} ${al.ville}' /></li>
										</c:forEach>
									</ul>
								</td>
								<td><c:out value="${u.telephone}" /></td>
								<td><c:out value="${u.dateNaissance}" /></td>
								<td><c:out value="${u.dateInscription}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
			<a role="button" class="btn btn-dark text-center mt-4"
				href='<c:url value="/home/" context="/springbootProject"/>'>Retour
				à l'accueil</a>
		</div>
	</div>
</main>
<c:import url="footer.jsp" />