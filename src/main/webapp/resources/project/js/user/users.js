$(document).ready(function() {

	$.get('./Users/Data', function(view, status, xhr){
		  $('.content').fadeOut(0).html(view).fadeIn('slow');
		}).done(function() {
			  ajaxSearchUser();
		  });


	$('#linkCreateUser').click(function(event) {

		event.preventDefault();

		$('.content').fadeOut(0).load('./Users/Create').fadeIn('slow');

	});
	
});


function ajaxSearchUser() {

	$.ajax({
	url : './Users/Search',
	contentType : 'application/json',
	method : 'POST',
	done : function() {

	},
	success : function(jsonResponse) {

		if (typeof jsonResponse == "string") {

			$('.content').fadeOut(0).html(jsonResponse).fadeIn(
					'slow');

			$('.error').show().fadeIn('slow');
		}

		console.log(jsonResponse);

		if (jsonResponse.errorMessage != null) {

			$('#tableUserData').show().fadeOut('slow');

			$('.error .message').text(jsonResponse.errorMessage);

			$('.error').show().fadeIn('slow');

		} else {

			$.each(jsonResponse.objectEntityList, function(key, value) {

				if (jsonResponse.objectEntityList[key].jobPosition == 1){
					jsonResponse.objectEntityList[key].jobPosition = "Jefe de departamento";
				}
				else{
					jsonResponse.objectEntityList[key].jobPosition = "Coordinador de área";
				}
				
				if (jsonResponse.objectEntityList[key].status == 1){
					jsonResponse.objectEntityList[key].status = "Activo";
				}
				else{
					jsonResponse.objectEntityList[key].status = "Inactivo";
				}
				
				
								$("#tableUserData")
										.append(
									"<tr>"
										+ "<td>"
										   + jsonResponse.objectEntityList[key].userId
										   + "</td> "
										   + "<td>"
										   + jsonResponse.objectEntityList[key].mask
										   + "</td> "
										   + "<td>"
										   + jsonResponse.objectEntityList[key].name
										   + "</td> "
										   + "<td>"
										   + jsonResponse.objectEntityList[key].jobPosition
										   + "</td> "
										   + "<td>"
										   + jsonResponse.objectEntityList[key].institutionalMail
										   + "</td> "
										   + "<td>"
										   + jsonResponse.objectEntityList[key].personalMail
										   + "</td> "
										   + "<td>"
										   + jsonResponse.objectEntityList[key].status
										   + "</td> "
										   + "<td>"
										   + '<div class="actions"> '+
											 '<a class="button edit-button buttonUpdateUserToolbar">' +
											 '<ion-icon name="create"></ion-icon>' +
											 '</a>'+ 
											 '<a class="button inactivate-button buttonUpdateStateUserToolbar">' +
											  '<ion-icon name="remove-circle"></ion-icon>' +
											  '</a>' +
											  '</div>' 
										   + "</td> "
										   + "<td style=" + "display:none;" + ">"
										   + jsonResponse.objectEntityList[key].password
										   + "</td> "
										   + "<td style=" + "display:none;" + ">"
										   + jsonResponse.objectEntityList[key].userType
										   + "</td> "
										   + "<td style=" + "display:none;" + ">"
										   + jsonResponse.objectEntityList[key].jobPosition
										   + "</td> "
										   + "</tr>");

							})

		}

	},
	complete: function() {
		
		initUserData();
	},
	error : function() {

		console.log("No se ha podido obtener la información");

	}

});

}
