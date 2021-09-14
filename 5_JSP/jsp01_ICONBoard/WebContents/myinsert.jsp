<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert board</title>
<style type="text/css">
	textarea{
		resize:none;
	}
</style>
</head>
<body>
	<h2>새 글 작성하기</h2>
<form action="myinsert_res.jsp" method="post">
	<table>
		<col width="220px;">
		<col width="100px;">
		<tr>
			<th>NAME  </th>
			<td><input type="text" name="iName"></td>
		</tr>
		<tr>
			<th>DESIGNER </th>
			<td><input type="text" name="iDesigner" ></td>
		</tr>
		<tr>
			<th>IMG URL  </th>
			<td><input type="text" name="iImage"></td>
		</tr>
		<tr>
			<th>PRICE  </th>
			<td><input type="text" name="iPrice"></td>
		</tr>
		
		<tr><td>&nbsp;</td></tr>
		
		<tr>
			<th colspan="3" style="text-align:left">Description</th>
		</tr>
		<tr>
			<td colspan="3"><textarea rows="10" cols="60" name="iDescript" ></textarea></td>
		</tr>
		<tr>
			<td colspan="3" align="right">
			<input type="submit" value="추가" onclick="location.href='myupdate_res.jsp'">
			<input type="button" value="취소" onclick="history.back()">			
			</td>
		</tr>
	</table>
</form>
</body>
</html>