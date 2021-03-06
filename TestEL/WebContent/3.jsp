<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>jstl常用标签</title>
</head>
<body>
	<!-- set、out、remove 标签 -->
	<!-- set标签主要是往指定的域中存放数据 -->
	<c:set var="user" value="张三" scope="request"></c:set>
	<!-- 将数据打印显示 -->
	<c:out value="${user}"></c:out>
	<!-- remove标签 -->
	<hr><hr>
	<c:remove var="user" scope="request"/>
	<c:out value="${user}"></c:out>
</body>
</html>