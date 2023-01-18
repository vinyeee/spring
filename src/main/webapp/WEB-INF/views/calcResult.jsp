<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	span {
		color:red;
	}
</style>
</head>
<body>
	<h1>연산 요청 결과</h1>
	<hr>
	결과 : <span><%= request.getAttribute("data") %></span><br><br>
	결과 : <span> ${ data }</span><br><br>
	<a href=${ header.referer }>입력화면</a>
</body>
</html>