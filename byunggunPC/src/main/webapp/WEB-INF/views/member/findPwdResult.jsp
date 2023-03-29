<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/member.js"></script>
<script type="text/javascript">
	function idok() {
		self.close();
	}
</script>
</head>
<body>
	<div id="wrap">
		<h1>비밀번호 찾기 결과</h1>
		<form method="post" name="formm" action="change_pwd" id="pwd_form" style="margin-right: 0">
			<label>User ID</label><input type=text name="id" value="${id}" readonly="readonly">
			<div style="margin-top: 20px">
				<c:if test="${message == 1}">
					<label>Password</label>
					<input type="password" name="pwd" id="pwd">
					<br>
					<label>Retype Password</label>
					<input type="password" name="pwdCheck" id="pwdCheck">
					<br>
					<input type="button" value="확인" class="cancel" onclick="changePassword()">
				</c:if>
				<c:if test="${message==-1}">
             잘못된 사용자 정보입니다.
         <input type="button" value="확인" class="cancel" onclick="idok()">
				</c:if>
			</div>

		</form>
	</div>
</body>
</html>