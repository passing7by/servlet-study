package com.cookie.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class SaveNickServlet
 */
@WebServlet("/saveNick")
public class SaveNickServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveNickServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 입력값을 받아옴
		String nick = request.getParameter("nick");
		// 받아온 입력값을 쿠키로 만들어서 유지시간 설정 후, 클라이언트에게 보냄
		Cookie c = new Cookie("nick", nick);
		c.setMaxAge(60 * 60); // 60초(1분) * 60 = 1시간(60분)
		response.addCookie(c);
		// 화면 전환(새로 요청)
		response.sendRedirect("/practiceCookie");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
