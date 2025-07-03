package com.gn.service;

import com.gn.dao.MemberDao;

public class MemberService {
	private MemberDao dao = new MemberDao();
	
	public int insertMember(String memberId, String memberPw) {
		// dao에게 db와의 연결 부탁
		return dao.insertMember(memberId, memberPw);
	}
	
}
