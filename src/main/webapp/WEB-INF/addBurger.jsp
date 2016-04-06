<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
			<div id="central-form">
				<fieldset>
					<fieldset>
						<legend>Ajouter un nouveau burger</legend>
						<input id="burgerName" class="input" type="text" placeholder="Nom" required autofocus>
						<label id="burgerNameError" class="labelError"></label>
						
						<textarea id="burgerDescription" class="input" type="text" placeholder="Description" required></textarea>
						<label id="burgerDescriptionError" class="labelError"></label>
						
						<input id="burgerPicture" class="input" type="text" placeholder="URL de la photo" required>
						<label id="burgerPictureError" class="labelError"></label>
					</fieldset>
					
					<fieldset>
						<legend>Ajouter les ingrédients</legend>
				
						<div id="listIngredients"></div>
						<input id="ingredientToggleForm" class="showButton" onclick = "toggle('newIngredient', 'ingredientToggleForm', 'hideButton', 'showButton');"/>
						
						<div id="newIngredient" style="display: none">
							<h1>Nouveau ingrédient</h1>
							<input id="ingredientName" type="text" placeholder="Name">
							<label id="ingredientNameError" class="labelError"></label>
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
					
					<fieldset>
						<legend>Noter le burger</legend>
						
						<jsp:include page="gradePage.jsp">
							<jsp:param name="idOriginality" value="originality"/>
							<jsp:param name="idQuality" value="quality"/>
							<jsp:param name="idPresentation" value="presentation"/>							
							<jsp:param name="idTasty" value="tasty"/>
						</jsp:include>
						
						<textarea id="gradeDescription" type="text"  class="input" placeholder="Observation"></textarea>
						<label id="gradeDescriptionError" class="labelError"></label>
					</fieldset>
					
					<button class="btn-primary" onclick="addBurger()">Ajouter</button>
				</fieldset>
			</div>
		</div>	
	</body>
</html>