var arrayAcademicPrograms = [];

$(document).ready(function() {

	ajaxSearchAcademicProgram();
	


	$('.success .close').click(function(event) {

		event.preventDefault();

		$('.success').show().fadeOut('slow');

	});
	
	
	$('.error .close').click(function(event) {

		event.preventDefault();

		$('.error').show().fadeOut('slow');

	});
	

	$('#buttonCreateSubject').click(function(event) {

		event.preventDefault();

		ajaxCreateSubject();

	});

});

function tagingAcademicProgramCreate() {
	

	var input = document.querySelector('textarea[name=academicProgramCreate]'),
    tagify = new Tagify(input, {
        enforceWhitelist : true,
        whitelist        : arrayAcademicPrograms,
    dropdown : {
   	 enabled   : 2,
	 maxItems  : 5
    }
    });

}


function ajaxSearchAcademicProgram() {

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
			
			$.each(jsonResponse.objectEntityList,
					function(key, value) {
							
				arrayAcademicPrograms.push(jsonResponse.objectEntityList[key].name);
				
				//$("#academicProgramCreate").append(arrayAcademicPrograms + " , ");
				
			});
					
		},
		complete : function() {

			tagingAcademicProgramCreate();
			
		},
		error : function() {

			console.log("No se ha podido obtener la información");

		}

	});

}



function ajaxCreateSubject() {

	$('#disciplinaryAreaCreateError').text('');
	$('#nameCreateError').text('');
	$('#numberOfCreditsCreateError').text('');
	$('#academicProgramCreateError').text('');


	var disciplinaryArea = $('#disciplinaryAreaCreate option:selected').val();
	var name = $('#nameCreate').val();
	var numberOfCredits = $('#numberOfCreditsCreate option:selected').text();
	var academicProgram = $('#academicProgramCreate').val();


	var json = {
		"disciplinaryArea" : disciplinaryArea,
		"name" : name,
		"numberOfCredits" : numberOfCredits,
		"academicProgram" : academicProgram
	}

	console.log(json);

	$.ajax({
		url : "./Subjects/Create",
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

				$('#nameSearch').val($('#nameCreate').val());

				$('#disciplinaryAreaCreate').val('');
				$('#nameCreate').val('');
				$('#numberOfCreditsCreate').val('');
				$('#academicProgramCreate').val('');

				$('.success .message').text(jsonResponse.successMessage);

				$('.success').show().fadeIn('slow');

				$.get('./Subjects/Data', function(view) {

					$('.content').fadeOut(0).html(view).fadeIn('slow');

					ajaxSearchSubject();

				})
				
			}

			} else {

				$.each(jsonResponse.errorMessages, function(key, value) {

					$("#" + key + "CreateError").text(value);

				})

			}

		},
		error : function() {

		}

	});

}
