<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<article>
	<h1>상품 상세</h1>
	<div id="itemdetail">
		<form method="post" action="cart_insert" name="formm" id="theform">
			<fieldset>
				<legend> 상품 상세 정보</legend>
				<span style="float: left;"> <img src="images/product/${productVO.image}" style="width: 400px; height: 400px;" />
				</span>
				<h2>${productVO.name}</h2>
				<label> 가 격 : </label>
				<p>
					<fmt:formatNumber type="currency" value="${productVO.price2}" />
				</p>
				<label> 수 량 : </label> <input type="number" min="1" max="20" name="quantity" id="quantity" size="2" value="1" onchange="updateTotal()"><br> <input type="hidden" name="pseq" value="${productVO.pseq}"><br>
				<p>
					총 합계: <input type="text" readonly="readonly" id="total" style="border: 0;">
				</p>
				<label>${productVO.content }</label>

			</fieldset>
			<div class="clear"></div>
			<div id="buttons" align="center">
				<input type="button" value="장바구니에 담기" class="submit" onclick="go_cart()"> <input type="button" value="즉시 구매" class="submit" onclick="go_order()"> <input type="reset" value="취소" class="cancel">
			</div>
		</form>
	</div>
</article>
<script type="text/javascript">
	function updateTotal() {
		var quantity = document.getElementById('quantity').value;
		var price = parseInt("${productVO.price2}");
		var total = quantity * price;
		document.getElementById('total').value = total.toLocaleString() + "원";
	}

	window.onload = function() {
		updateTotal();
	};
</script>
<%@ include file="../footer.jsp"%>





