<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<h2> Order List </h2>
	<table id="datatable" class="table table-bordered dataTable">
		<thead>
			<tr >
				<th>주문번호</th>
				<th>제품명</th>
				<th>수량</th>
				<th>가격</th>
				<th>등록일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="cartVO" items="${listOrder}">
				<tr align="center">
					<td>${cartVO.oseq}</td>
					<td>${cartVO.pname}</td>
					<td>${cartVO.quantity}</td>
					<td>${cartVO.price2*cartVO.quantity}원</td>
					<td><fmt:formatDate value="${cartVO.indate}" pattern="yyyy-MM-dd"/></td>
				</tr>
			</c:forEach>
			<tr>
			<td>총액</td>
			<td colspan="4" align="center">${totalPrice}원</td>
			</tr>
		</tbody>	
	</table>
<%@ include file="../footer.jsp"%>