<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="./js/jquery-3.4.1.js"></script>
</head>
<style>
	body, html {
	margin: 0;
	padding: 0;
	height: 100%;
	}
	
	#insert_f{
		padding-top:100px;
		padding-bottom:300px;
		width:700px;
		background-color:#eee;
		margin: auto;
		height: 2000px;
	}
</style>
<body>
	<div id='insert_f'>
	<h3>${map_f.msg }</h3>
	<form id='frm_f' name='frm_f' method='post'>
		<input type='text' name='rCode' value='${map_f.rCode }'/>
	</form>
	<input type='button' name='btnRoomInsert_f' id='btnRoomInsert_f' value='방 추가하기'/>
	<input type='button' name='btnFirst_f' id='btnFirst_f' value='처음으로'/>
	</div>
	<script>
		$('#btnRoomInsert_f').click(function(){
			
			$('#frm_f').attr('action','roomInsert.ff').submit();
		});
	</script>
</body>
</html>