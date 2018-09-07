$(document).ready(function() {

	$('#buttonCancel').click(function(event) {

		event.preventDefault();
		
		$.get('./Users/Data', function(view, status, xhr){
			  $('.content').fadeOut(0).html(view).fadeIn('slow');
			}).done(function() {
				  ajaxSearchUser();
			  });
		
		$('.modalContainer').show().fadeOut('slow');

	});

	
	
	$('#closeModal').click(function(event) {
		
		event.preventDefault();
		
		$.get('./Users/Data', function(view, status, xhr){
			  $('.content').fadeOut(0).html(view).fadeIn('slow');
			}).done(function() {
				  ajaxSearchUser();
			  });

		
		$('.modalContainer').show().fadeOut('slow');

	});
	
	
	$('#buttonUpdateStatusUser').click(function(event) {

		event.preventDefault();
		
		ajaxUpdateUserStatus();

	});
	
	$('.success .close').click(function(event) {

		event.preventDefault();
		
		$('.success').show().fadeOut('slow');
		
	});
	
});



function ajaxUpdateUserStatus() {
	
	$('.modalContainer').show().fadeOut('slow');
	
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
			
			$('.modalContainer').show().fadeOut('slow');
			
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






