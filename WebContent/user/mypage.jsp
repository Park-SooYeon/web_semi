<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mypage</title>
</head>
<body>

<h3>마이 페이지</h3>
<img src="../image/user_mypage_s.png" class="img-thumbnail" style="width:200px; height:200px; margin-top: 10px">

<form method="post" name="frm" id="frm">
	<div class="form-group">
		<label class="col-form-label col-form-label-lg" for="inputLarge">닉네임</label>
		<input class="form-control form-control-lg" type="text" id="inputLarge" value="${vo.mName}" readonly>
	</div>
	<div class="form-group">
		<label class="col-form-label col-form-label-lg" for="inputLarge">이름</label>
		<input class="form-control form-control-lg" type="text" id="inputLarge" value="${vo.uName}" readonly>
	</div>
	<div class="form-group">
		<label class="col-form-label col-form-label-lg" for="inputLarge">핸드폰번호</label>
		<input class="form-control form-control-lg" type="text" id="inputLarge" value="${vo.phone}" readonly>
	</div>
	<div class="form-group">
		<label class="col-form-label col-form-label-lg" for="inputLarge">이메일</label>
		<input class="form-control form-control-lg" type="text" id="inputLarge" value="${vo.eMail}" readonly>
	</div>
	<button type="submit" class="btn btn-primary btnmp">내정보수정</button>
</form>
</body>
</html>