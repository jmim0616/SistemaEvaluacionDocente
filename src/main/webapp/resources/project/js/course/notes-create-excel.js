$(document).ready(function() {

	$('.success .close', window.parent.document).click(function(event) {

		event.preventDefault();
		
		$('.success', window.parent.document).show().fadeOut('slow');
		
	});
	
	$('.error .close', window.parent.document).click(function(event) {

		event.preventDefault();
		
		$('.error .close', window.parent.document).show().fadeOut('slow');
		
	});
	
	$('#buttonCreateNotesExcel').click(function(event) {
		event.preventDefault();
		
		ajaxCreateNotesExcel();

	});

	
});



function ajaxCreateNotesExcel() {

    
	var form = $('#Fileuploader')[0];

	// Create an FormData object 
    var data = new FormData(form);
	
    
	// disabled the submit button
    $("#buttonCreateNotesExcel").prop("disabled", true);
    
    
    $.ajax({
        method: "POST",
        enctype: 'multipart/form-data',
        url: "./CreateOnlineFeedBack",
        data: data,
        processData: false,
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (jsonResponse) {

            console.log("SUCCESS : ", data);
            console.log(jsonResponse);
            $("#buttonCreateNotesExcel").prop("disabled", false);
            
           if (jsonResponse.successMessage != null){
            	$('.success .message', window.parent.document).text(jsonResponse.successMessage);
            	$('.success', window.parent.document).show().fadeIn('slow');
            }
            else{
                $('.error .message', window.parent.document).text(jsonResponse.errorMessage);
            	$('.error', window.parent.document).show().fadeIn('slow');
           }
            
           $('#excelfile').val("");

        },
        error: function (jsonResponse) {

            $("#buttonCreateNotesExcel").prop("disabled", false);

        }
        
    });
	
}






