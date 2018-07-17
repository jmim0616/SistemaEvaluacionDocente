$(document).ready(function() {

	$('.success .close').click(function(event) {

		event.preventDefault();
		
		$('.success').show().fadeOut('slow');
		
	});
	
	
	$('#buttonCreateTeacher').click(function(event) {

		event.preventDefault();
		
		ajaxCreateTeacher();

	});



	
});



function ajaxCreateTeacher() {
	
	$('#teacherIdCreateError').text('');
	$('#nameCreateError').text('');
	$('#lastNameCreateError').text('');
	$('#identificationTypeCreateError option:selected').text('1');
	$('#underDegreeCreateError').text('');
	$('#masterDegreeCreateError').text('');
	$('#masterDegreeCreateError').text('');
	$('#doctorDegreeCreateError').text('');
	$('#institutionalMailCreateError').text('');
	$('#personalMailCreateError').text('');
	$('#cellNumberCreateError').text('');
	$('#homeNumberCreateError').text('');
	$('#experienceCreateError').text('');
	
	var teacherId = $('#teacherIdCreate').val();
	var name = $('#nameCreate').val();
	var lastName = $('#lastNameCreate').val();
	var identificationType = $('#identificationTypeCreate option:selected').val();
	var underDegree = $('#underDegreeCreate').val();
	var masterDegree = $('#masterDegreeCreate').val();
	var masterDegree = $('#masterDegreeCreate').val();
	var doctorDegree = $('#doctorDegreeCreate').val();
	var institutionalMail = $('#institutionalMailCreate').val();
	var personalMail = $('#personalMailCreate').val();
	var cellNumber = $('#cellNumberCreate').val();
	var homeNumber = $('#homeNumberCreate').val();
	var experience = $('#experienceCreate').val();
	
	var json = {
			"teacherId": teacherId,
			"name": name,
			"lastName": lastName,
			"identificationType": identificationType,
			"underDegree": underDegree,
			"masterDegree": masterDegree,
			"doctorDegree": doctorDegree,
			"institutionalMail": institutionalMail,
			"personalMail": personalMail,
			"cellNumber": cellNumber,
			"homeNumber": homeNumber,
			"experience": experience
			}
	
	console.log(json);
	
	$.ajax({
		url: "./Teachers/Create",
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
				
				$('#teacherIdSearch').val($('#teacherIdCreate').val());
				
				$('#teacherIdCreate').val('');
				$('#nameCreate').val('');
				$('#lastNameCreate').val('');
				$('#identificationTypeCreate option:selected').val('1');
				$('#underDegreeCreate').val('');
				$('#masterDegreeCreate').val('');
				$('#masterDegreeCreate').val('');
				$('#doctorDegreeCreate').val('');
				$('#institutionalMailCreate').val('');
				$('#personalMailCreate').val('');
				$('#cellNumberCreate').val('');
				$('#homeNumberCreate').val('');
				$('#experienceCreate').val('');
				
				
				$('.success .message').text(jsonResponse.successMessage);
				
				$('.success').show().fadeIn('slow');
				
				
				$.get('./Teachers/Data', function(view){
					
					$('.content').fadeOut(0).html(view).fadeIn('slow');

					ajaxSearchTeacher();
					
					})
				
				
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






