<!DOCTYPE html>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<% String basePath=request.getContextPath(); %>
<html lang="en">
<header>
	<meta charset="UTF-8">
	<title>List latest Sina Weibo</title>
	<link rel="stylesheet" href="<%=basePath%>/css/bootstrap.min.css" />
	<link rel="stylesheet" href="<%=basePath%>/css/bootstrap-theme.min.css" />
	<link rel="stylesheet" href="<%=basePath%>/css/styles.css" />

	<script src="<%=basePath%>/js/jquery/jquery-2.1.1.min.js"></script>
	<script src="<%=basePath%>/js/bootstrap/bootstrap.min.js"></script>
	<script src="<%=basePath%>/js/bootstrap/jquery-bootpag.js"></script>
	<script src="<%=basePath%>/js/custom/custom.js"></script>

</header>
<body>
<body>
<h2>System was crashed</h2>
<div class="panel-body" style="border:1px solid #f00;">
	<c:if test="${not empty errMsg}">
		<h2>${errMsg}</h2>
	</c:if>
</div>
</body>
</body>

</html>
