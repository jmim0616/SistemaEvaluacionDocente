var arrayAcademicPrograms = [];
var arrayAcademicProgramsAdded = [];
var arrayAcademicProgramsDeleted = [];

$(document).ready(function() {

	ajaxSearchAcademicPrograms();

	$('.success .close').click(function(event) {

		event.preventDefault();

		$('.success').show().fadeOut('slow');

	});

	$('#buttonUpdateSubject').click(function(event) {

		event.preventDefault();

		ajaxUpdateSubject();

	});

});

function tagingAcademicPrograms() {

	var input = document.querySelector('textarea[name=academicProgramUpdate]'), tagify = new Tagify(
			input, {
				enforceWhitelist : true,
				whitelist : arrayAcademicPrograms,
				dropdown : {
					enabled : 2,
					maxItems : 5
				},
			//    callbacks : {
			//        add    : console.log,  // callback when adding a tag
			//        remove : console.log   // callback when removing a tag
			//    }
			});

	tagify.on('remove', function(e) {

		arrayAcademicProgramsDeleted.push(e.detail.value);
	});

	tagify.on('add', function(e) {

		arrayAcademicProgramsAdded.push(e.detail.value);
	});

}

function ajaxSearchAcademicPrograms() {

	$.ajax({
		url : './Subjects/GetAcademicPrograms',
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

				arrayAcademicPrograms
						.push(jsonResponse.objectEntityList[key].name);

				//$("#academicProgramCreate").append(arrayAcademicPrograms + " , ");

			});

		},
		complete : function() {

			tagingAcademicPrograms();

		},
		error : function() {

			console.log("No se ha podido obtener la información");

		}

	});

}

function ajaxUpdateSubject() {

	$('#disciplinaryAreaUpdateError').text('');
	$('#nameUpdateError').text('');
	$('#numberOfCreditsUpdateError').text('');
	$('#academicProgramUpdateError').text('');

	var subjectId = $('#subjectIdUpdate').val();
	var disciplinaryArea = $('#disciplinaryAreaUpdate option:selected').text();
	var name = $('#nameUpdate').val();
	var numberOfCredits = $('#numberOfCreditsUpdate option:selected').text();
	var academicProgram = $('#academicProgramUpdate').val();

	var json = {
		"subjectId" : subjectId,
		"disciplinaryArea" : disciplinaryArea,
		"name" : name,
		"numberOfCredits" : numberOfCredits,
		"academicProgram" : academicProgram,
		"academicProgramAdded" : arrayAcademicProgramsAdded,
		"academicProgramDeleted" : arrayAcademicProgramsDeleted
	}

	console.log(json);

	$.ajax({
		url : "./Subjects/Update",
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
						
					} else {

				$('#nameSearch').val($('#nameUpdate').val());

				$('#disciplinaryAreaUpdate').val('');
				$('#nameUpdate').val('');
				$('#numberOfCreditsUpdate').val('');
				$('#academicProgramUpdate').val('');

				$('.success .message').text(jsonResponse.successMessage);

				$('.success').show().fadeIn('slow');

				$.get('./Subjects/Data', function(view) {

					$('.content').fadeOut(0).html(view).fadeIn('slow');

					ajaxSearchSubject();

				})
				
				}

			} else {

				$.each(jsonResponse.errorMessages, function(key, value) {

					$("#" + key + "UpdateError").text(value);

				})

			}

		},
		error : function() {

		}

	});

}
