<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.imooc.bean.*,com.imooc.db.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <%
     String account = request.getParameter("account");
     String password = request.getParameter("password");
     //out.println("account="+account+"||password="+password);
     Emp emp = new Emp(account,null,password,null);
     
    if(DBUtil.selectEmpByAccountAndPassword(emp)==true){
    %>
    	<h3 align="center">欢迎来到人事管理页面首页</h3>
    	<hr>
    	<table>
    		<tr>
    		  <td>
    		          	 账号
    		  </td>
    		  <td>
    		  		 	名字
    		  </td>
    		  <td>
    		    		密码
    		  </td>
    		  <td>
    		  			 邮箱
    		  </td>
    		</tr>
    		<%for(String key:DBUtil.map.keySet()){
    			Emp e =DBUtil.map.get(key);
    		%>
    		<tr>
    		  <td>
    		    <%=e.getAccount() %>
    		  </td>
    		  <td>
    		   <%= e.getName() %>
    		  </td>
    		  <td>
    		    <%=e.getPassword()%>
    		  </td>
    		  <td>
    		    <%=e.getEmail() %>
    		  </td>
    		</tr>
    		<% } %>
    	</table>
    <%
    }else{
    	out.println("用户和密码错误");
    }
   %>
</body>
</html>