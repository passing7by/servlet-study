<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비동기 연습하기</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	<h1>1. 텍스트 데이터</h1>
	<h2>(1) GET 방식</h2>
	<input type="text" name="user_id" id="user_id"> 
	<input type="button" value="아이디 길이 구하기" id="ajax_get_btn">
	<div id="ajax_get_div"></div>
	<script>
		$(document).ready(function() {
			$("#ajax_get_btn").click(function() {
				console.log("1 : 클릭 이벤트 동작");
				const userId = $("#user_id").val();
				console.log("2 : 사용자 정보 받아와졌는가");
				$.ajax({
					url : "/getTextAjax?userId=" + userId,
					type : "get",
					success : function(data) {
						// data => <p>아이디 : ㅇㅇㅇ (n글자)</p>
						console.log("3 : 요청 정상 동작 여부");
						// $("#ajax_get_div").html(data);
						
						const h3 = $('<h3>').text(data);
						$("#ajax_get_div").html(h3);
					},
					error : function() {
						alert("요청 실패!!");
					}
				});
			});
		});
	</script>
	
	<h2>(2) POST 방식</h2>
	<button type="button" id="ajax_post_btn">
		아이디 길이 구하기 ver2.
	</button>
	<div id="ajax_post_div"></div>
	<script>
		$(document).ready(function() {
			$("#ajax_post_btn").click(function() {
				const userId = $("#user_id").val();
				$.ajax({
					url: "/postTextAjax",
					type: "post",
					data: {userId : userId},
					success: function(data) {
						const p =$("<p>").text(data);
						$("#ajax_post_div").html(p);
					},
					error: function() {
						alert("요청 실패!");
					}
				});
			});
		})
	</script>
	
	<h1>Practice01</h1>
	<h2>성적 계산기</h2>
	
	<label for="kor">국어 : </label>
	<input type="number" id="kor"><br>
	
	<label for="eng">영어 : </label>
	<input type="number" id="eng"><br>
	
	<label for="math">수학 : </label>
	<input type="number" id="math"><br>
	
	<button id="btnPost">계산</button>
	
	<div id="resultArea"></div>

	<script>
		// 문서 로드
		$(document).ready(function() {
			// 문서 로드 후 실행할 콜백함수 내용
			$("#btnPost").click(function() {
				// 버튼이 클릭되면 실행할 콜백함수 내용
				// 점수값 받아오기
				// 점수값을 받아온 변수는 값을 받아온 이후에 다른 값으로 변경되지 않으므로 const로 선언
				const kor = $("#kor").val();
				const eng = $("#eng").val();
				const math = $("#math").val();
				
				$.ajax({ // ajax()에는 객체{}가 전달됨
					url: "/calScore",
					type: "post",
					data: {
						kor: kor,
						eng: eng,
						math: math
					},
					success: function(data) {
						// 요소를 가져와서 data를 요소의 내용으로 만듦
						$("#resultArea").text(data);
					},
					error: function() {
						alert("문제가 발생했습니다.");
					}
				});
			});
		});
	</script>
</body>
</html>