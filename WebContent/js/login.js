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

