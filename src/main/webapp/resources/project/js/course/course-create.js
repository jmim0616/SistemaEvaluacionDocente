var arraySubjects = [];
var arrayTeachers = [];
var arrayAcademicPeriods = [];

$(document).ready(function() {
	
	ajaxSearchSubjects();
	ajaxSearchTeachers();
	ajaxSearchAcademicPeriods();
	
	$('.createCourse #buttonCancel').click(function(event) {

		event.preventDefault();
		
		$('.createCourse .modalContainer').show().fadeOut('slow');

	});
	
	$('.createCourse #closeModal').click(function(event) {

		event.preventDefault();
		
		$('.createCourse .modalContainer').show().fadeOut('slow');

	});


	
	$('#buttonCreateCourse').click(function(event) {

		event.preventDefault();
		
		ajaxCreateCourse();

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




function AutocompleteForSubjects() {

	$("#subjectCreate").autocomplete({
		source : arraySubjects
	});

}

function AutocompleteForTeachers() {

	$("#teacherCreate").autocomplete({
		source : arrayTeachers
	});

}

function AutocompleteForAcademicPeriods() {

	$("#academicPeriodCreate").autocomplete({
		source : arrayAcademicPeriods
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

			AutocompleteForSubjects();

		},
		error : function() {

			console.log("No se ha podido obtener la información");

		}

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

				$('.content').fadeOut(0).html(jsonResponse).fadeIn('slow');

				$('.error').show().fadeIn('slow');

			}

			console.log(jsonResponse);

			$.each(jsonResponse.objectEntityList, function(key, value) {

				arrayTeachers.push(JSON.stringify(jsonResponse.objectEntityList[key].teacherId));

			});
			
//			console.log(arrayTeachers);

		},
		complete : function() {

			AutocompleteForTeachers();

		},
		error : function() {

			console.log("No se ha podido obtener la información");

		}

	});

}


function ajaxSearchAcademicPeriods() {

	$.ajax({
		url : './Courses/GetAcademicPeriods',
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

				arrayAcademicPeriods.push(jsonResponse.objectEntityList[key].name);

			});

		},
		complete : function() {

			AutocompleteForAcademicPeriods();

		},
		error : function() {

			console.log("No se ha podido obtener la información");

		}

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






