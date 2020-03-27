<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel='stylesheet' type='text/css' href='../css/bootstrap.min.css'>
<link rel='stylesheet' type='text/css' href='../css/login.css'>
<script src='../js/jquery-3.4.1.js'></script>
<script src='../js/login.js'></script>
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
				<input type='text'  id='email_c' name='email_C' value='<%=request.getParameter("email_c") %>' readonly>
				<br/>
				<label class='label_c'>생년월일</label><br/>
				<input type='date' id="birth_c" name='birth_c' />
				<br/>
				<label class='label_c'>비밀번호</label><br/>
				<input type='text' id='pwd_c' name='pwd_c' placeholder=" 비밀번호를 입력해주세요." />
				<div id='pwdM_c'></div>
				<br/>
				<label class='label_c'>비밀번호 확인</label><br/>
				<input type='text' id='pwd_check_c' name='pwd_check_c' placeholder=" 비밀번호를 입력해주세요." />
				<div id='pwdM_check_c'></div>
				<br/>
				<label class='label_c'>핸드폰번호</label><br/>
				<input type='text' id='phone_c' name='phone_c' placeholder=" - 빼고 입력해주세요. " maxlength="11">
				<div id='phoneM_c'></div>
				<br/>
				<label class='label_c'>닉네임</label><br/>
				<input type='text' id='nName' name='nName' maxlength="10">
				<div id='nNameM_c'></div>
				<br/>
			</div>
			<div class='mNotice_c' align='center'>
				로그인 / 회원가입시<br/>
				<a href='#'>이용약관, </a><a href='#'>개인정보처리방침</a>에 동의하게 됩니다.
			</div>
			<div align='center'>
				<button type="button" id='btn_Member_c' class="btn btn-primary btn-lg btn-block" style='width:330px;background-color:rgb(255,0,85)'>동의하고 회원가입</button>
			</div>
		</div>
	</div>
</div>
<script>check();</script>
<script src='../js/bootstrap.bundle.min.js'></script>
</body>
</html>