<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML>
<!--
	Phantom by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
	<head>
<script type="text/javascript" src="js/member.js"></script>
<script type="text/javascript" src="js/product.js"></script>
<script type="text/javascript" src="js/mypage.js"></script>
<script type="text/javascript" src="js/order.js"></script>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
		<title>Elteir</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />
		<noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>
		
	
	
	<nav class="navbar navbar-expand-lg navbar-light">
		<div class="container px-4 px-lg-5" style="margin:0 0 0 200px;">
			<!-- <a class="navbar-brand" href="index" style="font-weight:bold;  color:#135dba;">byunggunPC</a> -->
			<c:choose>
				<c:when test="${sessionScope.loginUser == null}">
					<a class="navbar-brand" href="loginForm" style="">로그인</a>
					<a class="navbar-brand" href="joinForm" style="margin:0 0 0 60px;">회원가입</a>
					<a class="navbar-brand" href="admin_login_form" style="margin:0 0 0 60px;">관리자페이지</a>
				</c:when>
				<c:otherwise>
					<a style="">${sessionScope.loginUser.name}님 환영합니다</a>
					<a class="navbar-brand" href="orders?result=1" style="margin:0 0 0 60px;">마이페이지</a>
					<a class="navbar-brand" href="logout" style="margin:0 0 0 60px;">로그아웃</a>
                    <a class="navbar-brand" href="cartList" style="margin:0 0 0 60px;">Cart</a>
				</c:otherwise>
			</c:choose>
			
		</div>
	</nav>
		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Header -->
					<header id="header">
						<div class="inner">

							<!-- Logo -->
								<a href="index" class="logo">
									<span class="symbol"><img src="images2/logo.svg" alt="" /></span><span class="title">Elteir</span>
								</a>

							<!-- Nav -->
								<nav>
									<ul>
										<li><a href="#menu">Menu</a></li>
									</ul>
								</nav>

						</div>
					</header>
</head>
	<body class="is-preload">
				<!-- Menu -->
					<nav id="menu">
						<h2>Menu</h2>
						<ul>
							<li><a href="category?kind=1" >CPU</a></li>
							<li><a href="category?kind=2" >메인보드</a></li>
							<li><a href="category?kind=3" >그래픽카드</a></li>
							<li><a href="category?kind=4" >파워</a></li>
							<li><a href="category?kind=5" >조립PC</a></li>
							<li><a href="category2?bestyn=1" >세일상품</a></li>
						</ul>
						<form action="search" method="post" id="searchform" name="searchform">
					<div id="searchdiv">
						<input type="text" name="keyword" id="search" placeholder="검색어 입력">
						<button type="button" onclick="go_search()" id="searchButton">검색</button>
					</div>
			</form>
						
					</nav>
					

				