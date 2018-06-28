$(document).ready(function() {

	
	$('#buttonCancel').click(function(event) {

		event.preventDefault();
		
		$('.modalContainer').show().fadeOut('slow');

	});
	
	$('#closeModal').click(function(event) {

		event.preventDefault();
		
		$('.modalContainer').show().fadeOut('slow');

	});
	
	$('#buttonCreateDepartment').click(function(event) {

		event.preventDefault();
		
		ajaxCreateDepartment();

	});

	
});



function ajaxCreateDepartment() {
	
	var departmentId = $('#departmentIdCreate').val();
	var name = $('#nameCreate').val();
	
	var json = {
			"departmentId": departmentId,
			"name": name
			}
	
	console.log(json);
	
	$.ajax({
		url: "./Departments/Create",
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






