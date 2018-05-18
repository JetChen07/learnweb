<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>jstl中的if标签和choose标签</title>
</head>
<body>
	<c:set var="age" value="12" scope="request"></c:set>
	<!-- if标签：
		test:接判断的条件，如果条件为true,这执行标签体中的内容
	-->
	<%-- <c:if test="${age==12 }">
		您的年龄为12岁
	</c:if>
	hello world --%>
	<hr>
	<!-- choose标签 -->
	<c:choose>
		<c:when test="${age==12 }">
		您的年龄为12岁
		</c:when>
		<c:otherwise>
		您的年龄不为12岁
		</c:otherwise>
	</c:choose>
</body>
</html>