<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src = "../js/jquery-3.4.1.js"></script>
<script type="text/JavaScript" src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
</head>
<style>
	body, html {
	margin: 0;
	padding: 0;
	height: 100%;
	}
	
	#insert_f{
		width:700px;
		background-color:#eee;
		margin: auto;
		height: 900px;
	}
	
	#insert_f #agree_f input[type='checkbox'] {
		display: none;
	}
	#insert_f #agree_f input[type='checkbox']+label{
		cursor: pointer;
	}
	#insert_f #agree_f input[type='checkbox']+label span{
	display: inline-block;
	width:20px;
	height: 20px;
	background-color:#fff;
	border: 1px solid #aaa;
	cursor:pointer;
	border-radius: 3px;
	vertical-align:middle;
	box-shadow : 0.2px 0.2px 1px 1px #ccc inset;
	}
	#insert_f #agree_f input[type='checkbox']:checked+label span{
	background-image: url("../image/checked_f.JPG");
	border: 1px solid #f62a4b;
	background-repeat : no-repeat;
	background-size : cover;
	box-shadow : 0.2px 0.2px 1px 1px #f62a4b inset;
	}
	#bedtype_f input[type='radio'] {
		display: none;
	}
	#bedtype_f input[type='radio']+label {
		cursor: pointer;
	}
	#bedtype_f input[type='radio']+label span{
		display: inline-block;
		width:20px;
		height: 20px;
		background-color:#fff;
		border: 1px solid #aaa;
		cursor:pointer;
		border-radius: 3px;
		vertical-align:middle;
		box-shadow : 0.2px 0.2px 1px 1px #ccc inset;
	}
	#bedtype_f input[type='radio']:checked+label span{
		background-image: url("../image/checked_f.JPG");
		border: 1px solid #f62a4b;
		background-repeat : no-repeat;
		background-size : cover;
		box-shadow : 0.2px 0.2px 1px 1px #f62a4b inset;
	}
	#aType_f input[type='radio'] {
		display: none;
	}
	#aType_f input[type='radio']+label {
		cursor: pointer;
	}
	#aType_f input[type='radio']+label span{
		display: inline-block;
		width:20px;
		height: 20px;
		background-color:#fff;
		border: 1px solid #aaa;
		cursor:pointer;
		border-radius: 3px;
		vertical-align:middle;
		box-shadow : 0.2px 0.2px 1px 1px #ccc inset;
	}
	#aType_f input[type='radio']:checked+label span{
		background-image: url("../image/checked_f.JPG");
		border: 1px solid #f62a4b;
		background-repeat : no-repeat;
		background-size : cover;
		box-shadow : 0.2px 0.2px 1px 1px #f62a4b inset;
	}
	
	
</style>
<body>
	<div id='insert_f'>
	<form id='frm_insert_f' name='frm_insert_f' method='post' enctype="multipart/form-data">
		<input type='hidden' name='ceo'/>
	
		<h3>숙박 등록 을 원하시나요?</h3>
		<div>약관을 읽어 보시고 동의 해주세요</div>
		<div id='agree_f'><input type="checkbox" name='Y' id='agree_check_f' /><label for='agree_check_f'><span></span>&nbsp;&nbsp;&nbsp;동의 합니다</label></div>
		<hr/>
		
		<label>숙소 이름</label><br/>
		<input type='text' name='rName' id='rName_f'/><br/><br/>
		
		<label>숙소 지역</label><br/>
		<label>우편번호 - </label>
		<input id="zonecode" type="text" value="" style="width:50px;" readonly/>
		&nbsp;
		<input type="button" onClick="openDaumZipAddress();" value = "주소 찾기" />
		<br/>
		<input type="text" name='adress' id="address" value="" style="width:240px;" readonly/>
		<input type="text" name="rPlace" id='rPlace_f' value="" style="width:100px;" readonly/>
		<br/>
		<label>상세주소</label>
		<input type="text" id="address_etc" value="" style="width:200px;"/>	
		<input type='hidden' name='stars' id='stars' value=''/>
		<br/>
		<label>숙소 소개 (간단히)</label><br/>
		<textarea rows="5" cols="40" id='gInfo' name='gInfo'></textarea>
		
		<br/>
		<label>숙소 타입</label>
		
			<div id='aType_f'><input type="radio" name='aType' class='aType_f' id='aType1_f' value='1'/><label for='aType1_f'><span></span>&nbsp;&nbsp;&nbsp;모텔</label></div>
			<div id='aType_f'><input type="radio" name='aType' class='aType_f' id='aType2_f' value='2'/><label for='aType2_f'><span></span>&nbsp;&nbsp;&nbsp;호텔</label></div>
			<div id='aType_f'><input type="radio" name='aType' class='aType_f' id='aType3_f' value='3'/><label for='aType3_f'><span></span>&nbsp;&nbsp;&nbsp;펜션</label></div>	
			<div id='aType_f'><input type="radio" name='aType' class='aType_f' id='aType4_f' value='4'/><label for='aType4_f'><span></span>&nbsp;&nbsp;&nbsp;게스트하우스</label></div>
			<div id='kind_select1_f'>
			<div id='kind_f'><input type="radio" name='kind' class='kind_f' id='kind1_f' value='1'/><label for='kind1_f'><span></span>&nbsp;&nbsp;&nbsp;5성급</label></div>
			<div id='kind_f'><input type="radio" name='kind' class='kind_f' id='kind2_f' value='2'/><label for='kind2_f'><span></span>&nbsp;&nbsp;&nbsp;특1급</label></div>
			<div id='kind_f'><input type="radio" name='kind' class='kind_f' id='kind3_f' value='3'/><label for='kind3_f'><span></span>&nbsp;&nbsp;&nbsp;특급</label></div>
			</div>
			<div id='kind_select2_f'>
			<div id='kind_f'><input type="radio" name='kind' class='kind_f' id='kind1_f' value='1'/><label for='kind1_f'><span></span>&nbsp;&nbsp;&nbsp;펜션</label></div>
			<div id='kind_f'><input type="radio" name='kind' class='kind_f' id='kind2_f' value='2'/><label for='kind2_f'><span></span>&nbsp;&nbsp;&nbsp;풀빌라</label></div>
			<div id='kind_f'><input type="radio" name='kind' class='kind_f' id='kind3_f' value='3'/><label for='kind3_f'><span></span>&nbsp;&nbsp;&nbsp;럭셔리</label></div>
			</div>
		
		<br/>
		<label>체크인 시간, 체크아웃 시간</label>
		<input type="time" name='checkIn'/>
		<input type="time" name='checkOut'/>
		
		<br/>
		<label>건물 사진을 선택해주세요</label><br/>
		<input type="file" name='rooms_photo' id='rooms_photo'/><br/>
		<img width='500px' height='300px' id = 'rooms_pre'/>
		
		<br/>
		<label>기타</label>
		<div id='agree_f'><input type="checkbox" name='pet' id='agree_check1_f' /><label for='agree_check1_f'><span></span>&nbsp;&nbsp;&nbsp;동물동반가능</label></div>
		
		<div id='agree_f'><input type="checkbox" name='smoke' id='agree_check2_f' /><label for='agree_check2_f'><span></span>&nbsp;&nbsp;&nbsp;객실내흡연</label></div>
		<div id='agree_f'><input type="checkbox" name='noSmoke' id='agree_check3_f' /><label for='agree_check3_f'><span></span>&nbsp;&nbsp;&nbsp;급연</label></div>
		<div id='agree_f'><input type="checkbox" name='parking' id='agree_check4_f' /><label for='agree_check4_f'><span></span>&nbsp;&nbsp;&nbsp;주차</label></div>
		<div id='agree_f'><input type="checkbox" name='breakfast' id='agree_check5_f' /><label for='agree_check5_f'><span></span>&nbsp;&nbsp;&nbsp;조식</label></div>
		<label>공용시설</label>
		<div id='agree_f'><input type="checkbox" name='pt' id='agree_check6_f' /><label for='agree_check6_f'><span></span>&nbsp;&nbsp;&nbsp;피트니스</label></div>
		<div id='agree_f'><input type="checkbox" name='swim' id='agree_check7_f' /><label for='agree_check7_f'><span></span>&nbsp;&nbsp;&nbsp;수영장</label></div>
		<div id='agree_f'><input type="checkbox" name='rest' id='agree_check8_f' /><label for='agree_check8_f'><span></span>&nbsp;&nbsp;&nbsp;레스토랑</label></div>
		<div id='agree_f'><input type="checkbox" name='cafe' id='agree_check9_f' /><label for='agree_check9_f'><span></span>&nbsp;&nbsp;&nbsp;카페</label></div>
		<div id='agree_f'><input type="checkbox" name='bar' id='agree_check10_f' /><label for='agree_check10_f'><span></span>&nbsp;&nbsp;&nbsp;바</label></div>
		<label>공용시설-게스트하우스</label>
		<div id='agree_f'><input type="checkbox" name='washer' id='agree_check11_f' /><label for='agree_check11_f'><span></span>&nbsp;&nbsp;&nbsp;세탁기</label></div>
		<div id='agree_f'><input type="checkbox" name='lounge' id='agree_check12_f' /><label for='agree_check12_f'><span></span>&nbsp;&nbsp;&nbsp;라운지</label></div>
		<div id='agree_f'><input type="checkbox" name='kitchen' id='agree_check13_f' /><label for='agree_check13_f'><span></span>&nbsp;&nbsp;&nbsp;주방</label></div>
		<div id='agree_f'><input type="checkbox" name='dryer' id='agree_check14_f' /><label for='agree_check14_f'><span></span>&nbsp;&nbsp;&nbsp;건조기</label></div>
		<div id='agree_f'><input type="checkbox" name='talsu' id='agree_check15_f' /><label for='agree_check15_f'><span></span>&nbsp;&nbsp;&nbsp;탈수기</label></div>
		
		<hr/>
		
		
		
		</form>
	</div>
		
		<input type='submit' id='btnInsert_f' value='등록 하기!!!!!!!!!!!!!!!!!!!'/>
		
	
	<script>
	$("#btnDiv_f").on("click", function(e){
	      $("#room_in_f").clone().appendTo("#room_f");
	});
	function openDaumZipAddress() {
		new daum.Postcode({
			oncomplete:function(data) {
				$('#rPlace_f').val(data.sigungu);
				$("#zonecode").val(data.zonecode);
				$("#address").val(data.address);
				$("#address_etc").focus();
				console.log(data);
			}
		}).open();

	}
	//호텔사진 변경시
	$('#rooms_photo').change(function(event){
		let ele = event.target;
		let url = ele.files[0];
			
		let reader = new FileReader();
		reader.readAsDataURL(url);
		
		reader.onload = function(e){
			let img = new Image();//이미지 객체 생성하라!!
			img.src = e.target.result;
			$('#rooms_pre').attr('src',img.src);
		}		
	});
	
	$('#btnInsert_f').click(function(){
		$('#frm_insert_f').attr('action','insert.ff');
	});
	//호텔종류,펜션종류 컨트롤
	
	</script>	
</body>
</html>