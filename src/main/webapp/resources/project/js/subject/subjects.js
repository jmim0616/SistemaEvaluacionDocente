$(document).ready(function() {

	
	$('.sub-menu-content').click(function(e) {

		e.preventDefault();

		$(this).addClass('true');
		


	});
	
	$('.container').click(function(e) {

		e.preventDefault();

		$('.sub-menu-content').removeClass('true');
		

	});

	
	$('#linkCreateSubject').click(function(event) {
		
		event.preventDefault();

		$('.content').fadeOut(0).load('./Subjects/Create').fadeIn('slow');
		
	});
	
	
	$('#linkCreateExcelSubject').click(function(event) {
		
		event.preventDefault();

		$('.content').fadeOut(0).load('./Subjects/CreateExcel').fadeIn('slow');
		
	});
	

	$('#buttonSearchSubject').click(function(event) {

		event.preventDefault();
		

		$.get('./Subjects/Data', function(view){
			
			$('.content').fadeOut(0).html(view).fadeIn('slow');

			ajaxSearchSubject();
			
			})
			
			
		
	});
	

	
});



function ajaxSearchSubject() {
	
	$('#nameSearchError').text("");
	
	var nameSearch = $('#nameSearch').val();
	
	var json = {
		"name": "nameSearch",
	};
	
	$.ajax({
		url: './Subjects/Search',
		data: JSON.stringify(json),
		contentType : "application/json",
		method: 'POST',
			beforeSend: function () {
				
				
			}, 
			done: function() {
				
			},
			success: function(jsonResponse){
			
				if (typeof jsonResponse == "string") {
					
					$('.content').fadeOut(0).html(jsonResponse).fadeIn('slow');
					
					$('.error').show().fadeIn('slow');
			}
				
				console.log(jsonResponse);
				
				if (jsonResponse.isValid) {
										
					
					if (jsonResponse.errorMessage != null) {
						
						$('#tableSubjectData').show().fadeOut('slow');
						
						$('.error .message').text(jsonResponse.errorMessage);
						
						$('.error').show().fadeIn('slow');
						
					} else {
						
						$("#tableSubjectData").append(
								"<tr>" +
								"<td>"+ jsonResponse.objectBean.subjectId +"</td> " +
								"<td>"+ jsonResponse.objectBean.disciplinaryArea +"</td> " +
								"<td>"+ jsonResponse.objectBean.name +"</td> " +
								"<td>"+ jsonResponse.objectBean.numberOfCredits +"</td> " +
								"<td>"+ jsonResponse.objectBean.subjectStatus +"</td> " +
								"<td>"+ jsonResponse.objectBean.academicProgram +"</td> " +
								"<td>"+ '<div class="actions"> '+
										 '<a class="button edit-button buttonUpdateSubjectToolbar">' +
										 '<ion-icon name="create"></ion-icon>' +
										 '</a>'+ 
										  '<a class="button inactivate-button buttonUpdateStateSubjectToolbar">' +
										  '<ion-icon name="remove-circle"></ion-icon>' +
										  '</a>' +
										  '</div>' +
										  "</td> " +
								"</tr>");

					
					}
					
				} else {
					
					$('#nameSearchError').append(jsonResponse.errorMessages.name);
				}



			
		},
		complete: function() {

			initSubjectData();
			
		},
	    error: function() {

	        console.log("No se ha podido obtener la información");

	    }
		
		
		
	});
	
}



