<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<% String basePath = this.getServletContext().getContextPath(); %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>菜名查询</title>
<style type="text/css">

</style>
</head>
<body>
	<center>
		<h1>菜名查询</h1>
		<form action="<%=basePath%>/SelectServlet" method="post">
			<input type="hidden" name="type" value="2">
			<table width="400px" border="1px" cellspacing="0px" cellpadding="0px">
				<tr>
					<td>菜名</td>
					<td><input type="text" name="foodName"></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align:center"><input type="submit" value="查询"></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>