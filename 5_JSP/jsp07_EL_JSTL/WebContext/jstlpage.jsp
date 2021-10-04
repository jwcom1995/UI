<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<!-- 
    JSTL - Core  (<foreach>, <if>, 변수)
         - Formatting
         - DataBase
         - Function
 -->
<body>
	<h1>JSTL Page</h1>
	
	<table border="1">
		<tr>
			<th>name</th>
			<th>kor</th>
			<th>eng</th>
			<th>math</th>
			<th>sum</th>
			<th>avg</th>
			<th>grade</th>
		</tr>
		
		<c:forEach var="score" items="${list}">
			<tr>
				<td>
					<c:if test="${score.name eq '이름1'}">
						<c:out value="홍길동"></c:out>
					</c:if>
					
					<!-- 조건이 하나 이상일때 사용하는 choose -->
					<!-- eq : == / nq : != / empty : 비었음 -->
					<c:choose> 
						<c:when test="${score.name eq '이름2' }">
							<c:out value="${score.name }님"></c:out>
						</c:when>
						<c:when test="${score.name eq '이름3' }">
							<c:out value="${score.name }님@"></c:out>
						</c:when>
						<c:otherwise>
							<c:out value="???님"></c:out>
						</c:otherwise>
					</c:choose>
				</td>
				<td>${score.kor }</td>
				<td>${score.eng }</td>
				<td>${score.math }</td>
				<td>${score.sum }</td>
				<td>
					<c:choose>
						<c:when test="${score.avg eq 83 || score.avg== 84}">
							<c:out value="${score.avg }**"></c:out>
						</c:when>
						<c:otherwise>
							<c:out value="${score.avg }"></c:out>
						</c:otherwise>
					</c:choose>
				</td>
				<td>${score.grade }</td>
			</tr>
		</c:forEach>
	</table>

	<hr>
	
	<!-- 변수 셋팅 -->
	<c:set var="no" value="1000"></c:set>
	<h2><c:out value="${no }"></c:out></h2>
	
	<c:forEach var="i" begin="1" end="10" step="1">
		<h1>${i}</h1>
	</c:forEach>
</body>
</html>