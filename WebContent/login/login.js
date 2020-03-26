/**
 * login.js
 */

function btnFunc(){
	
	if('#btnLogin_c' != null){
		$('#btnLogin_c').click(function(){
			$('#frm_c').attr('action','login.lg').submit();
		});
	}
	
	if('#btnNext_c' != null){
		$('#btnNext_c').click(function(){
			location.href="./email.jsp";
		});
	}
	
	if('#btnSend_c' != null){
		$('#btnSend_c').click(function(){
			$('#frm_c').attr('action', 'email.lg').submit();
		});
	}
};

/* 약관동의 */
function agree(){
	$('[name=agreeAll]').click(function(){
		$('[name=agreeOne]').prop('checked', $(box).prop('checked') );
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
					$('#btn_next_c').removeAttr('disabled');
					
				}else {
					allBox.prop('checked', false);
					$('#btn_next_c').attr("disabled", true);
				}
			}else{
				allBox.prop('checked', false);
				$('#btn_next_c').attr("disabled", true);
			}
		});
	});

	
	
};

