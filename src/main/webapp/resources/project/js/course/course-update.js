var arraySubjects = [];
var arrayTeachers = [];
var arrayAcademicPeriods = [];

$(document).ready(function() {

	ajaxSearchSubjects();
	ajaxSearchTeachers();
	ajaxSearchAcademicPeriods();

	$('.updateCourse #buttonCancel').click(function(event) {

		event.preventDefault();

		$('.updateCourse .modalContainer').show().fadeOut('slow');

	});

	$('.updateCourse #closeModal').click(function(event) {

		event.preventDefault();

		$('.updateCourse .modalContainer').show().fadeOut('slow');

	});

	$('#buttonUpdateCourse').click(function(event) {

		event.preventDefault();

		ajaxUpdateCourse();

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

function AutocompleteForSubjects() {

	$("#subjectUpdate").autocomplete({
		source : arraySubjects
	});

}

function AutocompleteForTeachers() {

	$("#teacherUpdate").autocomplete({
		source : arrayTeachers
	});

}

function AutocompleteForAcademicPeriods() {

	$("#academicPeriodUpdate").autocomplete({
		source : arrayAcademicPeriods
	});

}

function ajaxSearchSubjects() {

	$.ajax({
		url : './Courses/GetSubjects',
		contentType : 'application/json',
		method : 'POST',
		done : function() {

		},
		success : function(jsonResponse) {

			if (typeof jsonResponse == "string") {

				$('.content').fadeOut(0).html(jsonResponse).fadeIn('slow');

				$('.error').show().fadeIn('slow');

			}

			console.log(jsonResponse);

			$.each(jsonResponse.objectEntityList, function(key, value) {

				arraySubjects.push(jsonResponse.objectEntityList[key].name);

			});

		},
		complete : function() {

			AutocompleteForSubjects();

		},
		error : function() {

			console.log("No se ha podido obtener la información");

		}

	});

}

function ajaxSearchTeachers() {

	$.ajax({
		url : './Courses/GetTeachers',
		contentType : 'application/json',
		method : 'POST',
		done : function() {

		},
		success : function(jsonResponse) {

			if (typeof jsonResponse == "string") {

				$('.content').fadeOut(0).html(jsonResponse).fadeIn('slow');

				$('.error').show().fadeIn('slow');

			}

			console.log(jsonResponse);

			$.each(jsonResponse.objectEntityList, function(key, value) {

				arrayTeachers.push(jsonResponse.objectEntityList[key].name);

			});

		},
		complete : function() {

			AutocompleteForTeachers();

		},
		error : function() {

			console.log("No se ha podido obtener la información");

		}

	});

}

function ajaxSearchAcademicPeriods() {

	$.ajax({
		url : './Courses/GetAcademicPeriods',
		contentType : 'application/json',
		method : 'POST',
		done : function() {

		},
		success : function(jsonResponse) {

			if (typeof jsonResponse == "string") {

				$('.content').fadeOut(0).html(jsonResponse).fadeIn('slow');

				$('.error').show().fadeIn('slow');

			}

			console.log(jsonResponse);

			$.each(jsonResponse.objectEntityList, function(key, value) {

				arrayAcademicPeriods
						.push(jsonResponse.objectEntityList[key].name);

			});

		},
		complete : function() {

			AutocompleteForAcademicPeriods();

		},
		error : function() {

			console.log("No se ha podido obtener la información");

		}

	});

}

function ajaxUpdateCourse() {

	$('#groupIdUpdateError').text('');
	$('#subjectUpdateError').text('');
	$('#teacherUpdateError').text('');
	$('#academicPeriodUpdateError').text('');


	var groupId = $('#groupIdUpdate').val();
	var subject = $('#subjectUpdate').val();
	var teacher = $('#teacherUpdate').val();
	var academicPeriod = $('#academicPeriodUpdate').text();
	var isVirtual = $('#isVirtualUpdate option:selected').text();

	var json = {
			
		"groupId" : groupId,
		"subject" : subject,
		"teacher" : teacher,
		"academicPeriod" : academicPeriod,
		"isVirtual" : isVirtual

	}

	console.log(json);

	$.ajax({
		url : "./Courses/Update",
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

					$('#groupIdSearch').val($('#groupIdUpdate').val());
					$('#teacherSearch').val($('#teacherUpdate').val());
					$('#subjectSearch').val($('#subjectUpdate').val());
					$('#academicPeriodSearch').val($('#academicPeriodUpdate').val());

					$('#groupIdUpdate').val('');
					$('#subjectUpdate').val('');
					$('#teacherUpdate').val('');
					$('#academicPeriodUpdate').val('');
					$('#isVirtualUpdate option:selected').val('1');

					$('.success .message').text(jsonResponse.successMessage);

					$('.success').show().fadeIn('slow');

					$.get('./Courses/Data', function(view) {

						$('.content').fadeOut(0).html(view).fadeIn('slow');

						ajaxSearchCourse();

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
