<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<div class="container px-4 px-lg-5 my-5">
	<div class="text-center text-white">
		<img src="images/main_photo/banner.PNG"/>
		<br><br>
		
	</div>
	
	<div class="text-center text-white">
	<img src="images/main_photo/guard.PNG"/>
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
						<img class="card-img-top wh" src="images/product/${productVO.image}" onerror="this.onerror=null; this.src='images/product/ready.jpg';"/>
						<!-- Product details-->
						<div class="card-body p-4">
							<div class="text-center">
								<!-- Product name-->
								<h5 class="fw-bolder">
									<a href="product_detail?pseq=${productVO.pseq}">${productVO.name}</a>
								</h5>
								<!-- Product price-->
								<a class="pd_info_box">
								<span class="price">
								<span class="price_area">
								${productVO.price2}원
								</span></span></a>
							</div>
						</div>
						<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
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
