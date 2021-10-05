<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>글 목록</h1>
	<table border="1">
		<col width="50"><col width="100"><col width="300"><col width="100">
		<tr>
			<th>NO</th>
			<th>WRITER</th>
			<th>TITLE</th>
			<th>DATE</th>
		</tr>
	<c:choose>
		<c:when test="${empty list}">
			<tr>
				<td colspan="4" align="center">-----글이 존재하지 않습니다-----</td>
			</tr>
		</c:when>

		<c:otherwise>
			<c:forEach var="product" items="${list}">
				<tr>
					<td>${product.seq}</td>
					<td>${product.writer}</td>
					<td><a href="controller.do?command=detail&seq=${product.seq}">${product.title}</a></td>
					<td>${product.regdate}</td>
				</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
		<tr>
			<td colspan="4" align="right">
				<input type="button" value="글쓰기" onclick="location.href='controller.do?command=writeform'">
			</td>
		</tr>
	</table>
</body>
</html>