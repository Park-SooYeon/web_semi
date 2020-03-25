/**
 * web-semi project
 * 작성자 : 김도경
 */
//이벤트css 함수
let event_f = function(){
	//구 선택 hover시 div나타내기
	if($('#goo_select_f')!=null){
		$('#goo_select_f').hover(function(){
			$('#goo_list_f').slideToggle(10);
		});	
	}
	//낮은가격,높은가격 버튼클릭시 생상변경
	if($('.btnDsc_f')!=null){
		$('.btnDsc_f').click(function(){
			$('.btnDsc_f').css('color','#f62a4b');
			$('.btnAsc_f').css('color','#aaa');
			$('#pricename').text('높은가격순');
		})
	}
	if($('.btnAsc_f')!=null){
		$('.btnAsc_f').click(function(){
			$('.btnAsc_f').css('color','#f62a4b');
			$('.btnDsc_f').css('color','#aaa');
			$('#pricename').text('낮은가격순');
		})
	}
	//베드타입 클릭시 css변경
	if($('#bed1_f')!=null){
		$('#bed1_f').click(function(){
			$('#bed1_f').css('background-image',"url('../image/bedcl1_f.jpg')");
			$('#bed2_f').css('background-image',"url('../image/bed2_f.jpg')");
			$('#bed3_f').css('background-image',"url('../image/bed3_f.jpg')");
			$('#bed4_f').css('background-image',"url('../image/bed4_f.jpg')");
			$('#bedtype_f').val('1');
		});
	}
	if($('#bed2_f')!=null){
		$('#bed2_f').click(function(){
			$('#bed1_f').css('background-image',"url('../image/bed1_f.JPG')");
			$('#bed2_f').css('background-image',"url('../image/bedcl2_f.jpg')");
			$('#bed3_f').css('background-image',"url('../image/bed3_f.jpg')");
			$('#bed4_f').css('background-image',"url('../image/bed4_f.jpg')");
			$('#bedtype_f').val('2');
		});
	}
	if($('#bed3_f')!=null){
		$('#bed3_f').click(function(){
			$('#bed1_f').css('background-image',"url('../image/bed1_f.JPG')");
			$('#bed2_f').css('background-image',"url('../image/bed2_f.jpg')");
			$('#bed3_f').css('background-image',"url('../image/bedcl3_f.jpg')");
			$('#bed4_f').css('background-image',"url('../image/bed4_f.jpg')");
			$('#bedtype_f').val('3');
		});
	}
	if($('#bed4_f')!=null){
		$('#bed4_f').click(function(){
			$('#bed1_f').css('background-image',"url('../image/bed1_f.JPG')");
			$('#bed2_f').css('background-image',"url('../image/bed2_f.jpg')");
			$('#bed3_f').css('background-image',"url('../image/bed3_f.jpg')");
			$('#bed4_f').css('background-image',"url('../image/bedcl4_f.jpg')");
			$('#bedtype_f').val('4');
		});
	}
	
     
	//체크인 체크아웃 데이트 설정
	var deadLine = new Date(),
    y = deadLine.getFullYear(),
    m = deadLine.getMonth()+1,
    d = deadLine.getDate(),
    h = deadLine.getHours(),
    M = deadLine.getMinutes();
 
	if(h >= 16 && M >= 30 ) d++;
	deadLine = y + "-" + m + "-" + d;
 
	$(function(){
 
	    // 분 단위로 minDate 제어  - 16:30 지나면 minDate 일 단위에 하루 플러스 하여 선택불가 만들기
	    $( "#checkIn_f" ).datepicker({   // http://blog.naver.com/wizardkyn/220661505153
		      minDate: deadLine  //1. 좌측 달력 날짜의 최초 값은 기본 기능에 나와 있듯 “오늘” 날짜이며, 오늘 날짜 이전으로 월 & 일 이동 불가
		              //minDate 옵션 설정
		      ,dayNamesMin: [ "일", "월", "화", "수", "목", "금", "토"] //달력 한글화(요일)
		      ,monthNames: [ "1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월" ]//달력 한글화(월)
		      ,yearSuffix:"년"
		      ,showMonthAfterYear:true
		      ,nextText:"다음달"
		      ,prevText:"이전달"
		      ,dateFormat:"yy-mm-dd"
		      ,onSelect: function(selected,evnt){
			        //3. 좌측 달력에서 날짜를 선택하면 우측 달력은 좌측 달력에서 선택된 날짜 이전으로 월 & 일 이동 불가
			        var day = $("#checkIn_f").datepicker('getDate');
			        $('#checkOut_f').datepicker('option','minDate', day);//오른쪽달력 minDate 옵션으로 왼쪽달력의 선택된 날짜를 지정
		      }
		      ,onChangeMonthYear:function(year,month,evnt){//왼쪽이나 오른쪽버튼을 눌렀을때 호출되는 콜백함수
				    //2. 좌측 달력의 ‘월“ 과 우측 달력의 ’월‘ 은 동일하게 움직이도록 처리
				    var day2 = $("#checkIn_f").datepicker('getDate');
				    day2.setMonth(month-1);
				    day2.setFullYear(year);
				    $('#checkOut_f').datepicker('setDate', day2)
		 
		      }
	 
	   });
	   $( "#checkOut_f" ).datepicker({
	       minDate: deadLine
	      ,dayNamesMin: [ "일", "월", "화", "수", "목", "금", "토"]//달력 한글화(요일)
	      ,monthNames: [ "1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월" ]//달력 한글화(월)
	        ,yearSuffix:"년"
	        ,showMonthAfterYear:true
	        ,nextText:"다음달"
	        ,prevText:"이전달"
	        ,dateFormat:"yy-mm-dd"
	   });
 
 
   }); 
	 
	 
	 //리스트 클릭하면 view페이지로 이동
	

	
		

}
let view = function(){
	location.href = "index.jsp?middle=./kdg/rooms_view.jsp"
}


//버튼함수
let btnFunc_f = function(){
	//호텔 페이지 적용버튼 클릭시
	if($('#h_btnApply_f')!=null){
		$('#h_btnApply_f').click(function(){
			$('.btnAsc_f').css('color','#f62a4b');//적용 클릭시 낮은가격순으로 정렬할것이기에 이벤트추가
			$('.btnDsc_f').css('color','#aaa');
		})
	}
	//모텔 페이지 적용버튼 클릭시
	if($('#m_btnApply_f')!=null){
		$('#m_btnApply_f').click(function(){
			$('.btnAsc_f').css('color','#f62a4b');//적용 클릭시 낮은가격순으로 정렬할것이기에 이벤트추가
			$('.btnDsc_f').css('color','#aaa');
		})
	}
	//게하 페이지 적용버튼 클릭시
	if($('#g_btnApply_f')!=null){
		$('#g_btnApply_f').click(function(){
			$('.btnAsc_f').css('color','#f62a4b');//적용 클릭시 낮은가격순으로 정렬할것이기에 이벤트추가
			$('.btnDsc_f').css('color','#aaa');
		})
	}
	//캠핑 페이지 적용버튼 클릭시
	if($('#c_btnApply_f')!=null){
		$('#c_btnApply_f').click(function(){
			$('.btnAsc_f').css('color','#f62a4b');//적용 클릭시 낮은가격순으로 정렬할것이기에 이벤트추가
			$('.btnDsc_f').css('color','#aaa');
		})
	}
	
	
	//초기화 버튼 클릭시 페이지 새로고침 
	if($('.btnReset')!=null){
		$('.btnReset').click(function(){
			
		})
	}
	
	
	
	//호텔 높은가격순 클릭시
	if($('#h_btnDsc_f')!=null){
		$('#h_btnDsc_f').click(function(){
			
		})
	}
	//호텔 낮은가격순 클릭시
	if($('#h_btnAsc_f')!=null){
		$('#h_btnAsc_f').click(function(){
			
		})
	}
	//모텔 높은가격순 클릭시
	if($('#m_btnDsc_f')!=null){
		$('#m_btnDsc_f').click(function(){
			
		})
	}
	//모텔 낮은가격순 클릭시
	if($('#m_btnAsc_f')!=null){
		$('#m_btnAsc_f').click(function(){
			
		})
	}
	//게하 높은가격순 클릭시
	if($('#g_btnDsc_f')!=null){
		$('#g_btnDsc_f').click(function(){
			
		})
	}
	//게하 낮은가격순 클릭시
	if($('#g_btnAsc_f')!=null){
		$('#g_btnAsc_f').click(function(){
			
		})
	}
	//캠핑 높은가격순 클릭시
	if($('#c_btnDsc_f')!=null){
		$('#c_btnDsc_f').click(function(){
			
		})
	}
	//캠핑 낮은가격순 클릭시
	if($('#c_btnAsc_f')!=null){
		$('#c_btnAsc_f').click(function(){
			
		})
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}