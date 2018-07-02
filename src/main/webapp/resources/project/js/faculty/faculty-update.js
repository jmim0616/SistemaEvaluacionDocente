$(document).ready(function() {

	$('#buttonCancel').click(function(event) {

		event.preventDefault();
		
		$('.modalContainer').show().fadeOut('slow');

	});
	
	$('#closeModal').click(function(event) {

		event.preventDefault();
		
		$('.modalContainer').show().fadeOut('slow');

	});
	
	
	$('#buttonUpdateFaculty').click(function(event) {

		event.preventDefault();
		
		ajaxUpdateFaculty();

	});

	$('.success .close').click(function (event){
		
		event.preventDefault();
		
		$('.success').show().fadeOut('slow');
		
	}); 
	
});



function ajaxUpdateFaculty() {
	
	$('#nameUpdateError').text('');
	
	var facultyId = $('#facultyIdUpdate').val();
	var department = $('#departmentUpdate option:selected').text();
	var name = $('#nameUpdate').val();
	
	var json = {
			"facultyId": facultyId,
			"department": department,
			"name": name
			}
	
	console.log(json);
	
	$.ajax({
		url: "./Faculties/Update",
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
				
				$('#nameUpdate').val('');
				
				$('.success .message').text(jsonResponse.successMessage);
				
				$('.success').show().fadeIn('slow');
				
				$('.modalContainer').show().fadeOut('slow');
				
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






