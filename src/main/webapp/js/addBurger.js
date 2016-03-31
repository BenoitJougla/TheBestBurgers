function getRequest(requestUrl, success_fct, error_fct) {
	$.ajax({
		url : requestUrl,
		type : 'GET',
		dataType : 'json',
		success : success_fct,
		error : error_fct
	});
}

function addRequest(requestUrl, requestData, success_fct, error_fct) {
	$.ajax({
		url : requestUrl,
		type : 'POST',
		data : requestData, 
		success : success_fct,
	    error : error_fct
	});
}

/*
 * Ingredients
 */

function getIngredients() {
	console.log("getIngredients");
	
	getRequest('ingredients', 
		function(data) {
			$.each(data, function(i, item) {
				var id = item.ingredientBean.id;
				var name = item.ingredientBean.name;
				
				if( $('#ingredient_' + id).length == 0 ) {
					$('#listIngredients').append('<input id=ingredient_' + id + ' type="checkbox" name="ingredient" value="' + id + '">' + name);
				}
			});
		},
		function(jqXHR, textStatus, errorThrown) {
			alert('error ' + textStatus);
		}
	);
}

function addIngredient() {
	var data = {name : $('#ingredientName').val(),picture : $('#ingredientPicture').val()};
	var success_fct = function(data, status) { getIngredients(); };
	var error_fct = function(jqXHR, textStatus, errorThrown) { console.log(jqXHR); };
	
	addRequest('ingredients', data, success_fct, error_fct);
}

/*
 * Restaurants
 */

function getRestaurants() {
	console.log("getRestaurant");
	
	var success_fct = function(data) {
		$.each(data, function(i, item) {
			var id = item.restaurantBean.id;
			var name = item.restaurantBean.name;
			
			if( $('#restaurant_' + id).length == 0 ) {
				$('#listRestaurants').append('<option id=restaurant_' + id + ' value="' + id + '">' + name + '</option>');
			}			
		});
	}
	
	var error_fct = function(jqXHR, textStatus, errorThrown) { console.log(jqXHR); };
	
	getRequest('restaurant', success_fct, error_fct);
}

function addRestaurant() {
	var data = {
		name		: $('#restaurantName').val(), 
		latitude	: $('#restaurantLatitude').val(), 
		longitude	: $('#restaurantLongitude').val()
	};
	var success_fct = function(data, status) { getIngredients(); };
	var error_fct = function(jqXHR, textStatus, errorThrown) { console.log(jqXHR); };
	
	addRequest('restaurant', data, success_fct, error_fct);
}

/*
 * Burger
 */

function addBurger() {
	var ingredientsList = $('#listIngredients').find('input:checked');
	var ingredientsTab = [];
	$.each(ingredientsList, function(i, item) {
		ingredientsTab.push(item.value);
	});
	
	var originalityNote  = $('#originality').find('input:checked').val();
	var qualityNote		 = $('#quality').find('input:checked').val();
	var presentationNote = $('#presentation').find('input:checked').val();
	var tastyNote		 = $('#tasty').find('input:checked').val();
	
	var data = {
		name		 : $('#burgerName').val(), 
		latitude	 : $('#burgerDescription').val(), 
		longitude	 : $('#burgerPicture').val(),
		ingredients	 : ingredientsTab,
		restaurant	 : $('#listRestaurants').val(),
		originality	 : originalityNote,
		quality		 : qualityNote,
		presentation : presentationNote,
		tasty		 : tastyNote,
		observation	 : $('#gradeDescription').val()
	};
}

$(document).ready(function() {
	getIngredients();
	getRestaurants();
});