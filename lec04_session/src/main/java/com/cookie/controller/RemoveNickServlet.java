package com.cookie.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/removeNick")
public class RemoveNickServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RemoveNickServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 삭제할 쿠키의 키값을 가지는 쿠키를 생성해서 덮어씌움
		Cookie c = new Cookie("nick", "");
		// 유지시간을 0초로 설정
		c.setMaxAge(0);
		// 쿠키를 보냄
		response.addCookie(c);
		// 화면 전환(새로 요청)
		response.sendRedirect("/");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
