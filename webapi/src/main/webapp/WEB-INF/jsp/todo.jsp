<html>
<head>
<title>Welcome</title>
<link href="webjars/bootstrap/5.0.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<h2>Add Todos for ${name}</h2>
			<form method="post" class="form-group">
				<fieldset>
					<label>Description</label>
					<input type="text" name="desc" class="form-control" required="required" />
				</fieldset>
				<button type="submit" class="btn btn-success">Add</button>
			</form>
	
		<div>
			<a href="/list-todos">Manage Todos</a>
		</div>
	</div>
	
	<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
	<script src="webjars/bootstrap/5.0.1/js/bootstrap.min.js"></script>
</body>
</html>
