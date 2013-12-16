var params;
$(document).ready(function() {

    //Loading templates
    $(".pagination-container").load("template/pagination.html");
    $("#new-header").load("header.html");

    params = parseParams(window.location.search.substr(1));

    $("#title").text(params['categName']);

    //Load first page from server
	getThreads(1);

	$("#btnThread").click(function(){
		var topic=$.trim($("#topic").val());
		var content=$.trim($("#content").val());

		if(content.length==0 || topic.length==0){
			return false;
        }else{
            var url = "/SelfCareCommunity/service/category/"+params['categoryId']+"/newthread";
            $.ajax({
                url: url,
                type: "POST",
                dataType: "json",
                contentType: 'application/json; charset=utf-8',
                data:JSON.stringify({
                    "topic":topic,
                    "content":content
                }),
                success: function(data){
                    location.href = "/SelfCareCommunity/content/view.html?id="+ data.id +"&displayName="+ topic +"&postCount=1";
                },
                error: function(){
                    $("#threadFail").show();
                }
            });
            return false;
		}
	});

    $("#btnThreadNewPage").click(function(){
        location.href = "/SelfCareCommunity/content/createNewThread.html?categoryId="+params['categoryId'];
    });

});

function getThreads(pageNum){
	    
	$.ajax({
		url: "/SelfCareCommunity/service/category/"+params['categoryId']+"/threads/page/"+pageNum,
		type: "get",
		dataType: "json",
		success: function(result){

			data=result.data;

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
            initalizePagination(params['threadCount'], 10, getThreads);
            paginationManageArrows(result.last);
        	$("#container").show();
		}
	});
}