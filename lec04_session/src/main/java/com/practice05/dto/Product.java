package com.practice05.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Product implements Comparable<Product> {
	private int code;
	private String name;
	private int price;
	
	// TODO 정렬 기능 추가하기
	@Override
	public int compareTo(Product o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
