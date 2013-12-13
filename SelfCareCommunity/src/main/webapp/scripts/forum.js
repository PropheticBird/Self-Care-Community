var currentPage=1;
var idCat = 0; 
$(document).ready(function() {
	
	var prmstr = window.location.search.substr(1);
    var prmarr = prmstr.split ("&");
    var params = {};
	
    for ( var i = 0; i < prmarr.length; i++) {
        var tmparr = prmarr[i].split("=");
        params[tmparr[0]] = decodeURIComponent(tmparr[1]);
    }
    
    $("#title").text(params['categName']);

	idCat= params['categoryId']; // used for getting the category id from URL
	
	var threadCount=params['threadCount'];	
	var n=parseInt(threadCount/10)+1;
	
	prePage=1;
	
	$("#pagePre").parent().attr("class","active");
	$("#page1").parent().attr("class","active");
	
	if(n>1)	{
		element = '<li><a onclick="page(this);return false;"id="pagePre">&laquo</a></li>';
		$("#page").append(element);
		for(var i=1;i<=n;i++){
			
			element = '<li><a onclick="page(this);return false;"id="page'+i+'">'+i+'</a></li>';
			$("#page").append(element);
		}
		element = '<li><a onclick="page(this);return false;"id="pageNext">&raquo;</a></li>';
		$("#page").append(element);
					
	}
	else{
		element = '<li><a onclick="page(this);return false;"id="page1">1</a></li>';
		$("#page").append(element);
		
	}
	
	getThreads(1);
	
	$("#categoryId").text(idCat);    		
	
	$("#btnThread").click(function(){
		
		var id=$("#categoryId").text();
		var topic=$.trim($("#topic").val());
		var content=$.trim($("#content").val());
		    			
		var url="/SelfCareCommunity/service/category/"+id+"/newthread";
		//alert(url);
		if(content.length==0 || topic.length==0)
			return false;
		else{
			$.ajax({
				  url: url,
				  type: "POST",
				  dataType: "json",
				  contentType: 'application/json; charset=utf-8',
				  data: JSON.stringify({ "topic":topic, "content":content}),
				  success: function(id_data){
					  
					//alert(JSON.stringify(id_data));
					  //$("#postSuccess").alert();
					  $("#threadSuccess").show();
					
					 var url_thread="/SelfCareCommunity/content/view.html?id="+ id_data.id +"&displayName="+ topic +"&postCount=1";
					 location.href = url_thread;
				  },
				  error: function(xhr, ajaxOptions, thrownError){
					  //console.log(xhr.status+"  "+thrownError);
					  //$("#postFail").alert();
					  $("#threadFail").show();
				  }
				  
			});
			//$("#postSuccess").show();
			return false;
		}
		
		
	});
	
});

function page(item){
	
	if (item.id=='pageNext'){
		getThreads(currentPage+1);
		currentPage++;
    		
	}
	if (item.id=='pagePre'){
		getThreads(currentPage-1);
		currentPage--;
	}
	
	if ($.isNumeric(item.innerHTML)){
		currentPage=parseInt(item.innerHTML);
		getThreads(item.innerHTML);
	}
	
	$("#page"+prePage).parent().attr("class","");
	$("#page"+currentPage).parent().attr("class","active");
	

	if(currentPage==1)
		$("#pagePre").parent().attr("class","active");
	else
	{
		$("#pagePre").parent().attr("class","");
		$("#pagePre").attr("href","/SelfCareCommunity/service/category/"+idCat+"/threads/page/"+(currentPage-1));
		$("#pageNext").attr("href","/SelfCareCommunity/service/category/"+idCat+"/threads/page/"+(currentPage+1));
	}
}
	 	    	
function getThreads(pageNum){
	    
	var url="/SelfCareCommunity/service/category/"+idCat+"/threads/page/"+pageNum;

	$.ajax({
		url: url,
		type: "get",
		dataType: "json",
		success: function(result){    
			lastPage = result.last;
			data=result.data;
			if (lastPage==true){
				$("#pageNext").hide();
			} else {
				$("#pageNext").show();
					
			} 
			if (pageNum==1){
				$("#pagePre").hide();
			} else {
				$("#pagePre").show();
					
			}
			$("#threadList").html("");

			for(var i=0;i<data.length;i++){
		
				var id=data[i].id;
				var author=data[i].author.name;
				var displayName=data[i].displayName;
				var postCount=data[i].postCount;
				var lastPostDate=data[i].lastPostDate;

				$("#threadList").append("<div id='thread"+id+"'></div>");
				$("#thread"+id).loadTemplate("template/thread.html",
				{
					author: author,
					url: "/SelfCareCommunity/content/view.html?id="+id+"&displayName="+displayName+"&postCount="+postCount,
					displayName:displayName,
					postCount:postCount,
					date: lastPostDate
				});		
		}
			
        	$("#container").show();
		}
		});
	}