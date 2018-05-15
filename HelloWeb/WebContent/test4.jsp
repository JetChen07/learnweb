<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%!int x=-5;
   int y=0;
%>
<% if(x<0){
	y=-1;
}else if(x==0){
	y=0;
}else if (x>0){
	y=1;
} %>
<%out.println("x="+x); %>
<%out.println("y="+y); %>
</body>
</html>