<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Hi</h1>
	<table class="table">
  
  <tbody>
    
      <c:forEach items="${Employees}" var="e">
				<tbody>
					<tr>
						<td>${e.fullname}</td>
						<td>${e.email}</td>
						<td>${e.gender}</td>
						<td>${e.hobbies}</td>
						<td>${e.country}</td>
						<td>${e.address}</td>
						
					</tr>
				</tbody>
			</c:forEach>
    
  </tbody>
</table>
</body>
</html>