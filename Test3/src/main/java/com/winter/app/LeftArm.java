package com.winter.app;

public class LeftArm implements Arm {
	long tan = 100;
	
	@Override
	public void attack() {
		System.out.println("총쏘기");
	}
}
