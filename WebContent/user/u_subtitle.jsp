<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>u_subtitle</title>
</head>
<body>
<%
	String inc2 = "mypage.jsp";
	if(request.getParameter("inc2") != null){
		inc2 = request.getParameter("inc2");
	}
%>

<div class="container-fluid pl-0 pr-0">
	<div class="jumbotron text-center pt-0 pb-0 bg-danger">
		<img src="../image/user_main_s.PNG"/>
	</div>
</div>
<div class="container" style="padding-top: 30px">
	<!-- submenu -->
	<div class="row">
		<div class="col-3 u_list" >
			<ul class="nav flex-column" >
				<li class="nav-item">
					<a class="nav-link active" href="mpindex.jsp?inc2=mypage.jsp">내 정보 관리</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="mpindex.jsp?inc2=reserve_list.jsp">예약 현황</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="mpindex.jsp?inc2=last_place.jsp">이용현황</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="#">포인트</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="#">쿠폰함</a>
				</li>
			</ul>
		</div>
		<div class="col-9">
			<jsp:include page="<%=inc2 %>"/>
		</div>
	</div>
</div>
</body>
</html>