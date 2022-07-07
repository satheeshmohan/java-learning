<html>
<head>
<title>My Profile</title>
<link href="webjars/bootstrap/5.0.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<h2>My Profile</h2>
	<form method="POST">
		<div>Name : <input type="text" name="name" value="${name}" /></div>
		<div>Email : <input type="text" name="email" value="${email}" /></div>
		<div>DOB : <input type="text" name="dob" value="${dob}" /></div>
		<div>Address : <input type="text" name="address" value="${address}" /></div>
		<div>City : <input type="text" name="city" value="${city}" /></div>
		<div>Country : <input type="text" name="country" value="${country}" /></div>
		<div>Pin : <input type="text" name="pin" value="${pin}" /></div>
		<div><input type="submit" value="Save"/></div>
	</form>
	
	<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
	<script src="webjars/bootstrap/5.0.1/js/bootstrap.min.js"></script>
</body>
</html>
