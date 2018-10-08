$(document).ready(function() {

	$('#buttonUpdateStatusUser').click(function(event) {

		event.preventDefault();
		
		ajaxUpdateUserStatus();

	});
	
	$('.updateUserStatus #buttonCancel').click(function(event) {

		event.preventDefault();
		
		$('.updateUserStatus .modalContainer').show().fadeOut('slow');

	});
	
	
	$('.updateUserStatus #closeModal').click(function(event) {
		
		event.preventDefault();

		$('.updateUserStatus .modalContainer').show().fadeOut('slow');

	});

	
	$('.success .close').click(function(event) {

		event.preventDefault();
		
		$('.success').show().fadeOut('slow');
		
	});
	
});



function ajaxUpdateUserStatus() {
	
	var userId = $('#userIdUpdateStatus').val();
	var userStatus = $('.status').text();
	
	if (userStatus == "Activo"){
		userStatus = 1;
	}
	if (userStatus == "Inactivo"){
		userStatus = 2;
	}
	
	var json = {
			"userId": userId,
			"status": userStatus

			}
	
	console.log(json);
	
	$.ajax({
		url: "./Users/UpdateStatus",
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
			
			$('.success .message').text(jsonResponse.successMessage);
			
			$('.success').show().fadeIn('slow');
			
			$.get('./Users/Data', function(view){
				
				$('.content').fadeOut(0).html(view).fadeIn('slow');

				ajaxSearchUser();
				
				})
			
		},
		error: function(){
			
			
		}
		
	});
	
	
	
}






