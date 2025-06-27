<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 페이지</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
    <p>이름: </p>
    <input type="text" name="name" id="name">
    <p>메시지: </p>
    <textarea name="message" id="message"></textarea>
    <button type="button" id="guestbook_btn">등록</button>
    <div id="guestbook">
    </div>

    <script>
        // 1. 문서 로드
        $(document).ready(function() {
            // 2. 클릭 이벤트 지정
            $('#guestbook_btn').click(function() {
                // 값 가져오기
                const name = $('#name').val();
                const message = $('#message').val();

                // 3. 비동기 통신 - post 방식 사용
                $.ajax({
                    url: '/guestbookRegister',
                    type: 'post',
                    data: {
                        name: name,
                        message: message
                    },
                    dataType: 'json',
                    success: function(data) {
                        $('#guestbook').append('<ul>');
                        $('#guestbook').append('<li>'+data.name+'</li>');
                        $('#guestbook').append('<li>'+data.message+'</li>');
                        $('#guestbook').append('<li>'+data.now+'</li>');
                        $('#guestbook').append('</ul>');

                        $('#name').val('');
                        $('#message').val('');
                    },
                    error: function() {
                        alert('문제가 발생했습니다.');
                    }
                });
            });
        });
    </script>
</body>
</html>