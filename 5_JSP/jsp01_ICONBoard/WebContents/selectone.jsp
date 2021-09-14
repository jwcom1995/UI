<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@page import = "com.my.dao.IconBoardDao" %>
<%@page import = "com.my.dto.IconBoardDto" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	img{
	width:210px;
	height:210px;
	}
	th{
		text-align:left;
	}
	textarea{
		resize:none;
	}
</style>
</head>
<body>
<%
	int ino = Integer.parseInt(request.getParameter("ino"));
	IconBoardDao dao = new IconBoardDao();
	IconBoardDto dto = dao.selectOne(ino);
%>
<form>
	<table>
		<col width="220px;">
		<col width="100px;">
		<col width="120px;">
		<tr>
			<td rowspan="6"><img src="<%= dto.getI_img() %>"></td>
			<th>NAME  </th>
			<td><%= dto.getI_name() %></td>
		</tr>
		<tr>
			<th>DESIGNER </th>
			<td><%= dto.getI_designer() %></td>
		</tr>
		<tr>
			<th>DATE  </th>
			<td><%= dto.getI_date() %></td>
		</tr>
		<tr>
			<th>PRICE  </th>
			<td><%= dto.getI_price() %></td>
		</tr>
		
		<tr><td>&nbsp;</td></tr>
		<tr><td>&nbsp;</td></tr>
		<tr><td>&nbsp;</td></tr>
		
		<tr>
			<th>Description</th>
		</tr>
		<tr>
			<td colspan="3"><textarea rows="10" cols="60" readonly="readonly" resize="none"><%= dto.getI_description() %></textarea></td>
		</tr>
		<tr>
			<td colspan="3" align="right">
			<input type="button" value="수정" onclick="location.href='myupdate.jsp?ino=<%= ino %>'">
			<input type="button" value="삭제" onclick="location.href='mydelete.jsp?ino=<%= ino %>'">
			<input type="button" value="목록" onclick="location.href='mylist.jsp'">
			</td>
		</tr>
	</table>
</form>
</body>
</html>