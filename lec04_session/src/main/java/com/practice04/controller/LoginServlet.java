package com.practice04.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.practice04.dto.Account;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. request body 안의 한글 데이터를 받아올 경우, 깨질 수 있으므로 인코딩
		request.setCharacterEncoding("UTF-8");
		// 계정 정보
		String correctId = "admin";
		String correctPw = "admin1234";
		String name = "관리자";
		// 세션 변수
		HttpSession session = null;
		
		// 2-1. 위의 계정 정보와 받아온 계정 정보가 같을 경우 session에 account라는 이름으로 사용자 정보 저장
		// 1) 계정 정보 받아오기
		String loginId = request.getParameter("loginId");
		String loginPwd = request.getParameter("loginPwd");
		
		if (correctId.equals(loginId) && correctPw.equals(loginPwd)) {
			// 세션 생성
			session = request.getSession(true); // true(default): 세션이 없으면 만듦 | false: 세션이 없으면 null 반환
			// 세션에 값 저장
			session.setAttribute("account", new Account(loginId, loginPwd, name));
			// 페이지 이동 - 두 방법 다 가능
//			request.getRequestDispatcher("/").forward(request, response);
			response.sendRedirect("/");
		} else { // 2-2. 로그인 실패시 아무 처리 없이 메인 페이지 재요청
			response.sendRedirect("/");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
