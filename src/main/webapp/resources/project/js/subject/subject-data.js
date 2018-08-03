var arrayItemsStandardTable = null;
	
function initSubjectData() {
	
	function obtainValuesTagTd(button){
		
		var items = new Array();
		
		$(button).parents("tr").find("td").each(function(key, value) {

		items.push($(this).html());

	});
		
		console.log(items);
		
		arrayItemsStandardTable = items;

	}

	$('.buttonUpdateSubjectToolbar').click(function(event) {

		event.preventDefault();
		
		obtainValuesTagTd(this);
		
		ajaxShowUpdateSubject();

	});

	
	$('.buttonUpdateStateSubjectToolbar').click(function(event) {

		event.preventDefault();
		
		obtainValuesTagTd(this);
		
		ajaxShowUpdateStatusSubject();

	});

	$('.error .close').click(function(event) {

		event.preventDefault();
		
		$('.error').show().fadeOut('slow');
		
	});

	
}



function ajaxShowUpdateSubject() {
	
	$.ajax({ 
		url : "./Subjects/Update",
		method : 'GET',
        beforeSend: function(xhr) {
        	
        },
        success: function(view) {
		
			$('.content').fadeOut(0).html(view).fadeIn('slow');
			
			$('#subjectIdUpdate').val(arrayItemsStandardTable[0]);
			$('#disciplinaryAreaUpdate .actualValue').text(arrayItemsStandardTable[1]);
			$('#nameUpdate').val(arrayItemsStandardTable[2]);
			$('#numberOfCreditsUpdate .actualValue').val(arrayItemsStandardTable[3]);
			$('#academicProgramUpdate').val(arrayItemsStandardTable[4]);
			$('#subjectStatusUpdate').val(arrayItemsStandardTable[5]);
		
			
		}
		
	});

}



function ajaxShowUpdateStatusSubject() {
	

	var subjectId = arrayItemsStandardTable[0];
	
	var json = {
			
			"subjectId": subjectId

			}
	
	$.ajax({ 
		url : "./Subjects/UpdateStatus",
		data: json,
		contentType : "application/json",
		method : 'GET',
        beforeSend: function(xhr) {
        	
        },
        success: function(view) {
		
			$('.content').fadeOut(0).html(view).fadeIn('slow');
			
			$('#dialogModal .status').text(arrayItemsStandardTable[5]);

			$('.updateSubjectStatus .modalContainer').show().fadeIn('slow');
			
		}
		
	});

}

