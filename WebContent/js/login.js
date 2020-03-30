/**
 * login.js
 */

function btnFunc(){
	/* 카카오
	  if($('#btn_kakao_c') != null){
		$('#btn_kakao_c').click(function(){
			Kakao.init('0c5164b04f51ba54280789c21fca1fc2');
			// 로그인 창을 띄웁니다.
			Kakao.Auth.createLoginButton({ 
				container: '#kakao-login-btn', 
				success: function(authObj) { alert(JSON.stringify(authObj)); 
				}, fail: function(err) { alert(JSON.stringify(err)); } 
			});

		});
	}*/
	
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
			var email = $('#email_c').val();
			$.post("emailS.lg", {'email':email}, 
					function(data, status){
						$('#btnNum_c').click(function(){
							var num = $('#num_c').val();
							if(data == num){
								$('#btnNextM_c').removeAttr('disabled');
								alert("인증되었습니다.");
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
	//회원가입 버튼 활성화 | 비활성화
	if('#btnMember_c' != null){
		$('#btnMember_c').click(function(){
				$('#frm_c').attr('action','member.lg').submit();
				//input태그의 값이 null이거나 오류상태이면 오류색으로 띄워주기
			
		});
	}
	
	//비밀번호 재설정 이메일전송
	if($('#btnPwEmail_c' != null)){	
		$('#btnPwEmail_c').click(function(){
			var email = $('#pwEmail_c').val();
			var content = $()
			$.post("pwResetMail.lg", {'email':email}, 
					function(data, status){
							if(data){
								alert("메일이 정상적으로 전송되었습니다.");
								sess
							}else{
								alert("메일 전송 중 오류가 발생했습니다.");
							}
						});
					});
		};
};

/* 약관동의 */
function agree(){
	$('[name=agreeAll]').click(function(){
		$('[name=agreeOne]').prop('checked', $(this).prop('checked') );
		if($(this).prop('checked')){
			$('#btnNextE_c').removeAttr('disabled');
		}else{
			$('#btnNextE_c').attr('disabled', true);
		}
	});
	$('[name=agreeOne]').each(function(){
		$(this).click(function(){
			var box = $(this);
			var allBox = $('[name=agreeAll]');
			var boxName = $(box).attr('name');
			
			if(box.prop('checked') ){
				checkBoxLength = $('[name='+ boxName +']').length;
				checkedLength = $('[name='+ boxName +']:checked').length;
			
				if(checkBoxLength == checkedLength) {
					allBox.prop('checked', true);
					$('#btnNextE_c').removeAttr('disabled');
				}else {
					allBox.prop('checked', false);
					$('#btnNextE_c').attr('disabled', true);
				}
			}else{
				allBox.prop('checked', false);
				$('#btnNextE_c').attr('disabled', true);
			}
		});
	});
};

function emailCk(){
	//이메일 중복체크
	$('#email_c').on('keyup', function(){
		var email = $(this).val();
		var msg = $('#emailM_c');
		var emailRule = $(this).val().search(/^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i);
		$.post("emailCk.lg", {'email':email},
				function(data, status){
					if(data == email){
						$('#email_c').css('border', '1px solid #ff0055');
						$(msg).text('이미 등록되어있는 이메일입니다.');
						$(msg).css('color', '#ff0055');
					}else if(emailRule < 0 || email.length < 1){
						$('#email_c').css('border', '1px solid #ff0055');
						$(msg).text('유효하지않은 E-Mail주소입니다.');
						$(msg).css('color', '#ff0055');
					}else{
						$(msg).text("");
						$('#nName_c').css('border', '1px solid #000');
						$('#btnSend_c').removeAttr('disabled');
					}
				});
	});
	
	//DB에 있는 이메일인지 체크
	$('#pwEmail_c').on('keyup', function(){
		var email = $(this).val();
		var msg = $('#pwEmailM_c');
		$.post("emailCk.lg", {'email':email},
				function(data, status){
					if(data != email){
						$('#pwEmail_c').css('border', '1px solid #ff0055');
						$(msg).text('등록되어있지 않은 이메일입니다.');
						$(msg).css('color', '#ff0055');
					}else{
						$(msg).text("");
						$('#pwEmail_c').css('border', '1px solid #000');
						$('#btnPwEmail_c').removeAttr('disabled');
					}
				});
	});
};

/* 회원가입 */
function member(){
	//비밀번호
	$('#pwd_c').on('keyup', function(){
		var msg = $('#pwdM_c');
		var num = $(this).val().search(/[0-9]/g);
		var eng = $(this).val().search(/[a-zA-Z]/ig);
		var spe = $(this).val().search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
		$(this).val($(this).val().replace(/[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/g, "")); //한글은 입력 X
		
		if($(this).val().length < 6 || $(this).val().length > 15){
			$(msg).text('6자리 ~ 15자리 이내로 입력해주세요.');
			$(msg).css('color', '#ff0055');	
			$(this).css('border', '1px solid #ff0055');
		}else if($(this).val().search(/\s/) != -1){
			$(msg).text('띄어쓰기 없이 입력해 주세요.');
			$(msg).css('color', '#ff0055');
			$(this).css('border', '1px solid #ff0055');
		}else if(num < 0 || eng < 0 || spe < 0 ){
			$(msg).text('영문, 숫자, 특수문자를 혼합하여 입력해주세요.');
			$(msg).css('color', '#ff0055');
			$(this).css('border', '1px solid #ff0055');
		}else {
			$(msg).text("");
			$(this).css('border', '1px solid #000');
		}
	});
	
	//비밀번호 확인
	$('#pwd_check_c').on('keyup', function(){
		var msg = $('#pwdM_check_c');
		$(this).val($(this).val().replace(/[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/g, ""));
		
		if($('#pwd_c').val() != $(this).val()){
			$(msg).text("비밀번호가 일치하지 않습니다.");
			$(msg).css('color', '#ff0055');
			$(this).css('border', '1px solid #ff0055');
		}else if($(this).val() == ""){
			$(msg).text("비밀번호를 한번 더 입력해 주세요.");
			$(msg).css('color', '#ff0055');
			$(this).css('border', '1px solid #ff0055');
		}else{
			$(msg).text("");
			$(this).css('border', '1px solid #000');
		};
	});
	
	//핸드폰번호
	$('#phone_c').on('keyup', function(){
		$(this).val($(this).val().replace(/[^0-9]/g, "")); //숫자만 입력.
	});
	
	//닉네임 중복체크
	$('#nName_c').on('keyup', function(){
		var nName = $('#nName_c').val();
		var msg = $('#nNameM_c');
		$.post("nNameCk.lg", {'nName':nName},
				function(data, status){
					if(data == nName){
						$('#nName_c').css('border', '1px solid #ff0055');
						$(msg).text('이미 등록되어있는 닉네임입니다.');
						$(msg).css('color', '#ff0055');
					}else{
						$(msg).text("");
						$('#nName_c').css('border', '1px solid #000');
					}
				});
	});
}




























