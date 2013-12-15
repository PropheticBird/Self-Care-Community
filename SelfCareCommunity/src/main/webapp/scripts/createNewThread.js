function gnida() {
            //alert('inside function');
            var prmstr = window.location.search.substr(1);
            var prmarr = prmstr .split ("&");
            var params = {};

            for ( var i = 0; i < prmarr.length; i++) {
                var tmparr = prmarr[i].split("=");
                params[tmparr[0]] = decodeURIComponent(tmparr[1]);
            }

            var topic=$.trim($("#topicSeparatePage").val());
            var content=$.trim($("#contentSeparatePage").val());

            var jsonToSend = { "topic" : topic, "content" : content };

            var url = "/SelfCareCommunity/service/category/"+params['categoryId']+"/newthread";

            sendPostToAddNewThread(url, jsonToSend);
        }