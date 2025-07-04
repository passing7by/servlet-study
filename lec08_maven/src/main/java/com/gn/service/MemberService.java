package com.gn.service;

import com.gn.dao.MemberDao;
import com.gn.dto.Member;

public class MemberService {
	private static final MemberDao dao = new MemberDao();
	
	public int insertMember(String memberId, String memberPw) {
		// dao에게 db와의 연결 부탁
		return dao.insertMember(memberId, memberPw);
	}

	public Member selectMember(String memberId, String memberPw) {
		// dto에 옮겨담기
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		
		// dao에 db연결 부탁
		return dao.selectMember(member);
	}
	
}
