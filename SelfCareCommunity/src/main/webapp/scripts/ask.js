$(document).ready(function() {
    var array;
    var topic;

    var data = [];
    var url = "/SelfCareCommunity/service/problems";
    
    $("#problems").hide();
    $("#problems_loading").show();

    $.ajax({
        url : url,
        type : "get",
        dataType : "json",
        success : function(result) {
            data = result;

            console.log("Lenght: "+data.length);
            console.log("Problem: "+data[0].isProblem);
            $("#row-body").html("");

            $("#problems").show();
            $("#problems_loading").hide();  

            for (var i = 0; i < data.length; i++) {
                $("#row-body").append("<div id='row"+i+"'></div>");
                var id = data[i].id;
                if(data[i].isProblem){
                    topic= "<a href='http://localhost:8080/SelfCareCommunity/content/solutionView.html?id="+id+"'>Problem</a>";
                }
                else{
                    topic= "<a href='http://localhost:8080/SelfCareCommunity/content/solutionView.html?id="+id+"'>Solution</a>";
                }
                
                 
                var whenVar = data[i].description.when;
                var descVar = data[i].description.where;
                
                if(topic == null)
                    topic = "Problem";
                else if(whenVar == null)
                    whenVar = "When";
                else if(descVar == null)
                    descVar = "Description";
                
                
                $("#row" + i).append("<h3 style='margin-bottom: -10px;'>" + topic + "</h3><br><h4 style='margin-top: 0px;'>"+whenVar+"</h4><h4 style='margin-top: 0px;'>"+descVar+"</h4><hr/>");
            }
        }

    });

});