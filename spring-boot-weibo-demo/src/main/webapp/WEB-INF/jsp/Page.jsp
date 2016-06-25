<!DOCTYPE html>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html lang="en">
<header>
	<meta charset="UTF-8">

</header>
<body>

<table class="table table-striped">
	<tr>

		<th width="160">#</th>
		<th width="160">Nickname</th>

		<th width="160">Date</th>
	</tr>
	<c:forEach items="${entities}" var="student" varStatus="status">
		<tr >
			<td><c:out value="${status.index +1}"/></td>
			<td><c:out value="${student.user.screenName}"/></td>

			<td><fmt:formatDate value="${student.createdAt}"  type="both" pattern="yyyy-MM-dd"/></td>
		</tr>
	</c:forEach>
</table>
</body>

</html>
