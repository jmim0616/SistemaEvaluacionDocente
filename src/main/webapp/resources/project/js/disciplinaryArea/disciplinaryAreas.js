$(document).ready(function() {


	$('#linkCreateDisciplinaryArea').click(function(event) {
		
		event.preventDefault();
		
		ajaxShowCreateDisciplinaryArea();
		
	});
	
	
	$('#linkSearchDisciplinaryArea').click(function(event) {

		event.preventDefault();
		
		$('.content').fadeOut(0).load('./DisciplinaryAreas/Data').fadeIn('slow');
		
		ajaxSearchDisciplinaryArea();

	});
	

	
});



function ajaxShowCreateDisciplinaryArea() {
	
	
	$.ajax({
		url: './DisciplinaryAreas/Create',
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



function ajaxSearchDisciplinaryArea() {
	
	
	$.ajax({
		url: './DisciplinaryAreas/Search',
		contentType: 'application/json',
		method: 'POST',
			done: function() {
				

			},
			success: function(jsonResponse){
			
			$('.disciplinaryAreaData').show().fadeIn('slow');
			
			$("#tableDisciplinaryAreaData").append(
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





