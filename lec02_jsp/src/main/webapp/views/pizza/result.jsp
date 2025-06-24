<%@page import="org.apache.jasper.tagplugins.jstl.core.Import"%>
<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>피자 주문내역 화면</title>
</head>
<body>
	<h1>주문내역</h1>
	<h4>[고객정보]</h4>
	<ul>
		<li>성함 : <%= request.getAttribute("userName") %></li>
		<li>전화번호 : <%= request.getAttribute("userPhone") %></li>
		<li>이메일 : <%= request.getAttribute("userEmail") %></li>
	</ul>
	<h4>[주문정보]</h4>
	<ul>
		<li>
			사이즈 : <%= request.getAttribute("pizzaSizeStr") %>
		</li>
		<li>
			토핑 : 
			<ul>
				<% Set<String> selectedToppingNames = (Set<String>) request.getAttribute("selectedToppingNames"); %>
				<% for(String toppingName : selectedToppingNames) { %>
					<li><%= toppingName %></li>
				<% } %>
			</ul>
		</li>
	</ul>
	<h4>위와 같이 주문하셨습니다.</h4>
	<h3>총 가격 : <%= request.getAttribute("totalCost") %>원</h3>
	<h4>즐거운 식사 시간되세요~</h4>
</body>
</html>