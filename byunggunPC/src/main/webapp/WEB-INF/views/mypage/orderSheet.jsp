<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<h2>Order List</h2>
<form id="orderForm" name="orderForm" method="post">
	<table id="datatable" class="table table-bordered dataTable">
		<thead>
			<tr align="center">
				<th>제품명</th>
				<th>수량</th>
				<th>가격</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${listOrder.size()>0}">
					<c:forEach var="cartVO" items="${listOrder}">
						<tr align="center">
							<td>${cartVO.pname}</td>
							<td>${cartVO.quantity}</td>
							<td>${cartVO.price2}원</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr align="center">
						<td>${order.pname}</td>
						<td>${order.quantity}</td>
						<td>${order.price2*order.quantity}원</td>
					</tr>
				</c:otherwise>
			</c:choose>
			<tr>
				<td>총액</td>
				<td colspan="3" align="center">${totalPrice}원</td>
			</tr>
		</tbody>
	</table>
	<div class="d-flex flex-row align-items-center mb-4">
		<i class="fas fa-user fa-lg me-3 fa-fw"></i>
		<div class="form-outline flex-fill mb-0">
			<input type="text" class="form-control" name="name" id="name" value="${memberVO.name}" /> <label class="form-label" for="form3Example1c">이름</label>
		</div>
	</div>
	<div class="d-flex flex-row align-items-center mb-4">
		<i class="fas fa-key fa-lg me-3 fa-fw"></i>
		<div class="form-outline flex-fill mb-0">
			<input type="text" class="form-control" value="${memberVO.zip_num}" name="zip_num" id="zipNum" readonly="readonly" style="display: inline-block; width: 140px;" />
			<button type="button" class="btn btn-primary btn-lg" onclick="getAddress()" style="display: inline-block; width: 140px; height: 38px">주소찾기</button>
			<input type="text" class="form-control" value="${address}" name="address" id="address" readonly="readonly" /> <input type="text" class="form-control" value="${addressDetail}" name="addressDetail" id="addressDetail" />
		</div>
	</div>
	<div class="d-flex flex-row align-items-center mb-4">
		<i class="fas fa-key fa-lg me-3 fa-fw"></i>
		<div class="form-outline flex-fill mb-0">
			<input type="text" class="form-control" value="${memberVO.phone}" name="phone" id="phone" /> <label class="form-label" for="form3Example4cd">휴대폰 번호(-포함)</label>
		</div>
	</div>
	<button type="button" class="btn btn-color" onclick="location.href='index'">취소하기</button>
	<input type="button" class="btn btn-color" onclick="go_order()" value="주문하기"> <input type="hidden" name="pseq" value="${order.pseq}"> <input type="hidden" name="quantity" value="${order.quantity}">
</form>
<style>
.btn-color {
	background-color: #975;
	color: #fff;
}
</style>
<%@ include file="../footer.jsp"%>