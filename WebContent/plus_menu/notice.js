let btnFuncm = function() {

	if ($('#btnInsertm') != null) {
		$('#btnInsertm').click(function() {
			$('#frmm').attr('action', 'nt_insertview.mm').submit();
		})
	}
	if ($('#btnDeletem') != null) {
		$('#btnDeletem').click(function() {
			let yn = confirm("삭제하시겠습니까 ????");
			if (yn) {
				$('#frmm').attr('action', 'nt_delete.mm').submit();
			}
		})
	}

	if ($('#btnModifym') != null) {
		$('#btnModifym').click(function() {
			$('#frmm').attr('action', 'nt_modify.mm').submit();
		})
	}

	if ($('#btnUpdatem') != null) {
		$('#btnUpdatem').click(function() {
			$('#frmm').attr('action', 'nt_insert.mm').submit();
		})
	}

	if ($('#btnSelectm') != null) {
		$('#btnSelectm').click(function() {
			$('#frmm').attr('action', 'nt_select.mm').submit();
		})
	}
}

let goPage= function(nowPage){
	$('#nowPage').val(nowPage);
	$('#frmm').attr('action', 'nt_select.mm').submit();
}