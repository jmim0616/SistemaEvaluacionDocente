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
		
		ajaxShowUpdateStatusUser();

	});


	$('.buttonUpdateUserToolbar').click(function(event) {

		event.preventDefault();

		obtainValuesTagTd(this);
		
		$('.updateUser .modalContainer').show().fadeIn('slow');

		$('#userIdUpdate').val(arrayItemsStandardTable[0]);
		$('#maskUpdate').val(arrayItemsStandardTable[1]);
		$('#nameUpdate').val(arrayItemsStandardTable[2]);
		$('#institutionalMailUpdate').val(arrayItemsStandardTable[4]);
		$('#personalMailUpdate').val(arrayItemsStandardTable[5]);
		$('#status').val(arrayItemsStandardTable[6]);
		$('#passwordUpdate').val(arrayItemsStandardTable[8]);
		$('#userTypeUpdate').val(arrayItemsStandardTable[9]);
		$('#jobPositionUpdate').val(arrayItemsStandardTable[10]);
		

	});
	
	function ajaxShowUpdateStatusUser() {

		var statusToShow = "";

		var userId = arrayItemsStandardTable[0];
		
		console.log("user " + userId);
		
		var json = {
				"userId": userId

				}
		
		$.ajax({ 
			url : "./Users/UpdateStatus",
			data: json,
			contentType : "application/json",
			method : 'GET',
	        beforeSend: function(xhr) {
	        	
	        },
	        success: function(view) {
			
				$('.content').fadeOut(0).html(view).fadeIn('slow');
				
				$('#dialogModal .status').text(arrayItemsStandardTable[6]);

				$('.updateUserStatus .modalContainer').show().fadeIn('slow');
				
			}
			
		});
	}

	$('.error .close').click(function(event) {

		event.preventDefault();

		$('.error').show().fadeOut('slow');

	});

	
}



