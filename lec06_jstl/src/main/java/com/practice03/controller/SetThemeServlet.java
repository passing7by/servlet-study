package com.practice03.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/setTheme")
public class SetThemeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SetThemeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String theme = request.getParameter("theme");
		request.setAttribute("theme", theme);
		System.out.println(theme);
		
		request.getRequestDispatcher("/views/sample.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
