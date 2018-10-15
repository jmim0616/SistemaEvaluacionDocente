$(document)
		.ready(
				function() {

					window.onload = function() {

						$('#teachers').addClass('active-main-bar-navigation-li-a');
						
						$('.container').fadeOut(0).load('/SistemaEvaluacionDocente/Teachers/').fadeIn('slow');
						

					};


					$('#teachers').click(
							function(event) {

								event.preventDefault();

								$('.container').fadeOut(0).load('/SistemaEvaluacionDocente/Teachers/').fadeIn('slow');

							});
					
					$('#subjects').click(
							function(event) {

								event.preventDefault();

								$('.container').fadeOut(0).load('./Subjects/').fadeIn('slow');

							});

					$('#faculties').click(
							function(event) {

								event.preventDefault();

								$('.container').fadeOut(0).load('./Faculties/').fadeIn('slow');

							});
					
					
					$('#disciplinaryAreas').click(
							function(event) {

								event.preventDefault();

								$('.container').fadeOut(0).load('./DisciplinaryAreas/').fadeIn('slow');

							});
					
					$('#academicPrograms').click(
							function(event) {

								event.preventDefault();

								$('.container').fadeOut(0).load('./AcademicPrograms/').fadeIn('slow');

							});
					
					$('#departments').click(
							function(event) {

								event.preventDefault();

								$('.container').fadeOut(0).load('./Departments/').fadeIn('slow');

							});
					
					$('#academicPeriods').click(
							function(event) {

								event.preventDefault();

								$('.container').fadeOut(0).load('./AcademicPeriods/').fadeIn('slow');

							});
					
					
					$('#users').click(
							function(event) {

								event.preventDefault();
								$('.container').fadeOut(0).load('./Users/').fadeIn('slow');

							});

					
					
					$('#courses').click(
							function(event) {

								event.preventDefault();

								$('.container').fadeOut(0).load('./Courses/').fadeIn('slow');

							});


					
					
					
					$('.main-bar-navigation li a')
							.click(
									function() {

										$(".main-bar-navigation li")
												.find(
														".active-main-bar-navigation-li-a")
												.removeClass(
														"active-main-bar-navigation-li-a");

										$(this)
												.addClass(
														'active-main-bar-navigation-li-a');

									});
					

				});


