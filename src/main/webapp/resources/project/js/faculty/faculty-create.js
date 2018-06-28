$(document).ready(function() {

	
	$('#buttonCancel').click(function(event) {

		event.preventDefault();
		
		$('.modalContainer').show().fadeOut('slow');

	});
	
	$('#closeModal').click(function(event) {

		event.preventDefault();
		
		$('.modalContainer').show().fadeOut('slow');

	});
	
	$('#buttonCreateFaculty').click(function(event) {

		event.preventDefault();
		
		ajaxCreateFaculty();

	});

	
});



function ajaxCreateFaculty() {
	
	var facultyId = $('#facultyIdCreate').val();
	var department = $('#departmentCreate option:selected').text();
	var name = $('#nameCreate').val();
	
	var json = {
			"facultyId": facultyId,
			"department": department,
			"name": name
			}
	
	console.log(json);
	
	$.ajax({
		url: "./Faculties/Create",
		data: JSON.stringify(json),
		contentType : "application/json",
		method: "POST",
		done: function(){

			
		},
		success: function(jsonResponse){
			
			console.log(jsonResponse);
			
			$.each(jsonResponse.errorMessages, function(key,value) {
				
				$("#"+key+"CreateError").text(value);
				
			})
			
		},
		error: function(){
			
			
		}
		
	});
	
	
	
}






