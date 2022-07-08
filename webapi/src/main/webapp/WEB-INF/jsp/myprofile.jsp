<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<h2>My Profile</h2>
	<form:form method="POST" class="form-group" modelAttribute="profile">
		<!-- modelAttribute commandName -->
		<fieldset>
			<form:label path="name">Name</form:label>
			<form:input path="name" type="text" value="${name}" />
		</fieldset>
		<fieldset>
			<form:label path="email">Email</form:label>
			<form:input path="email" type="text" value="${email}" />
			<form:errors path="email" cssClass="text-warning"></form:errors>
		</fieldset>
		<fieldset>
			<form:label path="dob">DOB</form:label>
			<form:input path="dob" type="text" value="${dob}" />
		</fieldset>
		<fieldset>
			<form:label path="address">Address</form:label>
			<form:input path="address" type="text" value="${address}" />
		</fieldset>
		<fieldset>
			<form:label path="city">City</form:label>
			<form:input path="city" type="text" value="${city}" />
		</fieldset>
		<fieldset>
			<form:label path="country">Country</form:label>
			<form:input path="country" type="text" value="${country}" />
		</fieldset>
		<fieldset>
			<form:label path="pin">Pin</form:label>
			<form:input path="pin" type="text" value="${pin}" />
		</fieldset>
		<div class="text-warning">${error}</div>
		<div>
			<input type="submit" value="Save" />
		</div>
	</form:form>
	<%@ include file="common/footer.jspf"%>