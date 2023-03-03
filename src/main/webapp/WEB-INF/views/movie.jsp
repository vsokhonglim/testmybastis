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

<input type="button" value="Add movie" onclick="window.location.href='addmovie'; return false;" />
	<div class="tableWrapper">
		<table class="table">
			<th>Title</th>
			<th>Description</th>
			<th>Release date</th>



			<c:forEach items="${Movielist}" var="e">

				<tr>
					<td>${e.title}</td>
					<td>${e.description}</td>
					<td><fmt:formatDate value="${e.releasedate}"
							pattern="yyyy-MMM-dd" /></td>

				</tr>

			</c:forEach>


		</table>
	</div>
</body>
</html>