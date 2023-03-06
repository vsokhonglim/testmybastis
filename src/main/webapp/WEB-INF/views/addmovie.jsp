<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add new movie</title>
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
						<td><form:input path="title" /></td>
					</tr>
				
					<tr>
						<td><label>Description</label></td>
						<td><form:input path="description" /></td>
					</tr>

					<tr>
						<td><label>Release date:</label></td>
						<td><form:input type="date" path="releasedate" format="yyyy-MM-dd" /></td>
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
	
	</div>


</body>
</html>