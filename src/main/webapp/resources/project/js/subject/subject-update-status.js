$(document).ready(function() {

	$('#buttonCancel').click(function(event) {

		event.preventDefault();
		
		$('.modalContainer').show().fadeOut('slow');

	});

	
	
	$('#closeModal').click(function(event) {

		event.preventDefault();
		
		$('.modalContainer').show().fadeOut('slow');

	});
	
	
	$('#buttonUpdateStatusSubject').click(function(event) {

		event.preventDefault();
		
		ajaxUpdateSubjectStatus();

	});
	
	$('.success .close').click(function(event) {

		event.preventDefault();
		
		$('.success').show().fadeOut('slow');
		
	});
	
});



function ajaxUpdateSubjectStatus() {
	
	$('.modalContainer').show().fadeOut('slow');
	
	var subjectId = $('#subjectIdUpdateStatus').val();
	var subjectStatus = $('.status').text();
	
	var json = {
			
			"subjectId": subjectId,
			"subjectStatus": subjectStatus

			}
	
	console.log(json);
	
	$.ajax({
		url: "./Subjects/UpdateStatus",
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
			
			$('.modalContainer').show().fadeOut('slow');
			
			$('.success .message').text(jsonResponse.successMessage);
			
			$('.success').show().fadeIn('slow');
			
			
			$('#nameSearch').val($(arrayItemsStandardTable[2]).val());
			
			
			$.get('./Subjects/Data', function(view){
				
				$('.content').fadeOut(0).html(view).fadeIn('slow');

				ajaxSearchSubject();
				
				})
			
		},
		error: function(){
			
			
		}
		
	});
	
	
	
}






