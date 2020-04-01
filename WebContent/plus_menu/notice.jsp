<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel='stylesheet' type='text/css' href='./css/bootstrap.min.css'/>
<link rel='stylesheet' type='text/css' href='./css/accordion.css'/>
<script src = '../js/jquery-3.4.1.js'></script>
<script src = './notice.js'></script>
</head>
<body>
<div class="container-fluid" style="height : 162px;">
<%
String inc = "./index_m.jsp";
if(request.getParameter("inc") !=null){
	inc = request.getParameter("inc");
}
String sp = "./nt_select.jsp";
if(request.getParameter("sp") != null){
	sp = request.getParameter("sp");
}
%>

<img src="./image/dobogo.png" class="img-responsive" alt="Responsive image">
</div>
<div class="container" style='border: 1px solid #ffffff'>
  <div class="row">
    <div class="col-3" style='border: 1px solid #ffffff; cursor : pointer;' >
	<ul>
		<jsp:include page="<%=inc %>"/>
	</ul>
    </div>
    <div class="col-9" style='border: 1px solid #ffffff'>
    
		<jsp:include page="<%=sp %>"/>
	
    </div>
  </div>

</div>

</body>
</html>