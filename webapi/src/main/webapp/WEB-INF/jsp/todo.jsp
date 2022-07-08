<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
<title>Welcome</title>
<link href="webjars/bootstrap/5.0.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<h2>Add Todos for ${name}</h2>
			<form:form method="post" class="form-group" modelAttribute="todo"> <!-- modelAttribute commandName -->
				<form:hidden path="id"/>
				<fieldset>
					<form:label path="desc">Description</form:label>
					<form:input type="text" path="desc" class="form-control" required="required" />
					<form:errors path="desc" cssClass="text-warning" />
				</fieldset>
				<button type="submit" class="btn btn-success">Add</button>
			</form:form>
	
		<div>
			<a href="/list-todos">Manage Todos</a>
		</div>
	</div>
	
	<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
	<script src="webjars/bootstrap/5.0.1/js/bootstrap.min.js"></script>
</body>
</html>
