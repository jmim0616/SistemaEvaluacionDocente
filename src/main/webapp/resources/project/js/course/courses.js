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

					$('#linkCreateCourse').click(
							function(event) {

								event.preventDefault();

								$('.createCourse .modalContainer').show()
										.fadeIn('slow');

							});

					$('#buttonSearchCourse').click(function(event) {

						event.preventDefault();

						$.get('./Courses/Data', function(view) {

							$('.content').fadeOut(0).html(view).fadeIn('slow');

							ajaxSearchCourse();

						})

					});

					$('#buttonSearchStudentsSurveyCourses').click(
							function(event) {

								event.preventDefault();

								
								var groupId = $('#groupIdSearch').val();
								var teacher = $('#teacherSearch').val();
								var subject = $('#subjectSearch').val();
								var academicPeriod = $('#academicPeriodSearch').val();
								
								window.open("./Courses/DataStudentsSurveyCourses?groupId="+groupId
										+"&teacher="+teacher+""
										+"&subject="+subject+""
										+"&academicPeriod="+academicPeriod+"");

							});

					$('#linkCreateCourse').click(
							function(event) {

								event.preventDefault();

								$('.createCourse .modalContainer').show()
										.fadeIn('slow');

							});

					$('#linkCreateExcelCourse')
							.click(
									function(event) {

										event.preventDefault();

										$('.content')
												.html(
														'<iframe src="http://localhost:8080/SistemaEvaluacionDocente/Courses/CreateExcel" lang="es" width="500">  </iframe>');

									});

					$('#linkCreateNotesExcel')
							.click(
									function(event) {

										event.preventDefault();

										$('.content')
												.html(
														'<iframe src="http://localhost:8080/SistemaEvaluacionDocente/Courses/CreateOnlineFeedBack" lang="es" width="500">  </iframe>');

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

	$
			.ajax({
				url : './Courses/GetCourses',
				contentType : 'application/json',
				method : 'POST',
				done : function() {

				},
				success : function(jsonResponse) {

					if (typeof jsonResponse == "string") {

						$('.content').fadeOut(0).html(jsonResponse).fadeIn(
								'slow');

						$('.error').show().fadeIn('slow');

					}

					console.log(jsonResponse);

					$
							.each(
									jsonResponse.objectEntityList,
									function(key, value) {

										arrayCourses
												.push(JSON
														.stringify(jsonResponse.objectEntityList[key].groupId));

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

	$
			.ajax({
				url : './Courses/GetTeachers',
				contentType : 'application/json',
				method : 'POST',
				done : function() {

				},
				success : function(jsonResponse) {

					if (typeof jsonResponse == "string") {

						$('.content').fadeOut(0).html(jsonResponse).fadeIn(
								'slow');

						$('.error').show().fadeIn('slow');

					}

					console.log(jsonResponse);

					$
							.each(
									jsonResponse.objectEntityList,
									function(key, value) {

										arrayTeachers
												.push(JSON
														.stringify(jsonResponse.objectEntityList[key].teacherId));

									});

					// console.log(arrayTeachers);

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

				arrayAcademicPeriods
						.push(jsonResponse.objectEntityList[key].name);

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
	
	console.log(json);

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

							$('.error .message')
									.text(jsonResponse.errorMessage);

							$('.error').show().fadeIn('slow');

						} else {

							var isVirtual = null;

							$.each(jsonResponse.objectEntityList,
											function(key, value) {

												if (jsonResponse.objectEntityList[key].isVirtual == "S") {
													isVirtual = "Si";
												} else if (jsonResponse.objectEntityList[key].isVirtual == "N") {
													isVirtual = "No";
												}

												$("#tableCourseData")
														.append(
																"<tr>"
																		+ '<td class="column">'
																		+ jsonResponse.objectEntityList[key].courseId
																		+ "</td> "
																		+ '<td class="column">'
																		+ jsonResponse.objectEntityList[key].academicPeriod.name
																		+ "</td> "
																		+ '<td class="column">'
																		+ jsonResponse.objectEntityList[key].teacher.teacherId
																		+ "</td> "
																		+ '<td class="column">'
																		+ jsonResponse.objectEntityList[key].subject.name
																		+ "</td> "
																		+ '<td class="column">'
																		+ jsonResponse.objectEntityList[key].groupId
																		+ "</td> "
																		+ '<td class="column">'
																		+ isVirtual
																		+ "</td> "
																		+ '<td class="column-actions">'
																		+ '<div class="actions"> '
																		+ '<a class="button edit-button buttonUpdateCourseToolbar">'
																		+ '<ion-icon name="create"></ion-icon>'
																		+ '</a>'
																		+ '<a class="button add-button buttonAddFeedbackCourseToolbar">'
																		+ 'Agregar Retroalimentacion'
																		+ '</a>'
																		+ '<a class="button delete-button buttonDeleteCourseToolbar">'
																		+ '<ion-icon name="trash"></ion-icon>'
																		+ '</a>'
																		+ '</div>'
																		+ "</td> "
																		+ "</tr>");

											})

						}

					} else {


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


