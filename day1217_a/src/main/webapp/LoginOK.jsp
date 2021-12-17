<%@page import="com.sist.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	MemberDAO dao = new MemberDAO();
	if(dao.isMember(id, pwd)){
		//세션이 있나 확인
		session.setAttribute("member", "yes");
		response.sendRedirect("member/main.jsp");		
	}else{
		response.sendRedirect("login.jsp");		
	}
%>
</body>
</html>