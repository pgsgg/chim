<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>TEST</title>
<link href="css/styles2.css" rel="stylesheet" />
<style type="text/css">
@charset "UTF-8";

@import url('https://fonts.googleapis.com/css?family=Montserrat:300,400,500&display=swap');

.body2{
	font-family:'Montserrat', sans-serif;
	margin:0;
}
.container2{
	display: grid;
	grid-gap:10px;
	height:100vh;
	grid-template-columns: 300px 1fr 300px;
	gird-template-rows:100px 150px 1fr 150px 100px;
	grid-template-areas:'header header header'
						'menu main top'
						'menu main aside'
						'menu main bottom'
						'footer footer footer';
	
}
.container2 div {
	background-color:skyblue;
	padding:20px;
	border:1px soild #000;
	display: grid;
	justify-items:center;
	align-items:center;
	
}

.header{
	grid-area:header;
	
}

.menu{
	grid-area:menu;
}
.main{
	grid-area:main;
}
.top{
	grid-area:top;
}
.asdie{
	grid-area: aside;
}
.bottom{
	grid-area: bottom;
}
.footer{
	grid-area: footer;
}

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
	background: #000;
	outline: none;
	color: #ffffff;
	border-radius: 15px;
}

button:not(:disabled), [type=button]:not(:disabled), [type=reset]:not(:disabled), [type=submit]:not(:disabled) {
    cursor: pointer;
}
button, [type=button], [type=reset], [type=submit] {
    -webkit-appearance: button;
}

button {text-transform: none;}

body, input, textarea, select, button, table {
    font-family: '¸¼Àº°íµñ',malgun gothic,'µ¸¿ò',Dotum,AppleGothic,sans- serif;
    font-size: 12px;
}

body, p, h1, h2, h3, h4, h5, h6, ul, ol, li, dl, dt, dd, table, th, td, form, fieldset, legend, input, textare a, button, select {
    margin: 0;
    padding: 0;
    border-radius: 15px;
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
	
	<div class="container2">
	<div class="header">header
	
	</div>
	<div class="menu">menu
	
	
	</div>
	<div class="main">main
		<img src="images/main_photo/banner.PNG"/>
	
		
		<br><br>
	<img src="images/main_photo/guard.PNG"/>
	<img src="images/main_photo/banner.PNG"/>
	<img src="images/main_photo/banner.PNG"/>

	</div>
	<div class="top">top</div>
	<div class="aside">aside</div>
	<div class="bottom">bottom</div>
	<div class="footer">footer</div>
	
	
	
	</div>
	
	
</body>
</html>
