$( document ).ready(function() {

    $('#btnEdit').click(function(){
        $('.profile_main_info_body').toggle();
    });

    $('#btnSave').click(function(){
        $('.profile_main_info_body').toggle();
    });

    $(function() {
    	 $( "#tbDofB" ).datepicker({
    		  yearRange: "1930:2012",
    	      changeMonth: true,
    	      changeYear: true
    	 });
    });

});
	