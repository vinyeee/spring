<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>과일 바구니 확인창</title> 
<style>
a{
	background : linear-gradient(to top, #d5f4e6 , #b3c6ff);
}
</style>
</head>
<body>
<c:if test="${ !empty sessionScope.p }" >
<h2>선택된 상품 정보</h2>
<hr>
<ul>
<li>선택된 사과의 개수 : ${sessionScope.p.apple}</li>
<li>선택된 바나나의 개수 : ${sessionScope.p.banana}</li>
<li>선택된 한라봉의 개수 : ${sessionScope.p.halabong}</li>
</ul>
</c:if>
<c:if test="${ empty sessionScope.p }" >
<h2>선택된 상품이 없음</h2>
</c:if>
<hr>
<a href="${header.referer}">상품선택화면</a>
</body>
</html>
