var currentPage=1;

function initalizePagination(itemsCount, itemsPerPage, itemClickFunction){

    var pageCount = parseInt(itemsCount/itemsPerPage)+1;
    $(".page").html("");

    element = '<li><a class="pagePre">&laquo</a></li>';
    $(".page").append(element);
    for(var i=1;i<=pageCount;i++){

        element = '<li><a class="pagination-item">'+i+'</a></li>';
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