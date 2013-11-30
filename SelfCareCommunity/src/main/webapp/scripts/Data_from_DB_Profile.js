function GetUserData () {
	//console.log(window.location.hostname);
	var url = window.location.href;
	var relativePath = "/SelfCareCommunity/service/currentuserdetails";
	var arr = url.split("/");
	var hostName = arr[0] + "//" + arr[2];
	//console.log(result);
	 //var url = "http://demo.group2.us.to:8080/SelfCareCommunity/service/currentuserdetails";
	var url = hostName + relativePath ;
	console.log(url);
	
	//url = 'http://localhost:8080/SelfCareCommunity/service/currentuserdetails';
	  //     http://localhost:8080/SelfCareCommunity/service/currentuserdetails 
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
		tbUserName.value = data.userName;
		tbName.value = data.name;
		tbSurName.value = data.surname;
		tbEmail.value = data.email;
		tbDofB.value = data.birthDate;
		tbGender.value = data.gender;
		tbZipCode.value = data.zipCode;
		tbInterests.value = data.interests;
		
		console.log(data);   
	}
}