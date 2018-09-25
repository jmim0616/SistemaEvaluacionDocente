var arrayItemsStandardTable = null;
	
function initCourseData() {

	
	function obtainValuesTagTd(button){
		
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
		
		ajaxShowUpdateCourse();

	});
	
	
	$('.buttonAddFeedbackCourseToolbar').click(function(event) {

		event.preventDefault();
		
		obtainValuesTagTd(this);
		
		ajaxShowAddFeedbackCourse();

	});
	
	$('.buttonDeleteCourseToolbar').click(function(event) {

		event.preventDefault();
		
		obtainValuesTagTd(this);
		
		ajaxShowDeleteCourse();

	});

	
	$('.error .close').click(function(event) {

		event.preventDefault();
		
		$('.error').show().fadeOut('slow');
		
	});

	
}


function ajaxShowUpdateCourse() {
	
	$.ajax({ 
		url : "./Courses/Update",
		method : 'GET',
        beforeSend: function(xhr) {
        	
        },
        success: function(view) {
		
			$('.content').fadeOut(0).html(view).fadeIn('slow');
			
			$('#groupIdUpdate').val(arrayItemsStandardTable[0]);
			$('#subjectUpdate').val(arrayItemsStandardTable[1]);
			$('#teacherUpdate').val(arrayItemsStandardTable[2]);
			$('#academicPeriodUpdate').val(arrayItemsStandardTable[3]);
//			$('#identificationTypeUpdate option:selected').text(arrayItemsStandardTable[3]);
			$('#isVirtualUpdate .actualValue').text(arrayItemsStandardTable[4]);
			
		}
		
	});

}



function ajaxShowAddFeedbackCourse() {
	
	var groupId = arrayItemsStandardTable[0];
	
	var json = {
			
			"groupId": groupId

			}
	
	$.ajax({ 
		url : "./Courses/AddFeedback",
		data: json,
		contentType : "application/json",
		method : 'GET',
        beforeSend: function(xhr) {
        	
        },
        success: function(view) {
		
			$('.content').fadeOut(0).html(view).fadeIn('slow');

			$('.addFeedbackCourse .modalContainer').show().fadeIn('slow');
			
		}
		
	});

}

function ajaxShowDeleteCourse() {
		
	
	var groupId = arrayItemsStandardTable[0];
	
	var json = {
			
			"groupId": groupId

			}
	
		$.ajax({ 
			url : "./Courses/Delete",
			data: json,
			contentType : "application/json",
			method : 'GET',
	        beforeSend: function(xhr) {
	        	
	        },
	        success: function(view) {
			
				$('.content').fadeOut(0).html(view).fadeIn('slow');
				
				$('#dialogModal .status').text(arrayItemsStandardTable[13]);

				$('.updateTeacherStatus .modalContainer').show().fadeIn('slow');
				
			}
			
		});

	}



