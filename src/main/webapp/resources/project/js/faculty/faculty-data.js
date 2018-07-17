var arrayItemsStandardTable = null;

function initFacultyData() {

	function obtainValuesTagTd(button){
		
		var items = new Array();
		
		$(button).parents("tr").find("td").each(function(key, value) {

		items.push($(this).html());

	});
		
		console.log(items);
		
		arrayItemsStandardTable = items;

	}


	$('.buttonUpdateFacultyToolbar').click(function(event) {

		event.preventDefault();

		obtainValuesTagTd(this);
		
		$('.updateFaculty .modalContainer').show().fadeIn('slow');

		$('#facultyIdUpdate').val(arrayItemsStandardTable[0]);
		$('#nameUpdate').val(arrayItemsStandardTable[1]);
		

	});

	$('.error .close').click(function(event) {

		event.preventDefault();

		$('.error').show().fadeOut('slow');

	});

	
}



