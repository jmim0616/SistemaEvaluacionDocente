$(document).ready(function() {

	$('#buttonCancel').click(function(event) {

		event.preventDefault();

		$('#groupIdSearch').val($('#groupIdDelete').val());

		$.get('./Courses/Data', function(view) {

			$('.content').fadeOut(0).html(view).fadeIn('slow');

			ajaxSearchCourse();

		})

		$('.modalContainer').show().fadeOut('slow');

	});

	$('#closeModal').click(function(event) {

		event.preventDefault();

		$('#groupIdSearch').val($('#groupIdDelete').val());

		$.get('./Courses/Data', function(view) {

			$('.content').fadeOut(0).html(view).fadeIn('slow');

			ajaxSearchCourse();

		})

		$('.modalContainer').show().fadeOut('slow');

	});

	$('#buttonDeleteCourse').click(function(event) {

		event.preventDefault();

		ajaxDeleteCourse();

	});

	$('.success .close').click(function(event) {

		event.preventDefault();

		$('.success').show().fadeOut('slow');

	});

});

function ajaxDeleteCourse() {

	$('.modalContainer').show().fadeOut('slow');

	var groupId = $('#groupIdDelete').val();

	var json = {

		"groupId" : groupId

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

			$('.modalContainer').show().fadeOut('slow');

			$('.success .message').text(jsonResponse.successMessage);

			$('.success').show().fadeIn('slow');

			$('#groupIdSearch').val($('#groupIdDelete').val());

			$.get('./Courses/Data', function(view) {

				$('.content').fadeOut(0).html(view).fadeIn('slow');

				ajaxSearchCourse();

			})

		},
		error : function() {

		}

	});

}
