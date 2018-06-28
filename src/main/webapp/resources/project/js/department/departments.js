$(document).ready(function() {


	
	
	$('#linkCreateDepartment').click(function(event) {
		
		event.preventDefault();
		
		ajaxShowCreateDepartment();
		
	});
	
	
	$('#linkSearchDepartment').click(function(event) {

		event.preventDefault();
		
		$('.content').fadeOut(0).load('./Departments/Data').fadeIn('slow');
		
		ajaxSearchDepartment();

	});
	

	
});



function ajaxShowCreateDepartment() {
	
	
	$.ajax({
		url: './Departments/Create',
		method: 'GET',
			done: function() {
				

			},
			success: function(view){
			
				
				$('.content').fadeOut(0).html(view).fadeIn('slow');
				
				$('.modalContainer').show().fadeIn('slow');
		
		},

	    error: function() {

	        console.log("No se ha podido obtener la información");

	    }
		
		
		
	});
	
}



function ajaxSearchDepartment() {
	
	
	$.ajax({
		url: './Departments/Search',
		contentType: 'application/json',
		method: 'POST',
			done: function() {
				

			},
			success: function(jsonResponse){
			
			$('.departmentData').show().fadeIn('slow');
			
			$("#tableDepartmentData").append(
					"<tr>" +
					"<td>1</td> " +
					"<td>Woz</td> " +
					"</tr>" );
		
		},

	    error: function() {

	        console.log("No se ha podido obtener la información");

	    }
		
		
		
	});
	
}





