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
	#bed_f{
	height: 55px;
	}
	#bed1_f,#bed2_f,#bed3_f,#bed4_f{
		float : left;
		width:53px;
		height: 53px;
		margin-left:4px;
		text-align: center;
		cursor: pointer;
	}
	
	#bed_f #bed1_f{
		background-image: url('../image/bed1_f.JPG');
	}
	#bed_f #bed2_f{
		background-image: url('../image/bed2_f.jpg');
	}
	#bed_f #bed3_f{
		background-image: url('../image/bed3_f.jpg');
	}
	#bed_f #bed4_f{
		background-image: url('../image/bed4_f.jpg');
	}
</style>
<body>
	<div id='insert_f'>
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
		<input type="text" id="address" value="" style="width:240px;" readonly/>
		<input type="text" name="rPlace" id='rPlace_f' value="" style="width:100px;" readonly/>
		<br/>
		<label>상세주소</label>
		<input type="text" id="address_etc" value="" style="width:200px;"/>	
		<input type='hidden' name='stars' id='stars'/>
		<br/>
		<label>숙소 소개 (간단히)</label><br/>
		<textarea rows="5" cols="40" id='ginfo'></textarea>
		
		<br/>
		<label>숙소 타입</label>
		<select>
			<option value='1'>모텔</option>
			<option value='2'>호텔</option>
			<option value='3'>펜션</option>
			<option value='4'>게스트하우스</option>
		</select>
		<select>
			<option value=''></option>
			<option value='1'>5성급</option>
			<option value='2'>특1급</option>
			<option value='3'>특급</option>
		</select>
		<select>
			<option value=''></option>
			<option value='1'>펜션</option>
			<option value='2'>풀빌라</option>
			<option value='3'>럭셔리</option>
		</select>
		
		<br/>
		<label>체크인 시간, 체크아웃 시간</label>
		<input type="time"/>
		<input type="time"/>
		
		<br/>
		<label>건물 사진을 선택해주세요</label><br/>
		<input type="file" name='photo' id='photo'/><br/>
		<img width='500px' height='300px' id = 'pre'/>
		
		<br/>
		<label>기타</label>
		<div id='agree_f'><input type="checkbox" name='pet' id='agree_check1_f' /><label for='agree_check1_f'><span></span>&nbsp;&nbsp;&nbsp;동물동반가능</label></div>
		<div id='agree_f'><input type="checkbox" name='smoke' id='agree_check2_f' /><label for='agree_check2_f'><span></span>&nbsp;&nbsp;&nbsp;객실내흡연</label></div>
		<div id='agree_f'><input type="checkbox" name='noSmoke' id='agree_check3_f' /><label for='agree_check3_f'><span></span>&nbsp;&nbsp;&nbsp;급연</label></div>
		<div id='agree_f'><input type="checkbox" name='parking' id='agree_check4_f' /><label for='agree_check4_f'><span></span>&nbsp;&nbsp;&nbsp;주차</label></div>
		<div id='agree_f'><input type="checkbox" name='breakfast' id='agree_check5_f' /><label for='agree_check5_f'><span></span>&nbsp;&nbsp;&nbsp;조식</label></div>
		<label>공용시설</label>
		<div id='agree_f'><input type="checkbox" name='pt' id='agree_check6_f' /><label for='agree_check6_f'><span></span>&nbsp;&nbsp;&nbsp;피트니스</label></div>
		<div id='agree_f'><input type="checkbox" name='pool' id='agree_check7_f' /><label for='agree_check7_f'><span></span>&nbsp;&nbsp;&nbsp;수영장</label></div>
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
		<h3>객실 정보</h3>
		<div id=room_f>
			<label>방이름</label><br/>
			<input type='text' name='roomName'/>
			
			<br/>
			<label>수용 가능 인원</label><br/>
			<select>
				<option value='1'>1명</option>
				<option value='2'>2명</option>
				<option value='3'>3명</option>
				<option value='4'>4명</option>
				<option value='5'>5명</option>
				<option value='6'>6명</option>
				<option value='7'>7명</option>
				<option value='8'>8명</option>
				<option value='9'>9명</option>
				<option value='10'>10명</option>
			</select>
			
			<br/>
			<label>가격</label><br/>
			<input type='text' name='price'><label>원</label><br/>
			
			<br/>
			<label>객실내시설</label>
			<div id='agree_f'><input type="checkbox" name='tv' id='agree_check16_f' /><label for='agree_check16_f'><span></span>&nbsp;&nbsp;&nbsp;TV</label></div>
			<div id='agree_f'><input type="checkbox" name='wifi' id='agree_check17_f' /><label for='agree_check17_f'><span></span>&nbsp;&nbsp;&nbsp;WIFI</label></div>
			<div id='agree_f'><input type="checkbox" name='shower' id='agree_check18_f' /><label for='agree_check18_f'><span></span>&nbsp;&nbsp;&nbsp;샤워실</label></div>
			<div id='agree_f'><input type="checkbox" name='aircon' id='agree_check19_f' /><label for='agree_check19_f'><span></span>&nbsp;&nbsp;&nbsp;에어컨</label></div>
			<div id='agree_f'><input type="checkbox" name='spa' id='agree_check20_f' /><label for='agree_check20_f'><span></span>&nbsp;&nbsp;&nbsp;스파</label></div>
			<div id='agree_f'><input type="checkbox" name='tub' id='agree_check21_f' /><label for='agree_check21_f'><span></span>&nbsp;&nbsp;&nbsp;욕조</label></div>
			<div id='agree_f'><input type="checkbox" name='computer' id='agree_chec22_f' /><label for='agree_check22_f'><span></span>&nbsp;&nbsp;&nbsp;컴퓨터</label></div>
			<div id='agree_f'><input type="checkbox" name='iron' id='agree_chec23_f' /><label for='agree_check23_f'><span></span>&nbsp;&nbsp;&nbsp;다리미</label></div>
			<div id='agree_f'><input type="checkbox" name='refr' id='agree_chec24_f' /><label for='agree_check24_f'><span></span>&nbsp;&nbsp;&nbsp;냉장고</label></div>
			<div id='agree_f'><input type="checkbox" name='socket' id='agree_check25_f' /><label for='agree_check25_f'><span></span>&nbsp;&nbsp;&nbsp;개인콘센트</label></div>
			
			<h4 class='bed_f'>베드타입</h4>
				<input type='hidden' name='bedtype' value="${empty bedtype?'5':bedtype }" id='bedtype_f'/><!-- 베드 타일 보낼 히든 태그 -->
				<div id='bed_f'>
					<div id='bed1_f'>
					</div>
					<div id='bed2_f'>
					</div>
					<div id='bed3_f'>
					</div>
					<div id='bed4_f'>
					</div>
				</div>
			
			<br/>
			<label>방 사진을 선택해주세요</label><br/>
			<input type="file" name='photo' id='photo'/><br/>
			<img width='500px' height='300px' id = 'pre'/>
		</div>
		
		<input type='button' value='+++객실 추가 작성 하기+++'/>
		
		<input type='button' value='등록 하기!!!!!!!!!!!!!!!!!!!'/>
		
	</div>
	<script>
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
	</script>	
</body>
</html>