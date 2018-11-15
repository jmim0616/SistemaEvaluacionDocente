$(document).ready(function() {

	setDates();
	
	$('#buttonCreateAcademicPeriod').click(function(event) {

		event.preventDefault();

		ajaxCreateAcademicPeriod();

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

function setDates() {

	var year = (new Date).getFullYear();

	$("#initialDateCreate").datepicker({
		minDate : new Date(year, 0, 1),
		maxDate : new Date(year+1, 11, 31),
		dateFormat : 'yy-mm-dd'
	});

	$("#endDateCreate").datepicker({
		minDate : new Date(year, 0, 1),
		maxDate : new Date(year+1, 11, 31),
		dateFormat : 'yy-mm-dd'
	});
	
	$(function() {
		$.datepicker.setDefaults($.datepicker.regional["es"]);
		$("#nameCreate1").datepicker({
			dateFormat : 'yy'
		}).datepicker("setDate", new Date());
	});

}

function ajaxCreateAcademicPeriod() {

	$('#nameCreateError').text('');
	$('#initialDateCreateError').text('');
	$('#endDateCreateError').text('');

	var name = $('#nameCreate1').val() + "-"
			+ $('#nameCreate2 option:selected').val();
	var initialDate = $('#initialDateCreate').val();
	var endDate = $('#endDateCreate').val();

	var json = {
		"name" : name,
		"initialDate" : initialDate,
		"endDate" : endDate
	}

	console.log(json);

	$.ajax({
		url : "./AcademicPeriods/Create",
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

					$("#" + key + "CreateError").text(value);

				})

			}

		},
		error : function() {

		}

	});

}
