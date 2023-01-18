<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>요청 방식 : ${ pageContext.request.method }</h2>
<hr>
<h2>쿼리 문자열 : ${ param.pageno }</h2>
<hr>
<a href='${ header.referer }'>다시 요청 해보자</a>
</body>
</html>





