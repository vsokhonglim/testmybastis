<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/main.css" />

<title>Moooovie</title>
</head>
<body>

	<input type="button" value="Add movie"
		onclick="window.location.href='addmovie'; return false;" />
	<div class="tableWrapper">
		<table class="table">
			<th>Title</th>
			<th>Description</th>
			<th>Release date</th>
			<th>Action</th>
			



			<c:forEach items="${Movielist}" var="e">
			<c:url var="deleteLink" value="/deletemovie">
					<c:param name="movieid" value="${e.id}" />
				</c:url>

				<tr>
					<td>${e.title}</td>
					<td>${e.description}</td>
					<td><fmt:formatDate value="${e.releasedate}"
							pattern="yyyy-MMM-dd" /></td>
					<td><a href="${deleteLink}"
						onclick="if(!(confirm('Are you sure want to delete this Employee permanently?'))) return false">Delete</a>
					</td>

				</tr>

			</c:forEach>


		</table>
	</div>
</body>
</html>