<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
   h1 {
   	color : lime;
   }

</style>
</head>
<body>
<h1><%= request.getMethod() %></h1>
<hr>
<a href="${ header.referer }">요청 화면</a>
</body>
</html>
