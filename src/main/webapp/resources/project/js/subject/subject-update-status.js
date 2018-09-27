$(document).ready(function() {

	$('#buttonUpdateStatusSubject').click(function(event) {

		event.preventDefault();
		
		ajaxUpdateSubjectStatus();

	});
	
	$('.updateSubjectStatus #buttonCancel').click(function(event) {

		event.preventDefault();
		
		$('.updateSubjectStatus .modalContainer').show().fadeOut('slow');

	});
	
	
	$('.updateSubjectStatus #closeModal').click(function(event) {

		event.preventDefault();
		
		$('.updateSubjectStatus .modalContainer').show().fadeOut('slow');

	});

	
	$('.success .close').click(function(event) {

		event.preventDefault();
		
		$('.success').show().fadeOut('slow');
		
	});
	
	
});



function ajaxUpdateSubjectStatus() {
	
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
			

			$('.success .message').text(jsonResponse.successMessage);
			
			$('.success').show().fadeIn('slow');
			
			$('#nameSearch').val(jsonResponse.objectBean.name);

			$.get('./Subjects/Data', function(view){
				
				$('.content').fadeOut(0).html(view).fadeIn('slow');

				ajaxSearchSubject();
				
				})
				
			
		},
		error: function(){
			
			
		}
		
	});
	
	
	
}






