package com.gn.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editCookie")
public class EditCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditCookieServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	// 방법1: 쿠키 덮어쓰기
    	// user_id 라는 name을 가진 쿠키의 value를 admin으로 수정
    	Cookie c = new Cookie("user_id", "user02");
    	// 기존과 동일한 유지 시간 설정
    	c.setMaxAge(60 * 60 * 24);
    	// => index.jsp 화면에서 <쿠키 수정> 클릭 후 새로고침
    	// 브라우저가 새로운 요청을 다시 보내게 하는 메소드: sendRedirect
    	response.addCookie(c);
    	response.sendRedirect("/");
    	
    	// 방법2: 클라이언트가 가진 쿠키를 가져와서 값 수정
//    	Cookie[] cookies = request.getCookies();
//    	for (Cookie cookie : cookies) {
//			if (cookie.getName().equals("user_id")) {
//				cookie.setValue("admin");
//				cookie.setMaxAge(60 * 60 * 24);
//		    	response.addCookie(cookie);
//			}
//		}
    	
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
