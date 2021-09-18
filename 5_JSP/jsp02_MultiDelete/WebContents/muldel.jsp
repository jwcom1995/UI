<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@page import = "com.multi.dao.MDBoardDao" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	String[] seq = request.getParameterValues("chk");
	
	if(seq==null || seq.length==0){
%>
	<script type="text/javascript">
		alert("삭제할 글을 1개 이상 선택해주세요.");
		location.href="boardlist.jsp;"
	</script>
<%
	} else{
		MDBoardDao dao = new MDBoardDao();
		int res= dao.multiDelete(seq);
		if(seq.length == res){
%>
		<script type="text/javascript">
			alert("선택한 항목(들)이 삭제되었습니다.");
			location.href="boardlist.jsp";
		</script>
<% 		} else{
%>
		<script type="text/javascript">
			alert("삭제가 정상적으로 이루어지지 않았습니다.");
			location.href="boardlist.jsp";
		</script>ㄴ
<%			
		}
	} 
%>
<body>
</body>
</html>