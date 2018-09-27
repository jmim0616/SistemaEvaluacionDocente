$(document).ready(function() {
	
	$('#buttonUpdateStatusTeacher').click(function(event) {

		event.preventDefault();

		ajaxUpdateTeacherStatus();

	});

	$('#buttonCancel').click(function(event) {

		event.preventDefault();

		$('#teacherIdSearch').val($('#teacherIdUpdateStatus').val());


		$('.modalContainer').show().fadeOut('slow');

	});

	$('#closeModal').click(function(event) {

		event.preventDefault();

		$('#teacherIdSearch').val($('#teacherIdUpdateStatus').val());

		$('.modalContainer').show().fadeOut('slow');

	});


	$('.success .close').click(function(event) {

		event.preventDefault();

		$('.success').show().fadeOut('slow');

	});

});

function ajaxUpdateTeacherStatus() {

	var teacherId = $('#teacherIdUpdateStatus').val();
	var teacherStatus = $('.status').text();

	var json = {
		"teacherId" : teacherId,
		"teacherStatus" : teacherStatus

	}

	console.log(json);

	$.ajax({
		url : "./Teachers/UpdateStatus",
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

			$('.success .message').text(jsonResponse.successMessage);

			$('.success').show().fadeIn('slow');

			
			$('#teacherIdSearch').val($('#teacherIdUpdateStatus').val());

			$.get('./Teachers/Data', function(view) {

				$('.content').fadeOut(0).html(view).fadeIn('slow');

				ajaxSearchTeacher();

			})

		},
		error : function() {

		}

	});

}
