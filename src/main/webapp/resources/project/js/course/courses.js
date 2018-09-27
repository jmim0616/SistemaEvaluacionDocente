var arrayCourses = [];
var arraySubjects = [];
var arrayTeachers = [];
var arrayAcademicPeriods = [];

$(document)
		.ready(
				function() {
					
					ajaxSearchCourses();
					ajaxSearchSubjects();
					ajaxSearchTeachers();
					ajaxSearchAcademicPeriods();

					$('.sub-menu-content').click(function(e) {

						e.preventDefault();

						$(this).addClass('true');

					});

					$('.container').click(function(e) {

						e.preventDefault();

						$('.sub-menu-content').removeClass('true');

					});

					
					$('#buttonSearchCourse').click(function(event) {

						event.preventDefault();

						$.get('./Courses/Data', function(view) {

							$('.content').fadeOut(0).html(view).fadeIn('slow');

							ajaxSearchCourse();

						})

					});
					
					$('#linkCreateCourse').click(function(event) {

								event.preventDefault();
								
								$('.createCourse .modalContainer').show().fadeIn('slow');

							});


					$('#linkCreateExcelCourse').click(
									function(event) {

										event.preventDefault();

										$('.content')
												.html(
														'<iframe src="http://localhost:8080/SistemaEvaluacionDocente/Courses/CreateExcel" width="500">  </iframe>');

									});
					

				});


function AutocompleteForCoursesSearch() {

	$("#groupIdSearch").autocomplete({
		source : arrayCourses
	});

}

function AutocompleteForSubjectsSearch() {

	$("#subjectSearch").autocomplete({
		source : arraySubjects
	});

}

function AutocompleteForTeachersSearch() {

	$("#teacherSearch").autocomplete({
		source : arrayTeachers
	});

}

function AutocompleteForAcademicPeriodsSearch() {

	$("#academicPeriodSearch").autocomplete({
		source : arrayAcademicPeriods
	});

}


function ajaxSearchCourses() {

	$.ajax({
		url : './Courses/GetCourses',
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

				arrayCourses.push(jsonResponse.objectEntityList[key].groupId);

			});

		},
		complete : function() {

			AutocompleteForCoursesSearch();

		},
		error : function() {

			console.log("No se ha podido obtener la información");

		}

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

			AutocompleteForSubjectsSearch();

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

				arrayTeachers.push(JSON.stringify(jsonResponse.objectEntityList[key].teacherId));

			});
			
//			console.log(arrayTeachers);

		},
		complete : function() {

			AutocompleteForTeachersSearch();

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

				arrayAcademicPeriods.push(jsonResponse.objectEntityList[key].name);

			});

		},
		complete : function() {

			AutocompleteForAcademicPeriodsSearch();

		},
		error : function() {

			console.log("No se ha podido obtener la información");

		}

	});

}


function ajaxSearchCourse() {

	$('#groupIdSearchError').text("");
	$('#teacherSearchError').text("");
	$('#subjectSearchError').text("");
	$('#academicPeriodSearchError').text("");

	var groupId = $('#groupIdSearch').val();
	var teacher = $('#teacherSearch').val();
	var subject = $('#subjectSearch').val();
	var academicPeriod = $('#academicPeriodSearch').val();

	var json = {
		"groupId" : groupId,
		"teacher" : teacher,
		"subject" : subject,
		"academicPeriod" : academicPeriod
	};

	$
			.ajax({
				url : './Courses/Search',
				data : JSON.stringify(json),
				contentType : "application/json",
				method : 'POST',
				beforeSend : function() {

				},
				done : function() {

				},
				success : function(jsonResponse) {

					if (typeof jsonResponse == "string") {

						$('.content').fadeOut(0).html(jsonResponse).fadeIn(
								'slow');

						$('.error').show().fadeIn('slow');
					}

					console.log(jsonResponse);

					if (jsonResponse.isValid) {

	

						if (jsonResponse.errorMessage != null) {

							$('#tableCourseData').show().fadeOut('slow');

							$('.error .message')
									.text(jsonResponse.errorMessage);

							$('.error').show().fadeIn('slow');

						} else {

							$("#tableCourseData")
									.append(
											"<tr>" + "<td>"
													+ jsonResponse.objectEntity.course.courseId
													+ "</td> "
													+ "<td>"
													+ jsonResponse.objectEntity.course.academicPeriod
													+ "</td> "
													+ "<td>"
													+ jsonResponse.objectEntity.course.teacher
													+ "</td> "
													+ "<td>"
													+ jsonResponse.objectEntity.course.subject
													+ "</td> "
													+ "<td>"
													+ jsonResponse.objectEntity.course.groupId
													+ "</td> "
													+ "<td>"
													+ jsonResponse.objectEntity.course.isVirtual
													+ "</td> "
													+ "<td>"
													+ '<div class="actions"> '
													+ '<a class="button edit-button buttonUpdateCourseToolbar">'
													+ '<ion-icon name="create"></ion-icon>'
													+ '</a>'
													+ '<a class="button add-button buttonAddFeedbackCourseToolbar">'
													+ 'Agregar Retroalimentacion'
													+ '</a>'
													+ '<a class="button delete-button buttonDeleteCourseToolbar">'
													+ '<ion-icon name="trash"></ion-icon>'
													+ '</a>' + '</div>'
													+ "</td> " + "</tr>");

						}

					} else {
						
						$('#groupIdSearchError').append(
								jsonResponse.errorMessages.groupId);
						
						$('#teacherSearchError').append(
								jsonResponse.errorMessages.teacher);
						
						$('#subjectSearchError').append(
								jsonResponse.errorMessages.subject);
						
						$('#academicPeriodSearchError').append(
								jsonResponse.errorMessages.academicPeriod);
						
					}

				},
				complete : function() {

					initCourseData();

				},
				error : function() {

					console.log("No se ha podido obtener la información");

				}

			});

}
