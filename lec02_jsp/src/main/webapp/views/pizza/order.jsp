<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>피자 주문 화면</title>
</head>
<body>
	<h2>피자 주문하기</h2>
	<form name="orderFrm" id="orderFrm" action="/pizzaOrderEnd" method="post">
		<fieldset>
		    <legend>고객 정보</legend>
		    <label for="user_name">고객명 : </label>
		    <input type="text" id="user_name" name="userName">
		    <br>
		    <label for="user_phone">전화번호 : </label>
		    <input type="text" id="user_phone" name="userPhone">
		    <br>
		    <label for="user_email">E-mail : </label>
		    <input type="email" id="user_email" name="userEmail">
		</fieldset>
		<fieldset>
		    <legend>피자 사이즈</legend>
		    <input type="radio" id="small" value="1" name="pizzaSize">
		    <label for="small">Small</label>
		    <br>
		    <input type="radio" id="medium" value="2" name="pizzaSize">
		    <label for="medium">Medium</label>
		    <br>
		    <input type="radio" id="large" value="3" checked name="pizzaSize">
		    <label for="large">Large</label>
		</fieldset>
		<fieldset>
		    <legend>토핑 선택</legend>
		    <input type="checkbox" id="shrimp" value="1" name="pizzaTopping">
		    <label for="shrimp">새우</label>
		    <br>
		    <input type="checkbox" id="sweet" value="2" name="pizzaTopping">
		    <label for="sweet">고구마</label>
		    <br>
		    <input type="checkbox" id="potato" value="3" name="pizzaTopping">
		    <label for="potato">감자</label>
		    <br>
		    <input type="checkbox" id="pine" value="4" name="pizzaTopping">
		    <label for="pine">파인애플</label>
		</fieldset>
		<br>
		<label for="delivery_time">희망 배송 시간 : </label>
		<input type="time" id="delivery_time" name="deliveryTime">
		<input type="submit" value="주문하기">
	</form>
</body>
</html>