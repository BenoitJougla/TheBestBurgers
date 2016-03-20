<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<!-- Bootstrap core CSS -->
		<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
		
		<title>Connexion</title>
	</head>
	
	<body>
		
		<div class="container">
		
			<form class="form-signin" method="post" action="${pageContext.request.contextPath}/signin">
				<h2 class="form-signin-heading">Se connecter</h2>
				
				<label for="inputName" class="sr-only">Pseudonyme</label>
				<input type="text" id="inputName" name="firstName" class="form-control" placeholder="Pseudonyme" required autofocus>
				
				<button class="btn btn-lg btn-primary btn-block" type="submit">Connection</button>
			</form>
		
		</div>
		
	</body>
</html>