<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	window.onload=function(){
		//opener 부모창과 자식창의 정보 교환
		var id=opener.document.getElementsByName("myid")[0].value;
	
		document.getElementsByName("id")[0].value=id;
	}
	function confirm(bool){
		if(bool == "true"){
			//focus 패스워드쪽으로 이동
			opener.document.getElementsByName("mypw")[0].focus();
			opener.document.getElementsByName("myid")[0].title="y";
		} else{
			//focus 아이디 쪽으로 이동
			opener.document.getElementsByName("myid")[0].focus();
		}
		//팝업을 닫음
		self.close();
	}
</script>

</head>
<%
	String idnotused = request.getParameter("idnotused");
%>
<body>
	<table border="1">
		<tr>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<td><%= idnotused.equals("true")?"아이디 생성 가능":"중복 아이디 존재" %></td>
		</tr>
		<tr>
			<td>
				<input type="button" value="확인" onclick="confirm('<%= idnotused%>');">
			</td>
		</tr>
	</table>
</body>
</html>