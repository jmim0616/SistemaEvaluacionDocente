$(document).ready(function() {

	$('#buttonCancel').click(function(event) {

		event.preventDefault();
		
		$('.modalContainer').show().fadeOut('slow');

	});
	
	$('#closeModal').click(function(event) {

		event.preventDefault();
		
		$('.modalContainer').show().fadeOut('slow');

	});
	
	
	$('#buttonUpdateAcademicProgram').click(function(event) {

		event.preventDefault();
		
		ajaxUpdateAcademicProgram();

	});

	
});



function ajaxUpdateAcademicProgram() {
	
	var academicProgramId = $('#academicProgramIdUpdate').val();
	var faculty = $('#facultyUpdate option:selected').text();
	var name = $('#nameUpdate').val();
	
	var json = {
			"academicProgramId": academicProgramId,
			"faculty": faculty,
			"name": name
			}
	
	console.log(json);
	
	$.ajax({
		url: "./AcademicPrograms/Update",
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






