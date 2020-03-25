/**
 *  reserve_insert.js
 *  : 예약할 때 사용하는 js
 */


//-------------------------------------------------------------------
// reserve.jsp에 사용되는 변수 및 함수, 기능들
//-------------------------------------------------------------------
var msg_k = ""; // 결제하기 버튼을 눌렀을 때의 결과
var href_k = ""; // 팝업창으로 띄울 페이지의 url경로

// reserve.jsp에서 예약자 이름과 휴대폰 번호, 전체 동의가 되어 있어야 결제 가능
let payment_ck_k = function() {
	let flag = false;
	if($('#reserve_name_k').val() == '') { 
		msg_k = "이름을 확인해주세요.";
		reserveR_k("reserve/reserve_ok.jsp");
	} else if($('#reserve_Phone_k').val() == '' || phone_ck_k()) {
		msg_k = "번호를 확인해주세요.";
		reserveR_k("reserve/reserve_ok.jsp");
	} else if(!$('#checkAll_k').prop('checked')) {
		msg_k = "약관 동의를 해주세요.";
		reserveR_k("reserve/reserve_ok.jsp");
	} else {
		flag = true;
	}
	
	return flag;
}

// reserve.jsp에서 휴대폰 번호 유효성 체크 함수
let phone_ck_k = function() {
	let result = false; // 유효성 체크 결과 저장
	
	// 기존 번호에서 -를 삭제
    var trans_num = $('#reserve_Phone_k').val().replace(/-/gi,'');
  	
    // 유효성 체크
   	var regExp_ctn = /^(01[016789]{1})([0-9]{3,4})([0-9]{4})$/;
   	if(regExp_ctn.test(trans_num)) { // 유효성 체크 성공
   		result = true;
	}
    
    return !result;
}

let reserveR_k = function(link) {
	$.colorbox({
		overlayClose : false,
		escKey : false,
		href : link
    });
}

//-------------------------------------------------------------------
// reserve.jsp에 사용되는 체크박스 클릭 이벤트
//-------------------------------------------------------------------
let ck_status = function() {
	// 전체 동의를 체크했을 경우
	$('#checkAll_k').click(function() {
		let chk = $(this).prop('checked'); // 전체 선택 체크박스의 속성값을 가져옴
		if(chk) { // 만약 전체 선택 체크박스가 체크된상태일경우
			$('input[type=checkbox]').prop('checked',true); // 해당화면에 전체 checkbox들을 체크해준다 
		} else { // 전체선택 체크박스가 해제된 경우
			$('input[type=checkbox]').prop('checked',false); // 해당화면에 모든 checkbox들의 체크를해제시킨다. 
		} 
	});

	// 아래 세 약관이 모두 체크되었을 경우 전체 동의도 체크됨
	$('input:checkbox[name=checkOk]').click(function() {
		let cnt = $('input:checkbox[name=checkOk]:checked').length;
		if(cnt == 3) {
			$('#checkAll_k').prop('checked',true);
		} else {
			$('#checkAll_k').prop('checked',false);
		}
	});
}


//-------------------------------------------------------------------
// reserve.jsp / reserve_ck.jsp / reserve_ok.jsp / reserve_modify.jsp의 버튼 클릭 이벤트
//-------------------------------------------------------------------
let btnFunc = function() {
	// reserve.jsp의 결제하기 버튼
	if($('#btnPay_k') != null) {
		$('#btnPay_k').click(function() {
			let flag = payment_ck_k();
			if(flag) { // 이름, 번호, 전체 동의 상태에서만 결제 가능
				reserveR_k("reserve/reserve_ck.jsp");
			}
		});
	}
	
	// reserve_ck.jsp의 결제 취소 버튼
	if($('#btnCkClose_k') != null) {
		$('#btnCkClose_k').click(function() {
			$.colorbox.close();
		});
	}
	// reserve_ck.jsp의 동의 후 결제 버튼
	if($('#btnPayOk_k') != null) {
		$('#btnPayOk_k').click(function() {
			msg_k = "정상 예약되었습니다.";
			reserveR_k("reserve/reserve_ok.jsp");
		});
	}

//-----------------------------------------------------------------------나중에 메인 or 숙소 상세페이지로 이동할 것
	// reserve_ok.jsp의 확인 버튼
	if($('#btnOk_k') != null) {
		$('#okMsg_k').text(msg_k);
		$('#btnOk_k').click(function() {
			$.colorbox.close();
		});
	}
//--------------------------------------------------------------------------------------------------

	// reserve_modify.jsp의 예약 변경 버튼
	if($('#btnDelete_k') != null) {
		$('#btnDelete_k').click(function() {
			msg_k = "정상 취소되었습니다.";
			reserveR_k("reserve/reserve_ok.jsp");
		});
	}
}
