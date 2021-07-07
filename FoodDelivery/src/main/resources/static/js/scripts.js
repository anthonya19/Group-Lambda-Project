function create_new_account() {
	location.href = "CreateProfile.html";
}
function home_page() {
	location.href = "Delivery.html";

}
function logIn() {
	location.href = "Login.html";
}
function createDriverform() {
	var client_form = document.getElementById("client-form");
	var driver_form = document.getElementById("driver-form");
	var restaurant_form = document.getElementById("restaurant-form");
	$("#driver-tab").prop("class", "flex-sm-fill text-sm-center nav-link active");
	$("#client-tab").prop("class", "flex-sm-fill text-sm-center nav-link");
	$("#restaurant-tab").prop("class", "flex-sm-fill text-sm-center nav-link");
	driver_form.style.display = "block";
	client_form.style.display = "none";
	restaurant_form.style.display = "none";
}
function createClientform() {
	var client_Form = document.getElementById("client-form");
	var driver_form = document.getElementById("driver-form");
	var restaurant_form = document.getElementById("restaurant-form");
	$("#client-tab").prop("class", "flex-sm-fill text-sm-center nav-link active");
	$("#driver-tab").prop("class", "flex-sm-fill text-sm-center nav-link");
	$("#restaurant-tab").prop("class", "flex-sm-fill text-sm-center nav-link");
	client_Form.style.display = "block";
	driver_form.style.display = "none";
	restaurant_form.style.display = "none";
}
function createRestaurantform() {
	var client_form = document.getElementById("client-form");
	var driver_form = document.getElementById("driver-form");
	var restaurant_form = document.getElementById("restaurant-form");
	$("#restaurant-tab").prop("class", "flex-sm-fill text-sm-center nav-link active");
	$("#driver-tab").prop("class", "flex-sm-fill text-sm-center nav-link");
	$("#client-tab").prop("class", "flex-sm-fill text-sm-center nav-link");
	restaurant_form.style.display = "block";
	client_form.style.display = "none";
	driver_form.style.display = "none";
}
function clientLogin() {
	var client_login_pseudo = document.getElementById("client-login-pseudo");
	var client_login_pwd = document.getElementById("client-login-pwd");
	if (client_login_pseudo["value"] == "" || client_login_pwd["value"] == "") {
		alert("UserName and Password Can't be Empty'");
		//client_login_email.prop("class","form-control is-invalid")
		return false;
	}
	else {
		// ajax request to a method
		
		return true;
	}

}

function driverLogin() {
	var driver_login_email = document.getElementById("driver-login-email");
	var driver_login_pwd = document.getElementById("driver-login-pwd");
	if (driver_login_email["value"] == "" || driver_login_pwd["value"] == "") {
		alert("Email and Password Can't be Empty'");
		//client_login_email.prop("class","form-control is-invalid")
		return false;
	}
	else {
		return true;
	}

}
function restaurantLogin() {
	var restaurant_login_email = document.getElementById("restaurant-login-email");
	var restaurant_login_pwd = document.getElementById("restaurant-login-pwd");
	if (restaurant_login_email["value"] == "" || restaurant_login_pwd["value"] == "") {
		alert("Email and Password Can't be Empty'");
		//client_login_email.prop("class","form-control is-invalid")
		return false;
	}
	else {
		return true;
	}

}


function createClient(){
var client_pseudo = document.getElementById("clientPseudo");
var client_address = document.getElementById("clientAddress");	
var client_pwd=document.getElementById("clientPWD");
var client_pwd2=document.getElementById("clientPWD2");
if (client_pseudo["value"] == "" || client_address["value"] == "" ||client_pwd["value"]==""||client_pwd2["value"]=="") {
		alert("Fields Can't be Empty'");
		//client_login_email.prop("class","form-control is-invalid")
		return false;
	}
if (client_pwd["value"] != client_pwd2["value"]) {
		alert("Passwords Does not Match");
		//client_login_email.prop("class","form-control is-invalid")
		return false;
	}		
}


function createDriver(){
var driver_pseudo = document.getElementById("driverpseudo");
var driver_pwd=document.getElementById("driverpwd");
var driver_pwd2=document.getElementById("driverrepwd");
if (driver_pseudo["value"] == "" || driver_pwd["value"] == "" ||driver_pwd["value"]==""||driver_pwd2["value"]=="") {
		alert("Fields Can't be Empty'");
		//client_login_email.prop("class","form-control is-invalid")
		return false;
	}
if (driver_pwd["value"] != driver_pwd2["value"]) {
		alert("Passwords Does not Match");
		//client_login_email.prop("class","form-control is-invalid")
		return false;
	}		
}



function createRestaurant(){
	var restaurant_name=document.getElementById("RName");
	var restaurant_pseudo=document.getElementById("Rpseudo");
	var restaurant_pwd=document.getElementById("Rpwd");
	var restaurant_pwd2=document.getElementById("Rpwd2");
if (restaurant_name["value"] == "" ||restaurant_pseudo["value"]=="" ||restaurant_pwd["value"] == ""||restaurant_pwd2["value"] == "" ) {
		alert("Fields Can't be Empty'");
		//client_login_email.prop("class","form-control is-invalid")
		return false;
	}
if (restaurant_pwd["value"] != restaurant_pwd2["value"]) {
		alert("Passwords Does not Match");
		//client_login_email.prop("class","form-control is-invalid")
		return false;
	}		
}
