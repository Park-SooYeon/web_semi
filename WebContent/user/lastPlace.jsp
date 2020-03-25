<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>지난 방문지</title>
</head>
<body>
<h3>지난방문지</h3>
	<div class="d-flex flex-column" >
		<!-- 내부 빨간박스 -->
		<div class="p-4 rlist">
			<div class="row">
				<div class="col-3">
					<img src="../image/user_mypage_s.png" class="img-thumbnail" style="width:200px; height:200px; ">
				</div>
				<div class="col-6">
					<div class="row">
						<a class="h3" >이태원 G 게스트하우스</a><br/>
					</div>
					<div class="row">
						<a class="h4" >용산구 | 이태원역 도보 2분</a><br/>
					</div>
					<div class="row">
						<small class="text-muted"><a class="h4" >용산구 | 이태원역 도보 2분</a></small>
					</div>
					<div class="row rprice">
						12,900원
					</div>
				</div>
				<div class="col-3">
					<button type="button" class="btn btn-primary btn-lg btnrlist">리뷰작성</button>
				</div>
			</div>
		</div>
		<div class="p-4 rlist">
			<div class="row">
				<div class="col-3">
					<img src="../image/user_mypage_s.png" class="img-thumbnail" style="width:200px; height:200px; ">
				</div>
				<div class="col-6">
					<div class="row">
						<a class="h3" >이태원 G 게스트하우스</a><br/>
					</div>
					<div class="row">
						<a class="h4" >용산구 | 이태원역 도보 2분</a><br/>
					</div>
					<div class="row">
						<small class="text-muted"><a class="h4" >용산구 | 이태원역 도보 2분</a></small>
					</div>
					<div class="row" style="float:right; margin-top: 80px;">
						12,900원
					</div>
				</div>
				<div class="col-3">
					<button type="button" class="btn btn-primary btn-lg btnrlist">리뷰작성</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>