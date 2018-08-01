$(document).ready(function() {

	
	$('#buttonCreateSubjectExcel').click(function(event) {

		event.preventDefault();
		
		ajaxCreateSubjectExcel();

	});

	
});



function ajaxCreateSubjectExcel() {
	
	var json = {
			"subjectId": "asdqwe"
			}
	
	console.log(json);
	
	$.ajax({
		url: "./Subjects/CreateExcel",
		data: JSON.stringify(json),
		contentType : "application/json",
		method: "POST",
		done: function(){

			
		},
		success: function(jsonResponse){
			
			console.log(jsonResponse);
		
		},
		error: function(){
			
			
		}
		
	});
	
	
	
}






