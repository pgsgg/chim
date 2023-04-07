<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<!-- Header-->
<header class="bg-dark py-5">
	<div class="container px-4 px-lg-5 my-5">
		<div class="text-center text-white">
			<h1 class="display-4 fw-bolder">byunggunPC</h1>
			<p class="lead fw-normal text-white-50 mb-0">병건 조립PC</p>
		</div>
	</div>
</header>
<!-- Section-->
<section class="py-5 text-center">
	<ul align="center" style="list-style-type: none;">
		<c:forEach var="productVO" items="${productKindList}" varStatus="status">
			<li style="width: 1050px; height: 220px; display: flex; align-items: center; border: 1px groove #bcbcbc; margin: 10px 10px 10px 200px;" >
				<div style="margin-left: 10px;">
					<a href="product_detail?pseq=${productVO.pseq}"> <img src="images/product/${productVO.image}" width="190" height="190" align="left"
					onerror="this.onerror=null; this.src='images/product/ready.jpg';">
					</a>
				</div>
				<div style="margin: auto;">
					<a href="product_detail?pseq=${productVO.pseq}" style="font-weight: bold;">${productVO.name}</a>
					<p style="text-align: center; width:500px;">${productVO.content}</p>
				</div>
				
				<div style="margin: auto;">
				<a href="product_detail?pseq=${productVO.pseq}" style="font-weight: bold;">${productVO.price2} 원</a>
				</div>
			</li>
		</c:forEach>
			<%@include file="page_area.jsp"%>
	</ul>
</section>

<style type="text/css">

.avav {
border : 1px soild #fff;
}

</style>
<%@ include file="../footer.jsp"%>
