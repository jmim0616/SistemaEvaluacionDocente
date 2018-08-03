$(document).ready(function() {

	
	$('.sub-menu-content').click(function(e) {

		e.preventDefault();

		$(this).addClass('true');
		


	});
	
	$('.container').click(function(e) {

		e.preventDefault();

		$('.sub-menu-content').removeClass('true');
		

	});

	
	$('#linkCreateAcademicPeriod').click(function(event) {
		
		event.preventDefault();
		
		$.get('./AcademicPeriods/Create', function(view){
			
			$('.content').fadeOut(0).html(view).fadeIn('slow');

//			ajaxSearchAcademicPeriod();
			
			})
		
	});
	

	$('#buttonSearchAcademicPeriod').click(function(event) {

		event.preventDefault();
		
		$.get('./AcademicPeriods/Data', function(view){
			
			$('.content').fadeOut(0).html(view).fadeIn('slow');

//			ajaxSearchAcademicPeriod();
			
			})
			
			
		
	});
	

	
});



function ajaxSearchAcademicPeriod() {
	
	$('#nameSearch').text("");
	
	var name = $('#nameSearch').val();
	
	var json = {
		"name" : name,
		"initialDate": "noaplica",
		"endDate": "noaplica"
	};
	
	$.ajax({
		url: './AcademicPeriods/Search',
		data: JSON.stringify(json),
		contentType : "application/json",
		method: 'POST',
			beforeSend: function () {
				
				
				
			}, 
			done: function() {
				

				
			},
			success: function(jsonResponse){
			
				if (typeof jsonResponse == "string") {
					
					$('.content').fadeOut(0).html(jsonResponse).fadeIn('slow');
					
					$('.error').show().fadeIn('slow');
			}
				
				console.log(jsonResponse);
				
				if (jsonResponse.isValid) {
					
					if (jsonResponse.errorMessage != null) {
						
						$('#tableAcademicPeriodData').show().fadeOut('slow');
						
						$('.error .message').text(jsonResponse.errorMessage);
						
						$('.error').show().fadeIn('slow');
						
					} else {
						
						$("#tableAcademicPeriodData").append(
								"<tr>" +
								"<td>"+ jsonResponse.objectBean.academicPeriodId +"</td> " +
								"<td>"+ jsonResponse.objectBean.name +"</td> " +
								"<td>"+ jsonResponse.objectBean.initialDate +"</td> " +
								"<td>"+ jsonResponse.objectBean.endDate +"</td> " +
								"<td>"+ '<div class="actions"> '+
										 '<a class="button edit-button buttonUpdateAcademicPeriodToolbar">' +
										 '<ion-icon name="create"></ion-icon>' +
										 '</a>'+ 
										  '</div>' +
										  "</td> " +
								"</tr>" );

					
					}
					
				} else {
					
					$('#nameSearchError').append(jsonResponse.errorMessages.name);
				}



			
		},
		complete: function() {

			initAcademicPeriodData();
			
		},
	    error: function() {

	        console.log("No se ha podido obtener la información");

	    }
		
		
		
	});
	
}



