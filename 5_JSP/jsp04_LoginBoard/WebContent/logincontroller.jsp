<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@page import ="java.util.List" %>
<%@page import ="com.login.dao.MyMemberDao" %>
<%@page import ="com.login.dto.MyMemberDto" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String command = request.getParameter("command");
	System.out.println("[command:"+command+"]");
	
	MyMemberDao dao = new MyMemberDao();
	
	if(command.equals("login")){
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		MyMemberDto dto = dao.login(id,pw);
		
		if(dto.getMyid() != null){
			
			//request 영역 : 요청하고 응답 받을때까지
			//session 영역 : 브라우저당 1개 
			
			session.setAttribute("dto", dto);
			session.setMaxInactiveInterval(60*60);
			
			if(dto.getMyrole().equals("ADMIN")){
				response.sendRedirect("adminmain.jsp");
			} else if (dto.getMyrole().equals("USER")){
				response.sendRedirect("usermain.jsp");
			}
		} else{
%>
		<script type="text/javascript">
			alert("login 실패");
			location.href="index.jsp";
		</script>
<%			
		}
	} else if(command.equals("userlistall")){

		List<MyMemberDto> list = dao.selectAll();
		
		request.setAttribute("list", list);
		pageContext.forward("userlistall.jsp");
	} else if(command.equals("userlistenabled")){
	
		List<MyMemberDto> list = dao.selectEnabled();
		
		request.setAttribute("list",list);
		pageContext.forward("userlistenabled.jsp");
	} else if (command.equals("updateroleform")){
		int myno = Integer.parseInt(request.getParameter("myno"));
		MyMemberDto dto = dao.selectUser(myno);
		
		request.setAttribute("selectone", dto);
		pageContext.forward("updateroleform.jsp");
	} else if (command.equals("updaterole")){
		int myno= Integer.parseInt(request.getParameter("myno"));
		String myrole = request.getParameter("myrole");
		
		int res= dao.updateRole(myno,myrole);
		
		if(res>0){
%>
	<script type="text/javascript">
		alert("회원 등급 조정 성공");
		location.href="logincontroller.jsp?command=userlistenabled";
	</script>
<%
		} else{
%>
	<script type="text/javascript">
		alert("회원 등급 조정 실패");
		location.href="logincontroller.jsp?command=updateroleform&myno=<%= myno%>";
	</script>
<%			
		}
	} else if(command.equals("logout")){
		//session 정보 삭제
		session.invalidate();
		response.sendRedirect("index.jsp");
	}
%>
</body>
</html>