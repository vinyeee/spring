<%@ page contentType="text/json; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<c:catch var="err">
	<c:import var="weather"
		url="http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1165051000">
	</c:import>
	<x:parse varDom="wrss" xml="${weather}"></x:parse>

	<c:set var="wfKor">
		<x:out select="$wrss/rss/channel/item/description/body/data/wfKor" />
	</c:set>
 {
     "time" :  "<x:out select="$wrss/rss/channel/pubDate" />", 
     "img" : <c:choose>
		<c:when test='${ wfKor == "구름많음" or wfKor == "흐림"}'>
					"images/cloud.png"
				</c:when>
		<c:when test='${ wfKor == "구름조금"}'>
					"images/cloud_sun.png"
				</c:when>
		<c:when test='${ wfKor == "맑음"}'>
					"images/sun.png"
				</c:when>
		<c:when test='${ wfKor == "비" or wfKor == "흐리고 비"}'>
					"images/rain.png"
				</c:when>
		<c:when test='${ wfKor == "눈"}'>
					"images/snow.png"
				</c:when>
		<c:otherwise>
					"images/etc.png"
		</c:otherwise>
	</c:choose>
  }         
</c:catch>
<c:if test="${err!=null}">
   ${err}
</c:if>
