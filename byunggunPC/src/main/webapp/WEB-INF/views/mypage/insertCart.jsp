<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<form>
		<label for="name">이름:</label> <input type="text" id="name" name="name"><br>
		<br> <label for="product_num">제품번호:</label> <input type="text" id="product_num" name="pseq"><br>
		<br> <label for="quantity">수량:</label> <input type="number" id="quantity" name="quantity"><br>
		<br> <label for="product_name">제품이름:</label> <input type="text" id="product_name" name="pname"><br>
		<br> <label for="price">가격:</label> <input type="number" id="price" name="price2"><br>
		<br>

		<button type="button" value="카트추가" onclick="go_cart_insert"></button>
	</form>
</body>
<script type="text/javascript">
	function go_cart_insert() {
		var form = document.getElementById('theform');
		form.action = "cart_insert";
		form.submit();
	}
</script>
</html>