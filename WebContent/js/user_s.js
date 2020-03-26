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
	 		$('#frm').attr('action', 'review.rv').submit();
	 	});
	 }
}


