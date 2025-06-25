package com.gn.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/receive/msg")
public class ReceiveMsgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReceiveMsgServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("==== 요청 확인 ====");
		String msg = request.getParameter("msg");
		System.out.println(msg);
		
		// 화면단 경로는 반드시 /로 시작
		// 왜? 절대경로를 사용하기 위해
		// /가 없으면 상대경로임 => 경로가 "/receive/msg" 뒤에서부터 시작하게 됨
//		RequestDispatcher view = request.getRequestDispatcher("/views/msgShow.jsp");
		RequestDispatcher view = getServletContext().getRequestDispatcher("/views/msgShow.jsp");
		request.setAttribute("msg", msg);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
