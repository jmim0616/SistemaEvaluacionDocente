$(document).ready(function() {

	$('#buttonCancel').click(function(event) {

		event.preventDefault();
		
		$('.modalContainer').show().fadeOut('slow');

	});
	
	$('#closeModal').click(function(event) {

		event.preventDefault();
		
		$('.modalContainer').show().fadeOut('slow');

	});
	
	
	$('#buttonUpdateAcademicProgram').click(function(event) {

		event.preventDefault();
		
		ajaxUpdateAcademicProgram();

	});

	$('.success .close').click(function (event){
		
		event.preventDefault();
		
		$('.success').show().fadeOut('slow');
		
	}); 
	
});



function ajaxUpdateAcademicProgram() {
	
	$('#nameUpdateError').text('');
	
	var academicProgramId = $('#academicProgramIdUpdate').val();
	var faculty = $('#facultyUpdate option:selected').text();
	var name = $('#nameUpdate').val();
	
	var json = {
			"academicProgramId": academicProgramId,
			"faculty": faculty,
			"name": name
			}
	
	console.log(json);
	
	$.ajax({
		url: "./AcademicPrograms/Update",
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

				$('#nameUpdate').val('');

				$('.success .message').text(jsonResponse.successMessage);

				$('.success').show().fadeIn('slow');

				$('.modalContainer').show().fadeOut('slow');

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






