function sendPostToAddNewThread(url, jsonToSend) {
            $.ajax({
                  url: url,
                  type: "POST",
                  dataType: "json",
                  contentType: 'application/json; charset=utf-8',
                  data: JSON.stringify(jsonToSend),
                  success: function(id_data){
                      
                    //alert(JSON.stringify(id_data));
                      //$("#postSuccess").alert();
                      $("#threadSuccess").show();
                    
                     var url_thread="/SelfCareCommunity/content/view.html?id="+ id_data.id +"&displayName="+ jsonToSend.topic +"&postCount=1";
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