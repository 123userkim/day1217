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
	request.setCharacterEncoding("UTF-8");
	String name =(String) session.getAttribute("name");
	int age = (Integer) session.getAttribute("age");
	ArrayList<String> list  = 
			(ArrayList<String>)session.getAttribute("list");
	ArrayList<Goods> goods_list = 
			(ArrayList<Goods>)session.getAttribute("goods_list");
%>
<h2>세션에 설정된 값 확인하기 </h2>
<hr>
name : <%= name %><br>
age : <%= age %><br>
foodList : 
<%
	for(String food:list){
		out.println(food+"&nbsp;&nbsp;&nbsp;");
	}
%>
<br>
goodsList : <br>
<%
	for(Goods g:goods_list){
		out.print("상품번호:"+g.getNo()+"<br>");
		out.print("상품이름:"+g.getItem()+"<br>");
		out.print("상품수량:"+g.getQty()+"<br>");
		out.print("상품가격:"+g.getPrice()+"<br>");
	}
%>

</body>
</html>
