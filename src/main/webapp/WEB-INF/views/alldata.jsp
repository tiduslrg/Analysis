<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>University Enrollments</title>

<style>
tr:first-child {
	font-weight: bold;
	background-color: #C6C9C4;
}
</style>

</head>


<body>
	<h2>List of VC</h2>
	<table>
		<tr>
			<td>主机号</td>
			<td>交易</td>
			<td>日期</td>
			<td>总量</td>
			<td>方差</td>
			<td>变异系数</td>
		</tr>
		<c:forEach items="${data}" var="item">
			<tr>
				<td>${item.NODE_ID}</td>
				<td>${item.BIZ_CODE}</td>
				<td>${item.DATE}</td>
				<td>${item.AMOUNT}</td>
				<td>${item.VARIANCE}</td>
				<td>${item.COFFICIENT}</td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<!--  <a href="<c:url value='/new' />">Add New Employee</a> -->
</body>
</html>