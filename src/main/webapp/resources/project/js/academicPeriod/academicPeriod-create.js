$(document).ready(function() {

	$('.success .close').click(function(event) {

		event.preventDefault();
		
		$('.success').show().fadeOut('slow');
		
	});
	
	
	$('#buttonCreateAcademicPeriod').click(function(event) {

		event.preventDefault();
		
		ajaxCreateAcademicPeriod();

	});



	
});



function ajaxCreateAcademicPeriod() {
	
	$('#nameCreateError').text('');
	$('#initialDateCreateError').text('');
	$('#endDateCreateError').text('');

	var name = $('#nameCreate').val();
	var initialDate = $('#initialDateCreate').val();
	var endDate = $('#endDateCreate').val();
	
	var json = {
			"name": name,
			"initialDate": initialDate,
			"endDate": endDate
			}
	
	console.log(json);
	
	$.ajax({
		url: "./AcademicPeriods/Create",
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
				
				$('#nameCreate').val('');
				$('#initialDateCreate').val('');
				$('#endDateCreate').val('');
				
				$('.success .message').text(jsonResponse.successMessage);
				
				$('.success').show().fadeIn('slow');
				
				
				$.get('./AcademicPeriods/Data', function(view){
					
					$('.content').fadeOut(0).html(view).fadeIn('slow');

					ajaxSearchAcademicPeriod();
					
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






