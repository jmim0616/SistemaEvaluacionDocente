var arrayItemsStandardTable = null;
	
function initTeacherData() {
	
//	$('.standard-table tr').not('.not').click(function() {
//
//		var items = new Array();
//
//		// Obtaining all the values within the tags <td> when a row is selected.
//		$(this).find("td").each(function(key, value) {
//
//			items.push($(this).html());
//
//		});
//
//		console.log(items);
//
//		arrayItemsStandardTable = items;
//
//	});
	
	function obtainValuesTagTd(button){
		
		var items = new Array();
		
		$(button).parents("tr").find("td").each(function(key, value) {

		items.push($(this).html());

	});
		
		console.log(items);
		
		arrayItemsStandardTable = items;

	}

	$('.buttonUpdateTeacherToolbar').click(function(event) {

		event.preventDefault();
		
		obtainValuesTagTd(this);
		
		ajaxShowUpdateTeacher();

	});

	
	$('.buttonUpdateStateTeacherToolbar').click(function(event) {

		event.preventDefault();
		
		obtainValuesTagTd(this);
		
		ajaxShowUpdateStatusTeacher();

	});

	$('.error .close').click(function(event) {

		event.preventDefault();
		
		$('.error').show().fadeOut('slow');
		
	});

	
}



function ajaxShowUpdateTeacher() {
	
	$.ajax({ 
		url : "./Teachers/Update",
		method : 'GET',
        beforeSend: function(xhr) {
        	
        },
        success: function(view) {
		
			$('.content').fadeOut(0).html(view).fadeIn('slow');
			
			$('#teacherIdUpdate').val(arrayItemsStandardTable[0]);
			$('#nameUpdate').val(arrayItemsStandardTable[1]);
			$('#lastNameUpdate').val(arrayItemsStandardTable[2]);
			$('#identificationTypeUpdate option:selected').text(arrayItemsStandardTable[3]);
			$('#underDegreeUpdate').val(arrayItemsStandardTable[4]);
			$('#masterDegreeUpdate').val(arrayItemsStandardTable[5]);
			$('#doctorDegreeUpdate').val(arrayItemsStandardTable[6]);
			$('#institutionalMailUpdate').val(arrayItemsStandardTable[7]);
			$('#personalMailUpdate').val(arrayItemsStandardTable[8]);
			$('#cellNumberUpdate').val(arrayItemsStandardTable[9]);
			$('#homeNumberUpdate').val(arrayItemsStandardTable[10]);
			$('#experienceUpdate').val(arrayItemsStandardTable[11]);
			
		}
		
	});

}



function ajaxShowUpdateStatusTeacher() {
	

	var teacherId = arrayItemsStandardTable[0];
	
	var json = {
			"teacherId": teacherId

			}
	
	$.ajax({ 
		url : "./Teachers/UpdateStatus",
		data: json,
		contentType : "application/json",
		method : 'GET',
        beforeSend: function(xhr) {
        	
        },
        success: function(view) {
			
			$('.tool-container').hide();
		
			$('.content').fadeOut(0).html(view).fadeIn('slow');
			
			$('#dialogModal .status').text(arrayItemsStandardTable[12]);

			
		}
		
	});

}

