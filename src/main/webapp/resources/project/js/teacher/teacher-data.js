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

	if ((classTdTableClicked == "column") && (tableIdClicked != null)) {

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
	
	
	$("#tableCourseData")
	.append(
			"<tr>"
					+ '<td class="column">'
					+ "AAAAAAAAA"
					+ "</td> "
					+ '<td class="column">'
					+ "BBBBBBB"
					+ "</td> "
					+ '<td class="column">'
					+ "CCCCCCCC"
					+ "</td> "
					+ '<td class="column">'
					+ "DDDDDDD"
					+ "</td> "
					+ '<td class="column">'
					+ "EEEEEEE"
					+ "</td> "
					+ '<td class="column">'
					+ "OOOOOOO"
					+ "</td> "
					+ "</tr>");
	
	
	$("#tableCourseData")
	.append(
			"<tr>"
					+ '<td class="column">'
					+ "SSSSS"
					+ "</td> "
					+ '<td class="column">'
					+ "DDDDD"
					+ "</td> "
					+ '<td class="column">'
					+ "VVVVV"
					+ "</td> "
					+ '<td class="column">'
					+ "TTTTTTTT"
					+ "</td> "
					+ '<td class="column">'
					+ "HHHHHH"
					+ "</td> "
					+ '<td class="column">'
					+ "YYYYYY"
					+ "</td> "
					+ "</tr>");
	
	$("#tableCourseData")
	.append(
			"<tr>"
					+ '<td class="column">'
					+ "MMMM"
					+ "</td> "
					+ '<td class="column">'
					+ "LLLLLL"
					+ "</td> "
					+ '<td class="column">'
					+ "OOOOO"
					+ "</td> "
					+ '<td class="column">'
					+ "RRRRRR"
					+ "</td> "
					+ '<td class="column">'
					+ "ZZZZZZZZ"
					+ "</td> "
					+ '<td class="column">'
					+ "FFFFFFF"
					+ "</td> "
					+ "</tr>");
	
	
	

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
//	$
//			.ajax({
//				url : './Teachers/',
//				data : JSON.stringify(json),
//				contentType : "application/json",
//				method : 'POST',
//				beforeSend : function() {
//
//				},
//				done : function() {
//
//				},
//				success : function(jsonResponse) {
//
//					if (typeof jsonResponse == "string") {
//
//						$('.content').fadeOut(0).html(jsonResponse).fadeIn(
//								'slow');
//
//						$('.error').show().fadeIn('slow');
//					}
//
//					console.log(jsonResponse);
//
//					if (jsonResponse.isValid) {
//
//						if (jsonResponse.errorMessage != null) {
//
//							$('#tableCourseData').show().fadeOut('slow');
//
//							$('.error .message')
//									.text(jsonResponse.errorMessage);
//
//							$('.error').show().fadeIn('slow');
//
//						} else {
//
//							$
//									.each(
//											jsonResponse.objectEntityList,
//											function(key, value) {
//
//												$("#tableCourseData")
//														.append(
//																"<tr>"
//																		+ "<td>"
//																		+ jsonResponse.objectEntityList[key].courseId
//																		+ "</td> "
//																		+ "<td>"
//																		+ jsonResponse.objectEntityList[key].academicPeriod
//																		+ "</td> "
//																		+ "<td>"
//																		+ jsonResponse.objectEntityList[key].teacher
//																		+ "</td> "
//																		+ "<td>"
//																		+ jsonResponse.objectEntityList[key].subject
//																		+ "</td> "
//																		+ "<td>"
//																		+ jsonResponse.objectEntityList[key].groupId
//																		+ "</td> "
//																		+ "<td>"
//																		+ jsonResponse.objectEntityList[key].isVirtual
//																		+ "</td> "
//																		+ "</tr>");
//
//											})
//						}
//
//					} else {
//
//					}
//
//				},
//				complete : function() {
//
//				},
//				error : function() {
//
//					console.log("No se ha podido obtener la información");
//
//				}
//
//			});

}





function ajaxSearchCourseFeedbackCourseOfTeacher() {
	
	
	$("#tableCourseFeedbackData")
	.append(
			"<tr>"
					+ "<td>"
					+ "asdasdsadasd"
					+ "</td> "
					+ "<td>"
					+ "sdfsdfsdfsdf"
					+ "</td> "
					+ "<td>"
					+ "xcvxcvxcvxcv"
					+ "</td> "
					+ "<td>"
					+ "ghjghjgj"
					+ "</td> "
					+ "<td>"
					+ "zxzxczczxc"
					+ "</td> "
					+ "<td>"
					+ "100"
					+ "</td> "
					+ "<td>"
					+ '<div class="actions"> '
					+ '<a class="button edit-button buttonUpdateCourseFeedbackToolbar">'
					+ '<ion-icon name="create"></ion-icon>'
					+ '</a>'
					+ '</div>'
					+ "</td> " + "</tr>");
	
	
	var courseId = arrayItemsStandardTable[0];
	var academicPeriod = arrayItemsStandardTable[1];
	var teacher = arrayItemsStandardTable[2];
	var subject = arrayItemsStandardTable[3];
	var groupId = arrayItemsStandardTable[4];
	var isVirtual = arrayItemsStandardTable[5];


	
	var json = {
			
			"courseId": courseId,
			"academicPeriod": academicPeriod,
			"teacher": teacher,
			"subject": subject,
			"groupId": groupId,
			"isVirtual": isVirtual

	}

		console.log(json);


//		$.ajax({
//					url : './Courses/',
//					data : JSON.stringify(json),
//					contentType : "application/json",
//					method : 'POST',
//					beforeSend : function() {
//
//					},
//					done : function() {
//
//					},
//					success : function(jsonResponse) {
//
//						if (typeof jsonResponse == "string") {
//
//							$('.content').fadeOut(0).html(jsonResponse).fadeIn(
//									'slow');
//
//							$('.error').show().fadeIn('slow');
//						}
//
//						console.log(jsonResponse);
//
//						if (jsonResponse.isValid) {
//
//							if (jsonResponse.errorMessage != null) {
//
//								$('#tableCourseFeedbackData').show().fadeOut('slow');
//
//								$('.error .message')
//										.text(jsonResponse.errorMessage);
//
//								$('.error').show().fadeIn('slow');
//
//							} else {
//
//								var buttonUpdateCourseFeedback = null;
//								
//								$.each(jsonResponse.objectEntityList,function(key, value) {
//													
//													if (!(jsonResponse.objectEntityList[key].feedBackType.description == "encuenta web")) {
//														
//														buttonUpdateCourseFeedback = "<td>"
//															+ '<div class="actions"> '
//															+ '<a class="button edit-button buttonUpdateCourseFeedbackToolbar">'
//															+ '<ion-icon name="create"></ion-icon>'
//															+ '</a>'
//															+ '</div>'
//															+ '</td> ';
//													}
//
//													$("#tableCourseFeedbackData").append("<tr>"
//																			+ "<td>"
//																			+ jsonResponse.objectEntityList[key].courseFeedBackId
//																			+ "</td> "
//																			+ "<td>"
//																			+ jsonResponse.objectEntityList[key].feedBackType.description
//																			+ "</td> "
//																			+ "<td>"
//																			+ jsonResponse.objectEntityList[key].comment
//																			+ "</td> "
//																			+ "<td>"
//																			+ jsonResponse.objectEntityList[key].user
//																			+ "</td> "
//																			+ "<td>"
//																			+ jsonResponse.objectEntityList[key].lastModifiedDate
//																			+ "</td> "
//																			+buttonUpdateCourseFeedback
//																			+ "</tr>");
//
//												})
//							}
//
//						} else {
//
//						}
//
//					},
//					complete : function() {
//
//					},
//					error : function() {
//
//						console.log("No se ha podido obtener la información");
//
//					}
//
//				});

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



