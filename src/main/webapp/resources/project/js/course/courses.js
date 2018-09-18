$(document)
		.ready(
				function() {

					$('.sub-menu-content').click(function(e) {

						e.preventDefault();

						$(this).addClass('true');

					});

					$('.container').click(function(e) {

						e.preventDefault();

						$('.sub-menu-content').removeClass('true');

					});

					$('#linkCreateExcelCourse')
							.click(
									function(event) {

										event.preventDefault();

										$('.content')
												.html(
														'<iframe src="http://localhost:8080/SistemaEvaluacionDocente/Courses/CreateExcel" width="500">  </iframe>');

									});

				});
