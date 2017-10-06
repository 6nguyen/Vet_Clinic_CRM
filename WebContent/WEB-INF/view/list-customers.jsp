<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
<head>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
	<title>Customers List</title>
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>		
		</div>
		
		<div id="container">
			<div id="content">
			
				<input type="button" value="Add Customer" onClick="window.location.href='addCustomer'; return false;"
					class="add-button" />
			
				<table>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
					</tr>
					
					<c:forEach var="tempCustomer" items="${customers}">
					
						<tr>
							<td>${tempCustomer.firstName}</td>
							<td>${tempCustomer.lastName}</td>
							<td>${tempCustomer.email}</td>
						</tr>
						
					</c:forEach>
				</table>
			</div>
		</div>
		
	</div>
</body>

</html>