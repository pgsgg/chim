<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="sub_menu.jsp" %>
<!DOCTYPE html>
<h2> Cart List </h2>
    <form name="formm" id="theform" method="post">
    <c:choose>
    <c:when test="${cartList.size() == 0}">
    <br><br><br>
    	장바구니 내역이 없습니다.
    	<br><br><br><br><br><br><br>
    </c:when>
    <c:otherwise>
	<table>
		<thead>
			<tr align="center">
				<th>주문번호</th>
				<th>아이디</th>
				<th>사용자 이름</th>
				<th>제품명</th>
				<th>수량</th>
				<th>가격</th>
				<th>등록일</th>
				<th>선택삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="cartVO" items="${cartList}">
				<tr>
					<td>${cartVO.cseq}</td>
					<td>${cartVO.id}</td>
					<td>${cartVO.mname}</td>
					<td>${cartVO.pname}</td>
					<td>${cartVO.quantity}</td>
					<td>${cartVO.price2*cartVO.quantity}원</td>
					<td><fmt:formatDate value="${cartVO.indate}" pattern="yyyy-MM-dd"/></td>
					<td><input type="checkbox" name="cseq" id="cseq" value="${cartVO.cseq}"> </td>
				</tr>
				<tr>
				<td colspan="8"> &nbsp;</td>
				</tr>
			</c:forEach>
			<tr style="background-color:#73685d;" height="5px">
			<td style="background-color:#73685d; color:white; font-size:20px;text-align: end;" colspan="7">총액</td>
			<td style="background-color:#73685d; color:white; font-size:20px;" colspan="1">${totalPrice}원</td>
			</tr>
		</tbody>	
	</table><br>
	<center>
	<button type="button" class="btn btn-color" onclick="go_cart_delete()">삭제하기</button>
	<input type="button" class="btn btn-color" onclick="go_order_sheet()" value="주문하기">
	</center>
	</c:otherwise>
	</c:choose>
	</form>
	<%@ include file="../footer.jsp"%>
	
	
	
	



<style type="text/css">

.btn-color {
background-color : #975;
color : #fff;
}

body {
  padding:1.5em;
  background: #f5f5f5
}

table {
  border: 1px #a39485 solid;
  font-size: .9em;
  box-shadow: 0 2px 5px rgba(0,0,0,.25);
  width: 100%;
  border-collapse: collapse;
  border-radius: 5px;
  overflow: hidden;
}

th {
  text-align: left;
}
  
thead {
  font-weight: bold;
  color: #fff;
  background: #73685d;
}
  
 td, th {
  /* padding: 1em .5em; */
  vertical-align: middle;
}
  
 td {
  border-bottom: 1px solid rgba(0,0,0,.1);
  background: #fff;
}

a {
  color: #73685d;
}
  
 @media all and (max-width: 768px) {
    
  table, thead, tbody, th, td, tr {
    display: block;
  }
  
  th {
    text-align: right;
  }
  
  table {
    position: relative; 
    padding-bottom: 0;
    border: none;
    box-shadow: 0 0 10px rgba(0,0,0,.2);
  }
  
  thead {
    float: left;
    white-space: nowrap;
  }
  
  tbody {
    overflow-x: auto;
    overflow-y: hidden;
    position: relative;
    white-space: nowrap;
  }
  
  tr {
    display: inline-block;
    vertical-align: top;
  }
  
  th {
    border-bottom: 1px solid #a39485;
  }
  
  td {
    border-bottom: 1px solid #e5e5e5;
  }
  
  
  }
</style>

	