var arrayItemsStandardTable = null;

function initDepartmentData() {

	function obtainValuesTagTd(button){
		
		var items = new Array();
		
		$(button).parents("tr").find("td").each(function(key, value) {

		items.push($(this).html());

	});
		
		console.log(items);
		
		arrayItemsStandardTable = items;

	}


$('.buttonUpdateDepartmentToolbar').click(function(event) {

	event.preventDefault();
	
	obtainValuesTagTd(this);

	$('.updateDepartment .modalContainer').show().fadeIn('slow');
	
	$('#departmentIdUpdate').val(arrayItemsStandardTable[0]);
	$('#nameUpdate').val(arrayItemsStandardTable[1]);

});


$('.error .close').click(function(event) {

	event.preventDefault();
	
	$('.error').show().fadeOut('slow');
	
});


}



