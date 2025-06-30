<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
		1. request에 바인딩 된 값 가져오기
		2. 별 찍기
	 -->
 	 <c:forEach var="i" begin="1" end="${ starNumber }" step="1">
	 	<p>
	 	<c:forEach var="j" begin="1" end="${ i }" step="1">
	 		⭐
	 	</c:forEach>
	 	</p>
	 </c:forEach>
</body>
</html>