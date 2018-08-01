$(document).ready(function() {

	$('.success .close').click(function(event) {

		event.preventDefault();

		$('.success').show().fadeOut('slow');

	});

	$('#buttonUpdateAcademicPeriod').click(function(event) {

		event.preventDefault();

		ajaxUpdateAcademicPeriod();

	});

});

function ajaxUpdateAcademicPeriod() {

	$('#nameUpdateError').text('');
	$('#initialDateUpdateError').text('');
	$('#endDateUpdateError').text('');

	var academicPeriodId = $('#academicPeriodIdUpdate').val();
	var name = $('#nameUpdate').val();
	var initialDate = $('#initialDateUpdate').val();
	var endDate = $('#endDateUpdate').val();

	var json = {
		"academicPeriodId" : academicPeriodId,
		"name" : name,
		"initialDate" : initialDate,
		"endDate" : endDate
	}

	console.log(json);

	$.ajax({
		url : "./AcademicPeriods/Update",
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

				$('#nameSearch').val($('#nameUpdate').val());

				$('#nameUpdate').val('');
				$('#initialDateUpdate').val('');
				$('#endDateUpdate').val('');

				$('.success .message').text(jsonResponse.successMessage);

				$('.success').show().fadeIn('slow');

				
				$.get('./AcademicPeriods/Data', function(view) {

					$('.content').fadeOut(0).html(view).fadeIn('slow');

					ajaxSearchAcademicPeriod();

				})
				

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
