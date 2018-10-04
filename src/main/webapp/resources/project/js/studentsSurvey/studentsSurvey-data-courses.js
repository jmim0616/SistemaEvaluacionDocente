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
		"groupId" : groupId,
		"teacher" : teacher,
		"subject" : subject,
		"academicPeriod" : academicPeriod
	};

	console.log(json);

	var jsonQuery1 = {
		"objectEntityList" : [ {

			"questionsByPeriodId" : "1",
			"department" : {
				"name" : "Operaciones y Sistemas"
			},
			"course" : {
				"groupId" : "1",
				"subject" : {
					"name" : "POO"
				},
				"teacher" : {
					"teacherId" : "1144080680"
				}
			},
			"question" : {
				"questionId" : "1",
				"question" : "El cabron explica bien ?"
			},
			"academicPeriod" : {
				"name" : "2018-1"
			},
			"percentage" : "80"
		}, {
			"questionsByPeriodId" : "1",
			"department" : {
				"name" : "Operaciones y Sistemas"
			},
			"course" : {
				"groupId" : "1",
				"subject" : {
					"name" : "Bases de Datos"
				},
				"teacher" : {
					"teacherId" : "16646114"
				}
			},
			"question" : {
				"questionId" : "1",
				"question" : "El cabron usa recursos audiovisuales ?"
			},
			"academicPeriod" : {
				"name" : "2018-1"
			},
			"percentage" : "50"
		} ]
	};

	console.log(jsonQuery1);

	$
			.each(
					jsonQuery1.objectEntityList,
					function(key, value) {

						$("#tableStudentsSurveyCoursesData")
								.append(
										"<tr>"
												+'<td>'
												+ jsonQuery1.objectEntityList[key].academicPeriod.name
												+ "</td> "
												+ '<td>'
												+ jsonQuery1.objectEntityList[key].department.name
												+ "</td> "
												+ '<td>'
												+ jsonQuery1.objectEntityList[key].course.subject.name
												+ "</td> "
												+ '<td>'
												+ jsonQuery1.objectEntityList[key].course.groupId
												+ "</td> "
												+ '<td>'
												+ jsonQuery1.objectEntityList[key].course.teacher.teacherId
												+ "</td> "
												+ '<td>'
												+ jsonQuery1.objectEntityList[key].question.question
												+ "</td> " + "</tr>");

					})

	 $.ajax({
	 url : './Courses/SearchStudentsSurveyCourses',
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
	
//	 if (jsonResponse.isValid) {
//	
//	 if (jsonResponse.errorMessage != null) {
//	
//	 $('#tableStudentsSurveyCoursesData').show().fadeOut('slow');
//	
//	 $('.error .message').text(jsonResponse.errorMessage);
//	
//	 $('.error').show().fadeIn('slow');
//	
//	 } else {
//								
//	 var isVirtual = null;
//								
//	 $.each(jsonResponse.objectEntityList, function(key, value) {
//									
//	
//									
//	
//		 $("#tableStudentsSurveyCoursesData")
//			.append(
//					"<tr>"
//							+'<td>'
//							+ jsonQuery1.objectEntityList[key].academicPeriod.name
//							+ "</td> "
//							+ '<td>'
//							+ jsonQuery1.objectEntityList[key].department.name
//							+ "</td> "
//							+ '<td>'
//							+ jsonQuery1.objectEntityList[key].course.subject.name
//							+ "</td> "
//							+ '<td>'
//							+ jsonQuery1.objectEntityList[key].course.groupId
//							+ "</td> "
//							+ '<td>'
//							+ jsonQuery1.objectEntityList[key].course.teacher.teacherId
//							+ "</td> "
//							+ '<td>'
//							+ jsonQuery1.objectEntityList[key].question.question
//							+ "</td> " + "</tr>");
//	
//	 })
//								
//	 }
//								
//	
//	 } else {
//							
//	 $('#groupIdSearchError').append(
//	 jsonResponse.errorMessages.groupId);
//							
//	 $('#teacherSearchError').append(
//	 jsonResponse.errorMessages.teacher);
//							
//	 $('#subjectSearchError').append(
//	 jsonResponse.errorMessages.subject);
//							
//	 $('#academicPeriodSearchError').append(
//	 jsonResponse.errorMessages.academicPeriod);
//							
//	 }
//	
	 },
	 complete : function() {
	
	 },
	 error : function() {
	
	 console.log("No se ha podido obtener la información");
	
	 }
	
	 });

}