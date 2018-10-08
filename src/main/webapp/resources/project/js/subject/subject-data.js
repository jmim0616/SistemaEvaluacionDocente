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
		
		$('#subjectIdUpdateStatus').val(arrayItemsStandardTable[0]);
		
		$('#dialogModal .status').text(arrayItemsStandardTable[5]);

		$('.updateSubjectStatus .modalContainer').show().fadeIn('slow');

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
			$('#numberOfCreditsUpdate .actualValue').text(arrayItemsStandardTable[3]);
			$('#academicProgramUpdate').val(arrayItemsStandardTable[4]);
			$('#subjectStatusUpdate').val(arrayItemsStandardTable[5]);
		
			
			
		}
		
	});

}



