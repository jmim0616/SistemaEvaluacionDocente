$(document).ready(function() {

	$('#buttonCancel').click(function(event) {

		event.preventDefault();
		
		$('.modalContainer').show().fadeOut('slow');

	});
	
	$('#closeModal').click(function(event) {

		event.preventDefault();
		
		$('.modalContainer').show().fadeOut('slow');

	});
	
	
	$('#buttonUpdateDepartment').click(function(event) {

		event.preventDefault();
		
		ajaxUpdateDepartment();

	});

	
});



function ajaxUpdateDepartment() {
	
	var departmentId = $('#departmentIdUpdate').val();
	var name = $('#nameUpdate').val();
	
	var json = {
			"departmentId": departmentId,
			"name": name
			}
	
	console.log(json);
	
	$.ajax({
		url: "./Departments/Update",
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






