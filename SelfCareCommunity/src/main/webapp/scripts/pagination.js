var currentPage=1;

function initalizePagination(itemsCount, itemsPerPage, itemClickFunction){

    var pageCount = parseInt(itemsCount/itemsPerPage)+1;
    $(".page").html("");

    element = '<li><a class="pagePre">&laquo</a></li>';
    $(".page").append(element);
    for(var i=1;i<=pageCount;i++){
         var activeClass = "";
         element = '<li class="'+activeClass+'"><a class="pagination-item page' + i +'">'+i+'</a></li>';
         if(i==currentPage){
        	 element = '<li class="active"><a class="pagination-item page' + i +'"> <span class="badge badge-info">'+i+'</span></a></li>';
             activeClass = "active";    
         }
       
        $(".page").append(element);
    }
    element = '<li><a class="pageNext">&raquo;</a></li>';
    $(".page").append(element);
    $(".pagination-item").click(function(){
                currentPage=parseInt(this.innerHTML);
                itemClickFunction(this.innerHTML);
    });
    $(".pagePre").click(function(){
        itemClickFunction(--currentPage);
    });
    $(".pageNext").click(function(){
        itemClickFunction(++currentPage);
    });
}



function paginationManagement( current, num_pages){ // this function will handle the visualization of the elements
	//in case the number of pages is bigger than 6... 
	if (num_pages > 6) {
		$(".tempAfter").remove();	
		$(".tempBefore").remove();
		
		for (i= 3; i<=(num_pages-2); i++){
				$(".page" + i).hide();	
		}
		
		if (current < (num_pages - 2) -1) {	
			tmp = parseInt(current) + 1;
			$(".page"+tmp).after("<span class='tempAfter'>. . .</span>");
		}	
		if (current > 4) {
			tmp = parseInt(current) - 1;
			$(".page"+ tmp ).before("<span class='tempBefore'>. . .</span>");
		}
		
		for (i= 1; i<=num_pages; i++){
			current = parseInt(current);
			if (( i == current)||  (i == current + 1) || (i == current -1)) {
				
				$(".page" + i).show();	
			}
		}


	}
	
	
}

function paginationManageArrows(lastPage){
    if (lastPage==true){
        $(".pageNext").hide();
        $(".page li:nth-last-child(2) a").css({"border-bottom-right-radius":"6px","border-top-right-radius":"6px","border-width":"1px"});
    } else {
        $(".pageNext").show();
        $(".page li:nth-last-child(2) a").css({"border-bottom-right-radius":"","border-top-right-radius":"","border-width":""});
    }
    if (currentPage==1){
        $(".pagePre").hide();
        $(".page li:nth-child(2) a").css({"border-bottom-left-radius":"6px","border-top-left-radius":"6px","border-width":"1px"});
    } else {
        $(".pagePre").show();
        $(".page li:nth-child(2) a").css({"border-bottom-left-radius":"","border-top-left-radius":"","border-width":""});
    }
}