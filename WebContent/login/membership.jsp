<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel='stylesheet' type='text/css' href='../css/bootstrap.min.css'>
<link rel='stylesheet' type='text/css' href='../login/login.css'>
<script src='../js/jquery-3.4.1.js'></script>
</head>
<body>

<div class='container'>
	<div class='row justify-content-md-center'>
		<div class='col-4'>
			<div class='title_c' align='center'>
				<strong class='logo center' >
					<a href="../index.jsp">여기어때</a>
				</strong>
				<h4 class='h4_c' style='margin-top:30px;'>회원가입</h4>
			</div>
			<div class='mform_c'>
				<label class='label_c'>이메일 아이디</label><br/>
				<input type='text' readonly>
				<br/>
				<label class='label_c'>생년월일</label><br/>
				<input type='date'>
				<br/>
				<label class='label_c'>비밀번호</label><br/>
				<input type='text' placeholder=" 비밀번호를 입력해주세요.">
				<br/>
				<label class='label_c'>비밀번호 확인</label><br/>
				<input type='text' placeholder=" 비밀번호를 입력해주세요.">
				<br/>
				<label class='label_c'>핸드폰번호</label><br/>
				<input type='text' placeholder=" - 빼고 입력해주세요. ">
				<br/>
				<label class='label_c'>닉네임</label><br/>
				<input type='text' >
				<br/>
			</div>
			<div class='mNotice_c' align='center'>
				로그인 / 회원가입시<br/>
				<a href='#'>이용약관, </a><a href='#'>개인정보처리방침</a>에 동의하게 됩니다.
			</div>
			<div align='center'>
				<button type="button" id='btn_next_c' class="btn btn-primary btn-lg btn-block" style='width:330px;background-color:rgb(255,0,85)'>동의하고 회원가입</button>
			</div>
		</div>
	</div>
</div>
<script src='../js/bootstrap.bundle.min.js'></script>
</body>
</html>