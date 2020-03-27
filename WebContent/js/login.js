/**
 * login.js
 */

function btnFunc(){
	
	if('#btnLogin_c' != null){
		$('#btnLogin_c').click(function(){
			$('#frm_c').attr('action','login.lg').submit();
		});
	}
	
	if('#btnNextE_c' != null){
		$('#btnNextE_c').click(function(){
			location.href="./email.jsp";
		});
	}
	 /* 이메일 인증 */
	if('#btnSend_c' != null){
		$('#btnSend_c').click(function(){
			$('#numView').css('display','block');
			var email = $('#email_c').val();
			$.post("email.lg", {'email':email}, 
					function(data, status){
						$('#btnSendNum_c').click(function(){
							console.log(2);
							var num = $('#num_c').val();
							if(data == num){
								$('#btnNextM_c').removeAttr('disabled');
							}else{
								alert("인증번호가 일치하지 않습니다.");
							}
						});
					});
		});
	}
	
	if('#btnNextM_c' != null){
		$('#btnNextM_c').click(function(){
			$('#frm_c').attr('action','membership.jsp').submit();
		});
	}
};

/* 약관동의 */
function agree(){
	$('[name=agreeAll]').click(function(){
		$('[name=agreeOne]').prop('checked', $(this).prop('checked') );
	});
	$('[name=agreeOne]').each(function(){
		$(this).click(function(){
			var box = $(this);
			var allBox = $('[name=agreeAll]');
			var boxName = $(box).attr('name');
			
			if( $(box).prop('checked') ){
				checkBoxLength = $('[name='+ boxName +']').length;
				checkedLength = $('[name='+ boxName +']:checked').length;
			
				if( checkBoxLength == checkedLength ) {
					allBox.prop('checked', true);
					$('#btnNext_c').removeAttr('disabled');
				}else {
					allBox.prop('checked', false);
					$('#btnNext_c').attr('disabled', true);
				}
			}else{
				allBox.prop('checked', false);
				$('#btnNext_c').attr('disabled', true);
			}
		});
	});
};

/* 회원가입 */
//비밀번호 
function check(){
	$('#pwd_c').on('keyup', function(){
		var num = pw.search(/[0-9]/g);
		var eng = pw.search(/[a-z]/ig);
		var spe = pw.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
		
		if($('#pwd_c').length < 8 || $('#pwd_c').length > 20){
			$('#pwdM_c').text('8자리 ~ 20자리 이내로 입력해주세요.');
			$('#pwd_c').css('border', '1px solid #FF3636');
			return false;
		}else if($('#pwd_c').search(/\s/) != -1){
			$('#pwdM_c').text('비밀번호는 공백 없이 입력해주세요.');
			$('#pwd_c').css('border', '1px solid #FF3636');
			return false;
		}else if(num < 0 || eng < 0 || spe < 0 ){
			$('#pwdM_c').text('영문, 숫자, 특수문자를 혼합하여 입력해주세요.');
			$('#pwd_c').css('border', '1px solid #FF3636');
			return false;
		}else {
			$('#pwdM_c').text("");
			$('#pwd_c').css('border', '1px solid #6BEC62');
			return true;
		}
	});
	//비밀번호 확인
		
	$('#pwd_check_c').on('keyup', function(){
		console.log("ddd");
		if($('#pwd_c').val() != $('#pwd_check_c').val()){
			$('#pwdM_check_c').text("비밀번호가 일치하지 않습니다.");
			$('#pwd_check_c').css('border', '1px solid #FF3636');
		}else{
			$('#pwdM_check_c').text("");
			$('#pwd_check_c').css('border', '1px solid #6BEC62');
		};
	});
}




























