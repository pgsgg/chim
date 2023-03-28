<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<section class="vh-100" style="background-color: #eee;">
		<div class="container h-100">
			<div class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-lg-12 col-xl-11">
					<div class="card text-black" style="border-radius: 25px;">
						<div class="card-body p-md-5">
							<div class="row justify-content-center">
								<div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">

									<p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">회원가입</p>

									<form class="mx-1 mx-md-4">
										<div class="d-flex flex-row align-items-center mb-4">
											<i class="fas fa-key fa-lg me-3 fa-fw"></i>
											<div class="form-outline flex-fill mb-0">
												<input type="text" id="form3Example4cd" class="form-control" name="id" id="id" /> <label class="form-label" for="form3Example4cd">아이디</label>
											</div>
										</div>
										<div class="d-flex flex-row align-items-center mb-4">
											<i class="fas fa-user fa-lg me-3 fa-fw"></i>
											<div class="form-outline flex-fill mb-0">
												<input type="text" id="form3Example1c" class="form-control" name="name" id="name" /> <label class="form-label" for="form3Example1c">이름</label>
											</div>
										</div>

										<div class="d-flex flex-row align-items-center mb-4">
											<i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
											<div class="form-outline flex-fill mb-0">
												<input type="password" id="form3Example3c" class="form-control" name="password" id="password" /> <label class="form-label" for="form3Example3c">비밀번호</label>
											</div>
										</div>

										<div class="d-flex flex-row align-items-center mb-4">
											<i class="fas fa-lock fa-lg me-3 fa-fw"></i>
											<div class="form-outline flex-fill mb-0">
												<input type="password" id="form3Example4c" class="form-control" name="passwordCheck" id="passwordCheck" /> <label class="form-label" for="form3Example4c">비밀번호 확인</label>
											</div>
										</div>

										<div class="d-flex flex-row align-items-center mb-4">
											<i class="fas fa-key fa-lg me-3 fa-fw"></i>
											<div class="form-outline flex-fill mb-0">
												<input type="text" id="form3Example4cd" class="form-control" name="email" id="email" /> <label class="form-label" for="form3Example4cd">이메일</label>
											</div>
										</div>
										<div class="d-flex flex-row align-items-center mb-4">
											<i class="fas fa-key fa-lg me-3 fa-fw"></i>
											<div class="form-outline flex-fill mb-0">
												<input type="text" id="form3Example4cd" class="form-control" placeholder="우편번호" name="zipNum" id="zipNum" style="display: inline-block; width: 140px;" />
												<button type="button" class="btn btn-primary btn-lg" style="display: inline-block; width: 140px; height: 38px">주소찾기</button>
												<input type="text" id="form3Example4cd" class="form-control" placeholder="주소" name="address" id="address" /> <input type="text" id="form3Example4cd" class="form-control" placeholder="상세주소" name="addressDetail" id="addressDetail" />
											</div>
										</div>
										<div class="d-flex flex-row align-items-center mb-4">
											<i class="fas fa-key fa-lg me-3 fa-fw"></i>
											<div class="form-outline flex-fill mb-0">
												<input type="text" id="form3Example4cd" class="form-control" name="phone" id="phone" /> <label class="form-label" for="form3Example4cd">휴대폰 번호</label>
											</div>
										</div>
										<div class="form-check d-flex justify-content-center mb-5">
											<input class="form-check-input me-2" type="checkbox" value="" id="form2Example3c" /> <label class="form-check-label" for="form2Example3"> 약관에 동의합니다 <a href="#!">이용약관</a>
											</label>
										</div>

										<div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
											<button type="button" class="btn btn-primary btn-lg">회원가입</button>
										</div>

										<div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
											<button type="reset" class="btn btn-danger btn-lg">취소</button>
										</div>

									</form>

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<%@ include file="../footer.jsp"%>