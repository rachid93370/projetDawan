<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajouter un utilisateur</title>
</head>

</html>
<h1>Ajouter un utilisateur</h1>
<c:url value="/utilisateurs/add" context="/projet1" var="urlform" />
<form:form method="post" action="${urlform}" modelAttribute="formuser">
	<div class="mb-2">
		<form:label path="prenom" class="form-label">Prénom</form:label>
		<form:input path="prenom" placeholder="prénom" type="text"
			class="form-control" />
		<form:errors path="prenom" class="text-danger small" />
		<h3></h3>
	</div>
	<div class="mb-2">
		<form:label path="nom" class="form-label">Nom</form:label>
		<form:input path="nom" placeholder="nom" type="text"
			class="form-control" />
		<form:errors path="nom" class="text-danger small" />
		<h3></h3>
	</div>
	<div class="mb-2">
		<form:label path="email" class="form-label">Email</form:label>
		<form:input path="email" placeholder="email" type="email"
			class="form-control" />
		<form:errors path="email" class="text-danger small" />
		<h3></h3>
	</div>
	<div class="mb-2">
		<form:label path="telephone" class="form-label">Téléphone</form:label>
		<form:input path="telephone" placeholder="téléphone" type="text"
			class="form-control" />
		<form:errors path="telephone" class="text-danger small" />
		<h3></h3>
	</div>
	<div class="mb-2">
		<form:label path="motPasse" class="form-label">Mot de passe</form:label>
		<form:input path="motPasse" placeholder="mot de passe" type="motPasse"
			class="form-control" />
		<form:errors path="motPasse" class="text-danger small" />
		<h3></h3>
	</div>
	<div class="mb-2">
		<form:label path="dateNaissance" class="form-label">Date de naissance</form:label>
		<form:errors path="motPasse" class="text-danger small" />
		<select name="date_naissance_jour">
			<c:forEach var="i" begin="1" end="31" step="1">
				<option value="${i}">${i}</option>
			</c:forEach>
		</select> <select name="date_naissance_mois">
			<c:forEach var="i" begin="1" end="12" step="1">
				<option value="${i}">${i}</option>
			</c:forEach>
		</select> <select name="date_naissance_annee">
			<c:forEach var="i" begin="1900" end="2022" step="1">
				<option value="${i}">${i}</option>
			</c:forEach>
		</select>
	</div>
	<h3></h3>
	<input class="btn btn-primary" type="submit" value="Ajouter" />
</form:form>