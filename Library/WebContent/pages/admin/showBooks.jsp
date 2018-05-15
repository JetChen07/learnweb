<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="com.library.domain.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<% String basePath = this.getServletContext().getContextPath(); %>
	<%List<Book>books =null;
	try{
	  books = (List<Book>)request.getAttribute("books");
	}catch(Exception e){
		e.printStackTrace();
	}
	%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>图书查询</title>
<script type="text/javascript" src="<%=basePath%>/resources/js/jquery-1.4.2.js"></script>
</head>
<body>
	<center>
		<h1>图书查询</h1>
		<form action="<%=basePath%>/SelectBookServlet" method="post">
			图书ID：<input type="text" name="bookID">
			图书名：<input type="text" name="bookName">
			分类：<input type="text" name="catgoryName">
			<input type="submit" value="查询" id="search">
		</form>
		<hr>
		<table width="800px" cellspacing="0px" cellpadding="0px" border="1px">
			<thead>
				<tr>
					<th>图书ID</th>
					<th>书名</th>
					<th>分类</th>
					<th>价格</th>
					<th>描述</th>
				</tr>
			</thead>
			
			<tbody id="cont">
			
				<%if(books!=null){
					System.out.println("books!=null");
					for(Book book:books){ 
						System.out.println(book.getName());%>
				
					<tr>
						<td><%=book.getId() %></td>
						<td><%=book.getName() %></td>
						<td><%=book.getCatalog() %></td>
						<td><%=book.getPrice() %></td>
						<td><%=book.getDesc() %></td>
					</tr>
					<%} 
				}%>
			</tbody>
		</table>
	</center>
	
</body>
</html>