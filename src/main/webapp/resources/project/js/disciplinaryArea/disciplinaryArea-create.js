$(document).ready(function() {

	$('#buttonCreateDisciplinaryArea').click(function(event) {

		event.preventDefault();
		
		ajaxCreateDisciplinaryArea();

	});
	
	
	$('.createDisciplinaryArea #buttonCancel').click(function(event) {

		event.preventDefault();
		
		$('.createDisciplinaryArea .modalContainer').show().fadeOut('slow');

	});
	
	$('.createDisciplinaryArea #closeModal').click(function(event) {

		event.preventDefault();
		
		$('.createDisciplinaryArea .modalContainer').show().fadeOut('slow');

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



function ajaxCreateDisciplinaryArea() {
	
	$('#nameCreateError').text('');
	
	var department = $('#departmentCreate option:selected').val();
	var name = $('#nameCreate').val();
	
	var json = {
			"department": department,
			"name": name
			}
	
	console.log(json);
	
	$.ajax({
		url: "./DisciplinaryAreas/Create",
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
					
					$('.createDisciplinaryArea .modalContainer').show().fadeOut('slow');

				} else {
				
				$('#nameCreate').val('');

				$('.success .message').text(jsonResponse.successMessage);

				$('.success').show().fadeIn('slow');
				
				$.get('./DisciplinaryAreas/Data', function(view, status, xhr){
					  $('.content').fadeOut(0).html(view).fadeIn('slow');
					}).done(function() {
						ajaxSearchDisciplinaryArea();
					  });

			}
			
			} else {

				$.each(jsonResponse.errorMessages, function(key, value) {

					$("#" + key + "CreateError").text(value);

				})

			}
			
		},
		error: function(){
			
			
		}
		
	});
	
	
	
}






