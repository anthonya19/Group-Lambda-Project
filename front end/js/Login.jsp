<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Food Delivery</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/icon.png" />
<!-- Bootstrap icons-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
	rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="css/styles.css" rel="stylesheet" />
<link href="css/ClientFormStyles.css" rel="stylesheet" />
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
	<!-- Responsive navbar-->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container px-5">
			<a class="navbar-brand" href="#!">Food Delivery</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="#!">About</a></li>
					<li class="nav-item"><a class="nav-link" href="#!">Contact</a></li>
					<li class="nav-item"><a class="nav-link" href="#!">Services</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- Header-->
	<!-- 	<header class=" py-5">
		<div class="container px-5"
			style="background-image: url('assets/background2.png'); height: 400px; width: 1200px;">
			<div class="row gx-5 justify-content-center">
				<div class="col-lg-6">
					<div class="text-center my-5">
						<h1 class="display-5 fw-bolder text-white mb-2">MThree Food
							Delivery Application</h1>
						<p class="lead text-white mb-4">Login</p>
						<div class="d-grid gap-3 d-sm-flex justify-content-sm-center">
							 <a class="btn btn-primary btn-lg px-4 me-sm-3" onclick="Client_login()">Login</a>
                                <a class="btn btn btn btn-light btn-lg px-4"  onclick=" create_new_account()">Create a New Account</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header> -->

	<!-- 	<div class="container register">
		<div class="row">
			<div class="col-md-3 register-left">
				<img src="assets/icon2.jpg" alt="" />
				<h3>Welcome</h3>
				<p>To Our Food Delivery Application</p>

				<br />
			</div>
			<div class="col-md-9 register-right">
				<div class="tab-content" id="myTabContent">
					<div class="tab-pane fade show active" id="client-form"
						role="tabpanel" aria-labelledby="client-tab">
						<h3 class="register-heading">Login Into Your Account</h3>
						<div class="row register-form">
							<div class="col-md-6">
								<form action="clientLogin" method="post">
									<div class="form-group">
										<label for="email">Email:</label> <input type="email"
											class="form-control" id="email" placeholder="Enter email"
											name="email">
									</div>
									<div class="form-group">
										<label for="pwd">Password:</label> <input type="password"
											class="form-control" id="pwd" placeholder="Enter password"
											name="pwd">
									</div>
									<div class="checkbox">
										<label><input type="checkbox" name="remember">
											Remember me</label>
									</div>
									<button type="submit" class="btn btn-default">Submit</button>
								</form>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>

	</div>
 -->
	<div class="container register">
		<div class="row">
			<div class="col-md-3 register-left">
				<img src="assets/icon2.jpg" alt="" />
				<h3>Welcome</h3>
				<p>To Our Food Delivery Application</p>
				<br />
			</div>
			<div class="col-md-9 register-right">
				<!--     <ul class="nav nav-tabs" id="myTab" role="tablist">
                            <li class="nav-item">
                                <a class="nav-link active" id="client-tab" data-toggle="tab" role="tab" aria-controls="client" onclick="createClient()" aria-selected="true">Client</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" id="driver-tab" data-toggle="tab" role="tab" aria-controls="driver" onclick="createDriver()" aria-selected="false">Driver</a>
                            </li>
                             <li class="nav-item">
                                <a class="nav-link" id="restaurant-tab" data-toggle="tab" role="tab" aria-controls="restaurant" aria-selected="false">Restaurant</a>
                            </li> 
                        </ul> -->
				<nav class="nav nav-pills flex-column flex-sm-row">
					<a class="flex-sm-fill text-sm-center nav-link active"
						aria-current="page" id="client-tab" onclick="createClientform()">Client</a>
					<a class="flex-sm-fill text-sm-center nav-link" aria-current="page"
						id="driver-tab" onclick="createDriverform()">Driver</a> <a
						class="flex-sm-fill text-sm-center nav-link" aria-current="page"
						id="restaurant-tab" onclick="createRestaurantform()">Restaurant</a>

				</nav>
				<div class="tab-content" id="myTabContent">
					<div class="tab-pane fade show active" id="client-form"
						role="tabpanel" aria-labelledby="client-tab">
						<h3 class="register-heading">Login as a Client</h3>
						<div class="row register-form">
							<div class="col-md-6">
								<form action="clientLogin" id="client-login-form"
									onsubmit="return clientLogin()" method="post">
									<!-- -->
									<div class="form-group">
										<label for="pseudo">Pseudo:</label> <input type="pseudo"
											class="form-control" id="client-login-pseudo"
											placeholder="Enter Your UserName" name="pseudo">
									</div>
									<div class="form-group">
										<label for="pwd">Password:</label> <input type="password"
											class="form-control" id="client-login-pwd"
											placeholder="Enter password" name="pwd">
									</div>
									<!-- <div class="checkbox">
										<label><input type="checkbox" name="remember">
											Remember me</label>
									</div> -->
									<button type="submit" class="btn btn-default">Submit</button>
								</form>
							</div>
						</div>

					</div>
					<div class="tab-pane fade show" id="driver-form" role="tabpanel"
						aria-labelledby="driver-tab">
						<h3 class="register-heading">Login as a Driver</h3>
						<div class="row register-form">
							<div class="col-md-6">
								<form action="driverLogin" onsubmit="return driverLogin()"
									method="post">
									<div class="form-group">
										<label for="email">Email:</label> <input type="email"
											class="form-control" id="driver-login-email"
											placeholder="Enter email" name="email">
									</div>
									<div class="form-group">
										<label for="pwd">Password:</label> <input type="password"
											class="form-control" id="driver-login-pwd"
											placeholder="Enter password" name="pwd">
									</div>
									<div class="checkbox">
										<label><input type="checkbox" name="remember">
											Remember me</label>
									</div>
									<button type="submit" class="btn btn-default">Submit</button>
								</form>
							</div>
						</div>

					</div>
					<div class="tab-pane fade show" id="restaurant-form"
						role="tabpanel" aria-labelledby="driver-tab">
						<h3 class="register-heading">Login as a Restaurant</h3>
						<div class="row register-form">
							<div class="col-md-6">
								<form action="restaurantLogin"
									onsubmit="return restaurantLogin()" method="post">
									<div class="form-group">
										<label for="email">Email:</label> <input
											type="restaurant-login-email" class="form-control"
											id="restaurant-login-email" placeholder="Enter email"
											name="email">
									</div>
									<div class="form-group">
										<label for="pwd">Password:</label> <input type="password"
											class="form-control" id="pwd" placeholder="Enter password"
											name="pwd">
									</div>
									<div class="checkbox">
										<label><input type="checkbox" name="remember">
											Remember me</label>
									</div>
									<button type="submit" class="btn btn-default">Submit</button>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>




	<!-- Contact section-->
	<section class="bg-light py-5">
		<div class="container px-5 my-5 px-5">
			<div class="text-center mb-5">
				<div
					class="feature bg-primary bg-gradient text-white rounded-3 mb-3">
					<i class="bi bi-envelope"></i>
				</div>
				<h2 class="fw-bolder">Get in touch</h2>
				<p class="lead mb-0">We'd love to hear from you</p>
			</div>
			<div class="row gx-5 justify-content-center">
				<div class="col-lg-6">
					<!-- * * * * * * * * * * * * * * *-->
					<!-- * * SB Forms Contact Form * *-->
					<!-- * * * * * * * * * * * * * * *-->
					<!-- This form is pre-integrated with SB Forms.-->
					<!-- To make this form functional, sign up at-->
					<!-- https://startbootstrap.com/solution/contact-forms-->
					<!-- to get an API token!-->
					<form action="delivery" method="post">
						<!-- Name input-->
						<div class="form-floating mb-3">
							<input class="form-control" name="name" type="text"
								placeholder="Enter your name..." data-sb-validations="required" />
							<label for="name">Full name</label>
							<div class="invalid-feedback" data-sb-feedback="name:required">A
								name is required.</div>
						</div>
						<!-- Email address input-->
						<div class="form-floating mb-3">
							<input class="form-control" name="email" type="email"
								placeholder="name@example.com"
								data-sb-validations="required,email" /> <label for="email">Email
								address</label>
							<div class="invalid-feedback" data-sb-feedback="email:required">An
								email is required.</div>
							<div class="invalid-feedback" data-sb-feedback="email:email">Email
								is not valid.</div>
						</div>
						<!-- Phone number input-->
						<div class="form-floating mb-3">
							<input class="form-control" name="phone" type="tel"
								placeholder="(123) 456-7890" data-sb-validations="required" />
							<label for="phone">Phone number</label>
							<div class="invalid-feedback" data-sb-feedback="phone:required">A
								phone number is required.</div>
						</div>
						<!-- Message input-->
						<div class="form-floating mb-3">
							<textarea class="form-control" name="message" type="text"
								placeholder="Enter your message here..." style="height: 10rem"
								data-sb-validations="required"></textarea>
							<label for="message">Message</label>
							<div class="invalid-feedback" data-sb-feedback="message:required">A
								message is required.</div>
						</div>
						<!-- Submit success message-->
						<!---->
						<!-- This is what your users will see when the form-->
						<!-- has successfully submitted-->
						<div class="d-none" id="submitSuccessMessage">
							<div class="text-center mb-3">
								<div class="fw-bolder">Form submission successful!</div>
								<br />
							</div>
						</div>

						<div class="d-none" id="submitErrorMessage">
							<div class="text-center text-danger mb-3">Error sending
								message!</div>
						</div>
						<!-- Submit Button-->
						<div class="d-grid">
							<button class="btn btn-primary btn-lg" id="submitButton"
								type="submit">Submit</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>
	<!-- Footer-->
	<footer class="py-5 bg-dark">
		<div class="container px-5">
			<p class="m-0 text-center text-white">Copyright &copy; Your
				Website 2021</p>
		</div>
	</footer>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>
</body>
</html>
