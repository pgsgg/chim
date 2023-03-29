<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경</title>
<script type="text/javascript" src="js/member.js"></script>
</head>
<body>
	<form name="findPW" id="findPwd" action="find_pwd" method="post">
		<table>
			<tr>
				<td align="right">
					<label> 아이디</label>
				</td>
				<td>
					<input type="text" name="id" id="id" value="">
				</td>
			</tr>
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
					<label> 휴대폰번호(-포함)</label>
				</td>
				<td>
					<input type="text" name="phone" id="phone" value="">
				</td>
			</tr>
			<tr>
				<td align="center" colspan="2">
					<input type="button" value="비밀번호 찾기" onclick="findPassword()">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>