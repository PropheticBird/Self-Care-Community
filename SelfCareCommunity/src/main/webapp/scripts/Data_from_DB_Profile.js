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
		tbUserName.value = data.personCredentials.userName;
		tbName.value = data.name;
		tbSurName.value = data.surname;
		tbEmail.value = data.personCredentials.email;
		tbDofB.value = data.birthDate;
		tbGender.value = data.gender;
		tbZipCode.value = data.zipCode;
		tbInterests.value = data.interests;

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
	var JSONobjCred = {"username": tbUserName.value, "email": tbEmail.value};
	var JSONobj = { "name":tbName.value,
			"surname":tbSurName.value, 
			"gender": tbGender.value, 
			"zipCode": tbZipCode.value, 
			//'personCredentials':JSONobjCred,
			"interests": tbInterests.value};
	//var JSONobj = { "name":tbName.value};
	
	
	//console.log($.post(url,JSONobj));

	$.ajax({
        url: url,
        type: "POST",
        data: JSONobj,
        dataType:'json', 
        success: function (result) {
            switch (result) {
                case true:
                    window.alert(result);
                    break;
                default:
                    window.alert(result);
            }
        },
        error: function (xhr, ajaxOptions, thrownError) {
        alert(xhr.status);
        alert(thrownError);
        }
    });
}