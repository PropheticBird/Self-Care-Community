
function loadUserData() {
    $.ajax({
            url: '/SelfCareCommunity/service/currentuserdetails',
            type: "GET",
            success: function(data) {
		        InitControls(data);
            }
	});
	
    function replace(str){
    	if(str==null)
    		return "";
    	else
    		return str;
    }
    
	function InitControls(data) {

		$('#lblUserName').text(data.login + " (login)");
		//initialize controls with data from database 
		$('#tbName').val(replace(data.person.name));
		$('#lblName').text(replace(data.person.name));
		
		$('#tbSurName').val(replace(data.person.surname));
		$('#lblSurName').text(replace(data.person.surname));
		
		$('#tbEmail').val(replace(data.email));
		$('#lblEmail').text(replace(data.email));
		
		if (data.person.birthDate){
			$('#tbDofB').val(replace(data.person.birthDate.substr(0,9)));
			$('#lblDofB').text(replace(data.person.birthDate.substr(0,9)));
		}
		
		if (data.person.gender == 1){
			$('#lblGender').text ('Male');
			$('#radioMale').attr('checked', true);
			$('#radioFemale').attr('checked', false);
		}
		else{
			$('#lblGender').text('Female');
			$('#radioFemale').attr('checked', true);
			$('#radioMale').attr('checked', false);
		}
		
		$('#tbZipCode').val(replace(data.person.zipCode));
		$('#lblZipCode').text(replace(data.person.zipCode));
		
		$('#tbHeartDisease').val(replace(data.person.disease));
		$('#lblHeartDisease').text(replace(data.person.disease));
		
		$('#tbInterests').val(replace(data.person.interest));
		$('#lblInterests').text(replace(data.person.interest));
	}
}

function updateData(){
	
	//update divs with information from textboxes
	
	$('#lblName').text($('#tbName').val());
	$('#lblSurName').text($('#tbSurName').val());
	$('#lblEmail').text($('#tbEmail').val());
	$('#lblDofB').text($('#tbDofB').val());
	$('input[name=sex]:checked', '.gender').val()==1?$('#lblGender').text ('Male'):$('#lblGender').text ('Female');
	$('#lblZipCode').text($('#tbZipCode').val());
	$('#lblHeartDisease').text($('#tbHeartDisease').val());
	$('#lblInterests').text($('#tbInterests').val());
	
	saveUserData();
}

function saveUserData() {
	//building the JSON object
	
	var JSONobj = {
            "email": $('#tbEmail').val(),
            "person":{
                "name":$('#tbName').val(),
                "surname":$('#tbSurName').val(),
                "birthDate":$('#tbDofB').val(),
                "gender": $('input[name=sex]:checked', '.gender').val(),
                "zipCode": $('#tbZipCode').val(),
                "disease": $('#tbHeartDisease').val(),
                "interest": $('#tbInterests').val()
            }
    };
	
	$.ajax({
        url: '/SelfCareCommunity/service/currentuserdetails',
        type: "POST",
        data: JSON.stringify(JSONobj),
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        async: false,
        success: function (result) {
            //console.log(result);
        },
        error: function (xhr, ajaxOptions, thrownError) {
            //console.log(xhr.status+"  "+thrownError);
        }
    });
}
