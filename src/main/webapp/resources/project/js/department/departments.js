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
						
						 console.log("AAAAAAAAA");
						 console.log(key);
						 console.log("BBBBBBBBB");
						 console.log(value);

						$("#tableDepartmentData").append(
								"<tr>" +
								"<td>"+ jsonResponse.objectEntityList[key].departmentId +"</td> " +
							    "<td>" + jsonResponse.objectEntityList[key].faculty.name + "</td> " +
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





