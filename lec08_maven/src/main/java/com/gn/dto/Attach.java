package com.gn.dto;

import lombok.Data;

@Data
public class Attach {
	private int attachNo;
	private int boardNo;
	private String oriName;
	private String reName;
	
	private String regDate;
	// modDate 필드가 없는 이유? 파일에는 수정이라는 개념이 없기 때문
	// TODO 설명 추가
}
