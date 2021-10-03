<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@page import = "com.mvc.dto.MyMVCDto" %>
<%@page import = "java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	List<MyMVCDto> list = (List<MyMVCDto>)request.getAttribute("list");
%>
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
<%
	if(list.size()==0){
%>
	<tr>
		<td colspan="4" align="center">-----글이 존재하지 않습니다-----</td>
	</tr>
<%		
	} else{
		for(MyMVCDto dto : list){
%>
		<tr>
			<td><%= dto.getSeq() %></td>
			<td><%= dto.getWriter() %></td>
			<td><a href="controller.do?command=detail&seq=<%= dto.getSeq() %>"><%= dto.getTitle() %></a></td>
			<td><%= dto.getRegdate() %></td>
		</tr>
<%			
		}
	}
%>
		<tr>
			<td colspan="4" align="right">
				<input type="button" value="글쓰기" onclick="">
			</td>
		</tr>
	</table>
</body>
</html>