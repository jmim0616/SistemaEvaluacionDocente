$(document).ready(function() {

	setDates();

	$('.success .close').click(function(event) {

		event.preventDefault();

		$('.success').show().fadeOut('slow');

	});

	$('.error .close').click(function(event) {

		event.preventDefault();

		$('.error').show().fadeOut('slow');

	});
	
	$('#buttonUpdateAcademicPeriod').click(function(event) {

		event.preventDefault();

		ajaxUpdateAcademicPeriod();

	});

});


function setDates() {

	var year = (new Date).getFullYear();

	$("#initialDateUpdate").datepicker({
		minDate : new Date(year, 0, 1),
		maxDate : new Date(year, 11, 31),
		dateFormat : 'yy-mm-dd'
	});

	$("#endDateUpdate").datepicker({
		minDate : new Date(year, 0, 1),
		maxDate : new Date(year, 11, 31),
		dateFormat : 'yy-mm-dd'
	});

	$(function() {
		$.datepicker.setDefaults($.datepicker.regional["es"]);
		$("#nameUpdate1").datepicker({
			dateFormat : 'yy'
		}).datepicker("setDate", new Date());
	});

}

function ajaxUpdateAcademicPeriod() {

	$('#nameUpdateError').text('');
	$('#initialDateUpdateError').text('');
	$('#endDateUpdateError').text('');

	var academicPeriodId = $('#academicPeriodIdUpdate').val();
	var name = $('#nameUpdate1').val() + "-"
	+ $('#nameUpdate2 option:selected').val();
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

				if (jsonResponse.errorMessage != null) {

					$('.error .message').text(jsonResponse.errorMessage);

					$('.error').show().fadeIn('slow');

				} else {

					$('#nameSearch').val(name);

					$('#initialDateCreate').val('');
					$('#endDateCreate').val('');

					$('.success .message').text(jsonResponse.successMessage);

					$('.success').show().fadeIn('slow');

						$.get('./AcademicPeriods/Data', function(view) {

						$('.content').fadeOut(0).html(view).fadeIn('slow');

						ajaxSearchAcademicPeriod();

					})

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
