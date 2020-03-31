<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel='stylesheet' type='text/css' href='../css/bootstrap.min.css'/>
<link rel='stylesheet' type='text/css' href='../css/accordion.css'/>
<script src = '../js/jquery-3.4.1.js'></script>
<script src = './notice.js'></script>
</head>
<body>
<div class="container">
	<div class="row">
	<form method="post" name='frmm' id='frmm'>
		<table class = "talbe table-striped" styple="text-align: center; border:1px solid #dddddd">
		<thead>
			<tr>
				<th colspan="2" style="background-color : #eeeeee; text-align : center;">공지사항 글쓰기</th>
			</tr>
		</thead>
		<tbody>
				<tr>
					<td><input type="text" class="form-control"  placeholder="글제목" name="bbsTitle" maxlength="20"/></td>
					</tr>
					<tr>
					<td><textarea class="form-control"  placeholder="글내용" name="bbsContent" maxlength="500" style="width : 800px; height : 350px; resize : none;"></textarea></td>
				</tr>
		</tbody>
		</table> 
			<input type="button" id="btnSelectm"  value="목록"/>
			<input type="button" id="btnUpdatem"  value="저장 "/>
			<input type="button" id="btnDeletem"  value="삭제 "/>
			
		</form>
	</div> 
</div>
</body>
<script>btnFuncm();</script>
</html>































