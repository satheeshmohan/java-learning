<html>
<head>
<title>Welcome</title>
<link href="webjars/bootstrap/5.0.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	Welcome ${name}
	<div><a href="myprofile?username=${name}">My Profile</a></div>
	<div><a href="/list-todos">Click here</a> to manage your todos</div>
	<div><a href="/logout">Logout</a></div>
	
	<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
	<script src="webjars/bootstrap/5.0.1/js/bootstrap.min.js"></script>
</body>
</html>
