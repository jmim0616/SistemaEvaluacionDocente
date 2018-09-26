$(document).ready(function() {

	
	$('.createFaculty #buttonCancel').click(function(event) {

		event.preventDefault();
		
		$('.createFaculty .modalContainer').show().fadeOut('slow');

	});
	
	$('.createFaculty #closeModal').click(function(event) {

		event.preventDefault();
		
		$('.createFaculty .modalContainer').show().fadeOut('slow');

	});
	
	$('#buttonCreateFaculty').click(function(event) {

		event.preventDefault();
		
		ajaxCreateFaculty();

	});

	$('.success .close').click(function(event) {

		event.preventDefault();
		
		$('.success').show().fadeOut('slow');
		
	});
	
	$('.error .close').click(function(event) {

		event.preventDefault();

		$('.error').show().fadeOut('slow');

	});
	
});



function ajaxCreateFaculty() {
	
	$('#nameCreateError').text('');
	
	var name = $('#nameCreate').val();
	
	var json = {
			"name": name
			}
	
	console.log(json);
	
	$.ajax({
		url: "./Faculties/Create",
		data: JSON.stringify(json),
		contentType : "application/json",
		method: "POST",
		done: function(){

			
		},
		success: function(jsonResponse){
			
			if (typeof jsonResponse == "string") {
				
				$('.content').fadeOut(0).html(jsonResponse).fadeIn('slow');
				
				$('.error').show().fadeIn('slow');
			}
			
			console.log(jsonResponse);
			
			if (jsonResponse.isValid) {
				
				if (jsonResponse.errorMessage != null) {

					$('.error .message').text(jsonResponse.errorMessage);

					$('.error').show().fadeIn('slow');
					
					$('.createFaculty .modalContainer').show().fadeOut('slow');

				} else {
				
				$('#nameCreate').val('');
				
				$('.success .message').text(jsonResponse.successMessage);
				
				$('.success').show().fadeIn('slow');
				
				$('.createFaculty .modalContainer').show().fadeOut('slow');
				
				$.get('./Faculties/Data', function(view, status, xhr){
					  $('.content').fadeOut(0).html(view).fadeIn('slow');
					}).done(function() {
						  ajaxSearchFaculty();
					  });
				
				}
				
			} else {
			
			$.each(jsonResponse.errorMessages, function(key,value) {
				
				$("#"+key+"CreateError").text(value);
				
			})
			
			}
			
		},
		error: function(){
			
			
		}
		
	});
	
	
	
}






