$(document).ready(function() {

	$('.updateDepartment #buttonCancel').click(function(event) {

		event.preventDefault();
		
		$('.updateDepartment .modalContainer').show().fadeOut('slow');

	});
	
	$('.updateDepartment #closeModal').click(function(event) {

		event.preventDefault();
		
		$('.updateDepartment .modalContainer').show().fadeOut('slow');

	});

	
	$('.success .close').click(function(event) {

		event.preventDefault();
		
		$('.success').show().fadeOut('slow');
		
	});
	
	$('#buttonUpdateDepartment').click(function(event) {

		event.preventDefault();
		
		ajaxUpdateDepartment();

	});

	
});



function ajaxUpdateDepartment() {
	
	$('#nameUpdateError').text('');
	
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
			
			if (typeof jsonResponse == "string") {

				$('.content').fadeOut(0).html(jsonResponse).fadeIn('slow');

				$('.error').show().fadeIn('slow');
			}

			console.log(jsonResponse);

			if (jsonResponse.isValid) {

				$('#nameUpdate').val('');

				$('.updateDepartment .modalContainer').show().fadeOut('slow');
				
				$('.success .message').text(jsonResponse.successMessage);
				
				$('.success').show().fadeIn('slow');
				
				$.get('./Departments/Data', function(view, status, xhr){
					  $('.content').fadeOut(0).html(view).fadeIn('slow');
					}).done(function() {
						ajaxSearchDepartment();
					  });

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





