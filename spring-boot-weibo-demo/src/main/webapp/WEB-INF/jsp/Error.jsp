<!DOCTYPE html>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html lang="en">
<header>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="/css/bootstrap.min.css" />
	<link rel="stylesheet" href="/css/bootstrap-theme.min.css" />
	<link rel="stylesheet" href="css/styles.css" />

	<script src="/js/jquery/jquery-2.1.1.min.js"></script>
	<script src="/js/bootstrap/bootstrap.min.js"></script>
	<script src="/js/angular/angular.min.js"></script>
	<script src="/js/angular/angular-route.min.js"></script>
	<script src="/js/bootstrap/ui-bootstrap-custom-0.12.0.min.js"></script>
	<script src="/js/bootstrap/ui-bootstrap-custom-tpls-0.12.0.min.js"></script>
	<script src="/js/bootstrap/jquery-bootpag.js"></script>
	<script src="/js/custom/custom.js"></script>

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
