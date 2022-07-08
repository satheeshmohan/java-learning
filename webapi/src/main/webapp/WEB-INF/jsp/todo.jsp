<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<%@ include file="common/footer.jspf"%>

<div class="container">
	<h2>Add Todos for ${name}</h2>
	<form:form method="post" class="form-group" modelAttribute="todo">
		<!-- modelAttribute commandName -->
		<form:hidden path="id" />
		<fieldset>
			<form:label path="desc">Description</form:label>
			<form:input type="text" path="desc" class="form-control"
				required="required" />
			<form:errors path="desc" cssClass="text-warning" />
		</fieldset>
		<fieldset>
			<form:label path="targetDate">Target Date</form:label>
			<form:input type="text" path="targetDate" class="form-control"
				required="required" />
			<form:errors path="targetDate" cssClass="text-warning" />
		</fieldset>
		<button type="submit" class="btn btn-success">Add</button>
	</form:form>
</div>

<%@ include file="common/footer.jspf"%>

<script>
	$('#targetDate').datepicker({
		format : 'dd/mm/yyyy'
	});
</script>