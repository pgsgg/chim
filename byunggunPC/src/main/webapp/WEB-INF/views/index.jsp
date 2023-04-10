<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!-- Main -->
					<div id="main">
						<div class="inner">
							<header>
								<h1>Hello, Nice to meet you.<br />
								Welcome to ELTEIR</h1>
								<p>Etiam quis viverra lorem, in semper lorem. Sed nisl arcu euismod sit amet nisi euismod sed cursus arcu elementum ipsum arcu vivamus quis venenatis orci lorem ipsum et magna feugiat veroeros aliquam. Lorem ipsum dolor sit amet nullam dolore.</p>
							</header>
							
							
							<section class="tiles">
							<c:forEach var="productVO" items="${productList}" varStatus="status">
								<article class="style1">
									<span class="image">
										<img src="images/product/${productVO.image}" alt=""/>
									</span>
									<!-- <a href="generic.html"> -->
										<h2 href="product_detail?pseq=${productVO.pseq}">${productVO.name}</h2>
								</article>
								
								</c:forEach>
							</section>
						</div>
					</div>
<%@ include file="footer.jsp"%>