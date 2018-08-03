var arrayItemsStandardTable = null;
	
function initAcademicPeriodData() {
	
	function obtainValuesTagTd(button){
		
		var items = new Array();
		
		$(button).parents("tr").find("td").each(function(key, value) {

		items.push($(this).html());

	});
		
		console.log(items);
		
		arrayItemsStandardTable = items;

	}

	$('.buttonUpdateAcademicPeriodToolbar').click(function(event) {

		event.preventDefault();
		
		obtainValuesTagTd(this);
		
		ajaxShowUpdateAcademicPeriod();

	});

	

	$('.error .close').click(function(event) {

		event.preventDefault();
		
		$('.error').show().fadeOut('slow');
		
	});

	
}



function ajaxShowUpdateAcademicPeriod() {
	
	$.ajax({ 
		url : "./AcademicPeriods/Update",
		method : 'GET',
        beforeSend: function(xhr) {
        	
        },
        success: function(view) {
		
			$('.content').fadeOut(0).html(view).fadeIn('slow');
			
			$('#academicPeriodId').val(arrayItemsStandardTable[0]);
			$('#nameUpdate').val(arrayItemsStandardTable[1]);
			$('#initialDateUpdate').val(arrayItemsStandardTable[2]);
			$('#endDateUpdate').val(arrayItemsStandardTable[3]);
			
		}
		
	});

}



