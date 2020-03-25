/**
 * 
 */
//체크인 체크아웃 데이트 설정
let btnFunc_w = function(){
	
	if($('#btnHotel')!= null){
	  $('#btnHotel').click(function(){
		$('#frm').attr('action','roomReview.vi').submit();  
	  })
	}
	
	
	
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
	    $( "#checkIn_w" ).datepicker({   // http://blog.naver.com/wizardkyn/220661505153
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
			        var day = $("#checkIn_w").datepicker('getDate');
			        $('#checkOut_w').datepicker('option','minDate', day);//오른쪽달력 minDate 옵션으로 왼쪽달력의 선택된 날짜를 지정
		      }
		      ,onChangeMonthYear:function(year,month,evnt){//왼쪽이나 오른쪽버튼을 눌렀을때 호출되는 콜백함수
				    //2. 좌측 달력의 ‘월“ 과 우측 달력의 ’월‘ 은 동일하게 움직이도록 처리
				    var day2 = $("#checkIn_w").datepicker('getDate');
				    day2.setMonth(month-1);
				    day2.setFullYear(year);
				    $('#checkOut_w').datepicker('setDate', day2)
		 
		      }
	 
	   });
	   $( "#checkOut_w" ).datepicker({
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
	
   
	
	
	
}