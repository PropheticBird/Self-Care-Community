$( document ).ready(function() {
	$('#tab_1').bind( "click", function() {
		$('.tabs_context').css('display','none');
		$('#tab_con_1').css('display','block');
		
		$('#tab_1').removeClass().addClass("current");
		$('#tab_2, #tab_3, #tab_4').removeClass().addClass("another_tab");

	});

	$('#tab_2').bind( "click", function() {
		$('.tabs_context').css('display','none');
		$('#tab_con_2').css('display','block');
		
		$('#tab_2').removeClass().addClass("current");
		$('#tab_1, #tab_3, #tab_4').removeClass().addClass("another_tab");
	});
	
	$('#tab_3').bind( "click", function() {
		$('.tabs_context').css('display','none');
		$('#tab_con_3').css('display','block');
		
		$('#tab_3').removeClass().addClass("current");
		$('#tab_1, #tab_2, #tab_4').removeClass().addClass("another_tab");
	});
	
	$('#tab_4').bind( "click", function() {
		$('.tabs_context').css('display','none');
		$('#tab_con_4').css('display','block');
		
		$('#tab_4').removeClass().addClass("current");
		$('#tab_1, #tab_2, #tab_3').removeClass().addClass("another_tab");
	});
});
	