<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<article>
<h1>상품리스트</h1>	
<form name="frm" id="prod_form" method="post">
<table>
  <tr>
  <td >
      상품명 
     <input type="text" name="key" id="key">
     <input class="btn" type="button" name="btn_search" value="검색" onClick="go_search()">
     <input class="btn" type="button" name="btn_total" value="전체보기" onClick="go_total()">
     <input class="btn" type="button" name="btn_write" value="상품등록" onClick="go_wrt()">
  </td>
  </tr>
</table>
<!-- <table id="productList"> -->
<table id="datatable" class="table table-bordered dataTable">
    <tr>
        <th>번호</th><th>카테고리</th>
        <th>상품명</th><th>수량</th>
        <th>원가</th><th>판매가</th><th>등록일</th><th>사용유무</th>
    </tr>
    <tbody>
    <c:choose>
    <c:when test="${productListSize<=0}">
    <tr>
      <td width="100%" colspan="7" align="center" height="23">
        등록된 상품이 없습니다.
      </td>      
    </tr>
    </c:when>
	<c:otherwise>
	<c:forEach items="${productList}" var="productVO" varStatus="status">
    <tr>
      <td height="23" align="center">${status.count}</td>
      <td>${kind[productVO.kind]}</td>
      <td style="text-align: left; padding-left: 50px; padding-right: 0px;">   
  		<a href="#" onclick="go_detail('${productVO.pseq}')">    
    	 ${productVO.name}     
   		</a>
   	  </td>
   	  <td><fmt:formatNumber value="${productVO.quantity}"/></td>
      <td><fmt:formatNumber value="${productVO.price1}"/></td>
      <td><fmt:formatNumber value="${productVO.price2}"/></td>
      <td><fmt:formatDate value="${productVO.regdate}"/></td>
      <td>
      	<c:choose>
   	 		<c:when test='${productVO.bestyn=="n"}'>미사용</c:when>
   	 		<c:otherwise>사용</c:otherwise>  	 		
   	 	</c:choose>
   	  </td> 
    </tr>
    </c:forEach>
    <tr><td colspan="6" style="text-align: center;"> ${paging} </td></tr>
	</c:otherwise>	
</c:choose>  
</tbody>
</table>

<%@ include file="../page_area.jsp" %>
</form> 

</article>
<%-- <%@ include file="../footer.jsp" %> --%>
