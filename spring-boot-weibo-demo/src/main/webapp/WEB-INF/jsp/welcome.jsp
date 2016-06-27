<!DOCTYPE html>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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

<div  class="bs-docs-example">
	<h1>Latest Sina Weibo Result</h1>
	<input id="contextPath" type="hidden" value ="${pageContext.request.contextPath}">
	<input id="pageSize" type="hidden" value ="${pages}">

	<div id="page-selection" class="well demo content2">
		<table class="table table-striped">
			<tr>

				<th width="160">#</th>
				<th width="160">Nickname</th>

				<th width="160">Date</th>
			</tr>
			<c:forEach items="${entities}" var="entity" varStatus="status">
				<tr >
					<td><c:out value="${status.index +1}"/></td>
					<td><c:out value="${entity.user.screenName}"/></td>

					<td><fmt:formatDate value="${entity.createdAt}"  type="both" pattern="yyyy-MM-dd"/></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div id="page-selection1" class="demo demo2"></div>
</div>

</body>

</html>
