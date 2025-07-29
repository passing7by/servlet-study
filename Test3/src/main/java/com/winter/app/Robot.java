package com.winter.app;

public class Robot {
//	private LeftArm leftArm;
	private Arm arm; // 다형성을 고려해 변경
	
	// setter로? 생성자로?
	// 차이점: 생명주기
	
	public Robot() {
		this.arm = new LeftArm();
	}
	
	public void m1() {
		int a = 10;
		this.arm.attack();
		if(a == 10) {
			int b = 20;
		}
//		System.out.println(leftArm.tan); // 부모 타입이므로, 자식 타입의 필드에 접근 불가
		System.out.println(((LeftArm)arm).tan); // 부모 타입이므로, 자식 타입의 필드에 접근 불가
	}
}
