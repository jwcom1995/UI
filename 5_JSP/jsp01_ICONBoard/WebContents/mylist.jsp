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
		background-color:white;
		text-align:center;
		font-weight:bold;
	}
	th{
		background-color:#E0CCE3;
	}
	td{
		background-color :#FBF5F5;
	}
	#content{
		height:120px;
	}
	.inotd{
		background-color:#E7E2FB;
	}
	.imgtd{
		background-color:white;
	}
	#lastTd{
		background-color:#C1D0E3;
		height:50px;
		padding-right:10px;
	}
</style>
</head>
<body>
<% 
	IconBoardDao dao = new IconBoardDao(); 
	List<IconBoardDto> list = dao.selectAll();
%>
	<h2>아이콘 게시판</h2>
<form action="deleteSelected.jsp" method="post">
	<table >
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
		<tr id="content">
			<td class="inotd"><%= i+1 %></td>
			<td class="imgtd"><img src="<%= list.get(i).getI_img() %>" alt="<%= list.get(i).getI_name() %>" title="<%= list.get(i).getI_name() %>"></td>
			<td><a href='./selectone.jsp?ino=<%= list.get(i).getI_no() %>'><%= list.get(i).getI_name() %></a></td>
			<td><%= list.get(i).getI_designer() %></td>
			<td><%= list.get(i).getI_price() %></td>
			<td><%= list.get(i).getI_date() %></td>
			<td><a href="myupdate.jsp?ino=<%= list.get(i).getI_no() %>">수정</a></td>
			<td><input type="checkbox" name="delContents" value="<%= list.get(i).getI_no() %>"></td>
		</tr>
		<% } %>
		<tr>
			<td id="lastTd" colspan="8" align="right">
			<input type="button" value="게시글 작성" onclick="location.href='myinsert.jsp'">
			<input type="submit" value="삭제하기" onclick="location.href='deleteSelected.jsp'">
			</td>
		</tr>
	</table>
</form>
</body>
</html>