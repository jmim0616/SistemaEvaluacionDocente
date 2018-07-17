$(document).ready(function() {

	$('#buttonExcelFile').click(function(event) {

		event.preventDefault();
		
		ajaxCreateTeacherExcel();

	});
	
	$('#buttonCreateTeacherExcel').click(function(event) {
		event.preventDefault();
		
		ajaxCreateTeacherExcel();

	});

	
});



function ajaxCreateTeacherExcel() {
	
	var json = {
			"teacherId": "asdqwe"
			}
	
	console.log(json);
	
	$.ajax({
		url: "./Teachers/CreateExcel",
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






