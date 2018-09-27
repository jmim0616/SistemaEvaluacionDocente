$(document).ready(function() {

	AutocompleteForSubjectsCreate();
	AutocompleteForTeachersCreate();
	AutocompleteForAcademicPeriodsCreate();
	
	$('#buttonCreateCourse').click(function(event) {

		event.preventDefault();
		
		ajaxCreateCourse();

	});
	
	$('.createCourse #buttonCancel').click(function(event) {

		event.preventDefault();
		
		$('.createCourse .modalContainer').show().fadeOut('slow');

	});
	
	$('.createCourse #closeModal').click(function(event) {

		event.preventDefault();
		
		$('.createCourse .modalContainer').show().fadeOut('slow');

	});


	$('.success .close').click(function(event) {

		event.preventDefault();
		
		$('.success').show().fadeOut('slow');
		
	});
	
	$('.error .close').click(function(event) {

		event.preventDefault();

		$('.error').show().fadeOut('slow');

	});


	
});


function AutocompleteForSubjectsCreate() {

	$("#subjectCreate").autocomplete({
		source : arraySubjects
	});

}

function AutocompleteForTeachersCreate() {

	$("#teacherCreate").autocomplete({
		source : arrayTeachers
	});

}

function AutocompleteForAcademicPeriodsCreate() {

	$("#academicPeriodCreate").autocomplete({
		source : arrayAcademicPeriods
	});

}


function ajaxCreateCourse() {
	
	$('#groupIdCreateError').text('');
	$('#subjectCreateError').text('');
	$('#teacherCreateError').text('');
	$('#academicPeriodCreateError').text('');


	var groupId = $('#groupIdCreate').val();
	var subject = $('#subjectCreate').val();
	var teacher = $('#teacherCreate').val();
	var academicPeriod = $('#academicPeriodCreate').val();
	var isVirtual = $('#isVirtualCreate option:selected').val();

	
	var json = {
			
			"groupId": groupId,
			"subject": subject,
			"teacher": teacher,
			"academicPeriod": academicPeriod,
			"isVirtual": isVirtual

	}
	
	console.log(json);
	
	$.ajax({
		url: "./Courses/Create",
		data: JSON.stringify(json),
		contentType : "application/json",
		method: "POST",
		done: function(){

			
		},
		success: function(jsonResponse){
			
			if (typeof jsonResponse == "string") {
				
				$('.content').fadeOut(0).html(jsonResponse).fadeIn('slow');
				
				$('.error').show().fadeIn('slow');
			}
			
			console.log(jsonResponse);
			
			if (jsonResponse.isValid) {
				
				if (jsonResponse.errorMessage != null) {

					$('.error .message').text(jsonResponse.errorMessage);

					$('.error').show().fadeIn('slow');
					
					$('.createCourse .modalContainer').show().fadeOut('slow');

				} else {
				
				$('#groupIdSearch').val($('#groupIdCreate').val());
				$('#teacherSearch').val($('#teacherCreate').val());
				$('#subjectSearch').val($('#subjectCreate').val());
				$('#academicPeriodSearch').val($('#academicPeriodCreate').val());
				
				
				$('#groupIdCreate').val('');
				$('#subjectCreate').val('');
				$('#teacherCreate').val('');
				$('#academicPeriodCreate').val('');
				$('#isVirtualCreate option:selected').val('1');
			
				$('.success .message').text(jsonResponse.successMessage);
				
				$('.success').show().fadeIn('slow');
				
				$.get('./Courses/Data', function(view){
					
					$('.content').fadeOut(0).html(view).fadeIn('slow');

					ajaxSearchCourse();
					
					})
				
				}
				
			} else {
			
			$.each(jsonResponse.errorMessages, function(key,value) {
				
				$("#"+key+"CreateError").text(value);
				
			})
			
			}
			
		},
		error: function(){
			
			
		}
		
	});
	
	
	
}






