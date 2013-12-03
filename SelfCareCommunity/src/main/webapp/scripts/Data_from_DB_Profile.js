function GetUserData () {
	var url = window.location.href;
	var relativePath = "/SelfCareCommunity/service/currentuserdetails";
	var arr = url.split("/");
	var hostName = arr[0] + "//" + arr[2];
	var url = hostName + relativePath ;
	
	$.getJSON(url, function(data) {
		mainfunction(data);
	});
	
	function mainfunction(data) {
		// getting textbox objects
		tbUserName = document.getElementById("tbUserName");
		tbName = document.getElementById("tbName");
		tbSurName = document.getElementById("tbSurName");
		tbEmail = document.getElementById("tbEmail");
		tbDofB = document.getElementById("tbDofB");
		tbGender = document.getElementById("tbGender");
		tbZipCode = document.getElementById("tbZipCode");
		tbInterests = document.getElementById("tbInterests");
		
		//adding value to these texboxes
		tbUserName.value = data.login;
		tbName.value = data.persons.name;
		tbSurName.value = data.persons.surname;
		tbEmail.value = data.email;
		tbDofB.value = data.persons.birthDate;
		tbGender.value = data.persons.gender;
		tbZipCode.value = data.persons.zipCode;
		tbInterests.value = data.persons.interests;

	}
}



function SaveEditedUserData() {
	var url = window.location.href;
	var relativePath = "/SelfCareCommunity/service/currentuserdetails";
	var arr = url.split("/");
	var hostName = arr[0] + "//" + arr[2];
	var url = hostName + relativePath ;
	
	
	// get the current values within the elements
	tbUserName = document.getElementById("tbUserName");
	tbName = document.getElementById("tbName");
	tbSurName = document.getElementById("tbSurName");
	tbEmail = document.getElementById("tbEmail");
	tbDofB = document.getElementById("tbDofB");
	tbGender = document.getElementById("tbGender");
	tbZipCode = document.getElementById("tbZipCode");
	tbInterests = document.getElementById("tbInterests");
	
	//building the JSON object

	var JSONobj = {
            "email": tbEmail.value,
            "persons":{
            "name":tbName.value,
			"surname":tbSurName.value,
            "birthDate":tbDofB.value,
			"gender": tbGender.value, 
			"zipCode": tbZipCode.value,
			"interest": tbInterests.value}
    };

	$.ajax({
        url: url,
        type: "POST",
        data: JSON.stringify(JSONobj),
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        async: false,
        success: function (result) {
            console.log(result);
        },
        error: function (xhr, ajaxOptions, thrownError) {
            console.log(xhr.status+"  "+thrownError);
        }
    });
}