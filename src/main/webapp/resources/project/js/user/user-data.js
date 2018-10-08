var arrayItemsStandardTable = null;

function initUserData() {
	
	function obtainValuesTagTd(button){
		
		var items = new Array();
		
		$(button).parents("tr").find("td").each(function(key, value) {

		items.push($(this).html());

	});
		
		console.log(items);
		
		arrayItemsStandardTable = items;

	}
	
	$('.buttonUpdateStateUserToolbar').click(function(event) {

		event.preventDefault();
		
		obtainValuesTagTd(this);
		
		$('#userIdUpdateStatus').val(arrayItemsStandardTable[0]);
		
		$('#dialogModal .status').text(arrayItemsStandardTable[6]);

		$('.updateUserStatus .modalContainer').show().fadeIn('slow');
		

	});


	$('.buttonUpdateUserToolbar').click(function(event) {

		event.preventDefault();

		obtainValuesTagTd(this);

		$('#userIdUpdate').val(arrayItemsStandardTable[0]);
		$('#maskUpdate').val(arrayItemsStandardTable[1]);
		$('#nameUpdate').val(arrayItemsStandardTable[2]);
		$('#institutionalMailUpdate').val(arrayItemsStandardTable[4]);
		$('#personalMailUpdate').val(arrayItemsStandardTable[5]);
		$('#status').val(arrayItemsStandardTable[6]);
		$('#passwordUpdate').val(arrayItemsStandardTable[8]);
		$('#userTypeUpdate').val(arrayItemsStandardTable[9]);
		$('#jobPositionUpdate').val(arrayItemsStandardTable[10]);
		
		$('.updateUser .modalContainer').show().fadeIn('slow');
		

	});
	

	$('.error .close').click(function(event) {

		event.preventDefault();

		$('.error').show().fadeOut('slow');

	});

	
}



