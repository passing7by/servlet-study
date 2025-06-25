<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Cookie🍪</h1>
	<ul>
		<li>
			<a href="/makeCookie">쿠키 생성</a>
		</li>
		<li>
			<a href="/editCookie">쿠키 수정</a>
		</li>
		<li>
			<a href="/deleteCookie">쿠키 삭제</a>
		</li>
	</ul>
	
	<h2>현재 쿠키 값 확인</h2>
	<%
		// 1. 클라이언트가 보낸 쿠키 배열 가져오기
		Cookie[] cookies = request.getCookies();
		String userId = "쿠키 없음";
	
		// 2. 쿠키 배열에서 원하는 쿠키 찾기
		if(cookies != null) {
			for(Cookie c : cookies) {
				if(c.getName().equals("user_id")) {
					userId = c.getValue();
					break;
				}
			}
		}
	%>
	<p>user_id 쿠키값 : <%= userId %></p>
	
	<h1>Practice01 - Cookie1</h1>
	<a href="/practiceCookie">쿠키 연습하기</a>
	
	<h1>Practice02 - Filter</h1>
	<!-- CommentWriteServlet으로 요청을 보냄 -->
	<form action="/comment/write" method="post"> 
	    <input type="text" name="writer" placeholder="작성자명 입력">
	    <input type="submit" value="댓글 작성">
	</form>
	
	<h1>Practice03 - Cookie2</h1>
	<!-- ChangePageServlet로 요청을 보냄 -->
	<a href="/changePage">방문 횟수 추적하기</a>
</body>
</html>