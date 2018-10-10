$(document).ready(function() {

	$('#buttonDeleteCourse').click(function(event) {

		event.preventDefault();

		ajaxDeleteCourse();

	});

	$('.deleteCourse #buttonCancel').click(function(event) {

		event.preventDefault();

		$('.deleteCourse .modalContainer').show().fadeOut('slow');

	});

	$('.deleteCourse #closeModal').click(function(event) {

		event.preventDefault();

		$('.deleteCourse .modalContainer').show().fadeOut('slow');

	});

	$('.success .close').click(function(event) {

		event.preventDefault();

		$('.success').show().fadeOut('slow');

	});

});

function ajaxDeleteCourse() {

	var courseId = $('#courseIdDelete').val();

	var json = {

		"courseId" : courseId

	}

	console.log(json);

	$.ajax({
		url : "./Courses/Delete",
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

					$('.deleteCourse .modalContainer').show().fadeOut('slow');

				} else {
					
					$('.success .message').text(jsonResponse.successMessage);

					$('.success').show().fadeIn('slow');

					$('.deleteCourse .modalContainer').show().fadeOut('slow');
					
					
					$('.container').fadeOut(0).load('./Courses/').fadeIn('slow');

				}

			}

		},
		error : function() {

		}

	});

}
