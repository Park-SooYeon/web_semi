<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pw_email</title>
<link rel='stylesheet' type='text/css' href='../css/bootstrap.min.css'>
<link rel='stylesheet' type='text/css' href='../login/login.css'>
<script src='../js/jquery-3.4.1.js'></script>
</head>
<body>
<div class='container'>
	<div class='row justify-content-md-center'>
		<div class='col-4'>
			<h4 class='h4_c' align='center'>비밀번호 재설정</h4>
			<div class='pwNotice_c' align='center'>
				회원가입 시 등록한 이메일 주소를 입력해주세요.
			</div>
			<label class='label_c'>이메일 주소</label>
			<br/>
			<input type='text' class='email_c' placeholder="이메일 주소">
			<button type="button" class="btn btn-secondary disabled">인증번호 전송</button>
			<br/>
			<label class='label_c'>인증번호</label>
			<br/>
			<input type='text' class='email_c' placeholder="인증번호">
			<button type="button" class="btn btn-secondary disabled" style='width:125px;'>확인</button>
			<div align='center'>
				<button type="button" id='btn_next_c' class="btn btn-primary btn-lg btn-block" style='width:330px;background-color:rgb(255,0,85)'>다음</button>
			</div>
		</div>
	</div>
</div>
<script>
	$('#btn_next_c').click(function(){
		location.href="./pw_reset.jsp";
	});
</script>
<script src='../js/bootstrap.bundle.min.js'></script>
</body>
</html>