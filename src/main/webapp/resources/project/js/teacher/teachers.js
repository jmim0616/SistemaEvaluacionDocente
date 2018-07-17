$(document).ready(function() {
	
	
	$('.sub-menu-content').click(function(e) {

		e.preventDefault();

		$(this).addClass('true');
		


	});
	
	$('.container').click(function(e) {

		e.preventDefault();

		$('.sub-menu-content').removeClass('true');		

	});

	
	$('#linkCreateTeacher').click(function(event) {
		
		event.preventDefault();

		$('.content').fadeOut(0).load('./Teachers/Create').fadeIn('slow');
		
	});
	

	

	$('#buttonSearchTeacher').click(function(event) {

		event.preventDefault();
		
		$('.content').fadeOut(0).load('./Teachers/Data').fadeIn('slow');
		
		ajaxSearchTeacher();

	});
	

	
});

$('#linkCreateExcelTeacher').click(function(event) {
	
	//event.preventDefault();
	
	$('.content').load('./Teachers/CreateExcel');
	
});

function ajaxSearchTeacher() {
	
	$('#teacherIdSearchError').text("");
	
	var teacherId = $('#teacherIdSearch').val();
	
	var json = {
		"teacherId" : teacherId,
		"name": "noaplica"
	};
	
	$.ajax({
		url: './Teachers/Search',
		data: JSON.stringify(json),
		contentType : "application/json",
		method: 'POST',
			done: function() {
				

				
			},
			success: function(jsonResponse){
			
				if (typeof jsonResponse == "string") {
					
					$('.content').fadeOut(0).html(jsonResponse).fadeIn('slow');
					
					$('.error').show().fadeIn('slow');
			}
				
				console.log(jsonResponse);
				
				if (jsonResponse.isValid) {
					
					$('#teacherIdSearch').val('');
					
					if (jsonResponse.errorMessage != null) {
						
						$('#tableTeacherData').show().fadeOut('slow');
						
						$('.error .message').text(jsonResponse.errorMessage);
						
						$('.error').show().fadeIn('slow');
						
					} else {
					
						var identificationType = null;
						
						if (jsonResponse.objectBean.identificationType == 1) {
							identificationType = "Cedula de Ciudadania";
						} else if (jsonResponse.objectBean.identificationType == 2) {
							identificationType = "Cedula de Extranjeria";
						}
						
						$("#tableTeacherData").append(
								"<tr>" +
								"<td>"+ jsonResponse.objectBean.teacherId +"</td> " +
								"<td>"+ jsonResponse.objectBean.name +"</td> " +
								"<td>"+ jsonResponse.objectBean.lastName +"</td> " +
								"<td>"+ identificationType +"</td> " +
								"<td>"+ jsonResponse.objectBean.underDegree +"</td> " +
								"<td>"+ jsonResponse.objectBean.masterDegree +"</td> " +
								"<td>"+ jsonResponse.objectBean.doctorDegree +"</td> " +
								"<td>"+ jsonResponse.objectBean.institutionalMail +"</td> " +
								"<td>"+ jsonResponse.objectBean.personalMail +"</td> " +
								"<td>"+ jsonResponse.objectBean.homeNumber +"</td>" +
								"<td>"+ jsonResponse.objectBean.homeNumber +"</td> " +
								"<td>"+ jsonResponse.objectBean.experience +"</td> " +
								"<td>"+ jsonResponse.objectBean.teacherStatus +"</td> " +
								"</tr>" );

					
					}
					
				} else {
					
					$('#teacherIdSearchError').append(jsonResponse.errorMessages.teacherId);
				}



			
		},

	    error: function() {

	        console.log("No se ha podido obtener la información");

	    }
		
		
		
	});
	
}





