$(document).ready(function() {

	$('#buttonCreateDepartment').click(function(event) {

		event.preventDefault();

		ajaxCreateDepartment();

	});
	
	
	$('.createDepartment  #buttonCancel').click(function(event) {

		event.preventDefault();

		$('.createDepartment  .modalContainer').show().fadeOut('slow');

	});

	$('.createDepartment  #closeModal').click(function(event) {

		event.preventDefault();

		$('.createDepartment  .modalContainer').show().fadeOut('slow');

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


function ajaxCreateDepartment() {

	$('#nameCreateError').text('');

	var faculty = $('#facultyCreate option:selected').val();
	var name = $('#nameCreate').val();

	var json = {
	    "faculty": faculty,
		"name" : name
	}

	console.log(json);

	$.ajax({
		url : "./Departments/Create",
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
				
				if (jsonResponse.errorMessage != null) {

					$('.error .message').text(jsonResponse.errorMessage);

					$('.error').show().fadeIn('slow');
					
					$('.createDepartment .modalContainer').show().fadeOut('slow');

				} else {
				
				$('#nameCreate').val('');
				
				$('.success .message').text(jsonResponse.successMessage);
				
				$('.success').show().fadeIn('slow');
				
				$.get('./Departments/Data', function(view, status, xhr){
					  $('.content').fadeOut(0).html(view).fadeIn('slow');
					}).done(function() {
						ajaxSearchDepartment();
					  });

			}
				
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
