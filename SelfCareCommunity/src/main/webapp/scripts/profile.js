$( document ).ready(function() {
    $('#btnEdit, #btnCancel, #btnSave').click(function(){
        $('.profile_main_info_body').toggle();
    });

    $(function() {
    	 $( "#tbDofB" ).datepicker({
    		  yearRange: "1900:2020",
    	      changeMonth: true,
    	      changeYear: true
    	 });
    });

});
$(document).ajaxStart(function () {
    $("#content").hide();
    $("#loading").show();
});

$(document).ajaxComplete(function () {
    $("#content").show();
    $("#loading").hide();
});
	