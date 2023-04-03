<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta charset="UTF-8">
<style>
.container {
	display: flex;
	justify-content: space-between;
	align-items: center;
}

#sub-menu ul {
	list-style: none;
	margin: 0;
	padding: 0;
	display: flex;
	justify-content: flex-start;
}

#sub-menu ul li {
	margin-right: 20px;
}

#main-menu {
	width: 80%;
	/* ... 생략 ... */
}
</style>
<div class=container">
	<nav id="sub-menu">
		<ul>
			<li><a href="cartList">장바구니(cart)내역</a></li>
			<li><a href="orders?result=1">입금확인중</a></li>
			<li><a href="orders?result=2">결제완료</a></li>
		</ul>
	</nav>