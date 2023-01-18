<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="vo.StepVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table, th, td  {
	border : 1px solid black;
	border-collapse: collapse;
}
td {
	text-align: center;
}
</style>
</head>
<body>
<h2>전달된 스텝 정보입니다.</h2>
<table>
<tr><th>스텝이름</th><th>전화번호</th><th>나이</th></tr>
<tr>
<td>${ kkk.name }</td>
<td>${ kkk.phoneNumber }</td>
<td>${ kkk.age }</td>
</tr> 
</table> 
<hr>
<a href=${ header.referer }>입력화면으로...</a>
</body>
</html>
