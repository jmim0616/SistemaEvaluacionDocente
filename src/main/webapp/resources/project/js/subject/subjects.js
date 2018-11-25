var arraySubjects = [];

$(document).ready(function() {

	ajaxSearchSubjects();
	
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

		$.get('./Subjects/Data', function(view) {

			$('.content').fadeOut(0).html(view).fadeIn('slow');

			ajaxSearchSubject();

		})

	});

});


function AutocompleteForSubjectsSearch() {

	$("#subjectIdSearch").autocomplete({
		source : arraySubjects
	});

}


function ajaxSearchSubjects() {

	$.ajax({
		url : './Subjects/GetSubjects',
		contentType : 'application/json',
		method : 'POST',
		done : function() {

		},
		success : function(jsonResponse) {

			if (typeof jsonResponse == "string") {

				$('.content').fadeOut(0).html(jsonResponse).fadeIn('slow');

				$('.error').show().fadeIn('slow');

			}

			console.log(jsonResponse);

			$.each(jsonResponse.objectEntityList, function(key, value) {


				arraySubjects.push(JSON.stringify(jsonResponse.objectEntityList[key].subjectId));


			});

		},
		complete : function() {

			AutocompleteForSubjectsSearch();

		},
		error : function() {

			console.log("No se ha podido obtener la información");

		}

	});

}


function ajaxSearchSubject() {

	$('#subjectIdSearchError').text("");

	var subjectId = $('#subjectIdSearch').val();

	var json = {
		"name" : "no aplica",
		"subjectId" : subjectId
	};

	$.ajax({
				url : './Subjects/Search',
				data : JSON.stringify(json),
				contentType : "application/json",
				method : 'POST',
				beforeSend : function() {

				},
				done : function() {

				},
				success : function(jsonResponse) {

					if (typeof jsonResponse == "string") {

						$('.content').fadeOut(0).html(jsonResponse).fadeIn(
								'slow');

						$('.error').show().fadeIn('slow');
					}

					console.log(jsonResponse);

					if (jsonResponse.isValid) {

						if (jsonResponse.errorMessage != null) {

//							$('#tableSubjectData').show().fadeOut('slow');

							$('.error .message')
									.text(jsonResponse.errorMessage);

							$('.error').show().fadeIn('slow');

						} else {

							$("#tableSubjectData")
									.append(
											"<tr>" + "<td>"
													+ jsonResponse.objectEntity.subject.subjectId
													+ "</td> "
													+ "<td>"
													+ jsonResponse.objectEntity.subject.disciplinaryArea.name
													+ "</td> "
													+ "<td>"
													+ jsonResponse.objectEntity.subject.name
													+ "</td> "
													+ "<td>"
													+ jsonResponse.objectEntity.subject.numberOfCredits
													+ "</td> "
													+ "<td>"
													+ jsonResponse.objectEntity.academicProgram.name
													+ "</td> "
													+ "<td>"
													+ jsonResponse.objectEntity.subject.subjectStatus.status
													+ "</td> "
													+ "<td>"
													+ '<div class="actions"> '
													+ '<a class="button edit-button buttonUpdateSubjectToolbar">'
													+ '<ion-icon name="create"></ion-icon>'
													+ '</a>'
													+ '<a class="button inactivate-button buttonUpdateStateSubjectToolbar">'
													+ '<ion-icon name="remove-circle"></ion-icon>'
													+ '</a>' + '</div>'
													+ "</td> " + "</tr>");

						}

					} else {

						$('#nameSearchError').append(
								jsonResponse.errorMessages.name);
					}

				},
				complete : function() {

					initSubjectData();

				},
				error : function() {

					console.log("No se ha podido obtener la información");

				}

			});

}
