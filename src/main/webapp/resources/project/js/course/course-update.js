$(document).ready(function() {

	AutocompleteForSubjectsUpdate();
	AutocompleteForTeachersUpdate();
	AutocompleteForAcademicPeriodsUpdate();
	
	
	$('#buttonUpdateCourse').click(function(event) {

		event.preventDefault();

		ajaxUpdateCourse();

	});

	$('.updateCourse #buttonCancel').click(function(event) {

		event.preventDefault();

		$('.updateCourse .modalContainer').show().fadeOut('slow');

	});

	$('.updateCourse #closeModal').click(function(event) {

		event.preventDefault();

		$('.updateCourse .modalContainer').show().fadeOut('slow');

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

function AutocompleteForSubjectsUpdate() {

	$("#subjectUpdate").autocomplete({
		source : arraySubjects
	});

}

function AutocompleteForTeachersUpdate() {

	$("#teacherUpdate").autocomplete({
		source : arrayTeachers
	});

}

function AutocompleteForAcademicPeriodsUpdate() {

	$("#academicPeriodUpdate").autocomplete({
		source : arrayAcademicPeriods
	});

}



function ajaxUpdateCourse() {

	$('#groupIdUpdateError').text('');
	$('#subjectUpdateError').text('');
	$('#teacherUpdateError').text('');
	$('#academicPeriodUpdateError').text('');

	

	var courseId = $('#courseIdUpdate').val();
	var groupId = $('#groupIdUpdate').val();
	var subject = $('#subjectUpdate').val();
	var teacher = $('#teacherUpdate').val();
	var academicPeriod = $('#academicPeriodUpdate').val();
	var isVirtual = $('#isVirtualUpdate option:selected').text();

	var json = {
			
		"courseId" : courseId,
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
					
					$('.updateCourse .modalContainer').show().fadeOut('slow');

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
