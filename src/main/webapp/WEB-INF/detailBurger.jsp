<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<!-- Include all the css and js file -->
		<%@include file="header.jsp" %>
		
		<title>The Best Burger</title>
	</head>
	<body>
		<%@include file="masterPage.jsp" %>
		
		<div class="container">
			<div class="jumbotron">
				<h1>${burger.name}</h1>
				<p><div class="img-container"><img class="burger-img" src="${burger.picture}" alt="burger picture"></div> ${burger.description}</p>
				<p><a class="btn btn-primary btn-lg" href="#" role="button">Commenter</a></p>
			</div>
		
		</div>
		
	
	</body>
</html>