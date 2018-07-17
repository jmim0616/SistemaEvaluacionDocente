var arrayItemsStandardTable = null;

function initDisciplinaryAreaData() {

	function obtainValuesTagTd(button){
		
		var items = new Array();
		
		$(button).parents("tr").find("td").each(function(key, value) {

		items.push($(this).html());

	});
		
		console.log(items);
		
		arrayItemsStandardTable = items;

	}


$('.buttonUpdateDisciplinaryAreaToolbar').click(function(event) {

	event.preventDefault();
	
	obtainValuesTagTd(this);
	
	$('.updateDisciplinaryArea .modalContainer').show().fadeIn('slow');
	
	$('#disciplinaryAreaIdUpdate').val(arrayItemsStandardTable[0]);
	$('#departmentUpdate .actualValue').text(arrayItemsStandardTable[1]);
	$('#nameUpdate').val(arrayItemsStandardTable[2]);

});


$('.error .close').click(function(event) {

	event.preventDefault();
	
	$('.error').show().fadeOut('slow');
	
});


}





