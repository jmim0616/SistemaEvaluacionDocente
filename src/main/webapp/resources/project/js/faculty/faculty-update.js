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

	
});



function ajaxUpdateFaculty() {
	
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
			
			console.log(jsonResponse);
			
			$.each(jsonResponse.errorMessages, function(key,value) {
				
				$("#"+key+"UpdateError").text(value);
				
			})
			
		},
		error: function(){
			
			
		}
		
	});
	
	
	
}






