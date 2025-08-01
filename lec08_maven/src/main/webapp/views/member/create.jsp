<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src= "<c:url value='/resources/jquery-3.7.1.js'/>"></script>
<%-- <script src= "/resources/jquery-3.7.1.js"></script> --%>
</head>
<body>
	<h1>회원가입</h1>
	
	<%@ include file="/views/include/nav.jsp" %>
	
	<form id="createMemberFrm">
		<input type="text" id="member_id" placeholder="아이디"> <br>
		<input type="password" id="member_pw" placeholder="비밀번호"> <br>
		<input type="password" id="member_pw_check" placeholder="비밀번호 확인"> <br>
		<input type="submit" value="회원가입"> 
	</form>
	
	<script>
		$('#createMemberFrm').submit(function(e) {
			e.preventDefault();

			// 1. 사용자 입력값 가져오기
			const memberId = $('#member_id').val();
			const memberPw = $('#member_pw').val();
			const memberPwCheck = $('#member_pw_check').val();

			// 2. 유효성 검사(비어있는 값이 아닐 것, 정규식을 통과할 것 등)
			// id 유효성 검사에 사용할 정규식
			const idReg = /^[a-zA-Z0-9]{4,12}$/;
			const pwReg = /^[a-zA-Z0-9!@#$%^&*]{4,20}$/;
			// 정규식 작성 방법: /^[정규식 내용]$/
			// [a-z]: a부터 z까지 다 쓸 수 있음
			// [A-Z]: A부터 A까지 다 쓸 수 있음
			// [0-9]: 0부터 9까지 다 쓸 수 있음
			// {4,12}: 4자리부터 12자리까지 쓸 수 있음

			if(!memberId) {
				alert('아이디를 입력하세요');
			} else if(!idReg.test(memberId)) {
				alert('아이디는 영문 또는 숫자로 4~12자리만 가능합니다');
			} else if(!memberPw) {
				alert('비밀번호를 입력하세요');
			} else if(!pwReg.test(memberPw)) {
				alert('비밀번호는 영문/숫자/특수문자 포함 4~20자리만 가능합니다');
			} else if(memberPw != memberPwCheck) {
				alert('비밀번호가 일치하지 않습니다');
			} else {
				// 3. ajax로 회원가입 요청
				$.ajax({
					url: '/memberCreate',
					type: 'post',
					data: {
						memberId: memberId,
						memberPw: memberPw
					},
					dataType: 'json',
					success: function(data) {
						alert(data.res_msg);
						if(data.res_code == 200) {
							// 로그인 화면 전환
							
						}
						
					}
				});
			}


		});
	</script>
</body>
</html>