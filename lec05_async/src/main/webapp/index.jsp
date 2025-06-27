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
	
	<h1>JSON + AJAX</h1>
	<input type="text" id="searchName">
	<button type="button" id="json_get_btn">조회</button>
	<div id="json_get_div"></div>
	<script>
		$(document).ready(function() {
			$("#json_get_btn").click(function() {
				// 1. 사용자 이름 정보 가져오기
				const keyword = $("#searchName").val();

				// 2. get 방식 (비동기) 요청
				$.ajax({
					url: "/searchAccount?name=" + keyword,
					type: "get",
					dataType: "json",
					success: function(data) {
						// 4. 화면에 목록 형태로 출력
						// const no = data.no;
						// const name = data.name;

						// $('#json_get_div').append('<p>' + no + '번: ' + name + '</p>');

						if(data.arr.length != 0) {
							for(let i = 0; i < data.arr.length; i++) {
								const account = data.arr[i];
								$("#json_get_div").append('<p>' + account.no + '번: ' + account.name + '</p>');
							}
						}
					}
				});
				// 주석을 ajax 안쪽에 썼을 때 안되는 경우가 있으므로 웬만하면 바깥에 작성
				// get방식일 때는 생략 가능하나, 명시적으로 써 주는 것이 좋음
			});
		});
	</script>

	<h1>Practice02 - JSON + AJAX</h1>
	<h2>도서 검색</h2>
	<label>도서명: </label>
	<input type="text" id="searchBook">
	<button id="book_get_btn">조회</button>
	<div id="book_get_div"></div>

	<script>
		$(document).ready(function() {
			// script 태그 바로 위까지 문서가 로드되면
			$('#book_get_btn').click(function() {
				// 조회 버튼이 클릭되면
				// 입력된 도서명을 가져옴
				const title = $('#searchBook').val();

				// 검색어를 입력하지 않았다면
				if(title === '') alert('검색어를 입력해 주세요.')
				// 검색어를 입력했다면
				else {
					// 비동기통신으로 데이터를 받아옴
					$.ajax({
						url: '/searchBook?title=' + title,
						type: 'get',
						dataType: 'json',
						success: function(data) {
							// 1. 데이터가 있다면
							if(data.arr.length != 0) {
								let html = "";
								
								data.arr.forEach(function(book) {
									html += '<p> '+book.no+' : '+book.title+' - '+book.writer+' </p>';
								});

								console.log("html: " + html);

								$('#book_get_div').html(html);
							}
							// 2. 데이터가 없다면
							else {
								alert('검색 결과가 없습니다.');
							}
						},
						error: function(){
							alert('요청 실패!');
						}
					});
				}
			});
		});
	</script>

	<h1>카테고리별 상품 조회</h1>
	<select id="categorySelect">
		<option value="1">전자제품</option>
		<option value="2">생활용품</option>
		<option value="3">패션</option>
	</select>
	<button type="button" id="searchBtn">조회</button>
	<div id="productListArea"></div>
	<script>
		$(function() {
			$('#categorySelect').change(function() {
				// 1. 선택된 카테고리 정보 가져오기
				const categoryCode = $(this).val();
				console.log(categoryCode);
				
				// 2. ajax 통신을 통해 목록 조회
				$.ajax({
					url: '/searchProduct',
					type: 'post',
					data: { code: categoryCode },
					dataType: 'json',
					success: function(data) {
						// 3. 화면에 출력하기
						$('#productListArea').empty();
						
						if(data.arr.length === 0) {
							$('#productListArea').html('해당 카테고리의 상품이 없습니다.');
						} else {
							for(let i = 0; i < data.arr.length; i++) {
								const product = data.arr[i];
								$('#productListArea').append('<p>'+product.name+'은 '+product.price+'원 입니다.</p>');
							}
						}
					}
				});

				// 3. 화면에 출력하기
			});
		});
	</script>
</body>
</html>