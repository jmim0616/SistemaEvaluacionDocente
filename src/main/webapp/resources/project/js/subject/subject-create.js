$(document).ready(function() {

	$('.success .close').click(function(event) {

		event.preventDefault();
		
		$('.success').show().fadeOut('slow');
		
	});
	
	
	$('#buttonCreateSubject').click(function(event) {

		event.preventDefault();
		
		ajaxCreateSubject();

	});



	
});



function ajaxCreateSubject() {
	
	$('#disciplinaryAreaCreateError').text('');
	$('#nameCreateError').text('');
	$('#numberOfCreditsCreateError').text('');
	$('#academicProgramCreateError').text('');
	
	var disciplinaryArea = $('#disciplinaryAreaCreate').val('');
	var name = $('#nameCreate').val('');
	var numberOfCredits = $('#numberOfCreditsCreate').val('');
	var academicProgram = $('#academicProgramCreate').val('');
	
	var json = {
			"disciplinaryArea": disciplinaryArea,
			"name": name,
			"numberOfCredits": numberOfCredits,
			"academicProgram": academicProgram
			}
	
	console.log(json);
	
	$.ajax({
		url: "./Subjects/Create",
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
				
				$('#nameSearch').val($('#nameCreate').val());
				
				$('#disciplinaryAreaCreate').val('');
				$('#nameCreate').val('');
				$('#numberOfCreditsCreate').val('');
				$('#academicProgramCreate').val('');
				
				$('.success .message').text(jsonResponse.successMessage);
				
				$('.success').show().fadeIn('slow');
				
				
				$.get('./Subjects/Data', function(view){
					
					$('.content').fadeOut(0).html(view).fadeIn('slow');

					ajaxSearchSubject();
					
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






