<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel='stylesheet' type='text/css' href='./css/f_roomsCss.css'/>
<script src="./js/jquery-3.4.1.js"></script>
<script src='./js/f_roomsJs.js'></script>

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

</head>
<body>
	<div id ='main_f'><!-- 메인 -->
		<form id='frm_f' name='frm_f' method='post'>
		<div id ='top_f'><!-- 위에 -->
			<div id='top_in_f'>
				<h1>펜션</h1>
				<div id='goo_select_f'>
					<div id='goo_f'>
						<span>펜션전체 > 구 전체펜션 ▼</span>
					</div>
					<div id='goo_list_f'>
						<div id='goo1_f' onclick=''>도봉구 · 강북구 · 노원구 · 성북구</div>
						<div id='goo2_f' onclick=''>중랑구 · 동대문구 · 성동구 · 광진구</div>
						<div id='goo3_f' onclick=''>은평구 · 종로구 · 서대문구</div>
						<div id='goo4_f' onclick=''>중구 · 마포구 · 용산구</div>
						<div id='goo5_f' onclick=''>강동구 · 송파구 · 강남구</div>
						<div id='goo6_f' onclick=''>서초구 · 동작구 · 관악구 · 금천구</div>
						<div id='goo7_f' onclick=''>강서구 · 양천구 · 구로구 · 영등포구</div>
					</div>
				</div>
				<div id='topImg_f'>
				</div>
			</div>
		</div>
		<div id ='mid_f'>
			<div id ='mid_in_f'>
				<div id='left_f'>
					<div id='check_f'><!-- 체크박스 들어간 div -->
						<h3>날짜</h3>
						<label>체크인</label><br/>
						<input type="text" name="" id="checkIn_f" value="체크인 날짜 선택"><br/>
						<label>체크아웃</label><br/>
						<input type="text" name="" id="checkOut_f" value="체크아웃 날짜 선택"><br/>				
						<hr/>
						
						<h3>상세조건</h3>
						<input type='button' name='btnReset' id='c_btnReset_f' class='btnReset_f' value='초기화'/>
						<input type='button' name='btnApply' id='c_btnApply_f' class='btnApply_f' value='적용'/><br/>
						
						<h4>펜션유형</h4>
						<div id='chk_f'><input type="checkbox" name='htype' id='htype1_f' value=''/><label for='htype1_f'><span></span>&nbsp;&nbsp;&nbsp;펜션</label></div>
						<div id='chk_f'><input type="checkbox" name='htype' id='htype2_f' value=''/><label for='htype2_f'><span></span>&nbsp;&nbsp;&nbsp;풀빌라</label></div>
						<div id='chk_f'><input type="checkbox" name='htype' id='htype3_f' value=''/><label for='htype3_f'><span></span>&nbsp;&nbsp;&nbsp;럭셔리</label></div>
						
						<h4>인원</h4>
						<select name=''>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
							<option value="7">7</option>
							<option value="8">8</option>
							<option value="9">9</option>
							<option value="10">10</option>
						</select>
						
						<h4 class='bed_f'>베드타입</h4>
						<input type='hidden' name='bedtype' value='1' id='bedtype_f'/><!-- 베드 타일 보낼 히든 태그 -->
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
						
						
						<h4>공용시설</h4>
						<div id='chk_f'><input type="checkbox" name='public' id='public1_f' value=''/><label for='public1_f'><span></span>&nbsp;&nbsp;&nbsp;피트니스</label></div>
						<div id='chk_f'><input type="checkbox" name='public' id='public2_f' value=''/><label for='public2_f'><span></span>&nbsp;&nbsp;&nbsp;수영장</label></div>
						<div id='chk_f'><input type="checkbox" name='public' id='public3_f' value=''/><label for='public3_f'><span></span>&nbsp;&nbsp;&nbsp;카페</label></div>
						<div id='chk_f'><input type="checkbox" name='public' id='public4_f' value=''/><label for='public4_f'><span></span>&nbsp;&nbsp;&nbsp;조식</label></div>
						<div id='chk_f'><input type="checkbox" name='public' id='public5_f' value=''/><label for='public5_f'><span></span>&nbsp;&nbsp;&nbsp;바</label></div>
						
						<h4>객실내 시설</h4>
						<div id='chk_f'><input type="checkbox" name='private' id='private1_f' value=''/><label for='private1_f'><span></span>&nbsp;&nbsp;&nbsp;TV</label></div>
						<div id='chk_f'><input type="checkbox" name='private' id='private2_f' value=''/><label for='private2_f'><span></span>&nbsp;&nbsp;&nbsp;WIFI</label></div>
						<div id='chk_f'><input type="checkbox" name='private' id='private3_f' value=''/><label for='private3_f'><span></span>&nbsp;&nbsp;&nbsp;샤워실</label></div>
						<div id='chk_f'><input type="checkbox" name='private' id='private4_f' value=''/><label for='private4_f'><span></span>&nbsp;&nbsp;&nbsp;에어컨</label></div>
						<div id='chk_f'><input type="checkbox" name='private' id='private5_f' value=''/><label for='private5_f'><span></span>&nbsp;&nbsp;&nbsp;스파</label></div>
					
						<h4>기타</h4>
						<div id='chk_f'><input type="checkbox" name='etc' id='etc1_f' value=''/><label for='etc1_f'><span></span>&nbsp;&nbsp;&nbsp;반려동물 동반</label></div>
						<div id='chk_f'><input type="checkbox" name='etc' id='etc2_f' value=''/><label for='etc2_f'><span></span>&nbsp;&nbsp;&nbsp;객실내흡연</label></div>
						<div id='chk_f'><input type="checkbox" name='etc' id='etc3_f' value=''/><label for='etc3_f'><span></span>&nbsp;&nbsp;&nbsp;금연</label></div>
						<div id='chk_f'><input type="checkbox" name='etc' id='etc4_f' value=''/><label for='etc4_f'><span></span>&nbsp;&nbsp;&nbsp;주차</label></div>
						<div id='chk_f'><input type="checkbox" name='etc' id='etc5_f' value=''/><label for='etc5_f'><span></span>&nbsp;&nbsp;&nbsp;조식</label></div>
					</div>
				</div>
				<div id ='right_f'>
					<div id ='search_f'><!-- 셀렉트된내용들 -->
						<div id='price_order_f'>
							<input type='button' name='btnAsc' id='c_btnAsc_f' class='btnAsc_f' value='낮은 가격순'/>
							<input type="button" name='btnDsc' id='c_btnDsc_f' class='btnDsc_f' value='높은 가격순'/>
						</div>
						
						<div id='page_change'>
							<h4 id='pricename'>낮은 가격순</h4>
							
							<jsp:include page='rooms_list.jsp'/>
						</div>
						
					</div>
				</div>
			</div>
		</div>
		</form>
	</div>
	
	

<script>
	event_f();
	btnFunc_f();
</script>
</body>
</html>