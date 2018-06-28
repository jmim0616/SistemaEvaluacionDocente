$(document).ready(function() {

	
	$('#buttonCreateTeacher').click(function(event) {

		event.preventDefault();
		
		ajaxCreateTeacher();

	});

	
});



function ajaxCreateTeacher() {
	
	var teacherId = $('#teacherIdCreate').val();
	var teacherStatus = $('#teacherStatusCreate option:selected').text();
	var name = $('#nameCreate').val();
	var lastName = $('#lastNameCreate').val();
	var identificationType = $('#identificationTypeCreate option:selected').text();
	var underDegree = $('#underDegreeCreate').val();
	var masterDegree = $('#masterDegreeCreate').val();
	var masterDegree = $('#masterDegreeCreate').val();
	var doctorDegree = $('#doctorDegreeCreate').val();
	var institutionalMail = $('#institutionalMailCreate').val();
	var personalMail = $('#personalMailCreate').val();
	var cellPhoneNumber = $('#cellPhoneNumberCreate').val();
	var homeNumber = $('#homeNumberCreate').val();
	var experience = $('#experienceCreate').val();
	
	var json = {
			"teacherId": teacherId,
			"teacherStatus": teacherStatus,
			"name": name,
			"lastName": lastName,
			"identificationType": identificationType,
			"underDegree": underDegree,
			"masterDegree": masterDegree,
			"doctorDegree": doctorDegree,
			"institutionalMail": institutionalMail,
			"personalMail": personalMail,
			"cellPhoneNumber": cellPhoneNumber,
			"homeNumber": homeNumber,
			"experience": experience
			}
	
	console.log(json);
	
	$.ajax({
		url: "./Teachers/Create",
		data: JSON.stringify(json),
		contentType : "application/json",
		method: "POST",
		done: function(){

			
		},
		success: function(jsonResponse){
			
			console.log(jsonResponse);
			
			$.each(jsonResponse.errorMessages, function(key,value) {
				
				$("#"+key+"CreateError").text(value);
				
			})
			
		},
		error: function(){
			
			
		}
		
	});
	
	
	
}






