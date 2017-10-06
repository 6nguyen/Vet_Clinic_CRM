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
						<th>Action</th>
					</tr>
					
					<c:forEach var="tempCustomer" items="${customers}">
					
						<!-- make an "Update" link for each customer id. updateLink used as an href later -->
						<c:url var="updateLink" value="/customer/updateCustomer" >
							<c:param name="customerId" value="${tempCustomer.id}" />
						</c:url>
						<tr>
							<td>${tempCustomer.firstName}</td>
							<td>${tempCustomer.lastName}</td>
							<td>${tempCustomer.email}</td>
							<td><a href="${updateLink}">Edit</a></td>
						</tr>
						
					</c:forEach>
				</table>
			</div>
		</div>
		
	</div>
</body>

</html>