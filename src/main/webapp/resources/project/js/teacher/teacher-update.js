$(document).ready(function() {

	
	$('#buttonUpdateTeacher').click(function(event) {

		event.preventDefault();
		
		ajaxUpdateTeacher();

	});

	
});



function ajaxUpdateTeacher() {
	
	var teacherId = $('#teacherIdUpdate').val();
	var name = $('#nameUpdate').val();
	var lastName = $('#lastNameUpdate').val();
	var identificationType = $('#identificationTypeUpdate option:selected').text();
	var underDegree = $('#underDegreeUpdate').val();
	var masterDegree = $('#masterDegreeUpdate').val();
	var masterDegree = $('#masterDegreeUpdate').val();
	var doctorDegree = $('#doctorDegreeUpdate').val();
	var institutionalMail = $('#institutionalMailUpdate').val();
	var personalMail = $('#personalMailUpdate').val();
	var cellPhoneNumber = $('#cellPhoneNumberUpdate').val();
	var homeNumber = $('#homeNumberUpdate').val();
	var experience = $('#experienceUpdate').val();
	
	var json = {
			"teacherId": teacherId,
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
		url: "./Teachers/Update",
		data: JSON.stringify(json),
		contentType : "application/json",
		method: "POST",
		done: function(){

			
		},
		success: function(jsonResponse){
			
			console.log(jsonResponse);
			
			$.each(jsonResponse.errorMessages, function(key,value) {
				
				$("#"+key+"UpdateError").text(value);
				
			})
			
		},
		error: function(){
			
			
		}
		
	});
	
	
	
}






