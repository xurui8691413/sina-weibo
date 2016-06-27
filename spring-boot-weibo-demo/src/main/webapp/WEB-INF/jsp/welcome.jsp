<!DOCTYPE html>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html lang="en">
<header>
	<meta charset="UTF-8">
	<title>List latest Sina Weibo</title>
	<link rel="stylesheet" href="/css/bootstrap.min.css" />
	<link rel="stylesheet" href="/css/bootstrap-theme.min.css" />
	<link rel="stylesheet" href="/css/styles.css" />

	<script src="/js/jquery/jquery-2.1.1.min.js"></script>
	<script src="/js/bootstrap/bootstrap.min.js"></script>
	<script src="/js/bootstrap/jquery-bootpag.js"></script>
	<script src="/js/custom/custom.js"></script>

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
<%--<script>--%>
	<%--var size = '${pages}';--%>
	<%--alert('${totalWeibos}');--%>
	<%--$('.demo2').bootpag({--%>
		<%--total: size,--%>
		<%--page: 1,--%>
		<%--maxVisible: 10--%>
	<%--}).on('page', function(event, num){--%>

		<%--$.ajax({--%>
			<%--url: "${pageContext.servletContext.contextPath }/weibo/"+num,--%>
			<%--type: "POST",--%>
<%--//			dataType: "json",--%>
<%--//			data: JSON.stringify(fieldsort),--%>
<%--//			contentType: "application/json;charset=UTF-8",--%>
			<%--success: function (data) {--%>
				<%--$(".content2").html(data + num);--%>
			<%--},--%>
			<%--error: function (data, status, err) {--%>
				<%--alert('Error', data.responseText);--%>
			<%--}--%>
		<%--});--%>
		<%--//$(".content2").html("asdasd " + num); // or some ajax content loading...--%>
	<%--});--%>
<%--</script>--%>
<script>

	<%--var Custom_JS = (function(){--%>
		<%--return {--%>
			<%--paging_fun : function() {--%>
				<%--var size = '${pages}';--%>
				<%--$('.demo2').bootpag({--%>
					<%--total: size,--%>
					<%--page: 1,--%>
					<%--maxVisible: 10--%>
				<%--}).on('page', function(event, num){--%>

					<%--$.ajax({--%>
						<%--url: "${pageContext.servletContext.contextPath }/weibo/"+num,--%>
						<%--type: "POST",--%>
						<%--success: function (data) {--%>
							<%--$(".content2").html(data + num);--%>
						<%--},--%>
						<%--error: function (data, status, err) {--%>
							<%--alert('Error', data.responseText);--%>
						<%--}--%>
					<%--});--%>
				<%--});--%>
			<%--}--%>
		<%--};--%>
	<%--})();--%>
	<%--$(function() {--%>
		<%--alert(1);--%>
		<%--Custom_JS.paging_fun();--%>
	<%--});--%>
</script>
</body>

</html>
