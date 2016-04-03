function addGrade(idBurger) {
	var originalityNote  = $('#gradeBurger').find('#originality').find('input:checked').val();
	var qualityNote		 = $('#gradeBurger').find('#quality').find('input:checked').val();
	var presentationNote = $('#gradeBurger').find('#presentation').find('input:checked').val();
	var tastyNote		 = $('#gradeBurger').find('#tasty').find('input:checked').val();
	var observation		 = $('#gradeBurger').find('#gradeDescription').val();
	
	var data = {
		burgerId		: idBurger,
		originality		: originalityNote,
		quality			: qualityNote,
		presentation	: presentationNote,
		tasty	 		: tastyNote,
		observation		: observation
	};
	
	var success_fct = function(data, status) {
		console.log("success")
	};
	
	var error_fct = function(jqXHR, textStatus, errorThrown) { 	
		console.log("Error");
	};
	
	$.ajax({
		url : 'add/grade',
		type : 'POST',
		data : data, 
		success : success_fct,
	    error : error_fct
	});
}