$(document).ready(function() {

	$.get('./DisciplinaryAreas/Data', function(view, status, xhr){
		  $('.content').fadeOut(0).html(view).fadeIn('slow');
		}).done(function() {
			ajaxSearchDisciplinaryArea();
		  });

	$('#linkCreateDisciplinaryArea').click(function(event) {
		
		event.preventDefault();
		
		$('.createDisciplinaryArea .modalContainer').show().fadeIn('slow');
		
		
	});
	
	
	$('#linkSearchDisciplinaryArea').click(function(event) {

		event.preventDefault();
		
		$.get('./DisciplinaryAreas/Data', function(view, status, xhr){
			  $('.content').fadeOut(0).html(view).fadeIn('slow');
			}).done(function() {
				ajaxSearchDisciplinaryArea();
			  });

	});
	

	
});


function ajaxSearchDisciplinaryArea() {
	
	
	$.ajax({
		url: './DisciplinaryAreas/Search',
		contentType: 'application/json',
		method: 'POST',
			done: function() {
				

			},
			success: function(jsonResponse){
			
				if (typeof jsonResponse == "string") {

					$('.content').fadeOut(0).html(jsonResponse).fadeIn('slow');

					$('.error').show().fadeIn('slow');
				}

				console.log(jsonResponse);

				if (jsonResponse.errorMessage != null) {

					$('#tableDisciplinaryAreaData').show().fadeOut('slow');

					$('.error .message').text(jsonResponse.errorMessage);

					$('.error').show().fadeIn('slow');

				} else {

					$
							.each(
									jsonResponse.objectEntityList,
									function(key, value) {

										$("#tableDisciplinaryAreaData")
												.append(
														"<tr>"
																+ "<td>"
																+ jsonResponse.objectEntityList[key].disciplinaryAreaId
																+ "</td> "
																+ "<td>"
																+ jsonResponse.objectEntityList[key].faculty.name
																+ "</td> "
																+ "<td>"
																+ jsonResponse.objectEntityList[key].name
																+ "</td> "
																+ "<td>"
																   + '<div class="actions"> '+
																	 '<a class="button edit-button buttonUpdateDisciplinaryAreaToolbar">' +
																	 '<ion-icon name="create"></ion-icon>' +
																	 '</a>'+ 
																	  '</div>' 
																   + "</td> "
																+ "</tr>");

									})

				}
		
		},
		complete: function() {
			
			initDisciplinaryAreaData();
		},
	    error: function() {

	        console.log("No se ha podido obtener la información");

	    }
		
		
		
	});
	
}





