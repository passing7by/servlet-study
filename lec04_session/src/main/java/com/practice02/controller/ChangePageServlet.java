package com.practice02.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ChangePageServlet
 */
@WebServlet("/changePage")
public class ChangePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean isExist = false;
		int count = 1;
		
		// 만약 쿠키가 있다면 가져와서 값을 +1 한 다음 쿠키 보내기
		Cookie[] cookies = request.getCookies();
		for (Cookie c : cookies) {
			if ("visit_count".equals(c.getName())) {
				int increasedCount = Integer.parseInt(c.getValue()) + 1;
				count = increasedCount;
				c.setValue(String.valueOf(increasedCount));
				response.addCookie(c);
				isExist = true;
			}
		}
		
		// 만약 없다면 쿠키 생성 후 쿠키 보내기
		if (!isExist) {
			Cookie c = new Cookie("visit_count", String.valueOf(count));
			response.addCookie(c);
		}
		
		// 페이지 이동
		// 방법1: request에 값을 set
		RequestDispatcher rd = request.getRequestDispatcher("/views/countPage.jsp");
		request.setAttribute("count", count);
		rd.forward(request, response);
		
		// 방법2: 리다이렉트 - 안됨
		// 근데 서버가 없이 바로 .jsp에 리다렉이 가능?
//		response.sendRedirect("/views/countPage.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
