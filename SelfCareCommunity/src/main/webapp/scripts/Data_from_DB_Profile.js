var username;
var name;
var surname;
var email;
var dateOfBirth;
var gender;
var zipCode;
var heartDesease;
var interests;

var url = composeUrl();

function loadUserData() {
	$.getJSON(url, function(data) {
		mainfunction(data);
	});
	
	function mainfunction(data) {
        //load values to variables
        username = data.login;
        name = data.person.name;
        surname = data.person.surname;
        email = data.email;
        dateOfBirth = data.person.birthDate.substr(0,9);
        gender = data.person.gender;
        zipCode = data.person.zipCode;
        heartDesease = data.person.disease;
        interests = data.person.interest;

        updateView();
	}
}
function updateView(){
    //set values for  ordinal view and edit view at the same time
    document.getElementById("lblUserName").innerHTML = username;
    document.getElementById("tbName").value = document.getElementById("lblName").innerHTML=name;
    document.getElementById("tbSurName").value = document.getElementById("lblSurName").innerHTML = surname;
    document.getElementById("tbEmail").value = document.getElementById("lblEmail").innerHTML = email;
    document.getElementById("tbDofB").value = document.getElementById("lblDofB").innerHTML = dateOfBirth;
    if(gender == 1){
        document.getElementById("lblGender").innerHTML = "Male";
        document.getElementById("radioMale").checked = true;
    } else {
        document.getElementById("lblGender").innerHTML = "Female";
        document.getElementById("radioFemale").checked = true;
    }
    document.getElementById("tbZipCode").value = document.getElementById("lblZipCode").innerHTML = zipCode;
    document.getElementById("tbHeartDisease").innerHTML = document.getElementById("lblHeartDisease").innerHTML = heartDesease;
    document.getElementById("tbInterests").innerHTML = document.getElementById("lblInterests").innerHTML = interests;
}

function updateVariables(){
    name = document.getElementById("tbName").value;
    surname = document.getElementById("tbSurName").value;
    email = document.getElementById("tbEmail").value;
    dateOfBirth = document.getElementById("tbDofB").value;
    if(document.getElementById("radioMale").checked){
        gender = 1
    }
    else{
        gender = 0;
    }
    zipCode = document.getElementById("tbZipCode").value;
    heartDesease = document.getElementById("tbHeartDisease").value;
    interests = document.getElementById("tbInterests").value;
}

function saveUserData() {

    updateVariables();

	//building the JSON object
	var JSONobj = {
            "email": email,
            "person":{
                "name":name,
                "surname":surname,
                "birthDate":dateOfBirth,
                "gender": gender,
                "zipCode": zipCode,
                "disease": heartDesease,
                "interest": interests
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
            updateView();
        },
        error: function (xhr, ajaxOptions, thrownError) {
            console.log(xhr.status+"  "+thrownError);
            updateView();
        }
    });
	
}

function composeUrl(){
    var relativePath = "/SelfCareCommunity/service/currentuserdetails";
    var arr = window.location.href.split("/");
    var hostName = arr[0] + "//" + arr[2];
    return hostName + relativePath
}