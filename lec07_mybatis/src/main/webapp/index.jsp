<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이바티스</title>
</head>
<body>
	<!-- 
		1. index.jsp에 목록 조회 a태그 생성
		2. 목록 조회 요청을 받는 Servlet(Controller) 만듦
		3. Service에 정보 전달
		4. DAO에 데이터베이스 연결 요청
		5. Mapper에 있는 쿼리 실행
	 -->
	 <ol>
	 	<li>
	 		<a href="<c:url value='/student/list'/>">학생 목록 조회</a>
	 	</li>	
	 </ol>
	 
	 <h1>Practice01</h1>
	 <form action="/desplayStars" method="get">
	 	<input type="number" name="starNumber">
	 	<button>별찍기</button>
	 </form>
	 
	 <!-- 
	 	입력된 이름이 포함된 모든 학생의 정보를 화면 또는 console에 출력
	 	화면: studentSearch.jsp 만들어서 출력 또는 표준 출력
	  -->
	 <form action="<c:url value='/student/search'/>" method="get">
	 	<input type="text" name="student_name">
	 	<input type="submit" value="이름 기준 검색">
	 </form>
	 
	 <a href="/student/insert">학생 등록하러 가기</a>
</body>
</html>