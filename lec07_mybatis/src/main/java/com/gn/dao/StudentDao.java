package com.gn.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.gn.common.SessionTemplate;
import com.gn.dto.Student;

public class StudentDao {

	public List<Student> selectAll() {
		// 데이터베이스 접근(MyBatis)
		SqlSession session = SessionTemplate.getSqlSession(true);
//		List<Student> list = session.selectList("매퍼의 위치.메소드명", "전달하는 파라미터");
		List<Student> list = session.selectList("com.gn.mapper.StudentMapper.selectAll");
		session.close();
		return list;
	}

	public Student selectOne(int studentNo) {
		// 데이터베이스 접근(MyBatis)
		SqlSession session = SessionTemplate.getSqlSession(true);
		Student student = session.selectOne("com.gn.mapper.StudentMapper.selectOne", studentNo); // 조회 시 필요한 매개 변수도 함께 전달
		session.close();
		return student;
	}

	public List<Student> selectAll(String studentName) {
		// 데이터베이스 접근(MyBatis)
		SqlSession session = SessionTemplate.getSqlSession(true);
		List<Student> list = session.selectList("com.gn.mapper.StudentMapper.selectAllByName", studentName); // 조회 시 필요한 매개 변수도 함께 전달
		session.close();
		return list;
	}

	public int insert(Student param) {
		// 데이터베이스 접근(MyBatis)
		SqlSession session = SessionTemplate.getSqlSession(true);
		int result = session.insert("com.gn.mapper.StudentMapper.insert", param);
		session.close();
		return result;
	}

	// Service한테 Student를 전달받았어요.
	// 전달받은 정보를 가지고 update 하고 싶어요.
	public int updateStudent(Student student) {
		SqlSession session = SessionTemplate.getSqlSession(true);
		int result = session.update("com.gn.mapper.StudentMapper.updateStudent", student);
		return result;
	}

	public int deleteStudent(int studentNo) {
		SqlSession session = SessionTemplate.getSqlSession(true);
		int result = session.delete("com.gn.mapper.StudentMapper.deleteStudent", studentNo);
		return result;
	}
	
	
}
