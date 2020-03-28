/**
 * http://usejsdoc.org/
 */
let user = function(){
	
	let view = function(eMail){
		$('#rCode').val(eMail);
		$('#frm').attr('action', 'resView.mp').submit();
	}
	
	if($('#btnRe_s')!=null){
		$('#btnRe_s').click(function(){
			$('#frm_rvv_s').attr('action', 'review.rv').submit();
	 	});
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
	 
	 if($('#btnRv_Mo_s')!=null){
		$('#btnRv_Mo_s').click(function(){
			$('#frm_rvSe_s').attr('action', 'reviewModify.rv').submit();
		})
	 }
	 
	 if($('#btnSe_s')!=null){
		$('#btnSe_s').click(function(){
			$('#frm_rvv_s').attr('action', 'reviewSelect.rv').submit();
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

let myPage = function(eMail){
	console.log(eMail);
	if(eMail == "") {
		location.href = "./login/login.jsp";
	} else {
		$('#eMail').val(eMail);
		$('#frm').attr('action', 'mpview.mp').submit();		
	}
}

let reserveList = function(eMail){
	 $('#eMail').val(eMail);
	 $('#frm').attr('action', 'reserveList.mp').submit();
}

let lastPlace = function(eMail){
	 $('#eMail').val(eMail);
	 $('#frm').attr('action', 'lastPlace.mp').submit();
}


