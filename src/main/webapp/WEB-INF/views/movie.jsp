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



	<div class="tableWrapper">

		<input type="button" value="Add movie"
			onclick="window.location.href='addmovie'; return false;" />
			
			
			
			<form action="" method="GET">			
			<div class="date-filter-container">
			<c:if test="${empty param.search}">
			<input type="text" placeholder="movies title or description" class="search-bar"
					name="search"
					value=""/>
			</c:if>
			<c:if test="${not empty param.search}">
			<input type="text" placeholder="movies title or description" class="search-bar"
					name="search"
					value="<%=request.getParameter("search")%>"/>
			</c:if>
			<span>From:</span>
			 <input type="date" name="fromdate" 
					value="<%=request.getParameter("fromdate")%>" />
			<span>to:</span> 
			<input type="date" name="todate" 
					value="<%=request.getParameter("todate")%>" />
			<input	type="submit" value="submit" />
			
			</div>
			
		</form>
		

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
	
	
	
	<div class="pagination">
		
	 		
			  <c:if test="${param.page>1}">
			  <c:url value="/" var="completeURL">
			  		<c:param name="search" value="${param.search}" />
					<c:param name="fromdate" value="${param.fromdate}" />
					<c:param name="todate" value="${param.todate}" />
					<c:param name="page" value="${param.page-1}"/>
					</c:url>
			 	<a href="${completeURL}">&laquo;</a>
			  </c:if>
			
			
			<c:forEach begin="1" end="${rowcount}" varStatus="loop" step="10" var="index">
			<c:url value="/" var="pageNumcompleteURL">
					<c:param name="search" value="${param.search}" />
					<c:param name="fromdate" value="${param.fromdate}" />
					<c:param name="todate" value="${param.todate}" />
					<c:param name="page" value="${loop.count}"/>
					</c:url>
			
			<a href="${pageNumcompleteURL}" <c:if test="${param.page ==loop.count}">
			 class="active"
			</c:if>
			<c:if test="${((param.page ==null)||(param.page ==0))&&(loop.count==1)}">
			 class="active"
			</c:if>
			>${loop.count}</a>
			
		
			</c:forEach>
			
			<c:if test="${(param.page==0 ||param.page==null)&&(rowcount>10) }">
			  	<c:url value="/" var="completeURL">
			  		<c:param name="search" value="${param.search}" />
					<c:param name="fromdate" value="${param.fromdate}" />
					<c:param name="todate" value="${param.todate}" />
					<c:param name="page" value="${2}"/>
					</c:url>
			 	<a href="${completeURL}">&raquo;</a>
			  </c:if>
			
			  <c:if test="${param.page<(rowcount/10)&&!(param.page==0)}">
			  	<c:url value="/" var="completeURL">
			  		<c:param name="search" value="${param.search}" />
					<c:param name="fromdate" value="${param.fromdate}" />
					<c:param name="todate" value="${param.todate}" />
					<c:param name="page" value="${param.page+1}"/>
					</c:url>
			 	<a href="${completeURL}">&raquo;</a>
			  </c:if>
			 
			 
			
			
		</div>
	
</body>


</html>