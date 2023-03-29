<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<script type="text/javascript" src="js/member.js"></script>
</head>
<body>
	<div id="wrap">
		<h1>아이디  찾기</h1>
		<br>
		<form name="findId" id="findId" action="find_id" method="post">
			<table>
				<tr>
					<td align="right">
						<label> 이름</label>
					</td>
					<td>
						<input type="text" name="name" id="name" value="">
					</td>
				</tr>
				<tr>
					<td align="right">
						<label> 휴대폰번호</label>
					</td>
					<td>
						<input type="text" name="phone" id="phone" value="">
					</td>
				</tr>
				<tr>
					<td align="center" colspan="2">
						<input type="button" value="아이디 찾기" onclick="findMemberId()">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>