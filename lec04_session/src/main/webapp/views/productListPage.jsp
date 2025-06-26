<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.practice04.dto.Account" %>
<%@ page import="com.practice05.dto.Product" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록 페이지</title>
</head>
<body>
	<% 
		List<Product> productList = (ArrayList<Product>) request.getAttribute("productList");
		if (productList != null) {
	%>
	<!-- AddToCartServlet 으로 요청을 보냄 -->
	<form action="/addToCart" method="post">
		<select name="productCode">
			<%
				for(Product p : productList) { %>
					<option value="<%= p.getCode() %>"><%= p.getName() %> | <%= p.getPrice() %>원</option>
			<%
				}
			%>
		</select>
		<button>장바구니에 추가</button>
	</form>
	<%
		}
	%>
	<a href="/cartList">장바구니 확인</a>
</body>
</html>