$(document).ready(function() {

	$('.updateDisciplinaryArea #buttonCancel').click(function(event) {

		event.preventDefault();
		
		$('.updateDisciplinaryArea .modalContainer').show().fadeOut('slow');

	});
	
	$('.updateDisciplinaryArea #closeModal').click(function(event) {

		event.preventDefault();
		
		$('.updateDisciplinaryArea .modalContainer').show().fadeOut('slow');

	});
	
	
	$('#buttonUpdateDisciplinaryArea').click(function(event) {

		event.preventDefault();
		
		ajaxUpdateDisciplinaryArea();

	});

	$('.success .close').click(function (event){
		
		event.preventDefault();
		
		$('.success').show().fadeOut('slow');
		
	}); 
	
	$('.error .close').click(function(event) {

		event.preventDefault();

		$('.error').show().fadeOut('slow');

	});
	
});



function ajaxUpdateDisciplinaryArea() {
	
	$('#nameUpdateError').text('');
	
	var disciplinaryAreaId = $('#disciplinaryAreaIdUpdate').val();
	var department = $('#departmentUpdate option:selected').text();
	var name = $('#nameUpdate').val();
	
	var json = {
			"disciplinaryAreaId": disciplinaryAreaId,
			"department": department,
			"name": name
			}
	
	console.log(json);
	
	$.ajax({
		url: "./DisciplinaryAreas/Update",
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
					
					$('.updateDisciplinaryArea .modalContainer').show().fadeOut('slow');

				} else {
				
				$('#nameUpdate').val('');

				$('.success .message').text(jsonResponse.successMessage);

				$('.success').show().fadeIn('slow');

				$('.updateDisciplinaryArea .modalContainer').show().fadeOut('slow');
				
				$.get('./DisciplinaryAreas/Data', function(view, status, xhr){
					  $('.content').fadeOut(0).html(view).fadeIn('slow');
					}).done(function() {
						ajaxSearchDisciplinaryArea();
					  });

				}
				
			} else {

				$.each(jsonResponse.errorMessages, function(key,value) {
					
					$("#"+key+"UpdateError").text(value);
					
				})

			}
			
		},
		error: function(){
			
			
		}
		
	});
	
	
	
}






