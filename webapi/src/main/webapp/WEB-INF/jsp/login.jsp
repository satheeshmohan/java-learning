<%@ include file="common/header.jspf"%>
<div class="container">
	<h2>Login</h2>
	<form method="POST">
		Name : <input type="text" name="name" /> Password : <input
			type="password" name="password" /> <input type="submit" />
	</form>
	<p style="color: red;">${validationMessage}</p>
</div>
<%@ include file="common/footer.jspf"%>