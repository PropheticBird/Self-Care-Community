$(document).ready(function() {		
		var url = '/SelfCareCommunity/service/categories';
		$.getJSON(url, function(data) {
			var categories='';
			for(var i=0; i<data.length;i++){
				categories+="<div class='forum_category'><a href='forum.html?categoryId="+ 
						data[i].id +"&threadCount="+data[i].threadCount+"&categName="+
						data[i].displayName+"'>"+ data[i].displayName+' ('+data[i].threadCount+')' +'</a></div>';
			}
			$('#threadList').html(categories);
			$('.forum_category').bind( "click", function() {
				var url = $(this).children('a').attr('href'); 
				location.href = url;
			});
			$('.forum_category').hover(function() {
				$('.forum_category').css('border',' 1px solid #ddd');
				$(this).css('border',' 1px solid rgb(73, 175, 205)');
				
			});
		});
		
	});