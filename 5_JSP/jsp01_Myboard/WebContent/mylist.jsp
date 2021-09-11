<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%@ page import ="com.my.dao.MyBoardDao" %>
<%@ page import ="com.my.dto.MyBoardDto" %>
<%@ page import ="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LIST PAGE</title>
</head>
<%
	MyBoardDao dao = new MyBoardDao();
	List<MyBoardDto> list = dao.selectAll();
%>
<body>
	<h1> LIST PAGE</h1>
	<table border="1">
		<col width="50px">
		<col width="100px">
		<col width="200px">
		<col width="100px">
		<tr>
			<th>NO</th>
			<th>NAME</th>
			<th>TITLE</th>
			<th>DATE</th>
			<th>UPDATE</th>
			<th>DELETE</th>
		</tr>
		<% for(int i = 0; i < list.size();i++){
			%>
			<tr>
				<td><%= list.get(i).getMyno()%></td>
				<td><%= list.get(i).getMyname()%></td>
				<td><%= list.get(i).getMytitle()%></td>
				<td><%= list.get(i).getMydate()%></td>
				<td><a>수정</a></td>
				<td><a>삭제</a></td>
			</tr>
			
		<%	
		}		
			%>
		<tr>
			<td colspan="6" align="right">
				<button onclick="">글쓰기</button>
			</td>
		</tr>
	</table>
</body>
</html>