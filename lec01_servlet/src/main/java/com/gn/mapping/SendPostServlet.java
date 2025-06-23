package com.gn.mapping;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginMember")
public class SendPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SendPostServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 한글 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 2. 사용자가 입력한 값 꺼내오기
		String id = request.getParameter("user_id");
		String pwd = request.getParameter("user_pw");
		
		// 3. 출력하기
		System.out.println("아이디: " + id);
		System.out.println("비밀번호: " + pwd);
		
		// 1. 응답 형식 지정
//		response.setContentType("text/html; charset=UTF-8");
		
		// 2. 응답하고자 하는 사용자와의 연결통로 생성
//		PrintWriter out = response.getWriter();
		
		// 3. HTML 구문 한줄씩 쌓기
//		out.println("<html>");
//		out.println("<head>");
//		out.println("<meta charset='UTF-8'>");
//		out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
//		out.println("<title>로그인 결과화면</title>");
//		out.println("</head>");
//		out.println("<body>");
//		
//		out.println("<h1>반가워요 " + id + "님</h1>");
//		out.println("<h2>비밀번호가 " + pwd + "이시네요~</h2>");
//		out.println("<a href='/'>홈페이지로 이동</a>");
//		
//		out.println("</body>");
//		out.println("</html>");
		
		// 4. 쌓여있는 데이터 밀어내기
//		out.flush();
		
		// jsp로 변경
		// 1. jsp로 요청을 넘기는 역할 = 어느 jsp 에 넘길지 지정
		RequestDispatcher view = request.getRequestDispatcher("views/loginSuccess.jsp");
		// 2. jsp에게 데이터를 넘겨주기
		request.setAttribute("id", id);
		request.setAttribute("pwd", pwd);
		// 3. 화면을 jsp에게 넘기고, 응답을 jsp에게 맡기기
		view.forward(request, response);
	}

}
