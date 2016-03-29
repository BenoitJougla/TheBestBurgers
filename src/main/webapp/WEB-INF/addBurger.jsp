<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<!-- Include all the css and js file -->
		<%@include file="header.jsp" %>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/toggleVisibility.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/ingredientsManager.js"></script>
		<title>Nouveau burger</title>
	</head>
	
	<body>
	
		<!-- Include of the navBar -->
		<%@include file="masterPage.jsp" %>
	
		<div class="container">
			<form id="central-form"  method="post" action="${pageContext.request.contextPath}/burger">
				<fieldset>
					<fieldset>
						<legend>Ajouter un nouveau burger</legend>
						<input id="name" name="name" class="input" type="text" placeholder="Nom" required autofocus>
						<textarea id="description" name="description" class="input" type="text" placeholder="Description" required></textarea>
						<input id="picture" name="picture" class="input" type="text" placeholder="URL de la photo" required>
					</fieldset>
					
					<fieldset>
						<legend>Ajouter les ingrédients</legend>
				
						<div id="listIngredients"></div>
						
						<input type="image" src="${pageContext.request.contextPath}/img/plus_orange.png" height="50px" width="50px" onclick = "toggle('newIngredient');"/>
					</fieldset>
					
					<button class="btn btn-lg btn-primary btn-block" type="submit">Ajouter</button>
				</fieldset>
			</form>
			
			<div id="newIngredient" style="visibility:hidden;">
				<div>
					<h1>Nouveau ingrédient</h1>
					<input id="ingredientName" name="name" type="text" placeholder="Name">
					<p><input id="ingredientPicture" name="picture" type="text" placeholder="Picture">(facultatif)</p>
					<button type="submit" onclick = "addIngredient()">Valider</button>
				</div>
			</div>
		</div>	
	</body>
</html>