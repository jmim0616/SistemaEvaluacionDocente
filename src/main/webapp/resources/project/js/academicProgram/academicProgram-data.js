var arrayItemsStandardTable = null;

function initAcademicProgramData() {

	function obtainValuesTagTd(button){
		
		var items = new Array();
		
		$(button).parents("tr").find("td").each(function(key, value) {

		items.push($(this).html());

	});
		
		console.log(items);
		
		arrayItemsStandardTable = items;

	}


$('.buttonUpdateAcademicProgramToolbar').click(function(event) {

	event.preventDefault();
	
	obtainValuesTagTd(this);
	
	$('.updateAcademicProgram .modalContainer').show().fadeIn('slow');
	
	$('#academicProgramIdUpdate').val(arrayItemsStandardTable[0]);
	$('#facultyUpdate option:selected').text(arrayItemsStandardTable[1]);
	$('#nameUpdate').val(arrayItemsStandardTable[2]);

});

$('.error .close').click(function(event) {

	event.preventDefault();
	
	$('.error').show().fadeOut('slow');
	
});

}




