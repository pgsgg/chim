<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
#searchdiv {
	display: flex;
	align-items: center;
	height: 40px;
	width: 400px;
	border-radius: 15px;
	background: #ffffff;
	box-sizing: border-box;
}

#search {
	flex: 1;
	font-size: 16px;
	padding: 10px;
	border: 0px;
	outline: none;
	
}

#searchButton {
	width: 50px;
	height: 100%;
	border: 0px;
	background: #1b5ac2;
	outline: none;
	color: #ffffff;
	border-radius: 15px;
}
</style>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>byunggunPC</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Bootstrap icons-->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="css/styles.css" rel="stylesheet" />
<link href="css/page-2.css" rel="stylesheet" />
<script src="https://code.jquery.com/jquery-3.6.2.min.js" integrity="sha256-2krYZKh//PcchRtd+H+VyyQoZ/e3EcrkxhM8ycwASPA=" crossorigin="anonymous"></script>
<script type="text/javascript" src="js/member.js"></script>
<script type="text/javascript" src="js/product.js"></script>
<script type="text/javascript" src="js/mypage.js"></script>
<script type="text/javascript" src="js/order.js"></script>
</head>
<body>
	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container px-4 px-lg-5">
			<a class="navbar-brand" href="index">byunggunPC</a>
			<c:choose>
				<c:when test="${sessionScope.loginUser == null}">
					<a class="navbar-brand" href="loginForm">로그인</a>
					<a class="navbar-brand" href="joinForm">회원가입</a>
					<a class="navbar-brand" href="admin_login_form">관리자페이지</a>
				</c:when>
				<c:otherwise>
					${sessionScope.loginUser.name}님 환영합니다
					<a class="navbar-brand" href="orders?result=1">마이페이지</a>
					<a class="navbar-brand" href="logout">로그아웃</a>
					<form class="d-flex">
                        <button class="btn btn-outline-dark" type="button" onclick="location.href = 'cartList'">
                            <i class="bi-cart-fill me-1"></i>
                            <a class="navbar-brand" href="cartList">Cart</a>
                            <span class="badge bg-dark text-white ms-1 rounded-pill" id="cartCounting">0</span>
                        </button>
                    </form>
				</c:otherwise>
			</c:choose>
			<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			
			<form action="search" method="post" id="searchform" name="searchform">
		<div align="center">
			<div id="searchdiv">
				<input type="text" name="keyword" id="search" placeholder="검색어 입력">
				<button type="button" onclick="go_search()" id="searchButton">검색</button>
			</div>
		</div>
	</form>
		</div>
	</nav>
	<header class="bg-dark">
	<div class="cpz_lnb_wrap">
		<div class="cpz_inner">
			<div class="lnb_menu_box">
				<div class="cpz_category_layer"></div>
				<div class="text-center text-white">
				<p class="lead fw-normal text-white-50 mb-0 fw-bolder">
					<a href="category?kind=1" style="margin:20px;">CPU</a>
					<a href="category?kind=2" style="margin:20px;">메인보드</a>
					<a href="category?kind=3" style="margin:20px;">그래픽카드</a>
					<a href="category?kind=4" style="margin:20px;">파워</a>
					<a href="category?kind=5" style="margin:20px;">조립PC </a>
					<a href="category?kind=5" style="margin:20px;">세일상품 </a>
					</p>
				</div>
			</div>
		</div>
	</div>
	</header>
	
	<div style="height: 20px;"></div>