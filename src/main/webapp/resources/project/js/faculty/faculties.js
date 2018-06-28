$(document).ready(function() {


	$('#linkCreateFaculty').click(function(event) {
		
		event.preventDefault();
		
		ajaxShowCreateFaculty();
		
	});
	
	
	$('#linkSearchFaculty').click(function(event) {

		event.preventDefault();
		
		$('.content').fadeOut(0).load('./Faculties/Data').fadeIn('slow');
		
		ajaxSearchFaculty();

	});
	

	
});



function ajaxShowCreateFaculty() {
	
	
	$.ajax({
		url: './Faculties/Create',
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



function ajaxSearchFaculty() {
	
	
	$.ajax({
		url: './Faculties/Search',
		contentType: 'application/json',
		method: 'POST',
			done: function() {
				

			},
			success: function(jsonResponse){
			
			$('.facultyData').show().fadeIn('slow');
			
			$("#tableFacultyData").append(
					"<tr>" +
					"<td>1</td> " +
					"<td>2</td> " +
					"<td>Woz</td> " +
					"</tr>" );
		
		},

	    error: function() {

	        console.log("No se ha podido obtener la información");

	    }
		
		
		
	});
	
}





