<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="sub_menu.jsp"%>
<article id="main-menu">
	<h2>My Page(${title})</h2>
	<form name="formm" method="post" id="formm">
		<c:choose>
			<c:when test="${orderList.size() == 0}">
			주문 내역이 없습니다.
			<input type="button" value="쇼핑 계속하기" class="cancel" onclick="location.href='index'">
			</c:when>
			<c:otherwise>
				<table id="cartList">
					<tr>
						<th>주문일자</th>
						<th>주문번호</th>
						<th>상품명</th>
						<th>결제 금액</th>
						<th>주문 상세</th>
						<c:if test="${orderList[0].result == 1}">
							<th>주문 삭제</th>
						</c:if>
					</tr>
					<c:forEach items="${orderList}" var="orderVO">
						<tr align="center">
							<td>
								<fmt:formatDate value="${orderVO.indate}" type="date" />
							</td>
							<td>${orderVO.oseq}</td>
							<td>${orderVO.pname}</td>
							<td>
								<fmt:formatNumber value="${orderVO.price2}" type="currency" currencySymbol="￦" />
							</td>
							<td>
								<a href="order_list?oseq=${orderVO.oseq}"> 조회 </a>
							</td>
							<c:if test="${orderVO.result == 1}">
								<td>
									<input type="checkbox" value="${orderVO.oseq}" name="oseq" id="oseq">
								</td>
							</c:if>
						</tr>
					</c:forEach>
				</table>

				<div class="clear"></div>
				<div id="buttons" style="float: right">
					<c:if test="${orderList[0].result == 1}">
						<input type="button" value="주문삭제" class="cancel" onclick="deleteOrder()">
					</c:if>
					<input type="button" value="쇼핑 계속하기" class="cancel" onclick="location.href='index'">
				</div>
			</c:otherwise>
		</c:choose>
	</form>

</article>
</div>
<%@ include file="../footer.jsp"%>