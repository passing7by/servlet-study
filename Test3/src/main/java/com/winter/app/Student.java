package com.winter.app;

public class Student {
	String name; // 인스턴스 변수
	
	static String school; // 클래스 변수
	
//	static final String school; // 상수
	
	// 클래스 초기화 블럭
	static {
		Student.school = "0";
	}
	
	// 필드 초기화 방법
	// setter
	// 생성자
	// 직접 입력
	// 변수 선업과 동시에 초기화
	
	// (참고) 인스턴스 초기화 블럭
	{
		this.name = "";
	}

	public Student() {
		name = "";
	}
	
	public Student(String name) {
		this.name = name;
	}
}
