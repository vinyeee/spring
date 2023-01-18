<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style>
    @font-face {
    font-family: 'OTWelcomeRA';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2110@1.0/OTWelcomeRA.woff2') format('woff2');
    font-weight: normal;
    font-style: normal;
	}

    * {
    	font-family: 'OTWelcomeRA';
    }
	td{
		border-bottom : 2px dotted green;
		padding-left : 20px;
	}
	tr:hover{ 
		background-color : pink;	
		font-weight : bold;
	}
	td:nth-child(2){
		width : 300px;
	}
	input, textarea {
		padding : 5px;
		border-radius : 5px;
	}
	div {
		margin-top : 20px;
	}
	button {
		padding-top : 5px;
	}
</style>
</head>
<body>
<c:if test="${ !empty list }" >
	<h1 onclick="location.href='/springedu/meeting'">미팅 스케쥴</h1>
	<hr>
	<table>
		<c:forEach var="vo"  items="${list}">
			<tr>
			<td class="${vo.id}">${ vo.name }</td>
			<td class="${vo.id}" onclick="displayReply(${vo.id})" >${ vo.title }</td>
			<td class="${vo.id}">${ vo.meetingDate }</td>
			<td><a href ="/springedu/meeting/delete?id=${vo.id}">
			<img src = "/springedu/resources/images/delete.png" width ='20'></a></td>
			<td><img onclick="displayUpdateForm('${vo.id}')" 
			       src="/springedu/resources/images/edit.png" width ='20'></td>
			<td><img onclick="insertReply('${vo.id}')" 
			       src="/springedu/resources/images/comment.png" width ='25'></td>
			</tr>
	</c:forEach>
	</table>
</c:if>
<c:if test="${ !empty msg }" >
	<script>
		alert('${ msg }');
	</script>
</c:if>
<hr>
<button onclick="displayDiv(1);">미팅 정보 작성</button>
<button onclick="displayDiv(2);">미팅 정보 검색</button>
<c:if test="${ button != null }" >
    <hr>
	<button onclick="location.href='/springedu/meeting'">${ button }</button>
</c:if>
<script>
function displayDiv(type) {
	if(type == 1) {
		document.getElementById("search").style.display='none';
		document.getElementById("write").style.display='block';
		document.getElementById("divT").textContent="미팅정보 작성";
		document.querySelector("#write [type=submit]").value="등록";		
	} else if(type == 2) {
		document.getElementById("write").style.display='none';
		document.getElementById("search").style.display='block';
	}	
}
function displayUpdateForm(cv) {
    var doms = document.getElementsByClassName(cv);
    document.getElementById("search").style.display='none';
	document.getElementById("write").style.display='block';	
	document.getElementById("m_name").value = 
		                                  doms[0].textContent;
	document.getElementById("m_title").value = 
		                                  doms[1].textContent;
	var str = doms[2].textContent;
	var ary = str.split(/\D+/g)
	var meeting_dt = ary[0]+"-"+ary[1]+"-"+ary[2]+
	                          "T"+ary[3]+":"+ary[4];
	document.getElementById("m_dt").value = meeting_dt;
	document.getElementById("divT").textContent="미팅정보 수정";
	document.querySelector("#write [type=submit]").value="수정";
	document.querySelector("#write [type=hidden]").value=cv;
	document.querySelector("#write form").action="/springedu/meeting/update";
}
function displayReply(id) {
	var xhr = new XMLHttpRequest();
	xhr.onload = function () {
		if(xhr.status == 200) {				
			let jsondoms = JSON.parse(xhr.responseText);
			let replyContent = "";			
			for(let i in jsondoms) {	
				i = Number(i);
				replyContent += "[댓글"+(i+1)+"] 작성자명 : "+jsondoms[i].name+", 내용 : "+jsondoms[i].content+"\n"; 
			}
			if (!replyContent)
				replyContent = "아직 댓글이 없네요!!";
			window.alert(replyContent);
		}
	}
	xhr.open("GET", "/springedu/meeting/lreply?refid="+id, true);
	xhr.send();		
}
function insertReply(id) {
	let name = window.prompt("댓글 작성자의 성명을 입력하세요..");
	let content = window.prompt("댓글 내용을 입력하세요..");
	let query = "name="+name+"&content="+content+"&refid="+id;	
	var xhr = new XMLHttpRequest();
	xhr.onload = function () {
		if(xhr.status == 200) {				
			let jsondom = JSON.parse(xhr.responseText);
			if (jsondom.result == true)
				window.alert("댓글 작성이 완료되었습니다.");
			else
				window.alert("댓글 작성에 실패했습니다.");
		}
	};
	xhr.open("GET", "/springedu/meeting/ireply?"+query, true);
	xhr.send();		
}
</script>
<div id="write"  style="display:none">
 <hr><h2 id="divT">미팅정보 작성</h2>
 <form method = "post" action = "/springedu/meeting/insert">
 <input type="hidden" name="id" value="0">
 미팅 대상 이름 : <input id="m_name" type="text"  name="name">
 <br>
 미팅 목적 : <br>
 <textarea id="m_title"  rows="3" cols="60" name = "title" ></textarea>
 <br>
 날짜와 시간 :  <input id="m_dt" type="datetime-local" name="meetingDate">
 <br><br>
 <input type = "submit" value = "등록">
 <input type="button"  value="취소" onclick="document.getElementById('write').style.display='none';return false">
 </form>
</div>
<div id="search" style="display:none">
 <hr>
 <form method = "get" action ="/springedu/meeting/search">
 검색어 : <input type = "search" name = "keyword" >
 <input type = "submit" value = "검색">
 </form>
</div>
</body>
</html>





