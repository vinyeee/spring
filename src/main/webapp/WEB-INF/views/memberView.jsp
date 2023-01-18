<%@page import="vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 정보</h1>
	<hr>
	<c:choose>
	<c:when test= "${ !empty requestScope.member }">
	<ul>
		<li>회원 이름2 : ${member.name }</li>
		<li>회원 전화번호2 : ${member.phone }</li>
		<li>회원 계정2 : ${member.id }</li>
		<li>회원 암호2 : ${member.password }</li>
	</ul>	
	</c:when>
	<c:when test= "${ !empty requestScope.memberVO }">	
	<ul>
		<li>회원 이름3 : ${memberVO.name }</li>
		<li>회원 전화번호3 : ${memberVO.phone }</li>
		<li>회원 계정3 : ${memberVO.id }</li>
		<li>회원 암호3 : ${memberVO.password }</li>
	</ul>
	</c:when>
	<c:otherwise>
	
	<ul>
		<li>회원 이름1 : ${ name }</li>
		<li>회원 전화번호1 : ${ phone }</li>
		<li>회원 계정1  : ${ id }</li>
		<li>회원 암호1  : ${ password }</li>		
	</ul>
	</c:otherwise>
	</c:choose>
	<hr>
	<a href=${ header.referer }>입력화면</a>
</body>
</html>
