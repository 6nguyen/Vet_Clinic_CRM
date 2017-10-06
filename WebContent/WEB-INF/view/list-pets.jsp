<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
<head>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
	<title>Registered Pets</title>
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Veterinary Clinic - CRM</h2>		
		</div>
		
		<div id="container">
			<div id="content">
			
				<table>
					<tr>
						<th>Species</th>
						<th>Breed</th>
						<th>Name</th>
						<th>Action</th>
					</tr>
					
					<c:forEach var="tempPet" items="${registeredPets}">
						
						<tr>
							<td>${tempPet.species}</td>
							<td>${tempPet.breed}</td>
							<td>${tempPet.name}</td>
							<td>
								Some Action
							</td>
						</tr>
						
					</c:forEach>
				</table>
			</div>
		</div>
		
	</div>
</body>

</html>