<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="./js/jquery-3.4.1.js"></script>
<link rel='stylesheet' type='text/css' href='./css/f_roomsCss.css'/>
<link rel='stylesheet' type='text/css' href='./css/bootstrap.min.css'/>
</head>

<body>
   <div id='roomsView_f'>
	<%
		String inc_f = "../wpy/total_w.jsp";
		if(request.getParameter("inc_f")!=null){
			inc_f = request.getParameter("inc_f");
		}
	%>
	<div id='roomsView_f'>
		<div id='view_f'>
			<div id='view_top_f'>
			<div id='view_top_right' class='btn pull-right'>
			  <div id='view_top_right1'>
			   <span class="badge badge-pill badge-info">레지던스</span>
			   <h4>메리어트 이즈제큐티브 아파트먼트</h4>
			   <span class="badge badge-pill badge-warning">8.0</span> <span class='text-warning'>만족해요</span>
			   <br>
			    <h5>서울 강남구 삼성동112-5</h5>
			   </div>
			   <div class="card border-secondary mb-3" style="max-width: 20rem;">
               <div class="card-header">사장님 한마디</div>
               <div class="card-body">
                <p class="card-text">비즈니스와 문화의 중심지인 강남구 삼성동에 위치하고 있으며,코엑스 전시장과 도심 공항 터미널과 가까이 있습니다
                      오랜 경험과 국제적인 서비스가 여러분의 미팅과 모임을 성공적으로 연출해 드릴 것이며, 
                      또한 도심 속 선릉공원의 아름다운 경관은 여러분의 마음을 한층 포근하게 해드릴 것입니다</p>
               </div>   
             </div>
			</div>
				<div id='view_top_left_f'>
				   <c:forEach var = 'item' items  = '${vo }'>
					<div id='view_top_left_main_f'>
						<img src='./upload/${item.sysFile }.jpg'/>
					</div>
					<div id='view_top_left_sub_f'>
						<div id='view_top_left_sub1_f'>
							<img src='./upload/${item.sysFile }.jpg'/>
						</div>
						<div id='view_top_left_sub2_f'>
							<img src='./upload/${item.sysFile }.jpg'/>
						</div>
						<div id='view_top_left_sub3_f'>
							<img src='./upload/${item.sysFile }.jpg'/>
						</div>
						<div id='view_top_left_sub4_f'>
							<img src='./upload/${item.sysFile }.jpg'/>
						</div>
					</div>
					</c:forEach>
				</div>
		</div>
	
		<div id='view_button'>
			<button class='btn btn-link' id='btnHotel'>
			<span class='text-danger' style='font-size: 20px;'>객실안내/예약</span>
			
			</button>
			<button class='btn btn-link' id='btnLodging'>
			<span class='text-danger' style='font-size: 20px;' >숙소정보</span>
			</button>
			<button class='btn btn-link' id='btnReview'>
			<span class='text-danger' style='font-size: 20px;' >리뷰</span>
			</button>
		</div>
	  </div>
	 </div>
		<div id = 'jsform'>
	    <%@ include file="../wpy/total_w.jsp" %>
	   </div>
<script>
 btnFunc_w();
 </script>
</body>
</html>















