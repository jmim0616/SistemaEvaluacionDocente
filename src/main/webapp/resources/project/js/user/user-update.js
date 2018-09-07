$(document).ready(function() {
	
	$('.updateUser #buttonCancel').click(function(event) {

		event.preventDefault();
		
		$('.updateUser .modalContainer').show().fadeOut('slow');

	});
	
	$('.updateUser #closeModal').click(function(event) {

		event.preventDefault();
		
		$('.updateUser .modalContainer').show().fadeOut('slow');

	});

	$('.success .close').click(function (event){
		
		event.preventDefault();
		
		$('.success').show().fadeOut('slow');
		
	}); 
	
	
	$('#buttonUpdateUser').click(function(event) {

		event.preventDefault();
		
		ajaxUpdateUser();

	});

	
});



function ajaxUpdateUser() {
	
	
	$('#maskUpdateError').text('');
	$('#passwordUpdateError').text('');
	$('#nameUpdateError').text('');
	$('#institutionalMailUpdateError').text('');
	$('#personalMailUpdateError').text('');
	
	var userId = $('#userIdUpdate').val();
	var mask = $('#maskUpdate').val();
	var name = $('#nameUpdate').val();
	var password = $('#passwordUpdate').val();
	var institutionalMail = $('#institutionalMailUpdate').val();
	var personalMail = $('#personalMailUpdate').val();
	var status = $('#status').val();
	var userType = $('#userTypeUpdate').val();
	var jobPosition = $('#jobPositionUpdate').val();
	
	if (jobPosition == "Jefe de departamento"){
		jobPosition = 1;
	}
	else{
		jobPosition = 2;
	}
	
	if (status == "Activo"){
		status = 1;
	}
	else{
		status = 2;
	}
	
	var json = {
			"userId": userId,
			"mask": mask,
			"name": name,
			"password": password,
			"institutionalMail": institutionalMail,
			"personalMail": personalMail,
			"status": status,
			"userType" : userType,
			"jobPosition" : jobPosition
			}
	
	console.log(json);
	
	$.ajax({
		url: "./Users/Update",
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
				
				$('#userIdUpdate').val('');
				$('#maskUpdate').val('');
				$('#nameUpdate').val('');
				$('#passwordUpdate').val('');
				$('#institutionalMailUpdate').val('');
				$('#personalMailUpdate').val('');
				$('#status').val('');
				$('#userTypeUpdate').val('');
				$('#jobPositionUpdate').val('');
			
				$('.success .message').text(jsonResponse.successMessage);
				
				$('.success').show().fadeIn('slow');
				
				$.get('./Users/Data', function(view){
					
					$('.content').fadeOut(0).html(view).fadeIn('slow');

					ajaxSearchUser();
					
					})
					
				
			
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






