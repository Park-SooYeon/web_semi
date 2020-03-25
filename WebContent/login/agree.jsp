<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>agree</title>
<link rel='stylesheet' type='text/css' href='../css/bootstrap.min.css'>
<link rel='stylesheet' type='text/css' href='../login/login.css'>
<script src='../js/jquery-3.4.1.js'></script>
</head>
<body>

<div class='container'>
	<div class='row justify-content-md-center'>
		<div class='col-4'>
			<h4 class='h4_c' align='center'>여기어때 약관 동의</h4>
			<div class='agree_ck_c'>
				<label style='text-decoration:none;'>
					<input type="checkbox" /> 전체 동의
				</label>
				<br/>
				<label>
					<input type="checkbox">
					<a href='#'> 이용약관 동의</a><span> (필수)</span>
				</label>
				<br/>
				<label>
					<input type="checkbox">
					<a href='#' > 개인정보 수집 및 이용 동의</a><span> (필수)</span>
				</label>
				<br/>
				<label>
					<input type="checkbox">
					<a href='#'> 위치기반 서비스 이용약관 동의</a><span style='color:#000;'> (선택)</span>
				</label>
			</div>
			 <button type="button" id='btn_next_c' class="btn btn-primary btn-lg btn-block" style='width:330px;background-color:rgb(255,0,85)'>다음</button>
		</div>
	</div>
</div>
<script>
	$('#btn_next_c').click(function(){
		location.href="./email.jsp";
	});
</script>
<script src='../js/bootstrap.bundle.min.js'></script>
</body>
</html>