package com.practice05.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.practice05.dto.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/addToCart")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddToCartServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 2. 세션에 선택한 상품 정보 저장
		// 0-1) 상품 코드에 따른 상품 정보를 저장하는 list (db처럼 사용)
		List<Product> list = new ArrayList<Product>();
		list.add(new Product(1001, "키보드", 25000));
		list.add(new Product(1002, "마우스", 15000));
		list.add(new Product(1003, "모니터", 180000));
		
		// 0-2) 장바구니에 담은 상품을 간직한 list 생성
		HttpSession session = request.getSession(true); // 기존의 세션이 있으면 그걸 가져다 쓰고, 없다면 생성
		List<Product> addedList = (ArrayList<Product>) session.getAttribute("addedList"); 
		
		// 1) 상품 정보 받아와서 list에 저장
		String productCode = request.getParameter("productCode");
		if (addedList == null) addedList = new ArrayList<Product>();
		for (Product p : list) {
			if (productCode.equals(String.valueOf(p.getCode()))) {
				addedList.add(p);
			}
		}
		// 2) 세션에 저장하기
		if (addedList.size() == 0 || addedList == null) session.setAttribute("msg", "장바구니가 비어있습니다."); // 1) 장바구니가 비어있는 경우
		else session.setAttribute("addedList", addedList); // 2) 비어있지 않은 경우
		
		// 3. 응답
		request.getRequestDispatcher("/").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
