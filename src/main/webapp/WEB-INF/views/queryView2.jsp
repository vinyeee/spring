<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>응답용JSP</title>
</head>
<body>
<h2>Forward from QueryStringController2 to queryView2.jsp</h2>
<hr>
	<c:if test="${!empty queryVO}" >
		<ul>
			<li>${ queryVO.testName }</li>
			<li>${ queryVO.testAge }</li>
			<li>${ queryVO.testAddr }</li>
		</ul>
    </c:if>
<h3>Total Query String : ${ spring }</h3>
<hr>
<a href="${ header.referer }">입력 화면으로</a>        
</body>
</html>



