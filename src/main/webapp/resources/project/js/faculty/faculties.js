$(document).ready(function() {
	
	$.get('./Faculties/Data', function(view, status, xhr){
		  $('.content').fadeOut(0).html(view).fadeIn('slow');
		}).done(function() {
			  ajaxSearchFaculty();
		  });
	
	
	$('#linkCreateFaculty').click(function(event) {

		event.preventDefault();

		$('.createFaculty .modalContainer').show().fadeIn('slow');

	});

	$('#linkSearchFaculty').click(function(event) {

		event.preventDefault();

		$.get('./Faculties/Data', function(view, status, xhr){
			  $('.content').fadeOut(0).html(view).fadeIn('slow');
			}).done(function() {
				  ajaxSearchFaculty();
			  });

	});

});

function ajaxSearchFaculty() {

				$.ajax({
				url : './Faculties/Search',
				contentType : 'application/json',
				method : 'POST',
				done : function() {

				},
				success : function(jsonResponse) {

					if (typeof jsonResponse == "string") {

						$('.content').fadeOut(0).html(jsonResponse).fadeIn(
								'slow');

						$('.error').show().fadeIn('slow');
					}

					console.log(jsonResponse);

					if (jsonResponse.errorMessage != null) {

						$('#tableFacultyData').show().fadeOut('slow');

						$('.error .message').text(jsonResponse.errorMessage);

						$('.error').show().fadeIn('slow');

					} else {

						$.each(jsonResponse.objectEntityList, function(key, value) {

											$("#tableFacultyData")
													.append(
												"<tr>"
													+ "<td>"
													   + jsonResponse.objectEntityList[key].facultyId
													   + "</td> "
													   + "<td>"
													   + jsonResponse.objectEntityList[key].department.name
													   + "</td> "
													   + "<td>"
													   + jsonResponse.objectEntityList[key].name
													   + "</td> "
													   + "<td>"
													   + '<div class="actions"> '+
														 '<a class="button edit-button buttonUpdateFacultyToolbar">' +
														 '<ion-icon name="create"></ion-icon>' +
														 '</a>'+ 
														  '</div>' 
													   + "</td> "
													   + "</tr>");

										})

					}

				},
				complete: function() {
					
					initFacultyData();
				},
				error : function() {

					console.log("No se ha podido obtener la información");

				}

			});

}



