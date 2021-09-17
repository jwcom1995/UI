<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("UTF-8");
%>
<%
response.setContentType("text/html; charset=UTF-8");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="./form/header.jsp"%>
	<h1>글 작성</h1>
	<form action="boardwrite_res.jsp" method="post">
		<table border="1">
			<col width="100px">
			<col width="400px">
			<tr>
				<th>WRITER</th>
				<td><input type="text" name="writer"></td>
			</tr>
			<tr>
				<th>TITLE</th>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<th>CONTENT</th>
				<td><textarea rows="10" cols="60" name="content"></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="등록">
					<input type="button" value="취소" onclick="location.href='boardlist.jsp'">
				</td>
			</tr>
		</table>
	</form>
	
<%@ include file="./form/footer.jsp"%>
</body>
</html>