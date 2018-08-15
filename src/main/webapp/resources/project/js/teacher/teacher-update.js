$(document).ready(function() {

	
	$('.success .close').click(function(event) {

		event.preventDefault();
		
		$('.success').show().fadeOut('slow');
		
	});
	
	$('.error .close').click(function(event) {

		event.preventDefault();

		$('.error').show().fadeOut('slow');

	});
	
	$('#buttonUpdateTeacher').click(function(event) {

		event.preventDefault();
		
		ajaxUpdateTeacher();

	});

	
});



function ajaxUpdateTeacher() {
	
	
	$('#teacherIdUpdateError').text('');
	$('#nameUpdateError').text('');
	$('#lastNameUpdateError').text('');
	$('#identificationTypeUpdateError option:selected').text('1');
	$('#underDegreeUpdateError').text('');
	$('#masterDegreeUpdateError').text('');
	$('#masterDegreeUpdateError').text('');
	$('#doctorDegreeUpdateError').text('');
	$('#institutionalMailUpdateError').text('');
	$('#personalMailUpdateError').text('');
	$('#cellNumberUpdateError').text('');
	$('#homeNumberUpdateError').text('');
	$('#experienceUpdateError').text('');
	
	var teacherId = $('#teacherIdUpdate').val();
	var name = $('#nameUpdate').val();
	var lastName = $('#lastNameUpdate').val();
	var identificationType = $('#identificationTypeUpdate option:selected').text();
	var underDegree = $('#underDegreeUpdate').val();
	var masterDegree = $('#masterDegreeUpdate').val();
	var masterDegree = $('#masterDegreeUpdate').val();
	var doctorDegree = $('#doctorDegreeUpdate').val();
	var institutionalMail = $('#institutionalMailUpdate').val();
	var personalMail = $('#personalMailUpdate').val();
	var cellNumber = $('#cellNumberUpdate').val();
	var homeNumber = $('#homeNumberUpdate').val();
	var experience = $('#experienceUpdate').val();
	
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
		url: "./Teachers/Update",
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
			
			if(jsonResponse.isValid) {
				
				if (jsonResponse.errorMessage != null) {

					$('.error .message').text(jsonResponse.errorMessage);

					$('.error').show().fadeIn('slow');

				} else {
			
				$('#teacherIdSearch').val($('#teacherIdUpdate').val());
				
				$('#teacherIdUpdate').val('');
				$('#nameUpdate').val('');
				$('#lastNameUpdate').val('');
				$('#identificationTypeUpdate option:selected').val('1');
				$('#underDegreeUpdate').val('');
				$('#masterDegreeUpdate').val('');
				$('#masterDegreeUpdate').val('');
				$('#doctorDegreeUpdate').val('');
				$('#institutionalMailUpdate').val('');
				$('#personalMailUpdate').val('');
				$('#cellNumberUpdate').val('');
				$('#homeNumberUpdate').val('');
				$('#experienceUpdate').val('');
			
				$('.success .message').text(jsonResponse.successMessage);
				
				$('.success').show().fadeIn('slow');
				
				$.get('./Teachers/Data', function(view){
					
					$('.content').fadeOut(0).html(view).fadeIn('slow');

					ajaxSearchTeacher();
					
					})
					
				}
			
			} else {

				$.each(jsonResponse.errorMessages, function(key,value) {
					
					$("#"+key+"UpdateError").text(value);
					
				})

			}
			
		},
		error: function(){
			
			
		}
		
	});
	
	
	
}






