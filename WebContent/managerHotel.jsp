<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Hello</h1>
<c:if test="${book != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${book == null}">
            <form action="insert" method="post">
        </c:if>
	<table>
		<tr>
			<th>Nom hotel : </th>
			<td>
				${hm.nom_hotel}
			</td>
		</tr>
		
		<tr>
			<th>Ville hotel : </th>
			<td>
				${hm.ville_hotel}
			</td>
		</tr>
		
		<tr>
			<th>Description hotel : </th>
			<td>
				${hm.description}
			</td>
		</tr>
		
		<tr>
			<th>Nbr etoiles hotel : </th>
			<td>
				${hm.nbr_etoiles}
			</td>
		</tr>
		<tr>
			<th>Update data</th>
			<td>
				<a href="EditHotel?id=${hm.getId_hotel()}">Edit</a>
			</td>
		</tr>
		<tr>
			<th>Delete data</th>
			<td>
				<a href="DeleteHotel?id=${hm.getId_hotel()}">delete</a>
			</td>
		</tr>
	</table>
</form>
</body>
</html>