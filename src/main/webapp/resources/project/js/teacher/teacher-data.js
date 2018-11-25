var arrayItemsStandardTable = null;

var tableIdClicked = null;

var classTdTableClicked = null;


function initTeacherData() {
	

	// $('.standard-table tr').not('.not').click(function() {
	//
	// var items = new Array();
	//
	// // Obtaining all the values within the tags <td> when a row is selected.
	// $(this).find("td").each(function(key, value) {
	//
	// items.push($(this).html());
	//
	// });
	//
	// console.log(items);
	//
	// arrayItemsStandardTable = items;
	//
	// });
	
	
	 
	$('.data').on('click', '.standard-table tr', function (e) {
		
	
		   if ($(this).hasClass("not")) {
				
			   
		      } else {
		    	  
				   $("#"+tableIdClicked).find("tr").removeClass("active-tr");
				   
				   $(this).addClass('active-tr');
		    	  
		      }
		

		});
	
	
	obtainValuesTdSearch();

	function obtainValuesTdSearch() {
		
	$('.data').on('click', '.standard-table tr td', function (e) {
			
			var items = new Array();
			
			classTdTableClicked = $(this).attr('class');
			tableIdClicked = $(this).parents("table").attr('id');
		
			
			$(this).parents("tr").find("td").each(function(key, value) {

				items.push($(this).html());
			
		});

			console.log(items);

			arrayItemsStandardTable = items;
			
			chooseTypeOfQuery();
			
		});

	}

	
	
	function obtainValuesTdActions(button) {

		var items = new Array();

		$(button).parents("tr").find("td").each(function(key, value) {

			items.push($(this).html());

		});

		console.log(items);

		arrayItemsStandardTable = items;
		
	}

	$('.buttonUpdateTeacherToolbar').click(function(event) {

		event.preventDefault();

		obtainValuesTdActions(this);

		ajaxShowUpdateTeacher();

	});

	$('.buttonUpdateStateTeacherToolbar').click(function(event) {

		event.preventDefault();

		obtainValuesTdActions(this);

		$('.updateTeacherStatus .modalContainer').show().fadeIn('slow');

		$('#teacherIdUpdateStatus').val(arrayItemsStandardTable[0]);

		$('#dialogModal .status').text(arrayItemsStandardTable[13]);

		// ajaxShowUpdateStatusTeacher();

	});

	$('.buttonAddSubjectTeacherToolbar').click(function(event) {

		event.preventDefault();

		obtainValuesTdActions(this);

		ajaxShowAddSubjectTeacher();

	});
	
	$('.data').on('click', '.buttonUpdateCourseFeedbackToolbar', function (event) {
		
		event.preventDefault();

		obtainValuesTdActions(this);
		
		
		$('#courseFeedBackIdUpdate').val(arrayItemsStandardTable[0]);
		$('#feedBackTypeUpdate').text(arrayItemsStandardTable[1]);
		$('#commentUpdate').val(arrayItemsStandardTable[2]);

		$('.updateCourseFeedback .modalContainer').show().fadeIn('slow');


	});

	$('.error .close').click(function(event) {

		event.preventDefault();

		$('.error').show().fadeOut('slow');

	});

}
	


function chooseTypeOfQuery() {

	console.log("tableIdClicked = " + tableIdClicked);
	
	if ((classTdTableClicked == "column") || (tableIdClicked != null)) {

		console.log("tableIdClicked = " + tableIdClicked);
		
		if (tableIdClicked == "tableTeacherData") {
			
			ajaxSearchCoursesByTeacher();

		}
		
		if (tableIdClicked == "tableCourseData") {
			
			ajaxSearchCourseFeedbackCourseOfTeacher();

		}
		
//		if (tableIdClicked == "tableCourseFeedbackData") {
//
//			console.log("DDDDDDDDDD");
//
//			ajaxSearchCourseFeedbackCourseOfTeacher();
//
//		}

	}

}

function ajaxSearchCoursesByTeacher() {

	var teacherId = arrayItemsStandardTable[0];
	var name = arrayItemsStandardTable[1];
	var lastName = arrayItemsStandardTable[2];
	var identificationType = arrayItemsStandardTable[3];
	var underDegree = arrayItemsStandardTable[4];
	var masterDegree = arrayItemsStandardTable[5];
	var doctorDegree = arrayItemsStandardTable[6];
	var institutionalMail = arrayItemsStandardTable[7];
	var personalMail = arrayItemsStandardTable[8];
	var cellNumber = arrayItemsStandardTable[9];
	var homeNumber = arrayItemsStandardTable[10];
	var experience = arrayItemsStandardTable[11];

	var json = {
		"teacherId" : teacherId,
		"name" : name,
		"lastName" : lastName,
		"identificationType" : identificationType,
		"underDegree" : underDegree,
		"masterDegree" : masterDegree,
		"doctorDegree" : doctorDegree,
		"institutionalMail" : institutionalMail,
		"personalMail" : personalMail,
		"cellNumber" : cellNumber,
		"homeNumber" : homeNumber,
		"experience" : experience
	}

	console.log(json);
//
	$
			.ajax({
				url : './Teachers/Courses',
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


							$('#tableCourseData .fila').remove();

							$('.error .message')
									.text(jsonResponse.errorMessage);

							$('.error').show().fadeIn('slow');

						} else {
	
	$("#tableCourseData tr").remove(); 

	$("#tableCourseData").append(
			'<thead>' + '<tr class="not">'
					+ '<th>Codigo</th>'
					+ '<th>Periodo Academico</th>'
					+ '<th>Profesor</th>' + '<th>Asignatura</th>'
					+ '<th>Identificador de Grupo</th>'
					+ '<th>Es virtual</th>'
					+ '</tr>' + '</thead>');

							
							$.each(jsonResponse.objectEntityList,
											function(key, value) {
								
											var isVirtual = jsonResponse.objectEntityList[key].isVirtual == "S" ? "Si" : "No";

												$("#tableCourseData")
														.append(
																"<tr class='fila' >"
																		+ "<td>"
																		+ jsonResponse.objectEntityList[key].courseId
																		+ "</td> "
																		+ "<td>"
																		+ jsonResponse.objectEntityList[key].academicPeriod.name
																		+ "</td> "
																		+ "<td>"
																		+ jsonResponse.objectEntityList[key].teacher.teacherId
																		+ "</td> "
																		+ "<td>"
																		+ jsonResponse.objectEntityList[key].subject.subjectId
																		+ "</td> "
																		+ "<td>"
																		+ jsonResponse.objectEntityList[key].groupId
																		+ "</td> "
																		+ "<td>"
																		+ isVirtual
																		+ "</td> "
																		+ "</tr>");

											})
						}

					} else {

					}

				},
				complete : function() {

				},
				error : function() {

					console.log("No se ha podido obtener la información");

				}

			});

}





function ajaxSearchCourseFeedbackCourseOfTeacher() {
	
	
	var courseId = arrayItemsStandardTable[0];
	var academicPeriod = arrayItemsStandardTable[1];
	var teacher = arrayItemsStandardTable[2];
	var subject = arrayItemsStandardTable[3];
	var groupId = arrayItemsStandardTable[4];
	var isVirtual = arrayItemsStandardTable[5];

	console.log('ajaxSearchCourseFeedbackCourseOfTeacher');
	
	var json = {
			
			"courseId": courseId,
			"academicPeriod": academicPeriod,
			"teacher": teacher,
			"subject": subject,
			"groupId": groupId,
			"isVirtual": isVirtual

	}

		console.log(json);


		$.ajax({
					url : './Courses/Feedbacks',
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

								$('#tableCourseFeedbackData .fila').remove();

								$('.error .message')
										.text(jsonResponse.errorMessage);

								$('.error').show().fadeIn('slow');

							} else {
								
								$("#tableCourseFeedbackData tr").remove(); 
								
								$("#tableCourseFeedbackData").append(
										'<thead>' + '<tr class="not">'
												+ '<th>Codigo de la Retroalimentacion</th>'
												+ '<th>Tipo de Retroalimentacion</th>'
												+ '<th>Comentario</th>' + '<th>Usuario</th>'
												+ '<th>Fecha de Modificacion</th>'
												+ '<th>Puntuacion Promedio</th>' + '<th>Acciones</th>'
												+ '</tr>' + '</thead>');
	
								var buttonUpdateCourseFeedback = null;
								
								$.each(jsonResponse.objectEntityList,function(key, value) {
													
													if (!(jsonResponse.objectEntityList[key].feedBackType.description == "encuenta web")) {
														
														buttonUpdateCourseFeedback = 
															  "<td>"
															+ "</td>" 
															+ "<td>"
															+ '<div class="actions"> '
															+ '<a class="button edit-button buttonUpdateCourseFeedbackToolbar">'
															+ '<ion-icon name="create"></ion-icon>'
															+ '</a>'
															+ '</div>'
															+ '</td> ';
													}

													var date = new Date(jsonResponse.objectEntityList[key].lastModifiedDate).toLocaleString();
													
													$("#tableCourseFeedbackData").append(
																			"<tr class='fila'>"
																			+ "<td>"
																			+ jsonResponse.objectEntityList[key].courseFeedBackId
																			+ "</td> "
																			+ "<td>"
																			+ jsonResponse.objectEntityList[key].feedBackType.description
																			+ "</td> "
																			+ "<td>"
																			+ jsonResponse.objectEntityList[key].comment
																			+ "</td> "
																			+ "<td>"
																			+ jsonResponse.objectEntityList[key].user.mask
																			+ "</td> "
																			+ "<td>"
																			+ date
																			+ "</td> "
																			+buttonUpdateCourseFeedback
																			+ "</tr>");

												})
							}

						} else {

						}

					},
					complete : function() {

					},
					error : function() {

						console.log("No se ha podido obtener la información");

					}

				});

	}
	

function ajaxShowUpdateTeacher() {

	$.ajax({
		url : "./Teachers/Update",
		method : 'GET',
		beforeSend : function(xhr) {

		},
		success : function(view) {

			$('.content').fadeOut(0).html(view).fadeIn('slow');

			$('#teacherIdUpdate').val(arrayItemsStandardTable[0]);
			$('#nameUpdate').val(arrayItemsStandardTable[1]);
			$('#lastNameUpdate').val(arrayItemsStandardTable[2]);
			// $('#identificationTypeUpdate
			// option:selected').text(arrayItemsStandardTable[3]);
			$('#identificationTypeUpdate .actualValue').text(
					arrayItemsStandardTable[3]);
			$('#underDegreeUpdate').val(arrayItemsStandardTable[4]);
			$('#masterDegreeUpdate').val(arrayItemsStandardTable[5]);
			$('#doctorDegreeUpdate').val(arrayItemsStandardTable[6]);
			$('#institutionalMailUpdate').val(arrayItemsStandardTable[7]);
			$('#personalMailUpdate').val(arrayItemsStandardTable[8]);
			$('#cellNumberUpdate').val(arrayItemsStandardTable[9]);
			$('#homeNumberUpdate').val(arrayItemsStandardTable[10]);
			$('#experienceUpdate').val(arrayItemsStandardTable[11]);

		}

	});

}

// function ajaxShowUpdateStatusTeacher() {
//	
//
// var teacherId = arrayItemsStandardTable[0];
//	
// var json = {
// "teacherId": teacherId
//
// }
//	
// $.ajax({
// url : "./Teachers/UpdateStatus",
// data: json,
// contentType : "application/json",
// method : 'GET',
// beforeSend: function(xhr) {
//        	
// },
// success: function(view) {
//		
// $('.content').fadeOut(0).html(view).fadeIn('slow');
//			
// $('#dialogModal .status').text(arrayItemsStandardTable[13]);
//
// $('.updateTeacherStatus .modalContainer').show().fadeIn('slow');
//			
// }
//		
// });
//
// }

function ajaxShowAddSubjectTeacher() {

	$.ajax({
		url : "./Teachers/AddSubjects",
		method : 'GET',
		beforeSend : function(xhr) {

		},
		success : function(view) {

			$('.content').fadeOut(0).html(view).fadeIn('slow');

			$('#teacherId').text(arrayItemsStandardTable[0]);
			$('#name').text(arrayItemsStandardTable[1]);
			$('#lastName').text(arrayItemsStandardTable[2]);
			$('#underDegree').text(arrayItemsStandardTable[4]);
			$('#masterDegree').text(arrayItemsStandardTable[5]);
			$('#doctorDegree').text(arrayItemsStandardTable[6]);
			$('#experience').text(arrayItemsStandardTable[11]);
			$('#subjectAdd').val(arrayItemsStandardTable[12]);

		}

	});

}



