<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<% String basePath = this.getServletContext().getContextPath(); %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>图书后台管理</title>
</head>
<body>
	<p><a href="./catgory.jsp" target="main">分类添加</a></p>
	<p><a href="<%=basePath%>/ToAddBookServlet" target="main">图书添加</a></p>
	<p><a href="<%=basePath%>/SelectBookServlet" target="main">图书查询</a></p>
</body>
</html>