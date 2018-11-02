var arrayItemsStandardTable = null;

var tableIdClicked = null;

var classTdTableClicked = null;

function initCourseData() {

	obtainValuesTdSearch();

	function obtainValuesTdSearch() {

		$('.data').on('click', '.standard-table tr td', function(e) {

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

	$('.buttonUpdateCourseToolbar').click(function(event) {

		event.preventDefault();

		obtainValuesTdActions(this);

		$('#courseIdUpdate').val(arrayItemsStandardTable[0]);
		$('#groupIdUpdate').val(arrayItemsStandardTable[4]);
		$('#subjectUpdate').val(arrayItemsStandardTable[3]);
		$('#teacherUpdate').val(arrayItemsStandardTable[2]);
		$('#academicPeriodUpdate').val(arrayItemsStandardTable[1]);
		$('#isVirtualUpdate .actualValue').text(arrayItemsStandardTable[5]);

		$('.updateCourse .modalContainer').show().fadeIn('slow');

	});

	$('.buttonAddFeedbackCourseToolbar').click(function(event) {

		event.preventDefault();

		obtainValuesTdActions(this);

		$('#courseAdd').val(arrayItemsStandardTable[0]);
		$('#groupIdAdd').val(arrayItemsStandardTable[4]);

		$('.addFeedbackCourse .modalContainer').show().fadeIn('slow');

		initAddFeedbackCourse();

	});

	$('.buttonDeleteCourseToolbar').click(function(event) {

		event.preventDefault();

		obtainValuesTdActions(this);

		$('#courseIdDelete').val(arrayItemsStandardTable[0]);

		$('.deleteCourse .modalContainer').show().fadeIn('slow');

	});

	$('.data').on(
			'click',
			'.buttonUpdateCourseFeedbackToolbar',
			function(event) {

				event.preventDefault();

				obtainValuesTdActions(this);

				$('#courseFeedBackIdUpdate').val(arrayItemsStandardTable[0]);
				$('#feedBackTypeUpdate').text(arrayItemsStandardTable[1]);
				$('#commentUpdate').val(arrayItemsStandardTable[2]);

				$('.updateCourseFeedback .modalContainer').show()
						.fadeIn('slow');

			});

	$('.error .close').click(function(event) {

		event.preventDefault();

		$('.error').show().fadeOut('slow');

	});

	$('#linkCreateCourse').click(function(event) {

		event.preventDefault();

		$('.createCourse .modalContainer').show().fadeIn('slow');

	});

}

function chooseTypeOfQuery() {

	if ((classTdTableClicked == "column") || (tableIdClicked != null)) {

		if (tableIdClicked == "tableCourseData") {

			ajaxSearchCourseFeedbackOfCourse();

		}

	}

}

function ajaxSearchCourseFeedbackOfCourse() {
	
	var courseId = arrayItemsStandardTable[0];
	var academicPeriod = arrayItemsStandardTable[1];
	var teacher = arrayItemsStandardTable[2];
	var subject = arrayItemsStandardTable[3];
	var groupId = arrayItemsStandardTable[4];
	var isVirtual = arrayItemsStandardTable[5];

	var json = {

		"courseId" : courseId,
		"academicPeriod" : academicPeriod,
		"teacher" : teacher,
		"subject" : subject,
		"group" : groupId,
		"isVirtual" : isVirtual

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
																+  "<td>"
																+ '<div class="actions"> '
																+ '<a class="button edit-button buttonUpdateCourseFeedbackToolbar">'
																+ '<ion-icon name="create"></ion-icon>'
																+ '</a>'
																+ '</div>'
																+ '</td> ';
														}
	
														$("#tableCourseFeedbackData")
																.append(
																		"<tr class='fila' >"
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
																				+ jsonResponse.objectEntityList[key].lastModifiedDate
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
