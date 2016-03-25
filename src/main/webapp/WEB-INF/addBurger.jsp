<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<!-- Include all the css and js file -->
		<%@include file="header.jsp" %>		
		<title>Nouveau burger</title>
	</head>
	
	<body>
	
		<!-- Include of the navBar -->
		<%@include file="masterPage.jsp" %>
	
		<div class="container">
			<form id="central-form"  method="post" action="${pageContext.request.contextPath}/burger">
				<h2 class="form-signin-heading">Ajouter un nouveau burger</h2>
				<input id="name" name="name" class="input" type="text" placeholder="Nom" required autofocus>
				<textarea id="description" name="description" class="input" type="text" placeholder="Description" required></textarea>
				<input id="picture" name="picture" class="input" type="text" placeholder="URL de la photo" required>
				<button class="btn btn-lg btn-primary btn-block" type="submit">Ajouter</button>
			</form>
		</div>
		
	</body>
</html>