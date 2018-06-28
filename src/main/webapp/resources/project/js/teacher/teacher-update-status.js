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
		
		
//		ajaxUpdateTeacher();

	});
	
	
});



function ajaxUpdateTeacher() {
	
	var teacherId = $('#teacherIdUpdate').val();
	
	var json = {
			"teacherId": teacherId,

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
			
			console.log(jsonResponse);
			
			$.each(jsonResponse.errorMessages, function(key,value) {
				
				$("#"+key+"UpdateError").text(value);
				
			})
			
		},
		error: function(){
			
			
		}
		
	});
	
	
	
}






