<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
	<form method="post">
		<!-- Email input -->
		<div class="form-outline mb-4">
			<input type="text" id="form2Example1" class="form-control" name="id" id="id" /> <label class="form-label" for="form2Example1">아이디</label>
		</div>

		<!-- Password input -->
		<div class="form-outline mb-4">
			<input type="password" id="form2Example2" class="form-control" name="password" id="password" /> <label class="form-label" for="form2Example2">비밀번호</label>
		</div>

		<!-- 2 column grid layout for inline styling -->
		<div class="row mb-4">
			<div class="col d-flex justify-content-center"></div>

			<div class="col">
				<!-- Simple link -->
				<a href="#!">비밀번호 찾기</a>
			</div>
		</div>

		<!-- Submit button -->
		<button type="button" class="btn btn-primary btn-block mb-4">로그인</button>

		<!-- Register buttons -->
		<div class="text-center">
			<p>
				회원이 아니신가요? <a href="#!">회원가입</a>
			</p>
			<button type="button" class="btn btn-link btn-floating mx-1">
				<i class="fab fa-facebook-f"></i>
			</button>

			<button type="button" class="btn btn-link btn-floating mx-1">
				<i class="fab fa-google"></i>
			</button>

			<button type="button" class="btn btn-link btn-floating mx-1">
				<i class="fab fa-twitter"></i>
			</button>

			<button type="button" class="btn btn-link btn-floating mx-1">
				<i class="fab fa-github"></i>
			</button>
		</div>
	</form>
	<%@ include file="../footer.jsp"%>