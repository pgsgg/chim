<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<h2> Cart List </h2>
    <form name="formm" id="theform" method="post">
    <c:choose>
    <c:when test="${cartList.size() == 0}">
    	장바구니 내역이 없습니다.
    </c:when>
    <c:otherwise>
	<table>
		<thead>
			<tr align="center">
				<th>주문번호</th>
				<th>아이디</th>
				<th>사용자 이름</th>
				<th>제품명</th>
				<th>가격</th>
				<th>등록일</th>
				<th>선택삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="cartVO" items="${cartList}">
				<tr align="center">
					<td>${cartVO.cseq}</td>
					<td>${cartVO.id}</td>
					<td>${cartVO.mname}</td>
					<td>${cartVO.pname}</td>
					<td>${cartVO.price2}원</td>
					<td><fmt:formatDate value="${cartVO.indate}" pattern="yyyy-MM-dd"/></td>
					<td><input type="checkbox" name="cseq" id="cseq" value="${cartVO.cseq}"> </td>
				</tr>
			</c:forEach>
			<tr>
			<td>총액</td>
			<td colspan="6" align="center">${totalPrice}원</td>
			</tr>
		</tbody>	
	</table>
	<button type="button" class="btn btn-danger btn-lg" onclick="go_cart_delete()">삭제하기</button>
	<input type="button" class="btn btn-primary btn-lg" onclick="go_order()" value="주문하기">
	</c:otherwise>
	</c:choose>
	</form>
	<%@ include file="../footer.jsp"%>