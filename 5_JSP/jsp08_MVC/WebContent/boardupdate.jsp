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
<h1>글 수정하기</h1>
	<form action="controller.do" method="post">
		<input type="hidden" name="command" value="boardupdate">
		<input type="hidden" name="seq" value="${dto.seq}">
	<table border="1">
		<tr>
			<th>NO</th>
			<td>${dto.seq }</td>
		</tr>
		<tr>
			<th>DATE</th>
			<td>${dto.regdate}</td>
		</tr>
		<tr>
			<th>WRITER</th>
			<td>${dto.writer }</td>
		</tr>
		<tr>
			<th>TITLE</th>
			<td><input type="text" name ="title" value="${dto.title}"></td>
		</tr>
		<tr>
			<th>Content</th>
			<td><textarea rows="10" cols="60" name="content">${dto.content }</textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="submit" value="등록">
				<input type="button" value="취소" onclick="location.href='controller.do?command=detail&seq=${dto.seq}'">
			</td>
		</tr>
	</table>
	</form>
</body>
</html>