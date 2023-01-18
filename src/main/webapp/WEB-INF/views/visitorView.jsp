<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/springedu/resources/css/visitor.css">
<style>
table {
	margin : 5px auto;
}
td{
	border-bottom: 1px dotted black;
	padding : 10px;
	text-align : left;
}
tr:hover{
    background-color: pink;
}
div {
	margin:10px auto;
	padding: 50px;
	background: linear-gradient(to bottom, #33ccff 0%, #ff99cc 100%);
	width: 800px;
	border-radius: 5px;
}
</style>
</head>
<body>
	<h1>방명록 글 리스트</h1>
	<hr>
	<div>
	<c:choose>
		<c:when test="${ !empty requestScope.list}">
			<table>
			<c:forEach var = "vo" items = "${requestScope.list }">
				<tr>					
					<td>${vo.name }</td>
					<td>${vo.writedate }</td>
					<td>${vo.memo }</td>
					<td><a href = "/springedu/vdelete?id=${vo.id}">
							<img src="/springedu/resources/images/delete.png"  width="38">
						  </a>
					</td>
					<td><img src="/springedu/resources/images/edit.png"  width="38" onclick="displayUpdateForm(${vo.id})"></td>
				</tr>
			</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
		<h3>${requestScope.msg }</h3>
		</c:otherwise>
	</c:choose>
	<hr>
	<a href = "/springedu/resources/visitorMain.html"><button>메인페이지로 돌아가기</button></a>
	</div>
	<div id="updateform" style="display:none">
	<h2>글을 수정하세요</h2>
	<hr>
	<form method = "post" action = "/springedu/vupdate">
	<input type="hidden" name="id"  value="">
	<input type ="text" name ="name"  value=""  required><br>
	<textarea cols="35" rows="10" name ="memo"  required></textarea><br>	
	<input type = "submit" value = "수정">
	<input type = "reset" value = "재작성" onclick="resetForm();return false;">
	<input type = "button" value = "취소"  onclick="document.getElementById('updateform').style.display='none'">
	</form>
	</div>
<script>
	let jsonobj = null;
	let namedom = null;
	let memodom = null;
	function displayUpdateForm(id) {
		let xhr = new XMLHttpRequest();
		xhr.onload = function() {
			if (xhr.status == 200) {
				document.getElementById('updateform').style.display='block';
				iddom = document.querySelector("#updateform input[name=id]");
				namedom = document.querySelector("#updateform input[name=name]");
				memodom = document.querySelector("#updateform textarea");
				jsonobj = JSON.parse(xhr.responseText);
				iddom.value = jsonobj.id;
				namedom.value = jsonobj.name;
				memodom.value = jsonobj.memo;								
			}
		};
		xhr.open('GET', '/springedu/one?id='+id, true);
		xhr.send();
	}
	function resetForm() {
		if (jsonobj) {
			namedom.value = jsonobj.name;
			memodom.value = jsonobj.memo;
		}
	}
</script>
</body>
</html>