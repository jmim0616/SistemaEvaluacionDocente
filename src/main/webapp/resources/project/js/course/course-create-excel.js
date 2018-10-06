$(document).ready(function() {

	$('#buttonCreateCourseExcel').click(function(event) {
		event.preventDefault();
		
		ajaxCreateCourseExcel();

	});
	
	$('.success .close', window.parent.document).click(function(event) {

		event.preventDefault();
		
		$('.success', window.parent.document).show().fadeOut('slow');
		
	});
	
	$('.error .close', window.parent.document).click(function(event) {

		event.preventDefault();
		
		$('.error .close', window.parent.document).show().fadeOut('slow');
		
	});

	
});



function ajaxCreateCourseExcel() {

    
	var form = $('#Fileuploader')[0];

	// Create an FormData object 
    var data = new FormData(form);
	
    
	// disabled the submit button
    $("#buttonCreateCourseExcel").prop("disabled", true);
    
    
    $.ajax({
        method: "POST",
        enctype: 'multipart/form-data',
        url: "./CreateExcel",
        data: data,
        processData: false,
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (jsonResponse) {

            console.log("SUCCESS : ", data);
            console.log(jsonResponse);
            $("#buttonCreateCourseExcel").prop("disabled", false);
            
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

            $("#buttonCreateCourseExcel").prop("disabled", false);

        }
        
    });
	
}






