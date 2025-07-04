package com.gn.dao;

import org.apache.ibatis.session.SqlSession;

import com.gn.common.sql.SqlSessionTemplate;
import com.gn.dto.Member;

public class MemberDao {
	private SqlSession session = SqlSessionTemplate.getSqlSession(true);

	public int insertMember(String memberId, String memberPw) {
		SqlSession session = SqlSessionTemplate.getSqlSession(true);
		
		// 그릇 만들기
		Member param = new Member();
		param.setMemberId(memberId);
		param.setMemberPw(memberPw);
		// 그릇에 담아 DB에 insert
		int result = session.insert("com.gn.mapper.MemberMapper.insertMember", param);
		session.close();
		
		return result;
	}

	public Member selectMember(Member member) {
		SqlSession session = SqlSessionTemplate.getSqlSession(true);
		
		Member result = session.selectOne("com.gn.mapper.MemberMapper.selectMember", member);
		session.close();
		
		return result;
	}
}
