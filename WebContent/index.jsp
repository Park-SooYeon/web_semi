<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WebProject</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/jquery-3.4.1.js"></script>
<link href="css/common.css" rel="stylesheet">
<link href="css/main.css" rel="stylesheet">
<style>
body { padding-top: 40px; }
</style>
</head>
<body>
<div id='main'>
	<!-- top.jsp -->
	<%@ include file="top.jsp" %>
	
	<!-- content -->
	<div class='content'>
		<jsp:include page="main.jsp"/>
	</div>
	
	<!-- bottom.jsp -->
	<%@ include file="bottom.jsp" %>
</div>

<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>