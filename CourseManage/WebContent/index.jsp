<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录页面</title>
<style type="text/css">
	.code 
	{
	 background:url(code_bg.jpg);
	 font-family:Arial;
	 font-style:italic;
	 color:blue;
	 font-size:20px;
	 border:0;
	 padding:2px 3px;
	 letter-spacing:3px;
	 font-weight:bolder;
	 float:left;
	 cursor:pointer;
	 width:40x;
	 height:20px;
	 line-height:20px;
	 text-align:center;
	 vertical-align:middle;
	}
	a 
	{
	 text-decoration:none;
	 font-size:12px;
	 color:#288bc4;
	}
	a:hover 
	{
	 text-decoration:underline;
	}
</style>

</head>
<script type="text/javascript">
    var flag = ${param.flag};
    if("1"==flag){
    	alert("请登录系统！");
    }else if("2"==flag){
    	alert("账户密码错误！");
    }else if ("3"==flag){
    	alert("验证码不对！");
    }else if ("4"==flag){
    	alert("密码格式不对！");
    }
</script>
<body ">
	<center>
		<h1>用户登录</h1>
		<form action="${basePath}/LoginServlet" method="post" onsubmit="return validateCode()">
			<table width="300px" cellspacing="0px" cellpadding="0px" border="1px">
				<tr>
					<td>用户名</td>
					<td colspan="2"><input type="text" name="username" placeholder="用户名为3-12位字母数字或下划线组合"></td>
				</tr>
				<tr>
					<td>密&nbsp;码</td>
					<td  colspan="2"><input type="password" name="password" placeholder="长度为5-12位字母数字或下划线组合" ></td>
				</tr>
				<tr>
					<td>验证码</td>
					<td style="border-right-style:none;">
						<input type="text" name="code" placeholder="请输入验证码" id="inputCode">
					</td>
					<td style="border-left-style:none;"><img src="${basePath}/kaptcha.jpg" id="changecode"/></td>
				</tr>
				<tr>
					<td colspan="3" style="text-align:center">
						<input type="submit" value="登录">
						<input type="reset" value="取消">
					</td>
				</tr>
			</table>
		</form>
	</center>

	<script src="${basePath}/js/jquery-1.12.4.min.js" type="text/javascript"></script>
	<script>		
		$(function() {
			$("#changecode").on(
					"click",
					function() {
						$(this).attr(
								"src",
								"${basePath}/kaptcha.jpg?d="
										+ new Date().getTime());
					});
			//给登录按钮绑定点击事件
			$("#login").on(
					"click",
					function() {
						//获取用户输入的验证码
						var code = $("#code").val();
						//alert(code);
						var params = {
							"code" : code
						};
						$.post("${basePath}/login",
								params, function(data) {
									//                if(data=="fail"){
									//                     alert("验证码输入有误!");
									//                }
									if (data == "success") {
										$("#result").html("验证码输入正确");
									} else {
										$("#result").html("验证码输入有误，请重新输入...");
										$("#code").val("").focus();
									}
								});
					});
		})
	</script>
</body>
</html>