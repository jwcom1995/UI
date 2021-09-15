
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
</head>
<body>
<% 
	int ino = Integer.parseInt(request.getParameter("ino"));
	String iName = request.getParameter("iName");
	String iDesigner = request.getParameter("iDesigner");
	String iPrice = request.getParameter("iPrice");
	String iDescript = request.getParameter("iDescript");
	
	IconBoardDto dto = new IconBoardDto();
	dto.setI_no(ino);
	dto.setI_name(iName);
	dto.setI_designer(iDesigner);
	dto.setI_price(iPrice);
	dto.setI_description(iDescript);
	
	IconBoardDao dao = new IconBoardDao();
	int res=dao.update(dto);
	if(res > 0){
		%>
	<script type="text/javascript">
		alert("수정이 정상적으로 완료되었습니다.");
		location.href="selectone.jsp?ino=<%= ino%>";
	</script>
		<%
	}else{
		%>
		<script type="text/javascript">
			alert("수정이 정상적으로 이루어지지 않았습니다.");
			location.href="mylist.jsp";
		</script>
			<%
	}
%>
</body>
</html>