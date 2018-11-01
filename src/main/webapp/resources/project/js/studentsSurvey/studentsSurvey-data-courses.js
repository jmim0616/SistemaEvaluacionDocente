$(document).ready(function() {
	console.log("ready!");

	ajaxSearchStudentsSurveyCourses();

});

function ajaxSearchStudentsSurveyCourses() {

	var groupId = $('#groupIdSearch').val();
	var teacher = $('#teacherSearch').val();
	var subject = $('#subjectSearch').val();
	var academicPeriod = $('#academicPeriodSearch').val();

	var json = {
		"courseId" : groupId,
		"teacher" : teacher,
		"subject" : subject,
		"academicPeriod" : academicPeriod
	};

	console.log(json);

	// var jsonQuery1 = {
	// "objectEntityList" : [ {
	//
	// "questionsByPeriodId" : "1",
	// "department" : {
	// "name" : "Operaciones y Sistemas"
	// },
	// "course" : {
	// "groupId" : "1",
	// "subject" : {
	// "name" : "POO"
	// },
	// "teacher" : {
	// "teacherId" : "1144080680"
	// }
	// },
	// "question" : {
	// "questionId" : "1",
	// "question" : "El cabron explica bien ?"
	// },
	// "academicPeriod" : {
	// "name" : "2018-1"
	// },
	// "percentage" : "80"
	// }, {
	// "questionsByPeriodId" : "1",
	// "department" : {
	// "name" : "Operaciones y Sistemas"
	// },
	// "course" : {
	// "groupId" : "1",
	// "subject" : {
	// "name" : "Bases de Datos"
	// },
	// "teacher" : {
	// "teacherId" : "16646114"
	// }
	// },
	// "question" : {
	// "questionId" : "1",
	// "question" : "El cabron usa recursos audiovisuales ?"
	// },
	// "academicPeriod" : {
	// "name" : "2018-1"
	// },
	// "percentage" : "50"
	// } ]
	// };

	/*
	 * var jsonQuery1 = { "objectEntityList" : [ {
	 * 
	 * "questionByPeriod" : { "questionsByPeriodId" : "1", "department" : {
	 * "name" : "Operaciones y Sistemas" }, "course" : { "groupId" : "1",
	 * "subject" : { "name" : "POO" }, "teacher" : { "teacherId" : "1144080680" } },
	 * "question" : { "questionId" : "1", "question" : "El cabron explica bien ?" },
	 * "academicPeriod" : { "name" : "2018-1" }, "percentage" : "80" } }, {
	 * "questionByPeriod" : { "questionsByPeriodId" : "1", "department" : {
	 * "name" : "Operaciones y Sistemas" }, "course" : { "groupId" : "1",
	 * "subject" : { "name" : "Bases de Datos" }, "teacher" : { "teacherId" :
	 * "16646114" } }, "question" : { "questionId" : "1", "question" : "El
	 * cabron usa recursos audiovisuales ?" }, "academicPeriod" : { "name" :
	 * "2018-1" }, "percentage" : "50" } } ] };
	 * 
	 * console.log(jsonQuery1);
	 * 
	 * $.each( jsonQuery1.objectEntityList, function(key, value) { //
	 * console.log("AAAAAAAAAA"); // console.log(key); //
	 * console.log("BBBBBBBBBB"); // console.log(value); //
	 * $("#tableStudentsSurveyCoursesData") .append( "<tr>" +'<td>' +
	 * jsonQuery1.objectEntityList[key].questionByPeriod.academicPeriod.name + "</td> " + '<td>' +
	 * jsonQuery1.objectEntityList[key].questionByPeriod.department.name + "</td> " + '<td>' +
	 * jsonQuery1.objectEntityList[key].questionByPeriod.course.subject.name + "</td> " + '<td>' +
	 * jsonQuery1.objectEntityList[key].questionByPeriod.course.groupId + "</td> " + '<td>' +
	 * jsonQuery1.objectEntityList[key].questionByPeriod.course.teacher.teacherId + "</td> " + '<td>' +
	 * jsonQuery1.objectEntityList[key].questionByPeriod.question.question + "</td> " + "</tr>"); })
	 */

	$
			.ajax({
				url : './CompareView',
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

					$
							.each(
									jsonResponse.periods,
									function(keyPeriods, valuePeriods) {

										var isFirstRow = true;

										$
												.each(
														jsonResponse.periods[keyPeriods].rows,
														function(keyRows,
																valueRows) {

															console
																	.log("AAAAAAAAAA");
															console
																	.log(jsonResponse.periods[keyPeriods].rows[keyRows]);
															console
																	.log("BBBBBBBBBB");
															console
																	.log(valueRows);

															var questions = '<table class= "tabla_contenedor_up">'
																	+ '<tr>';
															//								
															if (isFirstRow) {

																$
																		.each(
																				jsonResponse.periods[keyPeriods].rows[keyRows].questions,
																				function(
																						keyQuestions,
																						valueQuestions) {
																					questions += "<td>"
																							+ jsonResponse.periods[keyPeriods].rows[keyRows].questions[keyQuestions].question
																							+ "</td> "
																				})

																questions += "</tr>"
																		+ '</table>';

																$(

																"#tableStudentsSurveyCoursesData")
																		.append(
																				"<tr>"
																						+ '<td>'
																						+ "</td> "
																						+ '<td>'
																						+ "</td> "
																						+ '<td >'
																						+ "</td> "
																						+ '<td >'
																						+ "</td> "
																						+ '<td>'
																						+ "</td> "
																						+ '<td>'
																						+ questions
																						+ "</td> "
																						+ "</tr>");

																isFirstRow = false;
																
															} 

																questions = '<table class= "tabla_contenedor_down">'
																	+ '<tr>';														

																$
																		.each(
																				jsonResponse.periods[keyPeriods].rows[keyRows].questions,
																				function(
																						keyQuestions,
																						valueQuestions) {
																					questions += "<td>"
																							+ jsonResponse.periods[keyPeriods].rows[keyRows].questions[keyQuestions].response
																							+ "</td> ";
																				})

																questions += "</tr>"
																		+ '</table>';

																console
																		.log("Questions= "
																				+ questions);

																$(
																		"#tableStudentsSurveyCoursesData")
																		.append(
																				"<tr>"
																						+ '<td>'
																						+ jsonResponse.periods[keyPeriods].rows[keyRows].rowHeader.periodName
																						+ "</td> "
																						+ '<td>'
																						+ jsonResponse.periods[keyPeriods].rows[keyRows].rowHeader.departmentName
																						+ "</td> "
																						+ '<td >'
																						+ jsonResponse.periods[keyPeriods].rows[keyRows].rowHeader.signatureName
																						+ "</td> "
																						+ '<td >'
																						+ jsonResponse.periods[keyPeriods].rows[keyRows].rowHeader.groupId
																						+ "</td> "
																						+ '<td>'
																						+ jsonResponse.periods[keyPeriods].rows[keyRows].rowHeader.teacherId
																						+ "</td> "
																						+ '<td>'
																						+ questions
																						+ "</td> "
																						+ "</tr>");
															

														})
									})

					// if (jsonResponse.isValid) {
					//	
					// if (jsonResponse.errorMessage != null) {
					//	
					// $('#tableStudentsSurveyCoursesData').show().fadeOut('slow');
					//	
					// $('.error .message').text(jsonResponse.errorMessage);
					//	
					// $('.error').show().fadeIn('slow');
					//	
					// } else {
					//								
					// var isVirtual = null;
					//								
					// $.each(jsonResponse.objectEntityList, function(key,
					// value) {
					//									
					//	
					//									
					//	
					// $("#tableStudentsSurveyCoursesData")
					// .append(
					// "<tr>"
					// +'<td>'
					// + jsonQuery1.objectEntityList[key].academicPeriod.name
					// + "</td> "
					// + '<td>'
					// + jsonQuery1.objectEntityList[key].department.name
					// + "</td> "
					// + '<td>'
					// + jsonQuery1.objectEntityList[key].course.subject.name
					// + "</td> "
					// + '<td>'
					// + jsonQuery1.objectEntityList[key].course.groupId
					// + "</td> "
					// + '<td>'
					// +
					// jsonQuery1.objectEntityList[key].course.teacher.teacherId
					// + "</td> "
					// + '<td>'
					// + jsonQuery1.objectEntityList[key].question.question
					// + "</td> " + "</tr>");
					//	
					// })
					//								
					// }
					//								
					//	
					// } else {
					//							
					// $('#groupIdSearchError').append(
					// jsonResponse.errorMessages.groupId);
					//							
					// $('#teacherSearchError').append(
					// jsonResponse.errorMessages.teacher);
					//							
					// $('#subjectSearchError').append(
					// jsonResponse.errorMessages.subject);
					//							
					// $('#academicPeriodSearchError').append(
					// jsonResponse.errorMessages.academicPeriod);
					//							
					// }
					//	
				},
				complete : function() {

				},
				error : function() {

					console.log("No se ha podido obtener la información");

				}

			});

}