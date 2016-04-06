<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">		
		<!-- Include all the css and js file -->
		<%@include file="WEB-INF/header.jsp" %>		
		<title>Connexion</title>
	</head>
	
	<body>
		
		<!-- Include of the navBar -->
		<%@include file="WEB-INF/masterPage.jsp" %>
		
		<div class="container">
		
			<form id="central-form" class="form-signin" method="post" action="${pageContext.request.contextPath}/signin">
				<input type="hidden" name="from" value="${form}">
				<h2 class="form-signin-heading">Se connecter</h2>
				
				<label for="inputName" class="sr-only">Pseudonyme</label>
				<input type="text" id="inputName" name="firstName" class="form-control" placeholder="Pseudonyme" required autofocus>
				
				<button class="btn btn-lg btn-primary btn-block" type="submit">Connection</button>
			</form>
		
		</div>
		
	</body>
</html>