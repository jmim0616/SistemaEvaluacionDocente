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


$('#buttonUpdateDisciplinaryAreaToolbar').click(function(event) {

	event.preventDefault();
	
	ajaxShowUpdateDisciplinaryArea();

});


$('.error .close').click(function(event) {

	event.preventDefault();
	
	$('.error').show().fadeOut('slow');
	
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

function ajaxShowUpdateDisciplinaryArea() {
	
	$.ajax({ 
		url : "./DisciplinaryAreas/Update",
		method : 'GET',
        beforeSend: function(xhr) {
        	
        },
        success: function(view) {
			
			$('.tool-container').hide();
		
			$('.content').fadeOut(0).html(view).fadeIn('slow');
			
			$('.modalContainer').show().fadeIn('slow');
			
			$('#disciplinaryAreaIdUpdate').val(arrayItemsStandardTable[0]);
			$('#facultyUpdate option:selected').text(arrayItemsStandardTable[1]);
			$('#nameUpdate').val(arrayItemsStandardTable[2]);
			
		}
		
	});

}


