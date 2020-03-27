<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.4.1.js"></script>
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


#searchbox_main{
	width:100%;
	height: 422px;
	position:absolute;
	top:0px;
	display: none;
}
#searchbox{
	margin:auto;
	width: 717px;
	height: 422px;
	
}
#searchbox #search_top{
	width:717px;
	height: 72px;
	background-color:#f6323e;
}
#searchbox #search_top #top_left{
	float:left;
	width:72px;
	height: 72px;
	background-image: url('./image/find.jpg');
	cursor: pointer;
}
#searchbox #search_top #top_middle{
	float:left;
	width:573px;
	height: 72px;
}
#searchbox #search_top #top_right{
	float:left;
	width:72px;
	height: 72px;
	background-image: url('./image/exit.jpg');
	cursor: pointer;
}
#searchbox #search_top #top_middle #findStr{
	width: 572px;
	height: 71px;
	border: 1px solid #f6323e;
	background-color: #f6323e;
	font-size: 1.1em;
	color:#eee;
}
#searchbox #search_botoom{
	width:717px;
	height: 352px;
	background-color:#fff;
	box-sizing: border-box;
	padding: 25px;
	border-radius: 0px 0px 10px 10px;
}
#btnMy_c{
	background-color:#E10000;
	border:none;
}
#nName_c{
	color:#000;
	font-weight:bold;
	font-size:1em;
}
#logout_c{
	cursor:pointer;
}
</style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-danger fixed-top justify-content-center">
	<div class="container p-0">
				 
				<a class="navbar-brand ml-2" href="index.jsp?middle=main.jsp">logo</a>
					
					<form class="form-inline ml-auto mr-2"> 
						<button class="btn btn-primary my-2 my-sm-0" id="search_k" type="button">
							<i class="fas fa-search"></i>
						</button>
					</form>
					<ul class="navbar-nav" id="top_list_k">
						<li class="nav-item">
							 <a class="nav-link" href="index.jsp?middle=./user/u_subtitle.jsp">예약 내역</a>
						</li>
						<li class="nav-item dropdown">
							<a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown">더보기</a>
							<div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
								 <a class="dropdown-item" href="index.jsp?middle=./plus_menu/nt_select.jsp">공지사항</a>
								 <a class="dropdown-item" href="index.jsp?middle=./plus_menu/pv_select.jsp">이용 약관</a>
							</div>
						</li>
						<li class="nav-item">
							<%
								String email = (String)request.getSession().getAttribute("email");
								String nName = (String)request.getSession().getAttribute("nName");
								if(email != null){
									session.setAttribute("email", email);		
								} 
								if(session.getAttribute("email") == null){%>
							 		<a class="nav-link" href="./login/login.jsp">로그인</a>
							<% }else{ %>
									<div class="dropdown">
							  			<button type="button" id='btnMy_c' class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
							   			  	<a href="#">
							   			  		<img src='./image/myLogo_c.png'>
							   			  	</a>
							   			 </button>
							   		<div class="dropdown-menu">
											<div class="dropdown-header" id='nName_c'><%=nName %></div>
							      			<div class="dropdown-divider"></div>
							     			<a class="dropdown-item" href="#">내정보</a>
							     			<a class="dropdown-item" href="#">예약내역</a>
							     			<a class="dropdown-item" href="#">지난 방문지</a>
							     			<a class="dropdown-item" id='logout_c'>로그아웃</a>
							   			</div>
							  		</div>
							<% } %>
						</li>
					</ul>
	</div>
				<div id ='searchbox_main'>
					<div id ='searchbox'>
						<div id='search_top'>
							<div id='top_left' onclick=''>
							</div>
							<div id='top_middle'>
								<input type='text' name='findStr' id='findStr' placeholder="지역, 숙소명"/>
							</div>
							<div id='top_right'>
							</div>
						</div>
						<div id='search_botoom'>
						</div>
					</div>
				</div>
</nav>
	<script>
		$('#search_k').click(function(){
			$('#searchbox_main').slideToggle(100);
		})
		if($('#top_right')!=null){
			$('#top_right').click(function(){
				$('#searchbox_main').slideToggle(100);
			})
		}
		$('#logout_c').click(function(){
			<% session.removeAttribute("email"); %>
			location.href = './index.jsp';
		});
	</script>
</body>
</html>