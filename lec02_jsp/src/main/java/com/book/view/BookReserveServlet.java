package com.book.view;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/bookReserve")
public class BookReserveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BookReserveServlet() {
        super();
    }
    
    // a태그는 응답이 무조건 get으로 들어옴
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 화면(webapp/views/book/reserve.jsp) 전환
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/book/reserve.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
