$(document).ready(function() {

	$('.updateFaculty #buttonCancel').click(function(event) {

		event.preventDefault();

		$('.updateFaculty .modalContainer').show().fadeOut('slow');

	});

	$('.updateFaculty #closeModal').click(function(event) {

		event.preventDefault();

		$('.updateFaculty .modalContainer').show().fadeOut('slow');

	});

	$('#buttonUpdateFaculty').click(function(event) {

		event.preventDefault();

		ajaxUpdateFaculty();

	});

	$('.success .close').click(function(event) {

		event.preventDefault();

		$('.success').show().fadeOut('slow');

	});

});

function ajaxUpdateFaculty() {

	$('#nameUpdateError').text('');

	var facultyId = $('#facultyIdUpdate').val();
	var name = $('#nameUpdate').val();

	var json = {
		"facultyId" : facultyId,
		"name" : name
	}

	console.log(json);

	$.ajax({
		url : "./Faculties/Update",
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

					$('.updateFaculty .modalContainer').show().fadeOut('slow');

				} else {

					$('#nameUpdate').val('');

					$('.success .message').text(jsonResponse.successMessage);

					$('.success').show().fadeIn('slow');

					$('.updateFaculty .modalContainer').show().fadeOut('slow');

					$.get('./Faculties/Data', function(view, status, xhr) {
						$('.content').fadeOut(0).html(view).fadeIn('slow');
					}).done(function() {
						ajaxSearchFaculty();
					});

				}

			} else {

				$.each(jsonResponse.errorMessages, function(key, value) {

					$("#" + key + "UpdateError").text(value);

				})
			}
		},
		error : function() {

		}

	});

}
