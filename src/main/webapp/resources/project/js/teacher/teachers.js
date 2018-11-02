var arrayTeachersId = [];
var arrayTeachersName = [];
var arraySubjects = [];


$(document).ready(function() {
	
	ajaxSearchTeachers();
	ajaxSearchSubjects();

	$('.sub-menu-content').click(function(e) {

		e.preventDefault();

		$(this).addClass('true');

	});

	$('.container').click(function(e) {

		e.preventDefault();

		$('.sub-menu-content').removeClass('true');

	});

	$('#linkCreateTeacher').click(function(event) {

		event.preventDefault();

		$('.content').fadeOut(0).load('./Teachers/Create').fadeIn('slow');

	});
	
	$('#linkCreateExcelTeacher').click(
			function(event) {

				event.preventDefault();

				$('.content')
						.html(
								'<iframe src="http://localhost:8080/SistemaEvaluacionDocente/Teachers/CreateExcel" width="500">  </iframe>');

			});

	$('#buttonSearchTeacher').click(function(event) {

		event.preventDefault();

		// $('.content').fadeOut(0).load('./Teachers/Data').fadeIn('slow');

		// ajaxShow();

		$.get('./Teachers/Data', function(view) {

			$('.content').fadeOut(0).html(view).fadeIn('slow');

			ajaxSearchTeacher();

		})

	});

});



function AutocompleteForTeachersIdSearch() {

	$("#teacherIdSearch").autocomplete({
		source : arrayTeachersId
	});

}

function AutocompleteForTeachersNameSearch() {

	$("#nameSearch").autocomplete({
		source : arrayTeachersName
	});

}


function AutocompleteForSubjectsSearch() {

	$("#subjectSearch").autocomplete({
		source : arraySubjects
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

						$('.content').fadeOut(0).html(jsonResponse).fadeIn(
								'slow');

						$('.error').show().fadeIn('slow');

					}

					console.log(jsonResponse);

					$
							.each(
									jsonResponse.objectEntityList,
									function(key, value) {

										arrayTeachersId.push(JSON.stringify(jsonResponse.objectEntityList[key].teacherId));
										
										arrayTeachersName.push(jsonResponse.objectEntityList[key].name);


									});


				},
				complete : function() {

					AutocompleteForTeachersIdSearch();
					AutocompleteForTeachersNameSearch();

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



function ajaxSearchTeacher() {

	$('#teacherIdSearchError').text("");
	$('#nameSearchError').text("");
	$('#subjectSearchError').text("");

	var teacherId = $('#teacherIdSearch').val();
	var name = $('#nameSearch').val();
	var subjectSearch = $('#subjectSearch').val();

	var json = {
		"teacherId" : teacherId,
		"name" : name,
		"subjectSearch" : subjectSearch
	};

	console.log(json);
	

	
	$.ajax({
				url : './Teachers/Search',
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

							var identificationType = null;

							$.each(jsonResponse.objectEntityList, function(key, value) {
							
							if (jsonResponse.objectEntityList[key].teacher.identificationType == 1) {
								identificationType = "Cedula de Ciudadania";
							} else if (jsonResponse.objectEntityList[key].teacher.identificationType == 2) {
								identificationType = "Cedula de Extranjeria";
							}

							$("#tableTeacherData")
									.append(
											"<tr>" + '<td class="column">'
													+ jsonResponse.objectEntityList[key].teacher.teacherId
													+ "</td> "
													+ '<td class="column">'
													+ jsonResponse.objectEntityList[key].teacher.name
													+ "</td> "
													+ '<td class="column">'
													+ jsonResponse.objectEntityList[key].teacher.lastName
													+ "</td> "
													+ '<td class="column">'
													+ identificationType
													+ "</td> "
													+ '<td class="column">'
													+ jsonResponse.objectEntityList[key].teacher.underDegree
													+ "</td> "
													+ '<td class="column">'
													+ jsonResponse.objectEntityList[key].teacher.masterDegree
													+ "</td> "
													+ '<td class="column">'
													+ jsonResponse.objectEntityList[key].teacher.doctorDegree
													+ "</td> "
													+ '<td class="column">'
													+ jsonResponse.objectEntityList[key].teacher.institutionalMail
													+ "</td> "
													+ '<td class="column">'
													+ jsonResponse.objectEntityList[key].teacher.personalMail
													+ "</td> "
													+ '<td class="column">'
													+ jsonResponse.objectEntityList[key].teacher.cellNumber
													+ "</td>"
													+ '<td class="column">'
													+ jsonResponse.objectEntityList[key].teacher.homeNumber
													+ "</td> "
													+ '<td class="column">'
													+ jsonResponse.objectEntityList[key].teacher.experience
													+ "</td> "
													+ '<td class="column">'
													+ jsonResponse.objectEntityList[key].subject.name
													+ "</td> "
													+ '<td class="column">'
													+ jsonResponse.objectEntityList[key].teacher.teacherStatus.status
													+ "</td> "
													+ '<td class="column-actions">'
													+ '<div class="actions"> '
													+ '<a class="button edit-button buttonUpdateTeacherToolbar">'
													+ '<ion-icon name="create"></ion-icon>'
													+ '</a>'
													+ '<a class="button inactivate-button buttonUpdateStateTeacherToolbar">'
													+ '<ion-icon name="remove-circle"></ion-icon>'
													+ '</a>'
													+ '<a class="button add-button buttonAddSubjectTeacherToolbar">'
													+ 'Agregar Asignaturas'
													+ '</a>' + '</div>'
													+ "</td> " + "</tr>");

						})
							
						}

					} else {

						$('#teacherIdSearchError').append(
								jsonResponse.errorMessages.teacherId);

						$('#nameSearchError').append(
								jsonResponse.errorMessages.name);

						$('#subjectSearchError').append(
								jsonResponse.errorMessages.subjectSearch);

					}

				},
				complete : function() {

					initTeacherData();

				},
				error : function() {

					console.log("No se ha podido obtener la información");

				}

			});

}

//function ajaxShow() {
//
//	$.ajax({
//		// url : "./Teachers/Data",
//		method : 'GET',
//		beforeSend : function(xhr) {
//
//		},
//		done : function(view) {
//
//		},
//		success : function(view) {
//
//			//			$('.content').fadeOut(0).html(view).fadeIn('slow');
//
//			//        	$('.content').fadeOut(0).load('./Teachers/Data').fadeIn('slow');
//
//			//			$('.content').html(view);
//
//			//			ajaxSearchTeacher();
//
//			console.log("AAAAAAAAAAAA");
//
//		},
//		complete : function() {
//
//		},
//
//	});
//
//}