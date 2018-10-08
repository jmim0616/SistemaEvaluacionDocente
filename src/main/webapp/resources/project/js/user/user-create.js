$(document).ready(function() {

	$('#buttonCreateUser').click(function(event) {

		event.preventDefault();

		ajaxCreateUser();

	});
	

	$('.success .close').click(function(event) {

		event.preventDefault();

		$('.success').show().fadeOut('slow');

	});


});

function ajaxCreateUser() {

	$('#maskCreateError').text('');
	$('#passwordCreateError').text('');
	$('#nameCreateError').text('');
	$('#institutionalMailCreateError').text('');
	$('#personalMailCreateError').text('');

	var mask = $('#maskCreate').val();
	var name = $('#nameCreate').val();
	var password = $('#passwordCreate').val();
	var jobPosition = $('#jobPositionCreate option:selected').val();
	var institutionalMail = $('#institutionalMailCreate').val();
	var personalMail = $('#personalMailCreate').val();

	var json = {
		"mask" : mask,
		"password" : password,
		"institutionalMail" : institutionalMail,
		"personalMail" : personalMail,
		"name" : name,
		"jobPosition" : jobPosition

	}

	console.log(json);

	$.ajax({
		url : "./Users/Create",
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

					$('.createUser .modalContainer').show().fadeOut('slow');

				} else {

				$('#maskCreate').val('');
				$('#passwordCreate').val('');
				$('#nameCreate').val('');
				$('#institutionalMailCreate').val('');
				$('#personalMailCreate').val('');

				$('.success .message').text(jsonResponse.successMessage);

				$('.success').show().fadeIn('slow');

				$.get('./Users/Data', function(view) {

					$('.content').fadeOut(0).html(view).fadeIn('slow');

					ajaxSearchUser();

				})

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
