<%@page import="com.sist.vo.Goods"%>
<%@page import="java.util.ArrayList"%>
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
	String name ="홍길동";
	int age = 20;
	ArrayList<String>list =new ArrayList<String>();
	list.add("돈까스");
	list.add("김치찌개");
	list.add("곰탕");
 	session.setAttribute("name", name);
 	session.setAttribute("age", age);
 	session.setAttribute("list", list);
 	
 	
 	ArrayList<Goods>goods_list= new ArrayList<Goods>();
 	goods_list.add(new Goods(1,"축구화",10,5000));
 	goods_list.add(new Goods(2,"유니폼",10,6000));
 	goods_list.add(new Goods(3,"스타킹",10,2000));
 	session.setAttribute("goods_list", "goods_list");
%>
세션의 값을 설정 완료
<hr>
<a href="session_getAttribute.jsp">세션값 확인</a>
<a href="session_getAttribute_jstl_el.jsp">세션값 확인 jstl_el</a>

</body>
</html>