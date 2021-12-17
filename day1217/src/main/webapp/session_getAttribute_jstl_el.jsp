<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
 <body>
이름 : ${name }<br>
나이 : ${age }<br>
<c:forEach var="food" items="${list }">
	${food}
</c:forEach>
<hr>

<c:forEach var="g" items="${goods_list}">
	상품번호 : ${g.no} <br>
	상품명 : ${g.item} <br>
	상품수량 : ${g.qty} <br>
	상품가격 : ${g.price} <hr>
</c:forEach>


<br>
<%
	session.removeAttribute("name");
	session.removeAttribute("goods_list");
	
%>
<h4>----------세션을 삭제한 이후---------</h4>
이름 : ${name }<br>
나이 : ${age }<br>
<c:forEach var="food" items="${list }">
	${food}
</c:forEach>
<hr>
<%
/*<c:forEach var="g" items="goods_list">
	상품번호 : ${g.no} <br>
	상품명 : ${g.item} <br>
	상품수량 : ${g.qty} <br>
	상품가격 : ${g.price} <hr>
</c:forEach>
*/
%>
</body>


</html>