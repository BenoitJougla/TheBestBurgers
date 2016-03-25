<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<!-- Include all the css and js file -->
		<%@include file="header.jsp" %>	
		<title>Insert title here</title>
	</head>
	
	<body>
	
		<!-- Include of the navBar -->
		<%@include file="masterPage.jsp" %>
	
		<div class="container">
			<form id="central-form"  method="post" action="${pageContext.request.contextPath}/restaurant">
				<h2 class="form-signin-heading">Ajouter un nouveau Restaurant</h2>
				<input id="name" name="name" class="input" type="text" placeholder="Nom" required autofocus>
				
				<p>Localisation du restaurant :</p>
				<input id="latitude" name="latitude" class="input" type="text" placeholder="Latitude" required>
				<input id="longitude" name="longitude" class="input" type="text" placeholder="Longitude" required>
				<button class="btn btn-lg btn-primary btn-block" type="submit">Ajouter</button>
			</form>
		</div>
		
	</body>
</html>