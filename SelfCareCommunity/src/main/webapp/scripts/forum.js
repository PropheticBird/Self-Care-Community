var currentPage=1;
var idCat = 0; 
var num_pages=0;
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
	num_pages=parseInt(threadCount/10)+1; // it calculates the numbe of pages we will have
	
	prePage=1;
	
	$(".pagePre").parent().attr("class","active");
	$(".page1").parent().attr("class","active");
	
	if(num_pages>1)	{
		element = '<li><a onclick="page(this);return false;"class="pagePre">&laquo</a></li>';
		$(".page").append(element);
		element = '<li><a onclick="page(this);return false;"class="page1"><span class="page1span label label-info">1</span></a></li>';
		$(".page").append(element);
		for(var i=2;i<=num_pages;i++){ 
			clas='page'+i+'span';
			element = '<li><a onclick="page(this);return false;"class="page'+i+'"><span class='+clas+'>'+i+'</span></a></li>';
			$(".page").append(element);
		}
		element = '<li><a onclick="page(this);return false;"class="pageNext">&raquo;</a></li>';
		$(".page").append(element);
					
	}
	else{
		element = '<li><a onclick="page(this);return false;"class="page1">1</a></li>';
		$(".page").append(element);
		
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
	prePage=currentPage;
	
	if (item.className=='pageNext'){
		currentPage++;
		getThreads(currentPage);
			
	}
	if (item.className=='pagePre'){
		currentPage--;
		getThreads(currentPage);
		
	}
	
	if ($.isNumeric(item.innerText)){
		currentPage=parseInt(item.innerText);
		getThreads(item.innerText);
	} 
	changeNums(prePage, currentPage);
}
	 	    	
function changeNums(tPrePage, tcPage) {
	
	prePage = tPrePage;	
	currentPage=tcPage;


	clas='.page'+prePage+'span';
	
	$(".page"+prePage).parent().attr("class","");
	$(clas).attr('class','page'+prePage+'span');
	
	clas='.page'+currentPage+'span';
	
	$(".page"+currentPage).parent().attr("class","active");
	$(clas).attr("class","page"+currentPage+"span label label-info");

	if(currentPage==1)
		$(".pagePre").parent().attr("class","active");
	else
	{
		$(".pagePre").parent().attr("class","");
		$(".pagePre").attr("href","/SelfCareCommunity/service/category/"+idCat+"/threads/page/"+(currentPage-1));
		$(".pageNext").attr("href","/SelfCareCommunity/service/category/"+idCat+"/threads/page/"+(currentPage+1));
	}
}

function paginationManagement(last, current){ // this function will handle the visualization of the elements
	if (last==true){
		$(".pageNext").hide();
	} else {
		$(".pageNext").show();
	} 
	if (current==1){
		$(".pagePre").hide();
	} else {
		$(".pagePre").show();
	}
	
	//in case the number of pages is bigger than 6...
	if (num_pages > 4) {
		$(".tempAfter").remove();	
		$(".tempBefore").remove();	
		for (i= 3; i<=(num_pages -2); i++){
				$(".page" + i).hide();	
			
		}
		if (current < (num_pages - 2) -1) {
			$(".page"+(current+1)).after("<span class='tempAfter'>. . .</span>");
		}	
		if (current > 4) {
			$(".page"+(current-1)).before("<span class='tempBefore'>. . .</span>");
		}
		for (i= 1; i<=num_pages; i++){
			if (( i == current)||  (i == current +1) || (i == current -1)) {
			
				$(".page" + i).show();	
			}
		}
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
			
			paginationManagement(lastPage,  currentPage);
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

function createNewThread() {
	location.href = "/SelfCareCommunity/content/createNewThread.html?categoryId=" + idCat;
}