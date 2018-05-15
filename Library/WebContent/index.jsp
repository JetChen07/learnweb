<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<% String basePath = this.getServletContext().getContextPath(); 
	String flag = request.getParameter("flag");%>

<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>图书后台管理登录界面</title>
</head>
<script type="text/javascript">
    var flag = '<%=flag %>';
    if("1"==flag){
    	alert("请登录系统！");
    }else if("2"==flag){
    	alert("账户密码错误！");
    }else if ("3"==flag){
    	alert("账户格式不对！");
    }else if ("4"==flag){
    	alert("密码格式不对！");
    }
</script>
<body>
	<center>
		<h1>登录 | <a href="<%=basePath%>/regist.jsp">注册</a></h1>
		<form action="<%=basePath%>/LoginServlet" method="post">
			<table width="350px" cellspacing="0px" cellpadding="0px" border="1px">
				<tr>
					<td>用户名</td>
					<td><input type="text" name="username" placeholder="用户名为3-12位字母数字"  pattern="[a-zA-Z_0-9]{3,12}" required="required"></td>
				</tr>
				<tr>
					<td>密&nbsp;码</td>
					<td><input type="password" name="password" placeholder="长度为6-12位的纯数字" pattern="[0-9]{6,12}" required="required"></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align:center">
						<input type="submit" value="登录">
						<input type="reset" value="取消">
					</td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>