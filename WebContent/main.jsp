<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container-fluid pl-0 pr-0">
	<div class="jumbotron text-center pt-0 pb-0 bg-danger">
		<img src="./image/main.png" style="height:454px;"/>
	</div>
</div>
<div class="container">
	<!-- menu -->
		<div class='m_menu bg-white'>
			<ul>
				<li><a href="#"><span class="ico_01">&nbsp;</span><p>모텔</p></a></li>
				<li><a href="#"><span class="ico_02">&nbsp;</span><p>호텔</p></a></li>
				<li><a href="#"><span class="ico_03">&nbsp;</span><p>펜션</p></a></li>
				<li><a href="#"><span class="ico_04">&nbsp;</span><p>게스트하우스</p></a></li>
			</ul>
		</div>
		
		<h2 class="pt-5">공지사항 및 소식</h2>
		<ul class="list-group list-group-horizontal pt-3">
			<li class="list-group-item" style="border:1px solid #00f; width:50%;">
				<img src="./image/banner1.png" alt="사진1" class="img-thumbnail" style="width:200px;height:200px">
				<a class="pl-3">
					공지 content1
				</a>
			</li>
			<li class="list-group-item ml-3" style="border:1px solid #00f; width:50%;">
				<img src="./image/banner1.png" alt="사진1" class="img-thumbnail" style="width:200px;height:200px">
				<a class="pl-3">
					공지 content2
				</a>
			</li>
		</ul>
		
		<h2 class="pt-5">이벤트 및 광고</h2>
		<div id="carouselExampleIndicators" class="carousel slide pt-3" data-ride="carousel">
  			<ol class="carousel-indicators">
    			<li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
    			<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
    			<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
  			</ol>
  			<div class="carousel-inner">
    			<div class="carousel-item active">
      				<img class="d-block w-100" src="./image/adv1.png" alt="First slide">
    			</div>
    			<div class="carousel-item">
      				<img class="d-block w-100" src="./image/adv2.jpg" alt="Second slide">
    			</div>
    			<div class="carousel-item">
      				<img class="d-block w-100" src="./image/adv3.jpg" alt="Third slide">
    			</div>
  			</div>
  			<a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
    			<span class="carousel-control-prev-icon" aria-hidden="true"></span>
    			<span class="sr-only">Previous</span>
  			</a>
  			<a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
    			<span class="carousel-control-next-icon" aria-hidden="true"></span>
    			<span class="sr-only">Next</span>
  			</a>
		</div>
		
		<ul class="list-group list-group-horizontal pt-4">
			<li class="list-group-item p-0">
				<img src="./image/ad1.png" alt="사진1" class="img-fluid">
			</li>
			<li class="list-group-item ml-3 p-0">
				<img src="./image/ad2.png" alt="사진2" class="img-fluid">
			</li>
		</ul>
		
</div>
</body>
</html>