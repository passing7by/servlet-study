<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
<script src= "<c:url value='/resources/jquery-3.7.1.js'/>"></script>
</head>
<body>
	<h1>게시글 등록</h1>
	
	<%@ include file="/views/include/nav.jsp" %>
	
	<form id="createBoardFrm">
		<input type="hidden" name="boardWriter" value="${ loginMember.memberNo }">
			<label>제목:</label><br>
			<input type="text" name="boardTitle" required><br><br>
			
			<label>내용:</label><br>
			<textarea name="boardContent" rows="5" cols="40" required></textarea><br><br>
			
			<label>파일첨부:</label><br>
			<input type="file" name="boardFile" ><br><br>
		<input type="submit" value="등록">
	</form>
	
	<script>
		$('#createBoardFrm').submit(function(e) {
			e.preventDefault();

			const form = document.getElementById("createBoardFrm");
			const formData = new FormData(form);
			
			// 원래는 유효성 검사(파일이 있는지 없는지 확인)도 추가해야 함 

			$.ajax({
				url: '/boardWrite',
				type: 'post',
				data: formData,
				enctype: 'multipart/form-data',
				contentType: false,
				processData: false,
				cache: false,
				dataType: 'json',
				success: function(data) {
					alert(data.res_msg);
					if(data.res_code === '200') {
						location.href = "<%= request.getContextPath() %>/boardList";
					}
				}
			});
			// multipart: 파일 정보가 들어가 있음을 의미
			// enctype가 아닌 contentType으로 지정한 데이터로 넘어가는 걸 막기 위해 false로 설정
			// cache 때문에 이전 방식의 타입으로 ajax가 동작할 수 있기 때문에
		});
	</script>
</body>
</html>