$(document).ready(function() {

	$('.standard-table tr').not('.not').click(function() {

		$(".standard-table").find("tr").removeClass("active-tr");

		$(this).addClass('active-tr');

		if ($("tr:nth-child(even)").hasClass("active-tr")) {

			$("tr:nth-child(even)").css({
				"background-color" : "#f7f7f7"
			});

			$("tr:nth-child(" + ($(this).index() + 1) + ")").css({
				"background-color" : "#000"
			});

		} else {

			$("tr:nth-child(even)").css({
				"background-color" : "#f7f7f7"
			});

		}

		var items = new Array();
		var values = "";

		// Obtenemos todos los valores contenidos en los <td> de la fila
		// seleccionada
		$(this).find("td").each(function(key, value) {
			items.push($(this).html());

			console.log(key);
			console.log(value.textContent);

		});

		console.log(items);

	});

	$('.edit-button').click(function(event) {

		console.log("AAAAAAAAAAA");

		event.preventDefault();

		ajaxTest2();

	});

});

function ajaxTest2() {

	$.ajax({
		url : './test2',
		type : "GET",
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");

		},
		success : function(test2) {

			$('.tool-container').hide();

			$('.content').fadeOut(0).html(test2).fadeIn('slow');

		}

	});

}

