function loadTags() {
    $.ajax({
            url: '/SelfCareCommunity/service/tags',
            type: "GET",
            success: function(data) {
            	for (var i = 0; i < data.length; i++) { 
            		
            		 $("#dlb_tabgs").append("<option value='"+data[i].id+"'>"+data[i].tagName+"</option>") 
            	    
            	}
            	$('[name="dlb_tabgs"]').bootstrapDualListbox();
            }
	});
}