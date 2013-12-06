
var radioValue;
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

		//Getting label objects
		lblUsername = document.getElementById("lblUsername");
		lblName = document.getElementById("lblName");
		lblSurname = document.getElementById("lblSurname");
		lblEmail = document.getElementById("lblEmail");
		lblDofB = document.getElementById("lblDofB");
		radioMale = document.getElementById("radioMale");
		radioFemale = document.getElementById("radioFemale");
		lblZipCode = document.getElementById("lblZipCode");
		lblHeartDisease = document.getElementById("lblHeartDisease");
		lblInterests = document.getElementById("lblInterests");
		
		//adding text to these labels
		lblUsername.innerHTML = data.login;
		lblName.innerHTML = data.person.name;
		lblSurname.innerHTML = data.person.surname;
		lblEmail.innerHTML = data.email;
		lblDofB.innerHTML = data.person.birthDate;
		lblZipCode.innerHTML = data.person.zipCode;
		lblHeartDisease.innerHTML = data.person.disease;
		lblInterests.innerHTML = data.person.interest;
		
		radioValue = data.person.gender;
		//set radio button checked
		if(radioValue == 0){
			radioMale.checked=true;
		}
		else{
			radioFemale.checked=true;
		}
		
	}
}
function EditUserData () {
	var url = window.location.href;
	var relativePath = "/SelfCareCommunity/service/currentuserdetails";
	var arr = url.split("/");
	var hostName = arr[0] + "//" + arr[2];
	var url = hostName + relativePath ;
	
	$.getJSON(url, function(data) {
		mainfunction(data);
	});
	
	function mainfunction(data) {

		
		 //getting textbox objects
			tbUserName = document.getElementById("tbUserName");
			tbName = document.getElementById("tbName");
			tbSurName = document.getElementById("tbSurName");
			tbEmail = document.getElementById("tbEmail");
			tbDofB = document.getElementById("tbDofB");
			radioMale = document.getElementById("radioMale1");
			radioFemale = document.getElementById("radioFemale1");
			tbZipCode = document.getElementById("tbZipCode");
			tbHeartDisease = document.getElementById("tbHeartDisease");
			tbInterests = document.getElementById("tbInterests");
			
			tbUserName.value = data.login;
			tbName.value = data.person.name;
			tbSurName.value = data.person.surname;
			tbEmail.value = data.email;
			tbDofB.value = data.person.birthDate;
			tbZipCode.value = data.person.zipCode;
			tbHeartDisease.value = data.person.disease;
			tbInterests.value = data.person.interest;
			
			//set radio button checked
			if(radioValue == 0){
				radioMale1.checked=true;
			}
			else{
				radioFemale1.checked=true;
			}
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
	radioMale = document.getElementById("radioMale1");
	radioFemale = document.getElementById("radioFemale1");
	tbZipCode = document.getElementById("tbZipCode");
	tbHeartDisease = document.getElementById("tbHeartDisease");
	tbInterests = document.getElementById("tbInterests");
	console.log("RadioMale: "+radioMale.checked);
	console.log("RadioFeMale: "+radioFemale.value);

	//Get correct value for radio button
	if(radioMale.checked){
		radioValue = radioMale.value;
	}
	else{
		radioValue = radioFemale.value;
	}

	//building the JSON object
	var JSONobj = {
            "email": tbEmail.value,
            "person":{
            "name":tbName.value,
			"surname":tbSurName.value,
            "birthDate":tbDofB.value,
			"gender": radioValue, 
			"zipCode": tbZipCode.value,
			"disease": tbHeartDisease.value,
			"interest": tbInterests.value
            	}
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
            GetUserData();
        },
        error: function (xhr, ajaxOptions, thrownError) {
            console.log(xhr.status+"  "+thrownError);
            GetUserData(); //Works but have to fix.
        }
    });
	
}