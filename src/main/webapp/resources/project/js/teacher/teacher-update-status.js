$(document).ready(function() {

	$('#buttonCancel').click(function(event) {

		event.preventDefault();
		
		$('.modalContainer').show().fadeOut('slow');

	});

	
	
	$('#closeModal').click(function(event) {

		event.preventDefault();
		
		$('.modalContainer').show().fadeOut('slow');

	});
	
	
	$('#buttonUpdateStatusTeacher').click(function(event) {

		event.preventDefault();
		
		ajaxUpdateTeacherStatus();

	});
	
	$('.success .close').click(function(event) {

		event.preventDefault();
		
		$('.success').show().fadeOut('slow');
		
	});
	
});



function ajaxUpdateTeacherStatus() {
	
	$('.modalContainer').show().fadeOut('slow');
	
	var teacherId = $('#teacherIdUpdateStatus').val();
	var teacherStatus = $('.status').text();
	
	var json = {
			"teacherId": teacherId,
			"teacherStatus": teacherStatus

			}
	
	console.log(json);
	
	$.ajax({
		url: "./Teachers/UpdateStatus",
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
			
			$('#teacherIdSearch').val($('#teacherIdUpdateStatus').val());
			
			$.get('./Teachers/Data', function(view){
				
				$('.content').fadeOut(0).html(view).fadeIn('slow');

				ajaxSearchTeacher();
				
				})
			
		},
		error: function(){
			
			
		}
		
	});
	
	
	
}






