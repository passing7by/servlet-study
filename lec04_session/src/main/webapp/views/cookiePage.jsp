<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 연습 화면</title>
</head>
<body>
	<!-- 
		1. 사용자 닉네임 입력
		2. 쿠키에 저장
		3. 쿠키 삭제
	 -->
	<h1>닉네임 입력</h1>
	<form action="/saveNick" method="post">
		<input type="text" name="nick">
		<button>닉네임 저장!</button>
	</form>
	
	<%
		String userNick = null;
		Cookie[] cookies = request.getCookies();
		for(Cookie c : cookies) {
			if("user_nick".equals(c.getName())) {
				userNick = c.getValue();
			}
		}
	%>
	<p>닉네임 : <%= userNick == null ? "____" : userNick %></p>
	
	<h1>닉네임 삭제</h1>
	<form action="/removeNick" method="post">
		<button>닉네임 삭제!</button>
	</form>
</body>
</html>