$(document).ready(function() {

	
	$('#buttonCancel').click(function(event) {

		event.preventDefault();
		
		$('.modalContainer').show().fadeOut('slow');

	});
	
	$('#closeModal').click(function(event) {

		event.preventDefault();
		
		$('.modalContainer').show().fadeOut('slow');

	});
	
	$('#buttonCreateAcademicProgram').click(function(event) {

		event.preventDefault();
		
		ajaxCreateAcademicProgram();

	});

	
});



function ajaxCreateAcademicProgram() {
	
	var academicProgramId = $('#academicProgramIdCreate').val();
	var faculty = $('#facultyCreate option:selected').text();
	var name = $('#nameCreate').val();
	
	var json = {
			"academicProgramId": academicProgramId,
			"faculty": faculty,
			"name": name
			}
	
	console.log(json);
	
	$.ajax({
		url: "./AcademicPrograms/Create",
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






