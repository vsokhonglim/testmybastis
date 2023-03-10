<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ page isELIgnored="false" %>  
<!DOCTYPE html>
<html>
<head>



<meta charset="ISO-8859-1">
<title>Add new movie</title>
	<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/addmovie.css" />
	<script src = "https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.js"></script>
	<link href="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/css/select2.min.css" rel="stylesheet" />
	<script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/js/select2.min.js"></script>
		
</head>
<body>
<div id="container">
		<h3>Add new movie</h3>
	
		<form:form action="addNewMovie" modelAttribute="newmovie" method="POST">
		
		<form:hidden path="id" />
			<table>
				<tbody>
					<tr>
						<td><label>Title</label></td>
						<td><form:input path="title" required="required"/></td>
					</tr>
				
					<tr>
						<td><label>Description</label></td>
						<td><form:textarea path="description" maxlength="199" cols="40" rows="5" required="required"/></td>
					</tr>

					<tr>
						<td><label>Release date:</label></td>
						<td><form:input type="date" path="releasedate" format="yyyy-MM-dd" required="required"/></td>
					</tr>
					
					<tr>
						<td><label>Genre</label></td>
						<td>
						<form:select id="js-example-basic-multiple" path="genre" items="${genreList}" itemLabel="genre" 
						 multiple="true" class="js-example-basic-multiple" modelAttribute="Genre" />
						

						</td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
		

		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/">Back to List</a>
		</p>
		
		
		<%-- <form:select multiple="true" path="roles" items="${roles}" itemLabel="nombre" itemValue="id" />
		<form:select path="genre">
		<form:options items="${genreList.genre}" itemValue="${genreList.id}" itemLabel="${genreList.genre}"/>
		<c:forEach items="${genreList}" var="e">
		<form:option value="${e.id}">${e.genre}</form:option>
    
    	</c:forEach>
		</form:select> --%>
		
		
	
	</div>


		<script type="text/javascript">

			$(document).ready(function() {
				$("#js-example-basic-multiple").select2();
			});
		</script>
</body>

</html>