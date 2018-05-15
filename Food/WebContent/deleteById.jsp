<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<% String basePath = this.getServletContext().getContextPath(); %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>菜品删除(根据ID删)</title>
<style type="text/css">

</style>
</head>
<body>
	<center>
		<%
			String msg = "";
			if(request.getAttribute("msg")!=null){
				msg = (String)request.getAttribute("msg");
			}
		%>
		<h3><%=msg %></h3>
		<h1>菜品删除(根据ID删除)</h1>
		<form action="<%=basePath%>/FoodDeleteServlet" method="post">
			<table width="400px" border="1px" cellspacing="0px" cellpadding="0px">
				<tr>
					<td>菜品ID</td>
					<td><input type="text" name="id"></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align:center"><input type="submit" value="删除"></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>