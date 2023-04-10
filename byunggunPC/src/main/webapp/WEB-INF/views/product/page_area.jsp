<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!--  각 화면의 페이지 번호가 표시되는 영역의 구현 -->
<center>
<div style="margin:0 0 0 0;">
	<ul class="pagination">
	
		<c:if test="${pageMaker.prev}">
			<li class="paginate_button previous">
				<a href="${url}${pageMaker.makeQuery(pageMaker.startPage-1)}&kind=${productKindList[0].kind}">[이전]</a>
			</li>
		</c:if>
				
		<!-- [1][2][3]... 표시 부분 -->
		<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="index">
			<a href="${url}${pageMaker.makeQuery(index)}&kind=${productKindList[0].kind}&keyword=${keyword}">[${index}]</a>
		</c:forEach>
		
		<c:if test="${pageMaker.next}">
			<li class="paginate_button next">
				<a href="${url}${pageMaker.makeQuery(pageMaker.endPage+1)}&kind=${productKindList[0].kind}">[다음]</a>
			</li>
		</c:if>
			
	</ul>
</div>
</center>



