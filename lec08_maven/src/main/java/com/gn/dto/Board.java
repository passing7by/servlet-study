package com.gn.dto;

import com.gn.common.vo.Paging;

import lombok.Data;

@Data
public class Board extends Paging {
	private int boardNo;
	private String boardTitle;
	private String boardontent;
	private int boardWriter;
	
	// CURRENT_TIMESTAMP 걸려있고, modDate는 update 쿼리 날릴 때 자동으로 업데이트 됨
	// 굳이 Date 타입을 써서 복잡하게 작업할 필요 없음, String이 더 경량
	// -> 날짜 정보지만 String 타입으로 선언함
	private String regDate;
	private String modDate;
	
	private String memberId;
	private String keyword;
}
