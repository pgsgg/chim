<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<div class="container px-4 px-lg-5 my-5">
	<div class="text-center text-white">
		<h1 class="display-4 fw-bolder">byunggunPC</h1>
		<p class="lead fw-normal text-white-50 mb-0">병건 조립PC</p>
	</div>
</div>
<!-- Section-->
<section class="py-5">
	<div class="container px-4 px-lg-5 mt-5">
		<div class="row gx-4 gx-lg-5 row-cols-1 row-cols-md-2 row-cols-xl-3 justify-content-center">
			<c:forEach var="productVO" items="${productList}" varStatus="status">
				<div class="col mb-5">
					<div class="card h-100">
						<!-- Product image-->
						<img class="card-img-top" src="images/product/${productVO.image}" alt="..." />
						<!-- Product details-->
						<div class="card-body p-4">
							<div class="text-center">
								<!-- Product name-->
								<h5 class="fw-bolder">
									<a href="product_detail?pseq=${productVO.pseq}">${productVO.name}</a>
								</h5>
								<!-- Product price-->
								${productVO.price2}원
							</div>
						</div>
					</div>
				</div>
				<c:if test="${status.count % 3 == 0}">
					<div class="w-100"></div>
				</c:if>
			</c:forEach>
		</div>
	</div>
</section>
<%@ include file="footer.jsp"%>
