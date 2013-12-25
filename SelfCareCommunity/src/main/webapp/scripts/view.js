    var currentPage=1;
    var threadId=0;
    var params={};
    var num_pages=0;

$(document).ready(function() {
    
    //Loading templates
    $(".pagination-container").load("template/pagination.html");
    $("#new-header").load("header.html");
    
    var prmstr = window.location.search.substr(1);
    var prmarr = prmstr.split ("&");

	 	
    for ( var i = 0; i < prmarr.length; i++) {
    	 var tmparr = prmarr[i].split("=");
    	
        params[tmparr[0]] = decodeURIComponent(tmparr[1]);
       
    }
    
	threadId=params['id'];
	var postCount=parseInt(params['postCount']);
	num_pages=parseInt(postCount/5)+1;
	
	getPosts(1);

	$("#threadId").text(threadId);
	$("#title").text(params['displayName']);
			
	$("#btnPost").click(function(){
		var id=$("#threadId").html();
		var content=$.trim($("#content").val());
		var url="/SelfCareCommunity/service/thread/"+id+"/newpost";
		
		if(content.length==0)
			return false;
		else{
			$.ajax({
				  url: url,
				  type: "POST",
				  dataType: "json",
				  contentType: 'application/json; charset=utf-8',
				  data: JSON.stringify({ "content":content}),
				  success: function(){
					  $("#postSuccess").show();
					 var lastpage=parseInt(params['postCount']/5)+1;
					 getPosts(lastpage);


					 $('#content').val("");
				  },
				  error: function(xhr, ajaxOptions, thrownError){
					  $("#postFail").show();
				  }
				  
			});
			return false;
		}
	});	
});

function getPosts(pagNum){
	var url = "/SelfCareCommunity/service/thread/"+threadId+"/posts/page/"+pagNum;
	$.ajax({
		url: url,
		type: "get",
		dataType: "json",
		success: function(result){
		
		$("#postList").html("");
			data=result.data;
			for(var i=0;i<data.length;i++){
				var id=data[i].id;
				var author=data[i].author.name;
				var content=data[i].content;
				var date=data[i].postedDate;
				var likes=data[i].likes;
				var dislikes=data[i].dislikes;
							
				$("#postList").append("<div id='post"+id+"'></div>");
				$("#post"+id).loadTemplate("template/post.html",
				{
					authorPic: '../resources/img/avatar.png',
					author: author,
					content: content,
					date: date,
					likes: likes+" good advices",
					dislikes: dislikes+" bad advices",
					postId: data[i].id,
					canLike: !data[i].canLike,
					canDislike: !data[i].canDislike
				});
		}
			initalizePagination(params['postCount'], 5, getPosts);
	        paginationManageArrows(result.last);
	        paginationManagement(pagNum, num_pages);
			$("#container").show();
		}
		});
	}	

function like(item,identify){
    
 	 var id=parseInt($(item).attr("alt"));
 	
 	 var url="/SelfCareCommunity/service/post/"+id+"/like";
 	 
 	 if(identify=="1"){
 		 $.ajax({
 			 url:url,
 			 type:"PUT",
 			 success:function(result){
 
 				var like=$(item).parent().parent().find("p")[1];
 				var likeContent=like.innerHTML;
 				var num=parseInt(likeContent.replace(/[^\d]/g,''));
 				if(likeContent.indexOf("-")>=0){
 					num=0-num;
     				//alert(num);
 				}
 				num=num+1;
 				//alert(likeContent.replace(/[^(\d | '-')]/g,''));
 				$(item).parent().parent().find("p")[1].innerHTML=num+" good advices";	 
 						 
 			 }
 		 });
 	 }
 	 else{
 		 $.ajax({
 			 url:url,
 			 type:"DELETE",
 			 success:function(result){
 				var like=$(item).parent().parent().find("p")[2];
 				var likeContent=like.innerHTML;
 				var num=parseInt(likeContent.replace(/[^\d]/g,''));
 				if(likeContent.indexOf("-")>=0){
 					num=0-num;
     				//alert(num);
 				}
 				num=num+1;
 				$(item).parent().parent().find("p")[2].innerHTML=num+" bad advices";	   			 
			}
 		 });
 	 }
 	
 	$(item).attr("disabled","true");
 	$(item).siblings().attr("disabled","true");
  }

//zoom functionality	
var CurrentWidth = 0;	
var CurrentHeight = 0;	
var zoom=0;

function ZoomOut(){
	 if (zoom > 10) {
		 zoom = zoom - 10; 
	 	$('.posts').css('zoom', '1'+zoom+'%')
	 } 
		 
	if (zoom == 10) {
		zoom = 0;
	 	$('.posts').css('zoom', '100%')
	 	 document.getElementById("zoomOut").setAttribute("style","display:none");  
	}

}

function ZoomIn (){
	 document.getElementById("zoomOut").setAttribute("style","display:block"); 
	 if (zoom <= 80) {
		 zoom = zoom + 10; 
		 $('.posts').css('zoom', '1'+zoom+'%');
		 //
		 width = $("#postList").width();
			width = width + 50;
		 $("#postList").width(width + "px");
	 } else
		 window.alert("You cannot Zoom In more");
		
}