$(document).ready(function() {
	
	$('.menu-list li:has(ul)').children('ul').not('.sub-menu-content').slideDown();
	
	$('.general-menu').addClass('activated');

	$('.menu-list li:has(ul)').click(function(e) {

		e.preventDefault();
		

		if ($(this).hasClass('activated')) {

//			$(this).removeClass('activated');
//			$(this).children('ul').slideUp();


		} else {

			
			$('.menu-list li').removeClass('activated');
			$(this).addClass('activated');
			$(this).children('ul').slideDown();

		}

	});

	$('.menu-list .sub-menu').click(function(e) {

		e.preventDefault();
		

	if ( ($(this).hasClass('sub-menu-activated')) && (!($(this).children('ul').hasClass('true'))) ) {

			$(this).removeClass('sub-menu-activated');
			$(this).children('ul').slideUp();


		} else if ( (!($(this).hasClass('sub-menu-activated'))) ) {

			$('.menu-list .sub-menu').removeClass('sub-menu-activated');
			$(this).addClass('sub-menu-activated');
			$(this).children('ul').slideDown();

		
		}


	});

});
