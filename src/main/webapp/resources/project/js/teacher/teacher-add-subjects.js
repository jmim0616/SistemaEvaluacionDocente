var arraySubjects = [];
var arraySubjectsAdded = [];
var arraySubjectsDeleted = [];

$(document).ready(function() {
	
	ajaxSearchSubjects();
	
	$('#buttonAddSubjects').click(function(event) {

		event.preventDefault();
		
		ajaxAddSubjectsTeacher();

	});

	$('.success .close').click(function(event) {

		event.preventDefault();
		
		$('.success').show().fadeOut('slow');
		
	});
	
});



function tagingSubjects() {

	var input = document.querySelector('textarea[name=subjectAdd]'), tagify = new Tagify(
			input, {
				enforceWhitelist : true,
				whitelist : arraySubjects,
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

		arraySubjectsDeleted.push(e.detail.value);
	});

	tagify.on('add', function(e) {

		arraySubjectsAdded.push(e.detail.value);
	});

}



function ajaxSearchSubjects() {

	$.ajax({
		url : './Teachers/GetSubjects',
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

				arraySubjects.push(jsonResponse.objectEntityList[key].name);

				//$("#academicProgramCreate").append(arrayAcademicPrograms + " , ");

			});

		},
		complete : function() {

			tagingSubjects();

		},
		error : function() {

			console.log("No se ha podido obtener la información");

		}

	});

}


function ajaxAddSubjectsTeacher() {
	
	$('#subjectAddError').text('');

	var teacher = $('#teacherId').text();
	var subject = $('#subjectAdd').val();
	
	var json = {
			"teacher": teacher,
			"subject": subject,
			"subjectAdded" : arraySubjectsAdded,
			"subjectDeleted" : arraySubjectsDeleted
			}
	
	console.log(json);
	
	$.ajax({
		url: "./Teachers/AddSubjects",
		data: JSON.stringify(json),
		contentType : "application/json",
		method: "POST",
		done: function(){

			
		},
		success: function(jsonResponse){
			
			if (typeof jsonResponse == "string") {
				
				$('.content').fadeOut(0).html(jsonResponse).fadeIn('slow');
				
				$('.error').show().fadeIn('slow');
			}
			
			console.log(jsonResponse);
			
			if (jsonResponse.isValid) {
				
				$('#teacherIdSearch').val($('#teacherId').text());
				$('#nameSearch').val($('#name').text());
			
				
				$('.success .message').text(jsonResponse.successMessage);
				
				$('.success').show().fadeIn('slow');
				
				
				$.get('./Teachers/Data', function(view){
					
					$('.content').fadeOut(0).html(view).fadeIn('slow');

					ajaxSearchTeacher();
					
					})
				
				
			} else {
			
			$.each(jsonResponse.errorMessages, function(key,value) {
				
				$("#"+key+"").text(value);
				
			})
			
			}
			
			
		},
		error: function(){
			
			
		}
		
	});
	
	
	
}






