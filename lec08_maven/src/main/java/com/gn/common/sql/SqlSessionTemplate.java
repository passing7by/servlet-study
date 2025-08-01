package com.gn.common.sql;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionTemplate {
	public static SqlSession getSqlSession(boolean autoCommit) {
		SqlSession session = null;
		
		try {
			// 1. SqlSessionFactoryBuilder -> 공장 만드는 애
			// 공장 짓기 전에 공장 만드는 애가 필요
			// mybatis-config.xml의 설정 정보를 통해 객체 생성
			String path = "/mybatis-config.xml";
			InputStream is = Resources.getResourceAsStream(path);
			
			SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
			
			// 2. SqlSessionFactory 객체 생성
			// SqlSessionFactoryBuilder의 build() 메소드 활용
			// 매개변수로 mybatis-config.xml 파일 정보 전달
			SqlSessionFactory factory = sfb.build(is);
			
			// 3. SqlSession 객체 생성
			// SqlSessionFactory의 openSession() 메소드 사용
			// true: autoCommit 켜기 -> 데이터 변경을 자동으로 반영하겠다는 의미
			// false: 끄기(명시적으로 commit 호출해야 반영됨) -> 수동으로 반영하겠다는 의미
			session = factory.openSession(autoCommit);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return session;
	}
}
