$(document).ready(function() {

	$('.success .close').click(function(event) {

		event.preventDefault();
		
		$('.success').show().fadeOut('slow');
		
	});
	
	
	$('#buttonUpdateSubject').click(function(event) {

		event.preventDefault();
		
		ajaxUpdateSubject();

	});



	
});



function ajaxUpdateSubject() {
	
	$('#disciplinaryAreaUpdateError').text('');
	$('#nameUpdateError').text('');
	$('#numberOfCreditsUpdateError').text('');
	$('#academicProgramUpdateError').text('');
	
	var subjectId  = $('#subjectIdUpdate').val('');
	var disciplinaryArea = $('#disciplinaryAreaUpdate').val('');
	var name = $('#nameUpdate').val('');
	var numberOfCredits = $('#numberOfCreditsUpdate').val('');
	var academicProgram = $('#academicProgramUpdate').val('');
	
	var json = {
			"subjectId": subjectId,
			"disciplinaryArea": disciplinaryArea,
			"name": name,
			"numberOfCredits": numberOfCredits,
			"academicProgram": academicProgram
			}
	
	console.log(json);
	
	$.ajax({
		url: "./Subjects/Update",
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
				
				$('#nameSearch').val($('#nameUpdate').val());
				
				$('#subjectIdUpdate').val('');
				$('#disciplinaryAreaUpdate').val('');
				$('#nameUpdate').val('');
				$('#numberOfCreditsUpdate').val('');
				$('#academicProgramUpdate').val('');
				
				$('.success .message').text(jsonResponse.successMessage);
				
				$('.success').show().fadeIn('slow');
				
				
				$.get('./Subjects/Data', function(view){
					
					$('.content').fadeOut(0).html(view).fadeIn('slow');

					ajaxSearchSubject();
					
					})
				
				
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






