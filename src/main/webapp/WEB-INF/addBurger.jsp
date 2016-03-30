<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<!-- Include all the css and js file -->
		<%@include file="header.jsp" %>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/toggleVisibility.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/addBurger.js"></script>
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
						<legend>Ajouter les ingr�dients</legend>
				
						<div id="listIngredients"></div>
						<input id="ingredientToggleForm" class="showButton" onclick = "toggle('newIngredient', 'ingredientToggleForm', 'hideButton', 'showButton');"/>
						
						<div id="newIngredient" style="display: none">
							<h1>Nouveau ingr�dient</h1>
							<input id="ingredientName" type="text" placeholder="Name">
							<p><input id="ingredientPicture" type="text" placeholder="Picture">(facultatif)</p>
							<button onclick = "addIngredient()">Valider</button>
						</div>
					</fieldset>
					
					<fieldset>
						<legend>Choisisser un restaurant</legend>
						
						<select id="listRestaurants"></select>
						<input id='restaurantToggleForm' class="showButton" onclick = "toggle('newRestaurant', 'restaurantToggleForm', 'hideButton', 'showButton');"/>
						
						<div id="newRestaurant" style="display: none">
							<h1>Nouveau Restaurant</h1>
							<input id="restaurantName" class="input" type="text" placeholder="Nom" required autofocus>
							<p>Localisation du restaurant :</p>
							<input id="restaurantLatitude" class="input" type="text" placeholder="Latitude" required>
							<input id="restaurantLongitude" class="input" type="text" placeholder="Longitude" required>
							<button onclick="addRestaurant()">Valider</button>
						</div>
					</fieldset>
					
					<button class="btn btn-lg btn-primary btn-block" type="submit">Ajouter</button>
				</fieldset>
			</form>
		</div>	
	</body>
</html>