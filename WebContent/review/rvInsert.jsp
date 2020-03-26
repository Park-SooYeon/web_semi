<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰작성</title>
<style>
/* .starRev span{
	text-decoration: none;
	color: gray;
} */
/* .starRev span.on{
	color:yellow;
} */
.starR{
	background: url('../image/star1_f.png') no-repeat right 0;
	background-size: auto 100%;
	width: 30px;
	height: 30px;
	display: inline-block;
	text-indent: -9999px;
	cursor: pointer;
}
.starRev{
	width:200px;
	height:40px;
}
.starR.on{	
	background: url('../image/star2_f.png') no-repeat right 0;
	background-size: auto 100%;
	width: 30px;
	height: 30px;
	display: inline-block;
	text-indent: -9999px;
	cursor: pointer;}
</style>
</head>
<body>
<h3>리뷰 작성</h3>
<form method="post" name="frm" id="frm">
<div class="form-group">
	<label for="exampleInputPassword1">제목</label>
	<input type="text" class="form-control" id="exampleInputPassword1" placeholder="제목" name="title">
</div>
<div class="form-group">
	<label for="exampleInputPassword1">아이디</label>
	<input type="text" class="form-control" id="exampleInputPassword1" placeholder="아이디" name="eMail">
</div>
<div class="starRev">
	<span class="starR on" name="star" value="1">★</span>
	<span class="starR" name="star" value="2">★</span>
	<span class="starR" name="star" value="3">★</span>
	<span class="starR" name="star" value="4">★</span>
	<span class="starR" name="star" value="5">★</span>
</div>
<div class="form-group">
	<label for="exampleTextarea">리뷰 내용</label>
	<textarea class="form-control" id="exampleTextarea" rows="5" name="content"></textarea>
</div>
<button type="button" id="btnRe_s" class="btn btn-primary btn-lg">리뷰작성</button>
</form>
<script>
	$('.starRev span').click(function(){
	  $(this).parent().children('span').removeClass('on');
	  $(this).addClass('on').prevAll('span').addClass('on');
	  return false;
	});
	if($('#btnRe_s')!=null){
		$('#btnRe_s').click(function(){
			$('#frm').attr('action', 'rvInsert.rv').submit();
		})
	}
</script>
</body>
</html>