$(document).ready(function() {

	$('#buttonCancel').click(function(event) {

		event.preventDefault();
		
		$('.modalContainer').show().fadeOut('slow');

	});
	
	$('#closeModal').click(function(event) {

		event.preventDefault();
		
		$('.modalContainer').show().fadeOut('slow');

	});
	
	
	$('#buttonUpdateDisciplinaryArea').click(function(event) {

		event.preventDefault();
		
		ajaxUpdateDisciplinaryArea();

	});

	
});



function ajaxUpdateDisciplinaryArea() {
	
	var disciplinaryAreaId = $('#disciplinaryAreaIdUpdate').val();
	var faculty = $('#facultyUpdate option:selected').text();
	var name = $('#nameUpdate').val();
	
	var json = {
			"disciplinaryAreaId": disciplinaryAreaId,
			"faculty": faculty,
			"name": name
			}
	
	console.log(json);
	
	$.ajax({
		url: "./DisciplinaryAreas/Update",
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






