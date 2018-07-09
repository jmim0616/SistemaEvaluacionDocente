$(document).ready(function() {

	$.get('./Departments/Data', function(view, status, xhr){
		  $('.content').fadeOut(0).html(view).fadeIn('slow');
		}).done(function() {
			ajaxSearchDepartment();
		  });

	$('#linkCreateDepartment').click(function(event) {
		
		event.preventDefault();
		
		$('.createDepartment .modalContainer').show().fadeIn('slow');
		
	});
	
	
	$('#linkSearchDepartment').click(function(event) {

		event.preventDefault();
		
		$.get('./Departments/Data', function(view, status, xhr){
			  $('.content').fadeOut(0).html(view).fadeIn('slow');
			}).done(function() {
				ajaxSearchDepartment();
			  });

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
								 "<td>"+
								  '<div class="actions"> '+
									 '<a class="button edit-button buttonUpdateDepartmentToolbar">' +
									 '<ion-icon name="create"></ion-icon>' +
									 '</a>'+ 
									 '</div>'+ 
									 "</td> "+
								"</tr>" );
						
					})

					
					
				}
		
		},
		complete: function() {
			
			initDepartmentData();
			
		},
	    error: function() {

	        console.log("No se ha podido obtener la información");

	    }
		
		
		
	});
	
}





