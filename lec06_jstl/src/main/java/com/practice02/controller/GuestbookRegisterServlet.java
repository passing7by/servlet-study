package com.practice02.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.json.simple.JSONObject;

@WebServlet("/guestbookRegister")
public class GuestbookRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GuestbookRegisterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 2. 값 받아오기
		String name = request.getParameter("name");
		String message = request.getParameter("message");
		
		String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm"));
		
		// 3. json 객체로 값 감싸기
		JSONObject obj = new JSONObject();
		obj.put("name", name);
		obj.put("message", message);
		obj.put("now", now);
		
		// 4. 값 보내기
		response.getWriter().print(obj);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
