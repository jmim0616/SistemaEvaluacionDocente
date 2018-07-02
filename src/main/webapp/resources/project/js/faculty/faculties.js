$(document).ready(function() {

	$('#linkCreateFaculty').click(function(event) {

		event.preventDefault();

		$('.content').fadeOut(0).load('./Faculties/Create').fadeIn('slow');

		$('.modalContainer').show().fadeIn('slow');

	});

	$('#linkSearchFaculty').click(function(event) {

		event.preventDefault();

		$('.content').fadeOut(0).load('./Faculties/Data').fadeIn('slow');

		ajaxSearchFaculty();

	});

});

function ajaxSearchFaculty() {

	$
			.ajax({
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

						$
								.each(
										jsonResponse.objectEntityList,
										function(key, value) {

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
																	+ "</tr>");

										})

					}

				},

				error : function() {

					console.log("No se ha podido obtener la información");

				}

			});

}
