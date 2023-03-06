<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/js/bootstrap-datepicker.js"></script>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/css/bootstrap-datepicker.css"
	rel="stylesheet" />

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/main.css" />
<title>Moooovie</title>

</head>
<body>


	<div class="tableWrapper">

		<input type="button" value="Add movie"
			onclick="window.location.href='addmovie'; return false;" />
		<div id="picker-container">
			<input type="text" id="datepicker" />
		</div>

		<table class="table">
			<th>Title</th>
			<th>Description</th>
			<th>Release date</th>
			<th>Action</th>

			<c:forEach items="${Movielist}" var="e">

				<c:url var="deleteLink" value="/deletemovie">
					<c:param name="movieid" value="${e.id}" />
				</c:url>

				<c:url var="updateLink" value="/updatemovie">
					<c:param name="movieid" value="${e.id}" />
				</c:url>

				<tr>
					<td>${e.title}</td>
					<td>${e.description}</td>
					<td><fmt:formatDate value="${e.releasedate}"
							pattern="yyyy-MMM-dd" /></td>
					<td><a href="${updateLink}">Update</a> | <a
						href="${deleteLink}"
						onclick="if(!(confirm('Are you sure want to delete this Movie permanently?'))) return false">Delete</a>
					</td>

				</tr>

			</c:forEach>


		</table>
	</div>
</body>
<script type="text/javascript">
	$("#datepicker").datepicker({
		container : "#picker-container",
		zIndexOffset : 20 ,
		format : "yyyy",
		viewMode : "years",
		minViewMode : "years",
		autoclose : true

	});
</script>


</html>