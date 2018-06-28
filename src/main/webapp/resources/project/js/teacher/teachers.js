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
	
	
	$('#linkCreateExcelTeacher').click(function(event) {
		
		event.preventDefault();

		$('.content').fadeOut(0).load('./Teachers/CreateExcel').fadeIn('slow');
		
	});
	

	$('#buttonSearchTeacher').click(function(event) {

		event.preventDefault();
		
		$('.content').fadeOut(0).load('./Teachers/Data').fadeIn('slow');
		
		ajaxSearchTeacher();

	});
	

	
});



function ajaxSearchTeacher() {
	
	
	
	$('#teacherIdSearchError').text("");
	
	var teacherId = $('#teacherIdSearch').val();
	
	var json = {
		"teacherId" : teacherId
	};
	
	$.ajax({
		url: './Teachers/Search',
		data: JSON.stringify(json),
		contentType : "application/json",
		method: 'POST',
			done: function() {
				
			
				
			},
			success: function(jsonResponse){
			
			$('#teacherIdSearchError').append(jsonResponse.errorMessages.teacherId);
			
			$('.teacherData').show().fadeIn('slow');
			
			$("#tableTeacherData").append(
					"<tr>" +
					"<td>WWWWWWWWW</td> " +
					"<td>Woz</td> " +
					"<td>1</td> " +
					"<td>Sistemas1</td> " +
					"<td>Sistemas2</td> " +
					"<td>Sistemas3</td> " +
					"<td>VladWoz1@gmail.com</td> " +
					"<td>VladWoz2@gmail.com</td> " +
					"<td>1</td> " +
					"<td>2</td>" +
					"<td>100 años</td> " +
					"</tr>" );
			
			
//			$('.content').fadeOut(0).html('./Teachers/Data').fadeIn('slow');
			
			
			
		},

	    error: function() {

	        console.log("No se ha podido obtener la información");

	    }
		
		
		
	});
	
}





