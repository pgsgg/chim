<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="sub_menu.jsp"%>
<br>
<article id="main-menu">
	<h2>My Page(${title})</h2> 
	<br><br>
	<form name="formm" method="post" id="formm">
		<c:choose>
			<c:when test="${orderList.size() == 0}">
			주문 내역이 없습니다.
			<input type="button" value="쇼핑 계속하기" class="cancel" onclick="location.href='index'">
			</c:when>
			<c:otherwise>
				<table id="cartList">
				<thead>
					<tr>
						<th>주문일자</th>
						<th>주문번호</th>
						<th>상품명</th>
						<th>결제 금액</th>
						<th>주문 상세</th>
						<c:if test="${orderList[0].result == 1}">
							<th>주문 삭제</th>
						</c:if>
					</tr>
					</thead>
					<c:forEach items="${orderList}" var="orderVO">
						<tr >
							<td>
								<fmt:formatDate value="${orderVO.indate}" type="date" />
							</td>
							<td>${orderVO.oseq}</td>
							<td>${orderVO.pname}</td>
							<td>
								<fmt:formatNumber value="${orderVO.price2}" type="currency" currencySymbol="￦" />
							</td>
							<td>
								<a href="order_list?oseq=${orderVO.oseq}&result=${orderVO.result}"> 조회 </a>
							</td>
							<c:if test="${orderVO.result == 1}">
								<td>
									<input type="checkbox" value="${orderVO.oseq}" name="oseq" id="oseq">
									<input type="hidden" value="${pseq}" name = "pseq" id="pseq">
								</td>
							</c:if>
						</tr>
						
					</c:forEach>
				</table>
<br>
				<div class="clear"></div>
				<div id="buttons" style="float: right">
					<c:if test="${orderList[0].result == 1}">
						<input type="button" value="주문삭제" class="cancel btn-color" onclick="deleteOrder()" style='padding:10px;'>
					</c:if>
					<input type="button" value="쇼핑 계속하기" class="cancel btn-color" onclick="location.href='index'" style='padding:10px;'>
				</div>
			</c:otherwise>
		</c:choose>
	</form>
	<div align="center">
	<%@ include file="page_area.jsp" %>
	</div>
</article>
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