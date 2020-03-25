<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="colorbox/colorbox.css" rel="stylesheet">
<link href="css/reserve_insert_k.css" type="text/css" rel="stylesheet">
<script src="js/jquery.colorbox-min.js"></script>
<script src="js/reserve_insert_k.js"></script>
<style>
#reserveDel_k strong{
	font-size:25px;
}
#reserveDel_k span{
	font-size:20px;
}
</style>
</head>
<body>
<div class="col-5 border p-5">
	<div class="mb-5" id="reserveDel_k">
		<strong>숙소명</strong><br/>
		<span>객실 정보/1박</span>	
	</div>
	<section class="mt-4" id="section_modify_k">
		<div class="mb-4">
			<p class="w-50 mb-2"><strong class="text-secondary">체크인</strong>체크인 날짜</p>
			<p class="w-50"><strong class="text-secondary br-5">체크아웃</strong>체크아웃 날짜</p>
		</div>
		<div class="border-bottom pb-3">
			<p class="w-50 mb-2"><strong class="text-secondary">예약자 이름</strong>이르음</p>
			<p class="w-50"><strong class="text-secondary">휴대폰 번호</strong>번호</p>
		</div>
		<div class="border-bottom mt-4 pb-2">
			<strong>결제정보</strong>
			<p class="w-50"><strong class="text-secondary mt-2">총 결제금액</strong>10000원</p>
		</div>
	</section>
	<button type="button" class="btn btn-danger btn-lg mt-3" id="btnDelete_k">예약 취소</button>
</div>

<script>
btnFunc();
</script>
</body>
</html>