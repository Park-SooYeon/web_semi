/**
 *  reserve_insert.js
 *  : 예약할 때 사용하는 js
 */

var msg_k = ""; // 결제하기 버튼을 눌렀을 때의 결과
var href_k = ""; // 팝업창으로 띄울 페이지의 url경로

//-------------------------------------------------------------------
//결제 API에 쓰이는 함수 및 변수들
//-------------------------------------------------------------------
/*var IMP = window.IMP;
IMP.init('imp07869343');

let rName = '방이름'; // 방이름
let price = 1000; // 가격
let email = '로그인 아이디'; // 이메일 아이디
let uName = $('reserve_name_k').val(); // 예약자 이름
let uPhone = $('reserve_Phone_k').val();// 예약자 번호

let pay_iamport = function() {
	IMP.request_pay({
	    pg : 'nice', // version 1.1.0부터 지원. danal or inicis or nice
	    pay_method : 'card',
	    merchant_uid : 'merchant_' + new Date().getTime(),
	    name : rName,
	    amount : price,
	    buyer_email : email,
	    buyer_name : uName,
	    buyer_tel : uPhone
	}, function(rsp) {
	    if ( rsp.success ) {
	    	//[1] 서버단에서 결제정보 조회를 위해 jQuery ajax로 imp_uid 전달하기
//	    	jQuery.ajax({
//	    		url: "/payments/complete", //cross-domain error가 발생하지 않도록 동일한 도메인으로 전송
//	    		type: 'POST',
//	    		dataType: 'json',
//	    		data: {
//		    		imp_uid : rsp.imp_uid
//		    		//기타 필요한 데이터가 있으면 추가 전달
//	    		}
//	    	}).done(function(data) {
//	    		//[2] 서버에서 REST API로 결제정보확인 및 서비스루틴이 정상적인 경우
//	    		if ( everythings_fine ) {
//	    			msg_k = '결제가 완료되었습니다.';
//	    		} else {
//	    			msg_k = '???';
//	    			//[3] 아직 제대로 결제가 되지 않았습니다.
//	    			//[4] 결제된 금액이 요청한 금액과 달라 결제를 자동취소처리하였습니다.
//	    		}
//	    	});
	    } else {
	    	msg_k = rsp.error_msg;
	    }
	    alert(msg_k);
	});
}*/

//-------------------------------------------------------------------
// reserve.jsp에 사용되는 변수 및 함수, 기능들
//-------------------------------------------------------------------

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

// 전화번호 폼에 '-'입력 불가능
let removeChar = function() {
	if($('#reserve_Phone_k') != null) {
		$('#reserve_Phone_k').keyup(function(e) {
		    if(e.keyCode == 189) {
		    	let str = $(this).val().replace('-','');
		    	console.log(str);
		    	$(this).val(str);
		    }
		});
	}
}

// colorbox로 결과창 팝업으로 띄우기
let reserveR_k = function(link) {
	$.colorbox({
		overlayClose : false,
		escKey : false,
		href : link
    });
}


//-------------------------------------------------------------------
// ajax를 위한 함수
//-------------------------------------------------------------------

// 예약할 때, 사용할 ajax
let insertAjax_k = function() {
	let param = $('#rsForm_k').serialize();
	console.log($('#price_k').text());
	$.ajax({
		url : "rsInsert.rs",
		method : "post",
		data : param,
		dataType : "text", // 서버에서 받을 데이터 형식(msg(String형)만 반환해주므로 text타입으로 데이터를 받아옴)
		timeout: 3000, // ajax 대기시간 3초로 설정
		success : function(data) {
			alert("예약 성공!");
			console.log("data : ", data);
			msg_k = data;
		},
		error : function(e) {
			alert("에러!!");
			msg_k = "에러가 발생했습니다.";
		},
		complete : function() {
			reserveR_k("reserve/reserve_ok.jsp");
		}
	});
}

// 예약 취소할 때, 사용할 ajax
let deleteAjax_k = function() {
	$.ajax({
		url : "rsDelete.rs",
		method : "post",
		data : param,
		dataType : "text", // 서버에서 받을 데이터 형식(msg(String형)만 반환해주므로 text타입으로 데이터를 받아옴)
		timeout: 3000, // ajax 대기시간 3초로 설정
		success : function(data) {
			alert("예약 취소 성공!");
			console.log("data : ", data);
			msg_k = data;
		},
		error : function(e) {
			alert("에러!!");
			msg_k = "에러가 발생했습니다.";
		},
		complete : function() {
			reserveR_k("reserve/reserve_ok.jsp");
		}
	});
}

// 예약 상세 조회할 때 사용할 Ajax
let rsViewAjax = function() {
	// 예약 번호 가져오기
	let rNo = $('#rNo').val();
	console.log(rNo);
	$.ajax({
		url : "rsView.rs",
		method : "get",
		data : {"rNo" : rNo },
		dataType : "json", // 서버에서 받을 데이터 형식(msg(String형)만 반환해주므로 text타입으로 데이터를 받아옴
		timeout: 3000, // ajax 대기시간 3초로 설정
		success : function(data) {
			alert("예약 조회 성공!");
			console.log("data : ", data);
			msg_k = data;
		},
		error : function(e) {
			alert("에러!!");
			msg_k = "에러가 발생했습니다.";
		},
		complete : function() {
			reserveR_k("reserve/reserve_ok.jsp");
		}
	});
}

// 객실 상세 조회할 때 사용할 Ajax
let roomViewAjax = function() {
	// 숙소 번호, 객체 번호 가져오기
	let rCode = $('#rCode').val();
	let roomCode = $('#roomCode').val();
	console.log(rCode);
	console.log(roomCode);
	$.ajax({
		url : "rsRoom.rs",
		method : "get",
		data : { 
					"rCode" : rCode,
					"roomCode" : roomCode
			   },
		/*dataType : "json",*/ // 서버에서 받을 데이터 형식
		timeout: 3000, // ajax 대기시간 3초로 설정
		success : function(data) {
			alert("객실 조회 성공!");
			$('#r')
		},
		error : function(e) {
			alert("에러!!");
			msg_k = "에러가 발생했습니다.";
		},
		complete : function() {
			reserveR_k("reserve/reserve_ok.jsp");
		}
	});
}


//-------------------------------------------------------------------
// reserve.jsp에 사용되는 체크박스 클릭 이벤트
//-------------------------------------------------------------------
let ck_status_k = function() {
	if($('#checkAll_k') != null) {
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
}


//-------------------------------------------------------------------
// reserve.jsp / reserve_ck.jsp / reserve_ok.jsp / reserve_modify.jsp의 버튼 클릭 이벤트
//-------------------------------------------------------------------
let btnFunc_k = function() {
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
//-----------------------------------------------------------------------나중에 메인 or 숙소 상세페이지로 이동할 것
	// reserve_ck.jsp의 동의 후 결제 버튼
	if($('#btnPayOk_k') != null) {
		$('#btnPayOk_k').click(function() {
//			pay_iamport();
			insertAjax_k();
		});
	}


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
			deleteAjax_k();
/*			msg_k = "정상 취소되었습니다.";
			reserveR_k("reserve/reserve_ok.jsp");*/
		});
	}
}
