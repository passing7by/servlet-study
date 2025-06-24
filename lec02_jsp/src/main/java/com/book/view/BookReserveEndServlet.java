package com.book.view;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/bookReserveEnd")
public class BookReserveEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BookReserveEndServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		// POST 방식을 사용하는 경우, request body 안에 있는 데이터를 인코딩하여 사용해야 한글이 안 깨짐
//		request.setCharacterEncoding("UTF-8");
		
		// 유저 정보
		String userName = request.getParameter("userName");
		String userPhone = request.getParameter("userPhone");
		String userEmail = request.getParameter("userEmail");
		// 책 번호
		String bookName = request.getParameter("bookName");
		// 대출 기간
		int borrowPeriod = Integer.parseInt(request.getParameter("borrowPeriod"));
		
		System.out.println("userName: " + userName);
		System.out.println("userPhone: " + userPhone);
		System.out.println("userEmail: " + userEmail);
		System.out.println();
		System.out.println("bookName: " + bookName);
		System.out.println();
		System.out.println("borrowPeriod: " + borrowPeriod);
		
		// 금액 계산
		Map<String, Integer> costMap = new HashMap<>();
		costMap.put("1", 1500);
		costMap.put("2", 1800);
		costMap.put("3", 2000);
		
		int totalCost = costMap.get(bookName) * borrowPeriod;

		// 도서 제목 데이터
		Map<String, String> bookNameStrMap = new HashMap<>();
		bookNameStrMap.put("1", "자바 프로그래밍 입문");
		bookNameStrMap.put("2", "웹 개발의 기초");
		bookNameStrMap.put("3", "데이터베이스 시스템");
		
		String bookNameStr = bookNameStrMap.get(bookName);
		
		// 화면(webapp/views/book/confirm.jsp) 전환
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/book/confirm.jsp");
		// jsp에게 데이터를 넘겨주기
		request.setAttribute("userName", userName);
		request.setAttribute("userPhone", userPhone);
		request.setAttribute("userEmail", userEmail);
		request.setAttribute("borrowPeriod", borrowPeriod);
		request.setAttribute("totalCost", totalCost);
		request.setAttribute("bookNameStr", bookNameStr);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
