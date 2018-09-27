$(document).ready(function() {

	$('#buttonUpdateCourseFeedback').click(function(event) {

		event.preventDefault();
		
		ajaxUpdateCourseFeedback();

	});

	
	$('.updateCourseFeedback #buttonCancel').click(function(event) {

		event.preventDefault();
		
		$('.updateCourseFeedback .modalContainer').show().fadeOut('slow');

	});
	
	$('.updateCourseFeedback #closeModal').click(function(event) {

		event.preventDefault();
		
		$('.updateCourseFeedback .modalContainer').show().fadeOut('slow');

	});

	
	$('.success .close').click(function(event) {

		event.preventDefault();
		
		$('.success').show().fadeOut('slow');
		
	});
	
	$('.error .close').click(function(event) {

		event.preventDefault();

		$('.error').show().fadeOut('slow');

	});
	

	
});



function ajaxUpdateCourseFeedback() {
	
	$('#commentUpdateError').text('');
	
	var courseFeedBackId = $('#courseFeedBackIdUpdate').val();
	var comment = $('#commentUpdate').val();
	
	var json = {
			
			"courseFeedBackId": courseFeedBackId,
			"comment": comment
			
			}
	
	console.log(json);
	
	$.ajax({
		url: "./CourseFeedbacks/Update",
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
				
				if (jsonResponse.errorMessage != null) {

					$('.error .message').text(jsonResponse.errorMessage);

					$('.error').show().fadeIn('slow');
					
					$('.updateCourseFeedback .modalContainer').show().fadeOut('slow');

				} else {
				
				$('#commentUpdate').val('');
				
				$('.success .message').text(jsonResponse.successMessage);
				
				$('.success').show().fadeIn('slow');
				
//				$.get('./Courses/Data', function(view, status, xhr){
//					  $('.content').fadeOut(0).html(view).fadeIn('slow');
//					}).done(function() {
//						ajaxSearchDepartment();
//					  });

			}
				
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






