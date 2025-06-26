package com.gn.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calScore")
public class CalScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CalScoreServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 인코딩
		request.setCharacterEncoding("UTF-8");
		// 2. 받아온 값 조작해서 값 보내기
		// 1) 보내줄 형식 지정 - 텍스트만 보낼거니까 plain으로 지정했음
		response.setContentType("text/plain; charset=utf-8");
		// 2) 연결 통로(스트림) 생성
		PrintWriter pw = response.getWriter();
		
		// 3) 값 조작
		int kor = 0;
		int eng = 0;
		int math = 0;
		String text = "";
		
		try {
			kor = Integer.parseInt(request.getParameter("kor"));
			eng = Integer.parseInt(request.getParameter("eng"));
			math = Integer.parseInt(request.getParameter("math"));			
		} catch (NumberFormatException e) {
			// kor, eng, math 중 하나라도 입력되지 않아 값이 ""로 받아와진 경우
			text = "점수를 모두 입력해주세요!";
			pw.println(text);
			return;
		}
		
		int sum = kor + eng + math;
		int avg = sum / 3 ;
		String msg = "";
		
		if(avg >= 60 && !((kor < 40) || (eng < 40) || (math < 40))) {
			msg = "합격입니다!";
		} else {
			msg = "불합격입니다...";
		}
		
		text = "총점: " + sum + " 평균: " + avg + " 으로 " + msg;
		System.out.println("text: " + text);
		
		// 3) 통로로 값 내보내기
		pw.println(text);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
