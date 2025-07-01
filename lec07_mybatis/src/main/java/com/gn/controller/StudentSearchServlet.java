package com.gn.controller;

import java.io.IOException;
import java.util.List;

import com.gn.dto.Student;
import com.gn.service.StudentService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/student/search")
public class StudentSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private StudentService service = new StudentService();
	
    public StudentSearchServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 학생의 이름을 파라미터로 전달받음
		String studentName = request.getParameter("student_name");
		// 2. 해당 학생의 정보 조회(DB)
		List<Student> list = service.getStudentList(studentName);
		System.out.println(list);
		// 3. 상세 화면으로 전달
		request.setAttribute("list", list);
		request.getRequestDispatcher("/views/studentSearch.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
