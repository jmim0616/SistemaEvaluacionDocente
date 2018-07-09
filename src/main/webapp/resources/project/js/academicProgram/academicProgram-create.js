$(document).ready(function() {

	$('.createAcademicProgram #buttonCancel').click(function(event) {

		event.preventDefault();

		$('.createAcademicProgram .modalContainer').show().fadeOut('slow');

	});

	$('.createAcademicProgram #closeModal').click(function(event) {

		event.preventDefault();

		$('.createAcademicProgram .modalContainer').show().fadeOut('slow');

	});

	$('#buttonCreateAcademicProgram').click(function(event) {

		event.preventDefault();

		ajaxCreateAcademicProgram();

	});

	$('.success .close').click(function(event) {

		event.preventDefault();

		$('.success').show().fadeOut('slow');

	});

});

function ajaxCreateAcademicProgram() {

	$('#nameCreateError').text('');
	
	var faculty = $('#facultyCreate option:selected').val();
	var name = $('#nameCreate').val();

	var json = {
		"faculty" : faculty,
		"name" : name
	}

	console.log(json);

	$.ajax({
		url : "./AcademicPrograms/Create",
		data : JSON.stringify(json),
		contentType : "application/json",
		method : "POST",
		done : function() {

		},
		success : function(jsonResponse) {

			if (typeof jsonResponse == "string") {

				$('.content').fadeOut(0).html(jsonResponse).fadeIn('slow');

				$('.error').show().fadeIn('slow');
			}

			console.log(jsonResponse);

			if (jsonResponse.isValid) {

				$('#nameCreate').val('');

				$('.success .message').text(jsonResponse.successMessage);

				$('.success').show().fadeIn('slow');

				$('.createAcademicProgram .modalContainer').show().fadeOut('slow');
				
				$.get('./AcademicPrograms/Data', function(view, status, xhr){
					  $('.content').fadeOut(0).html(view).fadeIn('slow');
					}).done(function() {
						ajaxSearchAcademicProgram();
					  });

			} else {

				$.each(jsonResponse.errorMessages, function(key, value) {

					$("#" + key + "CreateError").text(value);

				})

			}
		},
		error : function() {

		}

	});

}
