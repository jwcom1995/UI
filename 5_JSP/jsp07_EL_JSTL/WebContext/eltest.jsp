<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>EL Page</h1>
	<table border="1">
		<tr><!-- request에 있는 score에 있는 값을 받아옴 -->
			<th colspan="2">${score.name} 님의 점수는 ...</th>
		</tr>
		<tr>
			<th>KOR</th>
			<td>${score.kor}</td>
		</tr>
		<tr>
			<th>ENG</th>
			<td>${score.eng}</td>
		</tr>
		<tr>
			<th>MATH</th>
			<td>${score.math}</td>
		</tr>
		<tr>
			<th>SUM</th>
			<td>${score.kor+score.eng+score.math}</td>
		</tr>
		<tr>
			<th>AVG</th>
			<td>${score.avg}</td>
		</tr>
		<tr>
			<th>GRADE</th>
			<td>${score.grade}</td>
		</tr>
	</table>
</body>
</html>