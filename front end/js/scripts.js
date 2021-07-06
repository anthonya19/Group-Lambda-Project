function create_new_account() {
	location.href = "CreateProfile.jsp";
}
function home_page() {
	location.href = "Delivery.jsp";

}
function Client_login() {
	location.href = "ClientLogin.jsp";
}
$("#driver-tab").click(function() {
	console.log("HEY");
	$(this).prop("class", "nav-link active");
	$("#client-tab").prop("class", "nav-link");
	//$(this).prop("aria-selected", "true");
	$("#client-form").prop("class", "tab-pane fade shows");
	$("#driver-form").prop("class", "tab-pane fade shows active");
	
	//$("#client-tab").prop("aria-selected", "false");

});

$("#client-tab").click(function() {
	console.log("HEY");
	$(this).prop("class", "nav-link active");
	$("#driver-tab").prop("class", "nav-link");
	//$(this).prop("aria-selected", "true");
	$("#driver-form").prop("class", "tab-pane fade shows");
	$("#client-form").prop("class", "tab-pane fade shows active");
	
	//$("#driver-tab").prop("aria-selected", "false");
	
});