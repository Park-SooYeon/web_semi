<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인  | 어때</title>
<link rel='stylesheet' type='text/css' href='../css/bootstrap.min.css'>
<link rel='stylesheet' type='text/css' href='../css/login.css'>
<script src='../js/jquery-3.4.1.js'></script>
<script src='../js/login.js'></script>
</head>
<body>

<div class='container'>
	<div class='row justify-content-md-center'>
		<div class='col-4' align='center'>
			<div class='title_c'>
				<strong class='logo center'>
					<a href="../index.jsp">여기어때</a>
				</strong>
			</div>
			<button type='button' class='btn_kakao_c'>
				<span class='kakao_c'>
					<i class='icon_kakao_c'></i>
					카카오톡으로 로그인
				</span>
			</button>
			<button type='button' class='btn_face_c'>
				<span class='face_c'>
					<i class='icon_face_c'></i>
					facebook으로 로그인
				</span>
			</button>
			<button type='button' class='btn_naver_c'>
				<span class='naver_c'>
					<i class='icon_naver_c'></i>
					네이버로 로그인
				</span>
			</button>
            <p class="space_or">
            	<span>또는</span>
            </p>
            <form id='frm_c' name='frm_c' method='post' class="was-validated">
	            <div class="form-group">
	            	<input type="hidden" name="redirectUrl" id="redirectUrl"/>
	      			<input type="email" class="form-control" id="email_c" placeholder="이메일 주소" name="email_c" autofocus required>
				    <div></div>
				    <div class="invalid-feedback" id="chkFail">유효하지 않은 E-Mail주소입니다.</div>
				</div>
				<div class="form-group">
				    <input type="password" class="form-control" id="pwd_c" placeholder="비밀번호" name="pwd_c" required>
					<div class="invalid-feedback">비밀번호를 입력해 주세요.</div>
				</div>
			</form>
            <button id='btnLogin_c' type="button" class="btn btn-primary btn-lg btn-block" style='width:330px;background-color:rgb(255,0,85)'>로그인</button>
            <div class='pw_email_c'>
            	<a href="./pw_email.jsp">비밀번호 재설정</a>
            </div>
            <div class='member_c'>
            	<a href="./agree.jsp">회원가입</a>
            </div>
		</div>
	</div>
</div>
<script>btnFunc();

/* 쿠키로 url받아 올 때 사용
$(function() {
	var url = $cookie('url');
	if (url != null && url != "") {
		$('#redirectUrl').val(url);
	}
}); */

</script>
<script src='../js/bootstrap.bundle.min.js'></script>
<body>

</body>
</html>