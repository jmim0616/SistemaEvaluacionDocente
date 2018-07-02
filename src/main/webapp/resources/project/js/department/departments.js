$(document).ready(function() {


	
	
	$('#linkCreateDepartment').click(function(event) {
		
		event.preventDefault();
		
		$('.content').fadeOut(0).load('./Departments/Create').fadeIn('slow');
		
		$('.modalContainer').show().fadeIn('slow');
		
	});
	
	
	$('#linkSearchDepartment').click(function(event) {

		event.preventDefault();
		
		$('.content').fadeOut(0).load('./Departments/Data').fadeIn('slow');
		
		ajaxSearchDepartment();

	});
	

	
});


function ajaxSearchDepartment() {
	
	
	$.ajax({
		url: './Departments/Search',
		contentType: 'application/json',
		method: 'POST',
			done: function() {
				

			},
			success: function(jsonResponse){
				
				if (typeof jsonResponse == "string") {
					
					$('.content').fadeOut(0).html(jsonResponse).fadeIn('slow');
					
					$('.error').show().fadeIn('slow');
			}
				
				console.log(jsonResponse);
				
				if (jsonResponse.errorMessage != null) {
					
					$('#tableDepartmentData').show().fadeOut('slow');
					
					$('.error .message').text(jsonResponse.errorMessage);
					
					$('.error').show().fadeIn('slow');
					
					
				} else {
					
					$.each(jsonResponse.objectEntityList, function(key, value) {

						$("#tableDepartmentData").append(
								"<tr>" +
								"<td>"+ jsonResponse.objectEntityList[key].departmentId +"</td> " +
								"<td>"+ jsonResponse.objectEntityList[key].name +"</td> " +
								"</tr>" );
						
					})

					
					
				}
		
		},

	    error: function() {

	        console.log("No se ha podido obtener la información");

	    }
		
		
		
	});
	
}





