<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>1. EL의 내장객체</h1>
    
    <%
        pageContext.setAttribute("test", "페이지");
        request.setAttribute("test", "리퀘스트");
        session.setAttribute("test", "세션");
        application.setAttribute("test", "애플리케이션");
    %>
    
    <h2>(1) jsp 방식 => 특정 범주 내장객체 지정</h2>
    <p><%= pageContext.getAttribute("test") %></p>
    
    <h2>(2) el 방식</h2>
    <!-- 
    	1. ~Scope로 끝나는 내장객체 사용
    	2. 내장객체 지정없이 key만 사용: 가장 작은 범주부터 탐색
     -->
    <p>${ pageScope.test }</p>
    <p>${ test }</p>
    
    <h1>2. el로 객체 다루기</h1>
    <%@ page import="com.gn.dto.Person" %>
    <%
    	Person p = new Person("김첨수", 77);
    	request.setAttribute("person", p);
    %>
    <h2>(1) jsp 방식</h2>
    <%
    	Person p1 = (Person) request.getAttribute("person");
    %>
    <p>이름: <%= p1.getName() %></p>
    <p>나이: <%= p1.getAge() %></p>
    
    <h2>(2) el 방식</h2>
    <!-- 
    	el 방식으로 객체 정보를 꺼내는 경우: key값.필드명
    	!!private 필드 직접 꺼내는거 아님!! getter 반드시 필요함
     -->
    <p>이름: ${ person.name }</p>
    <p>나이: ${ person.age }</p>
    
    <h1>Practice01</h1>
    <!-- 1. Planet 데이터 만들기 -->
    <%@ page import="com.gn.dto.Planet" %>
    <%
    	Planet planet = new Planet("지구", 1.5, true);
    	// String habitableStr = planet.isHabitable() ? "O" : "X";
    	request.setAttribute("planet", planet);
    	// request.setAttribute("habitableStr", habitableStr);
    %>
    <%-- <p>이름: ${ planet.name }</p>
    <p>태양으로부터의 거리: ${ planet.distance }</p> --%>
    <p>거주 가능 여부: ${ planet.habitable }</p>
    <%-- <p>거주 가능 여부: ${ habitableStr }</p>
    <p>거주 가능 여부: ${ planet.isHabitable ? "O" : "X" }</p>
    <p>거주 가능 여부: ${ planet.isHabitable ? "O" : "X" }</p> --%>
	<!-- el 안에서 삼항연산자 사용 가능 -->    
	
	<h1>4. el 연산자</h1>
	<%@ page import="java.util.*" %>
	<%
		request.setAttribute("num1", 7);
		request.setAttribute("num2", 2);
		request.setAttribute("str1", "햄버거");
		request.setAttribute("str2", "피자");
		
		List<String> menu = new ArrayList<String>();
		menu.add("짜장면");
		menu.add("짬뽕");
		request.setAttribute("menuList", menu);
	%>
	
	<p>
		산술 연산
		${num1 + num2 }
		${num1 - num2 }
		${num1 * num2 }
		${num1 div num2 }
		${num1 mod num2 }
	</p>
	<p>
		문자열 연결, 비교
		${str1 }${str2 }
		${str1 eq str2 }
		${str1 ne str2 }
	</p>
	<p>
		리스트 데이터 확인
		${empty menuList ? "메뉴가 비어있어요" : "메뉴가 있어요"}
		${not empty menuList }
	</p>
	<p>
		대소 비교 & 논리 연산
		${num1 gt num2 }
		${num1 lt num2 }

		num1이 num2보다 크고 , menuList가 비어 있지 않은 경우
		${num1 gt num2 and not empty menuList }
	</p>
	
	
	<%
	    request.setAttribute("kor", 85);
	    request.setAttribute("eng", 90);
	    request.setAttribute("math", 78);
	    request.setAttribute("name1", "이순신");
	    request.setAttribute("name2", "김유신");
	
	    List<String> heroList = new ArrayList<>();
	    heroList.add("홍길동");
	    request.setAttribute("heroList", heroList);
	%>
	<%-- 1. 산술 연산
		(1) 국어, 영어, 수학 점수 평균 => 나누기
		(2) 평균 점수가 80점 초과 => "합격" 그렇지 않으면 "불합격"
		
		2. 문자열 연결
		(1) 이순신김유신 처럼 이름 연결
		(2) 두분의 이름이 동일한지 비교 => "동일 인물" 그렇지 않으면 "다르다"
		
		3. 리스트 비어있는가
		(1) heroList가 비어있는지 판단 -> "O" 그렇지 않으면 "X"
		(2) 국어 점수가 영어 점수보다 높거나 heroList가 비어 있지 않은 경우 true 출력
		(3) 수학 점수가 80점 미만 이고, 영어 점수가 90점 이상이면 true 출력 --%>
	
	<p>${ (kor + eng + math) div 3 }</p>
	<p>${ ((kor + eng + math) div 3) gt 80 ? "합격" : "불합격" }</p>
	<br>
	<p>${ name1 }${ name2 }</p>
	<p>${ name1 eq name2 ? "동일 인물" : "다르다" }</p>
	<br>
	<p>${ empty heroList  ? "O" : "X" }</p>
	<p>${ (kor gt eng) or not empty heroList ? true : false }</p>
	<p>${ (math lt 80) and not (eng lt 90) ? true : false }</p>
	
	<h1>Practice02</h1>
	<a href="/guestbook">방명록 페이지로 이동</a>
	
	<h1>5. jstl Core Library</h1>
	<h2>(1) 변수 선언</h2>
	<!-- c:set 사용
		1. 자료형 선언하지 않음 (무조건 문자열로 들어감)
		2. 초기값 반드시 작성
		3. c:set으로 지정한 값을 스크립틀릿에서 꺼내 쓸 수 없음
		   반대로, 스크립틀릿에서 setting한 값은 jstl에서 꺼내 쓸 수 있음
	 -->
	<c:set var="num3" value="10" scope="page"/>
	<c:set var="num4" value="20"/>
	<c:set var="plus" value="${ num3 + num4 }"/>
	<h2>(2) 변수 출력</h2>
	<c:set var="result" value="<b>안녕하세요!</b>"/>
	<c:out value="${ result }"/>
	<c:out value="${ result }" escapeXml="false"/>
	
	<h2>(3) 조건문 : if</h2>
	<c:if test="${ num3 le num4 }">
	<p>num3가 num4보다 작거나 같음</p>
	</c:if>
	
	<h2>(4) 조건문 : choose</h2>
	 <c:choose>
	 	<c:when test="${ num3v gt 20 }">
	 		<p>num3이 20보다 큽니까?
	 	</c:when>
	 	<c:when test="${ num3 gt 10 }">
	 		<p>num3이 20보다 작거나 같으면서, 10보다 크거나 같습니까?</p>
	 	</c:when>
	 	<c:otherwise>
	 		<p>
	 			1. num3이 20보다 작거나 같다.
	 			2. num3이 10보다 작다.
	 			=> num3이 10보다 작습니까?
	 		</p>
	 	</c:otherwise>
	 </c:choose>
	 
	<h1>Practice03</h1>
	<h2>6. 사이트 테마 설정</h2>
	<form method="post" action="/setTheme">
	    <button type="submit" name="theme" value="dark">다크모드</button>
	    <button type="submit" name="theme" value="light">라이트모드</button>
	</form>
	
	<h2>(5) 반복문: forEach</h2>
	<!-- 기본 for문 처럼 사용하기 -->
	<c:forEach var="i" begin="1" end="10" step="2">
		<p>반복 숫자: ${ i }</p>
	</c:forEach>
	<!-- 향상된 for문 처럼 사용하기 -->
	<% 
		String[] colors = {"red", "green", "blue"};
		request.setAttribute("colors", colors);
	%>
	<ul>
		<c:forEach var="color" items="${ colors }">
			<li style="color:${ color }">${ color }</li>
		</c:forEach>
	</ul>
	<!-- varStatus 속성 -->
	<c:forEach var="num" begin="0" end="5" varStatus="vs">
		<p>
			숫자: ${ num }, 인덱스: ${ vs.index }, 카운트: ${ vs.count },
			첫번째?: ${ vs.first }, 마지막?: ${ vs.last }
		</p>
	</c:forEach>
	<script src="<%= request.getContextPath() %>/resources/jquery-3.7.1.js">
	</script>
	<a href="<%= request.getContextPath() %>/boardList">게시판</a>
	
	<script src="<c:url value='/resources/jquery-3.7.1.js'/>">
		
	</script>
	<a href="<c:url value='/boardList'/>">게시판</a>
	<!-- 파라미터 사용하기 -->
	<c:url var="testUrl" value="/boardList">
		<c:param name="nowPage" value="1"/>
	</c:url>
	<a href="${ testUrl }">게시판</a>
	
	<h1>8. jstl Formatting Library</h1>
	<h2>(1) 숫자 정보 포맷팅</h2>
	<fmt:formatNumber value="1234.567" type="number"/><br>
	<fmt:formatNumber value="0.875" type="percent"/><br>
	
	<fmt:formatNumber value="1234.567" pattern="#,###.##"/><br>
	<fmt:formatNumber value="1234.5" pattern="00000.00"/>
	
	<h2>(2) 날짜 정보 포맷팅</h2>
	<c:set var="now" value="<%= new java.util.Date() %>"/>
	<fmt:formatDate value="${ now }" type="date"/><br>
	<fmt:formatDate value="${ now }" pattern="yy-MM-dd HH:mm:ss"/>
	
	<h1>9. jstl Function Library</h1>
	<c:set var="data" value="How Are You? I am fine"/>
	<p><c:out value="${ data }"/></p>
	<p><c:out value="${ fn:toUpperCase(data) }"/></p>
	<p><c:out value="${ fn:replace(data, 'fine', 'apple') }"/></p>
</body>
</html>