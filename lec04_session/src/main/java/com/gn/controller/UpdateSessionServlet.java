package com.gn.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/updateSession")
public class UpdateSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateSessionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 기존 세션 사용 (false)
		HttpSession session = request.getSession(false); // 세션 없으면 null 반환
		System.out.println("세션 있니? " + session);
		// 2. 기본 값 위에 덮어쓰기
		if(session != null) { // 세션이 있다면
			session.setAttribute("member_id", "admin");
		}
		response.sendRedirect("/");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
