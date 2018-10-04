var arrayItemsStandardTable = null;

var tableIdClicked = null;

var classTdTableClicked = null;



function initCourseData() {

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

	$('.buttonUpdateCourseToolbar').click(function(event) {

		event.preventDefault();

		obtainValuesTdActions(this);
		
		$('#groupIdUpdate').val(arrayItemsStandardTable[0]);
		$('#subjectUpdate').val(arrayItemsStandardTable[1]);
		$('#teacherUpdate').val(arrayItemsStandardTable[2]);
		$('#academicPeriodUpdate').val(arrayItemsStandardTable[3]);
		$('#isVirtualUpdate .actualValue').text(arrayItemsStandardTable[4]);
		
		$('.updateCourse .modalContainer').show().fadeIn('slow');

	});

	$('.buttonAddFeedbackCourseToolbar').click(function(event) {

		event.preventDefault();

		obtainValuesTdActions(this);

		$('#courseAdd').val(arrayItemsStandardTable[0]);
		
		$('.addFeedbackCourse .modalContainer').show().fadeIn('slow');
		
	});

	$('.buttonDeleteCourseToolbar').click(function(event) {

		event.preventDefault();

		obtainValuesTdActions(this);
		
		$('#groupIdDelete').val(arrayItemsStandardTable[0]);

		$('.deleteCourse .modalContainer').show().fadeIn('slow');


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

		if (tableIdClicked == "tableCourseData") {
			
			ajaxSearchCourseFeedbackOfCourse();

		}


	}

}


function ajaxSearchCourseFeedbackOfCourse() {
	
	
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

//		$
//				.ajax({
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
//													$("#tableCourseFeedbackData")
//															.append(
//																	"<tr>"
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


