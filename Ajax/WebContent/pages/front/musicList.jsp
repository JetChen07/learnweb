<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="resources/js/jquery-1.4.2.js"></script>
<title>Insert title here</title>
</head>
<body>
		<h3><%=basePath %></h3>
		<table>
			<tr>
				<td>
					<input type="button" value="流行歌曲"  id="lx">
				</td>
				<td>
					<input type="button" value="经典歌曲"  id="jd">
				</td>
				<td>
					<input type="button" value="摇滚歌曲"  id="yg">
				</td>
			</tr>
			<tr>
				<td>
					<span class="tip1" style="color:red;font-size:12px"></span>
				</td>
			</tr>
			<tr>
				<td>
					<span class="tip2" style="color:red;font-size:12px"></span>
				</td>
			</tr>
				
			<tr>
			<td>
				<td>
					<span class="tip3" style="color:red;font-size:12px"></span>
				</td>
			</tr>
		</table>
		
			
</body>

<script type="text/javascript">
	$("#lx").click(function(){
	//单击登录按钮的时候触发ajax事件
		$.ajax({
			url:"<%=basePath%>/musicListServlet",
			type:"post",
			data:{
				command:"lx",
			},
			dataType:"json",
			success:function(result){
				var first = result.first;
				var second = result.second;
				var third = result.third;
				$(".tip1").text(first);
				$(".tip2").text(second);
				$(".tip3").text(third);
				<%-- window.location.href="<%=basePath%>/pages/front/musicList.jsp"; --%>
				
			}
		
		});
	});
	
	$("#jd").click(function(){
		//单击登录按钮的时候触发ajax事件
		$.ajax({
			url:"<%=basePath%>/musicListServlet",
			type:"post",
			data:{
				command:"jd",
			},
			dataType:"json",
			success:function(result){
				var first = result.first;
				var second = result.second;
				var third = result.third;
				$(".tip1").text(first);
				$(".tip2").text(second);
				$(".tip3").text(third);
				<%-- window.location.href="<%=basePath%>/pages/front/musicList.jsp"; --%>
				
			}
			
		});
	});
	$("#yg").click(function(){
		//单击登录按钮的时候触发ajax事件
		$.ajax({
			url:"<%=basePath%>/musicListServlet",
			type:"post",
			data:{
				command:"yg",
			},
			dataType:"json",
			success:function(result){
				var first = result.first;
				var second = result.second;
				var third = result.third;
				$(".tip1").text(first);
				$(".tip2").text(second);
				$(".tip3").text(third);
				<%-- window.location.href="<%=basePath%>/pages/front/musicList.jsp"; --%>
				
			}
			
		});
	});
</script>
</html>