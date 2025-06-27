package com.gn.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.gn.dto.Book;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/searchBook")
public class SearchBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchBookServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 도서 목록
		List<Book> list = new ArrayList<Book>();
		list.add(new Book(1, "자바의 정석", "김철수"));
		list.add(new Book(2, "스프링 입문", "이순신"));
		list.add(new Book(3, "MySQL 실습", "홍길동"));
		list.add(new Book(4, "웹 개발 가이드", "유관순"));
		list.add(new Book(5, "자바 섬의 비밀 - 말레이곰과 자바 섬", "농담곰"));
		
		// 1. 입력된 값을 받아옴
		String title = request.getParameter("title");
		
		// 2. 반환할 값을 json 형태로 만들기
		// jsonarray 생성
		JSONArray arr = new JSONArray();
		
		// 만약 title이 list에 있는 book의 title의 내용에 있다면 jsonarray에 담음
		for (Book b : list) {
			if(b.getTitle().contains(title)) {
				JSONObject obj = new JSONObject();
				obj.put("no", b.getNo());
				obj.put("title", b.getTitle());
				obj.put("writer", b.getWriter());
				arr.add(obj);
			}
		}
		
		// jsonarray를 jsonobject로 감쌈
		JSONObject data = new JSONObject();
		data.put("arr", arr);
		
		// 4. 반환
		// 반환 타입을 json으로 지정
		response.setContentType("application/json; charset=utf-8");

		// 데이터를 반환함
		response.getWriter().print(data);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
