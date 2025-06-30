package com.practice01.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/desplayStars")
public class DesplayStarsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DesplayStarsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 별 갯수 받아오기
		int starNumber = Integer.parseInt(request.getParameter("starNumber"));
		System.out.println(starNumber);
		// 별 갯수 정보 전달
		request.setAttribute("starNumber", starNumber);
		// 페이지 이동
		request.getRequestDispatcher("/views/star.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
