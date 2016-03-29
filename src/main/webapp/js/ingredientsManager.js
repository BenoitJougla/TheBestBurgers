function getIngredients() {
	console.log("getIngredients");
	$.ajax({
		url : 'ingredients',
		type : 'GET',
		dataType : 'json',
		success : function(data) {
			$.each(data, function(i, item) {
				var id = item.ingredientBean.id;
				var name = item.ingredientBean.name;
				
				if( $('#ingredient_' + id).length == 0 ) {
					$('#listIngredients').append('<input id=ingredient_' + id + ' type="checkbox" name="ingredient" value="' + id + '">' + name);
				}				
				
			    console.log(item);
			});
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert('error ' + textStatus);
		}
	});
}

function addIngredient() {
	$.ajax({
		url : 'ingredients',
		type : 'POST',
		data : {
			name : $('#ingredientName').val(),
			picture : $('#ingredientPicture').val()
		}, 
		success : function(data, status) {
	        getIngredients();
	    },
	    error : function(jqXHR, textStatus, errorThrown) {
			alert('error ' + errorThrown + ' ' + jqXHR);
		}
	});
}

$(document).ready(function() {
	setInterval(getIngredients(), 1000);
});
