$(document).ready(
		function() {

			$('#linkCreateAcademicProgram').click(
					function(event) {

						event.preventDefault();

						$('.content').fadeOut(0).load('./AcademicPrograms/Create').fadeIn('slow');

						$('.modalContainer').show().fadeIn('slow');

					});

			$('#linkSearchAcademicProgram')
					.click(
							function(event) {

								event.preventDefault();

								$('.content').fadeOut(0).load(
										'./AcademicPrograms/Data').fadeIn(
										'slow');

								ajaxSearchAcademicProgram();

							});

		});

function ajaxSearchAcademicProgram() {

	$
			.ajax({
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
																	+ "</tr>");

										})

					}

				},

				error : function() {

					console.log("No se ha podido obtener la información");

				}

			});

}
