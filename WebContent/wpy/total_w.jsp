  
  
  
  
  
  sdfa<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="./js/jquery-3.4.1.js"></script>
<script src="./js/w_roomsjs.js"></script>
<script src="./js/f_roomsJs.js"></script>
<script src="./js/reserve_insert_k.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
</head>
<body>
<div id = 'view1_w'>

<form id="frm_room_k" name="frm_room_k">
	<label id='check_w'>체크인</label><br/>
	<input type="text" name="checkIn_w" id="checkIn_w" value="${checkIn }"><br/>
	<label id='check2_w'>체크아웃</label><br/>
	<input type="text" name="checkOut_w" id="checkOut_w" value="${checkOut }"><br/>				
    <input type="hidden" id="rCode" name="rCode" value="2">
    <input type="hidden" id="roomCode" name="roomCode" value="1">
</form>
<hr/>

<c:forEach var="list" items="${vo }" >
<div id='room_w' >
  <div id='roomview_photo_w'>
   
   <img src='./upload/${list.pori }.jpg'/>
 
  </div>
   <div id = 'room_right_w'>
     <div id='room_head_w'>
    
     <strong >${list.roomName }</strong>
 
     </div>
     <div id='price_w'>
     <span>가격</span> 
     
     <span id='sub_price_w'>${list.price }원</span>
    
     <hr/>
     <button id="myBtn"  class="btn btn-outline-light text-left text-muted">  
       객실 이용 안내

     </button>
    <div id="myModal" class="modal">
 
      <!-- Modal content -->
      <div class="modal-content">
        <span class="close">&times;</span>                                                               
         <H4>기본정보</H4>
        <ul>
         <c:set var = 'bed' value='${list.bed }'/>
         <c:choose>
          <c:when test='${bed eq 1 }'>
          <li>싱글 배드</li>
          </c:when>
          <c:when test='${bed eq 2 }'>
          <li>트윈 배드</li>
          </c:when>
          <c:when test='${bed eq 3 }'>
          <li>더블 배드</li>
          </c:when>
          <c:when test='${bed eq 4 }'>
          <li>온돌침대</li>
          </c:when>
         </c:choose>
          <c:set var = 'kind' value='${list.kind }'/>
                 <c:choose>
                 <c:when test='${kind eq 1 }'>
                 <span class="badge badge-pill badge-info">레지던스</span>
                 </c:when>
                 <c:when test='${kind eq 2 }'>
                 <span class="badge badge-pill badge-info">특1급</span>
                 </c:when>
                 <c:when test='${kind eq 3 }'>
                 <span class="badge badge-pill badge-info">특급</span>
                 </c:when>
                 </c:choose>
         
       </ul>
       <hr>
       <h4>편의시설</h4>
       <ul>
       <c:set var = 'pt' value='${list.pt }'/>
       <c:if test ='${pt eq 1 }'>
       <li>피트니스 센터</li>
       </c:if>
       <c:set var = 'swim' value='${list.swim }'/>
       <c:if test = '${swim eq 1 }'>
       <li>수영장</li>
       </c:if>
       <c:set var = 'tub' value='${list.tub }'/>
       <c:if test = '${tub eq 1  }'>
       <li>욕조</li>
       </c:if>
       <c:set var = 'wifi' value='${list.wifi }'/>
       <c:if test='${wifi eq 1 }' >
       <li>Wifi</li>
       </c:if>
       <c:set var = 'breakfast' value='${list.breakfast }'/>
       <c:if test = '${breakfast eq 1 }'>
       <li>조식 제공</li>
       </c:if>
       <c:set var = 'tv' value='${list.tv }'/>
       <c:if test = '${tv eq 1 }'>
       <li>TV</li>
       </c:if>
       <c:set var = 'spa' value='${list.spa }'/>
       <c:if test = '${spa eq 1 }'>
       <li>스파</li>
       </c:if>
       <c:set var = 'computer' value='${list.computer }'/>
       <c:if test = '${computer eq 1 }'>
       <li>컴퓨터</li>
       </c:if>
       </ul>
       <hr>
       <h4>선택 날짜</h4>
       <li>${checkIn } | ${checkout }</li>
      </div>
 
    </div>
   
   
   
   
   
     </div>
     <button type='button' class='	btn btn-danger' id='btnR_w' onclick="roomView_k( '${list.rCode }','${list.roomCode }','${sessionScope.email}')">예약</button>
     </div>

   </div>
 <BR/>
 </c:forEach>
</div>

<div id = 'view2_w' style='display: none;'>
 <div id="accordion">
  <div class="card">
    <div class="card-header" id="headingOne">
      <h5 class="mb-0">
        <button class="btn btn-light " data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
          기본정보
        </button>
      </h5>
    </div>
<div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordion">
      <div class="card-body">
      <h3>주변정보</h3>
<ul>

<c:forEach var="list" items="${vo }" begin='0' end='0'>
<h3>기본 정보</h3>
<ul>
<li>${checkIn } | ${checkout }</li>
<c:set var = 'wifi' value='${list.wifi }'/>
<c:if test='${wifi eq 1 }' >
<li>무료 Wifi 있습니다</li>
</c:if>
<c:set var = 'smoke' value='${list.smoke }'/>
<c:if test="${smoke eq 1 }" >
<li>금연/흡연 객실 선택가능 (고객센터 문의)</li>
</c:if>
<li>Bath Amenity (치약, 칫솔 유료)</li>
<c:set var = 'parking' value='${list.parking }'/>
<c:if test="${parking eq 1 }" >
<li>주차가능</li>
</ul>
</c:if>
<h3>객실 정보</h3>
<ul>
<li>[체크인 시 배정] 객실의 경우, 객실타입 랜덤배정 및 객실타입 사전 지정 or 요청 불가 </li><li><b>특정 타입을 원하실 경우 해당 타입으로 예약 진행하여야 하며, 선호타입 지정불가로 인한 무료 취소는 불가합니다</b></li></ul>

<h3>인원 추가 정보</h3>
<ul>
<li><font color="#0652ff">36개월 미만 무료</font></b> / 1인 12,100원 (36개월 이상~성인)</li><li>영유아 인원수 포함 / 최대인원 초과불가</li><li><b><font color="#CA0101">침대 추가 : 1채당 36,300원 (슈페리어 트윈객실만 가능 / 입실 하루 전 요청 시 추가가능)</font></b></li><li>현장 결제 및 추가비용 호텔 프론트 문의</li></ul>
<h3>투숙객 혜택</h3>
<ul>
<c:set var = 'pt' value='${list.pt }'/>
<c:if test ='${pt eq 1 }'>
<li>피트니스 센터 무료 이용 </li>
<li>피트니스 센터 / 지하 1층 / 06:00~22:30 / <b>코로나 19 확산억제를 위한 정부 권고사항에 따라 2020년 3월 24일~4월 5일까지 휴관됩니다</b></li>
<li>생수 1병 무료 제공</li></ul>
</c:if>

<h3>시설 </h3>
<ul>
<c:set var = 'rest' value='${list.rest }'/>
<c:if test = '${rest eq 1 }'>
<li>레스토랑 / 1층 / 런치 및 디너 운영 중 / 이용 전 유선문의 필수 (02-6202-2000)</li>
</c:if>
<c:set var = 'lounge' value='${list.lounge }'/>
<c:if test = '${lounge eq 1 }'>
<li>라운지 / 1층 / 24시간</li>
</c:if>
</ul>
<h3>조식 정보</h3>
<ul>
<c:set var = 'breakfast' value='${list.breakfast }'/>
<c:if test = '${breakfast eq 1 }'>
<li>조식은 호텔 1층 라운지를 통해 가시면 됩니다./(주중) 06:30~10:00, (토,일) 06:30~10:30</li><li>투숙객 무료</li>
</ul>
</c:if>
<h3>취소 및 환불 규정</h3>
<ul>
<li>체크인일 기준 1일전 18시까지 : 100% 환불</li>
<li>체크인일 기준 1일전 18시이후~당일 : 환불불가</li>
<li>취소, 환불시 수수료가 발생할 수 있습니다</li>
<li><font color="#FF5C5C">[봄맞이! 단독특가], 체크인 시 배정 (취소, 변경 불가), [명절증후군 타파 특가], [최대규모! 특가], [11월~1월 미리예약 특가], [가을! 단풍특가], [가을 호캉스! 단독특가], [추석 패키지] 객실 : 예약 후 취소, 변경, 환불불가</font></li>
</ul>

<h3>확인사항 및 기타</h3>
<ul>
<li>최대인원 초과시 입실 불가합니다</li>
<li>위의 정보는 호텔의 사정에 따라 변경될 수 있습니다</li>
<li>해당 이미지는 실제와 상이 할 수 있습니다</li>
<li>체크인 시 배정 또는 베드타입 미기재 상품은 특정객실과 베드타입을 보장하지 않습니다</li>
<li>해당 객실가는 세금, 봉사료가 포함된 금액입니다</li>
<li>미성년자는 단독 투숙이 불가하며, 보호자 동반 시 투숙 가능합니다 (이로 인한 취소 및 환불은 불가합니다)</li>
<li>체크인 시 신분증 (주민등록증, 운전면허증, 여권만 가능) 확인하고 있으며, 신분증 미지참 혹은 신분증과 투숙자명이 다를 시 투숙이 거부될 수 있습니다 (이로 인한 취소 및 환불은 불가합니다)</li>
<li>당 호텔은 투숙객 안전을 위하여 주 1회 전체 방역을 실시하고 있습니다</li>
</ul>
</c:forEach>
      </div>
    </div>
  </div>
  <div class="card">
    <div class="card-header" id="headingTwo">
      <h5 class="mb-0">
      
        <button class="btn btn-light" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
          편의시설 및 서비스
        </button>
      </h5>
    </div>
    <c:forEach var="list" items="${vo }" begin='0' end='0'>
    <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordion">
      <div class="card-body">
        
        <c:set var = 'smoke' value='${list.smoke }'/>
        <c:if test="${smoke eq 1 }" >
        <div id='photo_w'></div>
        </c:if>
        
        <c:set var = 'rest' value='${list.rest }'/>
        <c:if test = '${rest eq 1 }'>
        <div id='photo1_w'></div>
        </c:if>
        
        <c:set var = 'parking' value='${list.parking }'/>
        <c:if test="${parking eq 1 }" >
        <div id='photo2_w'></div>
        </c:if>
        
        <c:set var = 'bar' value='${list.bar }'/>
        <c:if test="${bar eq 1 }" >
        <div id='photo3_w'></div>
        </c:if>
        
        <c:set var = 'lounge' value='${list.lounge }'/>
        <c:if test = '${lounge eq 1 }'>
        <div id='photo4_w'></div>
        </c:if>
        
        <c:set var = 'wifi' value='${list.wifi }'/>
        <c:if test='${wifi eq 1 }' >
        <div id='photo5_w'></div>
        </c:if>
        
        <c:set var = 'tub' value='${list.tub }'/>
        <c:if test = '${tub eq 1  }'>
        <div id='photo6_w'></div>
        </c:if>
        <div id='photo7_w'></div>
      </div>
      </div>
      </c:forEach>
    </div>
  </div>
</div>

<div id='view3_w' style='display: none;'>
<div id='view_bottom_f'>
				<hr/>
				<div id='view_bottom_score_f'>
					<div id='starForm_f'>
						<div id='star_f'><input type="checkbox" name='star' id='star1_f' value=''/><label for='star1_f'><span></span></label></div>
						<div id='star_f'><input type="checkbox" name='star' id='star2_f' value=''/><label for='star2_f'><span></span></label></div>
						<div id='star_f'><input type="checkbox" name='star' id='star3_f' value=''/><label for='star3_f'><span></span></label></div>
						<div id='star_f'><input type="checkbox" name='star' id='star4_f' value=''/><label for='star4_f'><span></span></label></div>
						<div id='star_f'><input type="checkbox" name='star' id='star5_f' value=''/><label for='star5_f'><span></span></label></div>
					</div>
					<br/><span>별점 : 8.0</span><br/><br/><br/>
					<span>전체리뷰 <b>848</b> &nbsp;&nbsp;|&nbsp;&nbsp; 제휴점 답변 <b>343</b></span>
				</div>
				<hr/>
				
				<div id='view_bottom_review_f'>
					<div id='review_img_f'>
						<img src=''/>
					</div>
					<div id='review_coment_f'>
						<span>나쁘지 않아요</span><br/><br/>
						<span>별점 : 3.9</span><br/><br/>
						아늑하고 푹신하고<br/>
						편안한 쉼이 되는곳..<br/>
						직원들도 친절하고..<br/>
						오래된 부분이 조금은<br/>
						아쉽지만..<br/>
						도심속 이만한 공간도<br/>
						많지는 않아서...<br/>
						좋아요..<br/>
						자주 이용하는 곳이에요<br/>
				</div>
			</div>
		<hr/>
				
	</div>
</div>

<script>
btnFunc_w();

//Get the modal
var modal = document.getElementById('myModal');

// Get the button that opens the modal
var btn = document.getElementById("myBtn");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];                                          

// When the user clicks on the button, open the modal 
btn.onclick = function() {
    modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
    modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}

</script>
</body>
</html>