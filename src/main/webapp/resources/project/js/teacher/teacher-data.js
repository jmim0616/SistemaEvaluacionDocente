var arrayItemsStandardTable = null;

$(document).ready(function() {
	
	$('.standard-table tr').not('.not').click(function asd() {

		if ($(this).hasClass("active-tr")) {
			
			$(".standard-table").find("tr").removeClass("active-tr");
			
			$(this).removeClass('active-tr');

		} else {

			$(".standard-table").find("tr").removeClass("active-tr");
			
			$(this).addClass('active-tr');

		}
		
		if ($(this).hasClass('active-toolbar')) {

			$(this).removeClass('active-toolbar');
			$('#toolbar').show().fadeOut('slow');
			
			
		} else {
			
			$(".standard-table").find("tr").removeClass("active-toolbar");
			$(this).addClass('active-toolbar');
			$('#toolbar').show().fadeIn('slow');
			
			
		}
		
		arrayItemsStandardTable = obtainValuesTagTd(this);
		
		
	});
	
	
});


$('#buttonUpdateTeacherToolbar').click(function(event) {

	event.preventDefault();
	
	
	ajaxShowUpdateTeacher();

});

$('#buttonUpdateStateTeacherToolbar').click(function(event) {

	event.preventDefault();
	
	$('.tool-container').hide();
	
	$('.modalContainer').show().fadeIn('slow');


});








function obtainValuesTagTd(tr){

	var items = new Array();

	// Obtaining all the values within the tags <td> when a row is selected.
	$(tr).find("td").each(function(key, value) {
		
		items.push($(this).html());
		
	});

	console.log(items);
	
	return items;
	
}

function ajaxShowUpdateTeacher() {
	
	$.ajax({ 
		url : "./Teachers/Update",
		method : 'GET',
        beforeSend: function(xhr) {
        	
        },
        success: function(view) {
			
			$('.tool-container').hide();
		
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
			$('#cellPhoneNumberUpdate').val(arrayItemsStandardTable[9]);
			$('#homeNumberUpdate').val(arrayItemsStandardTable[10]);
			$('#experienceUpdate').val(arrayItemsStandardTable[11]);
			
		}
		
	});

}


