<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel='stylesheet' type='text/css' href='./css/f_roomsCss.css'/>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="./js/jquery-3.4.1.js"></script>
<script src='./js/f_roomsJs.js'></script>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

</head>
<body>
	<%
		String rooms_list = "rooms_list.jsp";
		if(request.getParameter("rooms_list")!=null){
			rooms_list = request.getParameter("rooms_list");
		}
	%>
	<div id ='main_f'><!-- 메인 -->
		<form id='frm_f' name='frm_f' method='post'>
			<input type="hidden" name='target' value="/hrooms.jsp"/>
			<input type='hidden' name='nowPage_f' id='nowPage_f' value='${empty param.nowPage_f?1:param.nowPage_f }'/>
			<input type='hidden' name='aType' id='aType' value='2'/>
			<input type="hidden" name='place_f' id='place_f' value='구전체호텔,.,.,.'/>
			<input type="hidden" name='sort_f' id='sort_f' value='asc'/>
		<div id ='top_f'><!-- 위에 -->
			<div id='top_in_f'>
				<h1>호텔</h1>
				<div id='goo_select_f'>
					<div id='goo_f'>
						<span>호텔전체 > ${empty param.place_f?'구전체호텔':param.place_f } ▼</span>
					</div>
					<div id='goo_list_f'>
						<div id='goo1_f' onclick='goo1()'>도봉구 · 강북구 · 노원구 · 성북구</div>
						<div id='goo2_f' onclick='goo2()'>중랑구 · 동대문구 · 성동구 · 광진구</div>
						<div id='goo3_f' onclick='goo3()'>은평구 · 종로구 · 서대문구</div>
						<div id='goo4_f' onclick='goo4()'>중구 · 마포구 · 용산구</div>
						<div id='goo5_f' onclick='goo5()'>강동구 · 송파구 · 강남구</div>
						<div id='goo6_f' onclick='goo6()'>서초구 · 동작구 · 관악구 · 금천구</div>
						<div id='goo7_f' onclick='goo7()'>강서구 · 양천구 · 구로구 · 영등포구</div>
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
						<input type="text" name="checkIn" id="checkIn_f" value="체크인 날짜 선택"><br/>
						<label>체크아웃</label><br/>
						<input type="text" name="checkOut" id="checkOut_f" value="체크아웃 날짜 선택"><br/>				
						<hr/>
						
						
						
						
						<h3>상세조건</h3>
						<input type='submit' name='btnReset' id='h_btnReset_f' class='btnReset_f' value='초기화'/>
						<input type='submit' name='btnApply' id='h_btnApply_f' class='btnApply_f' value='적용'/><br/>
						
						<h4>호텔유형</h4>
						<div id='chk_f'><input type="radio" name='kind' id='htype1_f' value='1'/><label for='htype1_f'><span></span>&nbsp;&nbsp;&nbsp;5성급</label></div>
						<div id='chk_f'><input type="radio" name='kind' id='htype2_f' value='2'/><label for='htype2_f'><span></span>&nbsp;&nbsp;&nbsp;특1급</label></div>
						<div id='chk_f'><input type="radio" name='kind' id='htype3_f' value='3'/><label for='htype3_f'><span></span>&nbsp;&nbsp;&nbsp;특급</label></div>
						
						<h4>인원</h4>
						
						<select id='maxPeople' name='maxPeople'>
							<option value="1">1명</option>
							<option value="2">2명</option>
							<option value="3">3명</option>
							<option value="4">4명</option>
							<option value="5">5명</option>
							<option value="6">6명</option>
							<option value="7">7명</option>
							<option value="8">8명</option>
							<option value="9">9명</option>
							<option value="10">10명</option>
						</select>
						
						<h4 class='bed_f'>베드타입</h4>
						<input type='hidden' name='bedtype' value='5' id='bedtype_f'/><!-- 베드 타일 보낼 히든 태그 -->
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
						<div id='chk_f'><input type="checkbox" name='pt' id='public1_f' /><label for='public1_f'><span></span>&nbsp;&nbsp;&nbsp;피트니스</label></div>
						<div id='chk_f'><input type="checkbox" name='swim' id='public2_f' /><label for='public2_f'><span></span>&nbsp;&nbsp;&nbsp;수영장</label></div>
						<div id='chk_f'><input type="checkbox" name='rest' id='public3_f' /><label for='public3_f'><span></span>&nbsp;&nbsp;&nbsp;레스토랑</label></div>
						<div id='chk_f'><input type="checkbox" name='cafe' id='public4_f' /><label for='public4_f'><span></span>&nbsp;&nbsp;&nbsp;카페</label></div>
						<div id='chk_f'><input type="checkbox" name='bar' id='public5_f'/><label for='public5_f'><span></span>&nbsp;&nbsp;&nbsp;BAR</label></div>
						
						<h4>객실내 시설</h4>
						<div id='chk_f'><input type="checkbox" name='tv' id='private1_f' /><label for='private1_f'><span></span>&nbsp;&nbsp;&nbsp;TV</label></div>
						<div id='chk_f'><input type="checkbox" name='wifi' id='private2_f' /><label for='private2_f'><span></span>&nbsp;&nbsp;&nbsp;WIFI</label></div>
						<div id='chk_f'><input type="checkbox" name='spa' id='private3_f' /><label for='private3_f'><span></span>&nbsp;&nbsp;&nbsp;스파</label></div>
						<div id='chk_f'><input type="checkbox" name='tub' id='private4_f' /><label for='private4_f'><span></span>&nbsp;&nbsp;&nbsp;욕조</label></div>
						<div id='chk_f'><input type="checkbox" name='iron' id='private5_f' /><label for='private5_f'><span></span>&nbsp;&nbsp;&nbsp;다리미</label></div>
					
						<h4>기타</h4>
						<div id='chk_f'><input type="checkbox" name='pet' id='etc1_f' /><label for='etc1_f'><span></span>&nbsp;&nbsp;&nbsp;반려동물 동반</label></div>
						<div id='chk_f'><input type="checkbox" name='smoke' id='etc2_f' /><label for='etc2_f'><span></span>&nbsp;&nbsp;&nbsp;객실내 흡연</label></div>
						<div id='chk_f'><input type="checkbox" name='noSmoke' id='etc3_f' /><label for='etc3_f'><span></span>&nbsp;&nbsp;&nbsp;금연</label></div>
						<div id='chk_f'><input type="checkbox" name='parking' id='etc4_f' /><label for='etc4_f'><span></span>&nbsp;&nbsp;&nbsp;주차</label></div>
						<div id='chk_f'><input type="checkbox" name='breakfast' id='etc5_f' /><label for='etc5_f'><span></span>&nbsp;&nbsp;&nbsp;조식</label></div>
					</div>
				</div>
				<div id ='right_f'>
					<div id ='search_f'><!-- 셀렉트된내용들 -->
						<div id='price_order_f'>
							<input type='button' name='btnAsc' id='h_btnAsc_f' class='btnAsc_f' value='낮은 가격순'/>
							<input type="button" name='btnDsc' id='h_btnDsc_f' class='btnDsc_f' value='높은 가격순'/>
						</div>
						
						<div id='page_change'>
							<h4 id='pricename'>낮은 가격순</h4>
							
							<jsp:include page="<%=rooms_list %>"></jsp:include>
							
							
							<div id ='paging_f'>
							<c:if test="${p_f.nowPage > p_f.blockSize }">
								<input type='button'  class='btnBefore_f' onclick='goPage(1)'/>
							</c:if>
							
							<c:forEach var='i' begin='${p_f.startPage }' end='${p_f.endPage }'>
								<input type='button' id='btnMiddle_f' value='' ${(i==p_f.nowPage)? "class='here_f'":""} onclick='goPage(${i})'/>
							</c:forEach>
							
							<c:if test="${p_f.nowPage <p_f.totPage }">
								<input type='button'  class='btnAfter_f' onclick='goPage(${p_f.nowPage+1})'/>
							</c:if>
							</div>
						
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















