<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>   
    <%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>管理员查询</title>
</head>
<body>
	<center>
		<h1>管理员查询</h1>
		<hr>
		<table cellspacing="0px" cellpadding="0px" border="1px" width="600px">
			<thead>
				<tr>
					<th>用户名</th>
					<th>密码</th>
					<th>类型</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${userlist}" varStatus="status">
					<tr>
						<td>${user.name }</td>
						<td>${user.password}</td>
						<td>
						<c:choose> 
							<c:when test="${user.manager}">
								超级管理员
							</c:when>
							<c:otherwise>
								普通管理员
							</c:otherwise>
						</c:choose>
						</td>
						<td><a href="${basePath}/DelUserServlet?username=${user.name }">删除</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</center>
</body>
</html>