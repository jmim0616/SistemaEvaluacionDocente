function initAddFeedbackCourse() {
	
	ajaxSearchCourseFeedbacks();
	
	$('#buttonAddFeedbackCourse').click(function(event) {

		event.preventDefault();

		ajaxAddFeedbackCourse();

	});

	$('.addFeedbackCourse #buttonCancel').click(function(event) {

		event.preventDefault();

		$('.addFeedbackCourse .modalContainer').show().fadeOut('slow');

	});

	$('.addFeedbackCourse #closeModal').click(function(event) {

		event.preventDefault();

		$('.addFeedbackCourse .modalContainer').show().fadeOut('slow');

	});



	$('.success .close').click(function(event) {

		event.preventDefault();

		$('.success').show().fadeOut('slow');

	});

	$('.error .close').click(function(event) {

		event.preventDefault();

		$('.error').show().fadeOut('slow');

	});

}

function ajaxSearchCourseFeedbacks() {
	
	var courseId = $('#courseAdd').val();
	
	var json = {
			"courseId" : courseId
		};
	
	console.log(json);
	
	$.ajax({
		url : "./Courses/ValidateCourseFeedbacksAdd",
		data : JSON.stringify(json),
		contentType : "application/json",
		method : "POST",
		done : function() {

		},
		success : function(jsonResponse) {

			if (typeof jsonResponse == "string") {

				$('.content').fadeOut(0).html(jsonResponse).fadeIn('slow');

				$('.error').show().fadeIn('slow');
			}

			console.log(jsonResponse);

				var estate = "";
			
				$.each(jsonResponse.variables, function(key, value) {

					if (value == "true"){
						estate = "disabled";
					}

					$("#feedBackTypeAdd").append(
							'<option value="" '+estate+' >'+ key + '</option>');

				})

		},
		error : function() {

		}

	});

}

function ajaxAddFeedbackCourse() {
	
	var groupId = $('#groupIdAdd').val();
	
	console.log("groupIdAdd " + groupId);

	$('#commentAddError').text('');

	var course = $('#courseAdd').val();
	var feedBackType = $('#feedBackTypeAdd option:selected').text();
	var comment = $('#commentAdd').val();

	var json = {

		"course" : course,
		"feedBackType" : feedBackType,
		"comment" : comment

	}

	console.log(json);

	$.ajax({
		url : "./Courses/AddFeedback",
		data : JSON.stringify(json),
		contentType : "application/json",
		method : "POST",
		done : function() {

		},
		success : function(jsonResponse) {

			if (typeof jsonResponse == "string") {

				$('.content').fadeOut(0).html(jsonResponse).fadeIn('slow');

				$('.error').show().fadeIn('slow');
			}

			console.log(jsonResponse);

			if (jsonResponse.isValid) {

				if (jsonResponse.errorMessage != null) {

					$('.error .message').text(jsonResponse.errorMessage);

					$('.error').show().fadeIn('slow');
					
					$('.addFeedbackCourse .modalContainer').show().fadeOut('slow');

				} else {

					$('#groupIdSearch').val($('#groupIdAdd').val());

					$('#commentAdd').val('');

					$('.success .message').text(jsonResponse.successMessage);

					$('.success').show().fadeIn('slow');

					$.get('./Courses/Data', function(view) {

						$('.content').fadeOut(0).html(view).fadeIn('slow');

						ajaxSearchCourse();

					})

				}

			} else {

				$.each(jsonResponse.errorMessages, function(key, value) {

					$("#" + key + "AddError").text(value);

				})

			}

		},
		error : function() {

		}

	});

}
