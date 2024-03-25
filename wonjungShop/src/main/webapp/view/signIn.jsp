<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<link rel="stylesheet" href="./css/bootstrap.min.css">
<link rel="stylesheet" href="./css/carousel.css">

</head>
<body>
	<%
	//사용자 컴퓨터의 쿠키 저장소로 부터 쿠키 값을 읽어 드림, 몇개인지 모르기에 배열을 이용하여 쿠키값을 저장
	Cookie[] cookies = request.getCookies();
	String id = "";

	//쿠키값이 없을 수도 있기에 null처리를 해줌
	if (cookies != null) {
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("id")) {
		id = cookie.getValue();
		break;//원하는 데이터를 찾았기에 반복문을 빠져 나옴
			} //end of if-in
		} //end of for-each
	} //end of if
	%>
	<div class="container marketing" id="marketing">
		<!-- Three columns of text below the carousel -->
		<div class="row">
			<h2 class="text-center" id="carTitle">로그인</h2>
			<div class="col-xs-3 col-md-3"></div>

			<div class="col-sm-6">
				<form class="form-horizontal" id="form1" action="signIn.mc"
					method="post">
					<div class="form-group">
						<label for="id" class="col-sm-2">아이디</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="id" id="id"
								value="<%=id%>" placeholder="아이디 입력" autofocus="autofocus">
						</div>
					</div>

					<div class="form-group">
						<label for="pass" class="col-sm-2">패스워드</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" name="password"
								id="password" placeholder="비밀번호 입력">
						</div>
					</div>
					<input type="checkbox" name="saveId" id="saveId">아이디 저장
					<!-- 로그인 실패시 띄울 문구 -->
					<c:if test="${not empty signInCheck}">
						<div class="text-danger">${signInCheck }</div>
					</c:if>
					<div class="form-group">
						<div class="col-sm-12">
							<div class="text-center">
								<input type="submit" value="로그인" class="btn btn-success">
								<input type="reset" value="취소" class="btn btn-danger"
									onclick="location.href='reset.mc'">
								<button type="button" onclick="location.href='signUpView.mc'">회원
									가입</button>
							</div>
						</div>
					</div>

				</form>
			</div>

			<div class="col-xs-3 col-md-1"></div>
		</div>

	</div>

</body>
</html>