<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>

<html>
<head>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />
	<title>Add Customer</title>
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Veterinary Clinic - CRM</h2>
		</div>
		
		<div id="container">
			<h3>Add Customer</h3>
			<form:form action="saveCustomer" modelAttribute="customer" method="POST">
				
				<!-- Need to associate form data with customer id. Otherwise, it will create a new user -->
				<!-- When form is loaded, calls customer.getId() -->
				<!-- When form is submitted, calls customer.setId() -->
				<form:hidden path="id" />
				
				<table>
					<tbody>
						<tr>
							<td><label>First Name: </label></td>
							<td><form:input path="firstName" ></form:input></td>
						</tr>
						<tr>
							<td><label>Last Name: </label></td>
							<td><form:input path="lastName" ></form:input></td>
						</tr>
						<tr>
							<td><label>Email: </label></td>
							<td><form:input path="email" ></form:input></td>
						</tr>
						<tr>
							<td><label></label></td>
							<td><input type="submit" value="Save" class="save"/></td>
						</tr>
					</tbody>
				</table>
			</form:form>
			
			<div style="clear; both;"></div>
			<p>
				<a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
			</p>
		</div>
	</div>
</body>

</html>