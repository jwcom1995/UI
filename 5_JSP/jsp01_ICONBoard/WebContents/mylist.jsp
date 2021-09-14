<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@page import = "com.my.dao.IconBoardDao" %>
<%@page import = "com.my.dto.IconBoardDto" %>
<%@page import = "java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Icon Board</title>
<style type="text/css">
	img{
		width:120px;
		height:120px;
	}
	table{
		text-align:center;
	}
</style>
</head>
<body>
<% 
	IconBoardDao dao = new IconBoardDao(); 
	List<IconBoardDto> list = dao.selectAll();
%>
	<h2>아이콘 게시판</h2>
	<table border="1">
		<col width="50px">		
		<col width="125px">
		<col width="100px">
		<col width="200px">
		<col width="100px">
		<col width="100px">
		<col width="100px">
		<col width="100px">	
		<tr>
			<th>번호</th>
			<th>이미지</th>
			<th>이름</th>
			<th>디자이너</th>
			<th>가격</th>
			<th>날짜</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		<% for(int i = 0;i<list.size();i++){%>
		<tr>
			<td><%= i+1 %></td>
			<td><img src="<%= list.get(i).getI_img() %>"></td>
			<td><a href='./selectone.jsp?ino=<%= list.get(i).getI_no() %>'><%= list.get(i).getI_name() %></a></td>
			<td><%= list.get(i).getI_designer() %></td>
			<td><%= list.get(i).getI_price() %></td>
			<td><%= list.get(i).getI_date() %></td>
			<td><a href="#">수정</a></td>
			<td><a href="#">삭제</a></td>
		</tr>
		<% } %>
		<tr>
			<td colspan="8" align="right">
			<input type="button" value="게시글 올리기" onclick="location.href='myupdate.jsp'">
			</td>
		</tr>
	</table>
</body>
</html>