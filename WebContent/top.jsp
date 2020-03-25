<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#top_list_k li{
	padding:0px 5px;
}
#top_list_k li>a{
	color:#faa;
}
#top_list_k li a:hover{
	color:#fff;
}
#search_k{
	border:none;
	background-color:rgba(0,0,0,0);
}
#search_k{
	border:none;
	background-color:rgba(0,0,0,0);
}

#searchbox{
	width: 787px;
	height: 422px;
	background-color:#ff0;
}
#searchbox #search_top{
	float:left;
	width:787px;
	height: 72px;
	background-color:#00f;
}
#searchbox #search_top #top_left{
	
}
#searchbox #search_top #top_middle{

}
#searchbox #search_top #top_right{
}
#searchbox #search_botoom{
	float:left;
	width:787px;
	height: 352px;
	background-color:#0f0;
}
</style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-danger fixed-top justify-content-center">
	<div class="container p-0">
				 
				<a class="navbar-brand ml-2" href="#">logo</a>
					
					<form class="form-inline ml-auto mr-2">
						<input class="form-control mr-2" type="text" placeholder="지역, 숙소명"/> 
						<button class="btn btn-primary my-2 my-sm-0" id="search_k" type="button">
							<i class="fas fa-search"></i>
						</button>
					</form>
					<ul class="navbar-nav" id="top_list_k">
						<li class="nav-item">
							 <a class="nav-link" href="#">예약 내역</a>
						</li>
						<li class="nav-item dropdown">
							<a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown">더보기</a>
							<div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
								 <a class="dropdown-item" href="#">공지사항</a>
								 <a class="dropdown-item" href="#">이용 약관</a>
							</div>
						</li>
						<li class="nav-item">
							 <a class="nav-link" href="#">로그인</a>
						</li>
					</ul>
	</div>
					<div id ='searchbox'>
						<div id='search_top'>
							<div id='top_left'>
							</div>
							<div id='top_middle'>
							
							</div>
							<div id='top_right'>
							</div>
						</div>
						<div id='search_botoom'>
						</div>
					</div>
</nav>

</body>
</html>