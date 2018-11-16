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

			$.each(jsonResponse.objectBeanList, function(key, value) {

				if (jsonResponse.objectBeanList[key].jobPosition == 1){
					jsonResponse.objectBeanList[key].jobPosition = "Jefe de departamento";
				}
				else{
					jsonResponse.objectBeanList[key].jobPosition = "Coordinador de área";
				}
				
				if (jsonResponse.objectBeanList[key].status == 1){
					jsonResponse.objectBeanList[key].status = "Activo";
				}
				else{
					jsonResponse.objectBeanList[key].status = "Inactivo";
				}
				
				
								$("#tableUserData")
										.append(
									"<tr>"
										+ "<td>"
										   + jsonResponse.objectBeanList[key].userId
										   + "</td> "
										   + "<td>"
										   + jsonResponse.objectBeanList[key].mask
										   + "</td> "
										   + "<td>"
										   + jsonResponse.objectBeanList[key].name
										   + "</td> "
										   + "<td>"
										   + jsonResponse.objectBeanList[key].jobPosition
										   + "</td> "
										   + "<td>"
										   + jsonResponse.objectBeanList[key].institutionalMail
										   + "</td> "
										   + "<td>"
										   + jsonResponse.objectBeanList[key].personalMail
										   + "</td> "
										   + "<td>"
										   + jsonResponse.objectBeanList[key].status
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
										   + jsonResponse.objectBeanList[key].password
										   + "</td> "
										   + "<td style=" + "display:none;" + ">"
										   + jsonResponse.objectBeanList[key].userType
										   + "</td> "
										   + "<td style=" + "display:none;" + ">"
										   + jsonResponse.objectBeanList[key].jobPosition
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
