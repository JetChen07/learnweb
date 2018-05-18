<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
        <%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>课程查询</title>
<!-- 分页查看 -->
<link rel="stylesheet" type="text/css" href="resources/js/dataTable/jquery.dataTables.min.css">
<script type="text/javascript" src="resources/js/dataTable/jquery.js"></script>
<script type="text/javascript" src="resources/js/dataTable/jquery.dataTables.min.js"></script>
</head>
<body>
	<center>
		<h1>课程查询</h1>
		<hr>
		<table cellspacing="0px" cellpadding="0px" border="1px" width="100%" class="tablelist" id="example">
			<thead>
				<tr>
					<th>课程ID</th>
					<th>课程名</th>
					<th>方向</th>
					<th>描述</th>
					<th>时长(小时)</th>
					<th>操作人</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="course"  items="${courselist}" varStatus="status">
					<tr>
						<td>${course.id }</td>
						<td>${course.name }</td>
						<td>${course.direction }</td>
						<td>${course.description }</td>
						<td>${course.time }</td>
						<td>${course.operator }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</center>
	
</body>
</html>