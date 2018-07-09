$(document).ready(function() {
	
	

	$('.createDepartment  #buttonCancel').click(function(event) {

		event.preventDefault();

		$('.createDepartment  .modalContainer').show().fadeOut('slow');

	});

	$('.createDepartment  #closeModal').click(function(event) {

		event.preventDefault();

		$('.createDepartment  .modalContainer').show().fadeOut('slow');

	});

	$('#buttonCreateDepartment').click(function(event) {

		event.preventDefault();

		ajaxCreateDepartment();

	});
	
	$('.success .close').click(function(event) {

		event.preventDefault();
		
		$('.success').show().fadeOut('slow');
		
	});

});

function ajaxCreateDepartment() {

	$('#nameCreateError').text('');

	var name = $('#nameCreate').val();

	var json = {
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

				$('#nameCreate').val('');

				$('.createDepartment .modalContainer').show().fadeOut('slow');
				
				$('.success .message').text(jsonResponse.successMessage);
				
				$('.success').show().fadeIn('slow');
				
				$.get('./Departments/Data', function(view, status, xhr){
					  $('.content').fadeOut(0).html(view).fadeIn('slow');
					}).done(function() {
						ajaxSearchDepartment();
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
