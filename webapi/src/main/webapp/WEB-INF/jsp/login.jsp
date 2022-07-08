<html>
<head>
<title>Login</title>
<link href="webjars/bootstrap/5.0.1/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<h2>Login</h2>
	<form method="POST">
		Name : <input type="text" name="name" /> Password : <input
			type="password" name="password" /> <input type="submit" />
	</form>
	<p style="color: red;">${validationMessage}</p>

	<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
	<script src="webjars/bootstrap/5.0.1/js/bootstrap.min.js"></script>
</body>
</html>
