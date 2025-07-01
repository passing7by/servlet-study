<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 조회 결과 (이름으로 검색)</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>나이</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="s" items="#{ list }">
				<tr>
					<td>${ s.studentNo }</td>
					<td>${ s.studentName }</td>
					<td>${ s.studentAge }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>