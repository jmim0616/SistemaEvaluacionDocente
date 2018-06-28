$(document).ready(function() {


	$('#linkCreateAcademicProgram').click(function(event) {
		
		event.preventDefault();
		
		ajaxShowCreateAcademicProgram();
		
	});
	
	
	$('#linkSearchAcademicProgram').click(function(event) {

		event.preventDefault();
		
		$('.content').fadeOut(0).load('./AcademicPrograms/Data').fadeIn('slow');
		
		ajaxSearchAcademicProgram();

	});
	

	
});



function ajaxShowCreateAcademicProgram() {
	
	
	$.ajax({
		url: './AcademicPrograms/Create',
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



function ajaxSearchAcademicProgram() {
	
	
	$.ajax({
		url: './AcademicPrograms/Search',
		contentType: 'application/json',
		method: 'POST',
			done: function() {
				

			},
			success: function(jsonResponse){
			
			$('.academicProgramData').show().fadeIn('slow');
			
			$("#tableAcademicProgramData").append(
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





