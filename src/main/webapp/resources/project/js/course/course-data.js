var arrayItemsStandardTable = null;

function initCourseData() {

	function obtainValuesTagTd(button) {

		var items = new Array();

		$(button).parents("tr").find("td").each(function(key, value) {

			items.push($(this).html());

		});

		console.log(items);

		arrayItemsStandardTable = items;

	}

	$('.buttonUpdateCourseToolbar').click(function(event) {

		event.preventDefault();

		obtainValuesTagTd(this);
		
		$('#groupIdUpdate').val(arrayItemsStandardTable[0]);
		$('#subjectUpdate').val(arrayItemsStandardTable[1]);
		$('#teacherUpdate').val(arrayItemsStandardTable[2]);
		$('#academicPeriodUpdate').val(arrayItemsStandardTable[3]);
		$('#isVirtualUpdate .actualValue').text(arrayItemsStandardTable[4]);
		
		$('.updateCourse .modalContainer').show().fadeIn('slow');

	});

	$('.buttonAddFeedbackCourseToolbar').click(function(event) {

		event.preventDefault();

		obtainValuesTagTd(this);

		$('#courseAdd').val(arrayItemsStandardTable[0]);
		
		$('.addFeedbackCourse .modalContainer').show().fadeIn('slow');
		
	});

	$('.buttonDeleteCourseToolbar').click(function(event) {

		event.preventDefault();

		obtainValuesTagTd(this);
		
		$('#groupIdDelete').val(arrayItemsStandardTable[0]);

		$('.deleteCourse .modalContainer').show().fadeIn('slow');


	});

	
	$('.buttonUpdateCourseFeedbackToolbar').click(function(event) {

		event.preventDefault();

		obtainValuesTagTd(this);

		$('#courseFeedBackIdUpdate').val(arrayItemsStandardTable[0]);
		$('#feedBackTypeUpdate').val(arrayItemsStandardTable[1]);
		$('#commentUpdate').val(arrayItemsStandardTable[2]);

		$('.updateCourseFeedback .modalContainer').show().fadeIn('slow');


	});
	
	
	$('.error .close').click(function(event) {

		event.preventDefault();

		$('.error').show().fadeOut('slow');

	});

}




