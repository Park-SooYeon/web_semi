<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인  | 어때</title>
<link rel='stylesheet' type='text/css' href='../css/bootstrap.min.css'>
<link rel='stylesheet' type='text/css' href='../login/login.css'>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src='../js/jquery-3.4.1.js'></script>
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
            <form class="was-validated">
            <div class="form-group">
			      <input type="text" class="form-control" id="uname_c" placeholder="이메일 주소" name="uname"
			      pattern="^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[a-zA-Z])*.[a-zA-Z]{2,3}$"
			      title="형식  semi@abc.abc" autofocus required>
			     <!--  <div class="valid-feedback" id="chkOk">Valid.</div> -->
			      <div class="invalid-feedback" id="chkFail">유효하지 않은 E-Mail주소입니다.</div>
			</div>
			<div class="form-group">
			    <input type="password" class="form-control" id="pwd" placeholder="비밀번호" name="pswd" required>
			    <!-- <div class="valid-feedback">Valid.</div> -->
				<div class="invalid-feedback">비밀번호를 입력해 주세요.</div>
			</div>
			</form>
            <button type="button" class="btn btn-primary btn-lg btn-block" style='width:330px;background-color:rgb(255,0,85)'>로그인</button>
            <div class='pw_email_c'>
            	<a href="./pw_email.jsp">비밀번호 재설정</a>
            </div>
            <div class='member_c'>
            	<a href="./agree.jsp">회원가입</a>
            </div>
		</div>
	</div>
</div>
	
<!-- <script>
function validateEmail(sEmail) {
	var filter = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
	if (filter.test(sEmail)) {
		return true;
	}else {
		return false;
	}
};
	
$('#uname_c').keypress(function() {
	let str = $('#uname_c').val();
	validateEmail(str);
});
</script> -->
<script src='../js/bootstrap.bundle.min.js'></script>
<body>

</body>
</html>