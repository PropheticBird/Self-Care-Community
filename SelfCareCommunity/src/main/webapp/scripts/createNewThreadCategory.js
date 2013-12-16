$(document).ready(function() {

    $("#new-header").load("header.html");

    var params = parseParams(window.location.search.substr(1));

    $("#btnThreadNewPage").click(function(){
        var topic=$.trim($("#topicSeparatePage").val());
        var content=$.trim($("#contentSeparatePage").val());

        if(content.length==0 || topic.length==0)
            return false;

        else{
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
});