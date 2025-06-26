<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.practice04.dto.Account" %>
<%@ page import="com.practice05.dto.Product" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니 목록 확인 화면</title>
</head>
<body>
	<%
		List<Product> addedList = (ArrayList<Product>) session.getAttribute("addedList");
		if (addedList != null) {
			for(Product p : addedList) { %>
		<p><%= p.getName() %> | <%= p.getPrice() %></p>	
	<%
			}
		}
	%>
</body>
</html>