/**
 * http://usejsdoc.org/
 */
let user = function(){
	
	let view = function(eMail){
		$('#rCode').val(eMail);
		$('#frm').attr('action', 'resView.mp').submit();
	}
	
	
	if($('#btnMu_s')!=null){
		$('#btnMu_s').click(function(){
			$('#frm_up_s').attr('action', 'mpUp.mp').submit();
	 	});
	 }
	
	if($('#btnUpdate_s')!=null){
		$('#btnUpdate_s').click(function(){
			$('#frm_update_s').attr('action', 'mpUpdate.mp').submit();
	 	});
	 }
	 
	 if($('#btnRee_s')!=null){
		$('#btnRee_s').click(function(){
			$('#frm_rv_s').attr('action', 'reviewInsert.rv').submit();
		})
	 }
	 
	 
	 if($('#btnModify_s')!=null){
		$('#btnModify_s').click(function(){
			$('#frm_rm_s').attr('action', 'reviewModify.rv').submit();
		})
	 }
	 
	 if($('#btnRv_Reply_s')!=null){
		$('#btnRv_Reply_s').click(function(){
			$('#frm_rvReply_s').attr('action', 'reviewReply.rv').submit();
		})
	 }
	 
	 
	$('.starRev span').click(function(){
		  $(this).parent().children('span').removeClass('on');
		  $(this).addClass('on').prevAll('span').addClass('on');
		  return false;
	});
	
	$('#star1_s').click(function(){
		$('#star_s').val(1);
	})
	$('#star2_s').click(function(){
		$('#star_s').val(2);
	})
	$('#star3_s').click(function(){
		$('#star_s').val(3);
	})
	$('#star4_s').click(function(){
		$('#star_s').val(4);
	})
	$('#star5_s').click(function(){
		$('#star_s').val(5);
	})
}

let btnSelect = function(rCode){
	let code = rCode.value;
	$('#rCo_s').val(code);
	$('#frm_rvv_s').attr('action', 'reviewSelect.rv').submit();
}

/*let rvDelete = function(rIndex){
	//let index = $('#index_s'+rIndex).val();
	let result = confirm("삭제하시겠습니까?");
	if(result){
		let indent = $('#rIndent_s'+rIndex).val();
		$('#indent_s').val(indent);
		let index = $('#rNo_s'+rIndex).val();
		$('#rno_s').val(index);
		$('#frm_room_k').attr('action', 'reviewDelete.rv').submit();	
	}else{
		return false;
	}
}*/

let rvDelete = function(rNo, rIndent, rGroup){
	let result = confirm("삭제하시겠습니까?");
	if(result){
		let no = rNo.value;
		let rin = rIndent.value;
		let rgro = rGroup.value;
		$('#rno_s').val(no);
		$('#indent_s').val(rin);
		$('#rGro_s').val(rgro);
		$('#frm_room_k').attr('action', 'reviewDelete.rv').submit();
	}else{
		return false;
	}
}

let btnRvMo = function(rNo){
	let no = rNo.value;
	$('#rno_s').val(no);
	$('#frm_room_k').attr('action', 'reviewModifyform.rv').submit();
}

/*if($('.btnRv_Mo_s')!=null){
	$('.btnRv_Mo_s').click(function(){
		$('#frm_room_k').attr('action', 'reviewModifyform.rv').submit();
	})
}*/
 
let btnReview = function(rCode){
	let code = rCode.value;
	$('#rCo_s').val(code);
	$('#frm_rvv_s').attr('action', 'review.rv').submit();
}


let btnRv_Reply = function(rGroup){
	let group = rGroup.value;
	$('#rGro_s').val(group);
	$('#frm_room_k').attr('action', 'reviewReplyView.rv').submit();
}

let myPage = function(eMail){
	$('#eMail').val(eMail);
	$('#frm').attr('action', 'mpview.mp').submit();		
}

let reserveList = function(eMail){
	if(eMail == "") {
		location.href = "./login/login.jsp";
	} else {
	 $('#eMail').val(eMail);
	 $('#frm').attr('action', 'reserveList.mp').submit();
	}
}

let lastPlace = function(eMail){
	 $('#eMail').val(eMail);
	 $('#frm').attr('action', 'lastPlace.mp').submit();
}


