$(document).ready(function() {
	
	$.get('./AcademicPrograms/Data', function(view, status, xhr){
		  $('.content').fadeOut(0).html(view).fadeIn('slow');
		}).done(function() {
			ajaxSearchAcademicProgram();
		  });

			$('#linkCreateAcademicProgram').click(function(event) {

						event.preventDefault();

						$('.createAcademicProgram .modalContainer').show().fadeIn('slow');

					});

			$('#linkSearchAcademicProgram').click(function(event) {

								event.preventDefault();

								$.get('./AcademicPrograms/Data', function(view, status, xhr){
									  $('.content').fadeOut(0).html(view).fadeIn('slow');
									}).done(function() {
										ajaxSearchAcademicProgram();
									  });
								
							});

			});


function ajaxSearchAcademicProgram() {

			$.ajax({
				url : './AcademicPrograms/Search',
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

						$('#tableAcademicProgramData').show().fadeOut('slow');

						$('.error .message').text(jsonResponse.errorMessage);

						$('.error').show().fadeIn('slow');

					} else {

						$
								.each(
										jsonResponse.objectEntityList,
										function(key, value) {

											$("#tableAcademicProgramData")
													.append(
															"<tr>"
																	+ "<td>"
																	+ jsonResponse.objectEntityList[key].academicProgramId
																	+ "</td> "
																	+ "<td>"
																	+ jsonResponse.objectEntityList[key].faculty.name
																	+ "</td> "
																	+ "<td>"
																	+ jsonResponse.objectEntityList[key].name
																	+ "</td> "
																	+ "<td>"
																	+ '<div class="actions"> '+
																	  '<a class="button edit-button buttonUpdateAcademicProgramToolbar">' +
																	  '<ion-icon name="create"></ion-icon>' +
																	  '</a>'+ 
																	  '</div>'+
																	   "</td> " +
																	+ "</tr>");

										})

					}

				},
				complete: function() {
					
					initAcademicProgramData();
					
				},
				error : function() {

					console.log("No se ha podido obtener la información");

				}

			});

}
