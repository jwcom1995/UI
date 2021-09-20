<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("UTF-8");
%>
<%
response.setContentType("text/html; charset=UTF-8");
%>

<%@page import="com.mvc.dto.MVCBoardDto"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정</title>
</head>
<%
MVCBoardDto dto = (MVCBoardDto) request.getAttribute("dto");
%>
<body>
	<form action="mycontroller.jsp" method="post">
		<input type="hidden" name="seq" value="<%=dto.getSeq()%>">
		<input type="hidden" name="command" value="boardupdate">
		<table border="1">
			<tr>
				<th>NO</th>
				<td><%=dto.getSeq()%></td>
			</tr>
			<tr>
				<th>WRITER</th>
				<td><%=dto.getWriter()%></td>
			</tr>
			<tr>
				<th>Date</th>
				<td><%=dto.getRegdate()%></td>
			</tr>
			<tr>
				<th>TITLE</th>
				<td><input type="text" name="title" value="<%= dto.getTitle()%>"></td>
			</tr>
			<tr>
				<th>CONTENT</th>
				<td><textarea rows="10" cols="60" name="content"><%=dto.getContent()%></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="수정 확인">
					<input type="button" value="취소" onclick="location.href='mycontroller.jsp?command=boarddetail&seq=<%= dto.getSeq()%>'"> 
				</td>
			</tr>
		</table>
	</form>
</body>
</html>