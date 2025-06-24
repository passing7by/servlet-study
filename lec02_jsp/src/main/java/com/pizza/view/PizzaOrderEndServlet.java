package com.pizza.view;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@WebServlet("/pizzaOrderEnd")
public class PizzaOrderEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PizzaOrderEndServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request의 body에 한글 데이터가 있을 경우, 데이터를 가져올 때 깨지지 않게 하기 위해 데이터를 인코딩
		request.setCharacterEncoding("UTF-8");
		
		String userName = request.getParameter("userName");
		String userEmail = request.getParameter("userEmail");
		String userPhone = request.getParameter("userPhone");
		
		String pizzaSize = request.getParameter("pizzaSize");
		String[] pizzaTopping = request.getParameterValues("pizzaTopping");
		if (pizzaTopping == null) pizzaTopping = new String[]{"토핑 선택 안함"};
		String deliveryTime = request.getParameter("deliveryTime");
		
		System.out.println(userName);
		System.out.println(userEmail);
		System.out.println(userPhone);
		System.out.println(pizzaSize); // 숫자값으로 받아옴
		for (String s : pizzaTopping) { // 숫자값으로 받아옴
			System.out.println(s);
		}			
		System.out.println(deliveryTime);
		
		// 피자 사이즈에 따른 가격과 사이즈 이름
		int pizzaPrice = 0;
		String pizzaSizeStr = "";
		switch (pizzaSize) {
			case "1" -> {
				pizzaPrice = 15900;
				pizzaSizeStr = "Small";
			}
			case "2" -> {
				pizzaPrice = 21000;
				pizzaSizeStr = "Medium";
			}
			case "3" -> {
				pizzaPrice = 27900;
				pizzaSizeStr = "Large";
			}
		}
		
		// 토핑에 따른 가격과 토핑 이름
		Map<String, Integer> selectedTopping = new HashMap<String, Integer>();
		for (String s : pizzaTopping) {
			switch (s) {
				case "1" -> selectedTopping.put("새우", 2000);
				case "2" -> selectedTopping.put("고구마", 1000);
				case "3" -> selectedTopping.put("감자", 1000);
				case "4" -> selectedTopping.put("파인애플", 1000);
				default -> selectedTopping.put("토핑 선택 안함", 0);
			}
		}
		
		// 총 가격 계산
		// 토핑의 총 가격 계산
		int totalCost = pizzaPrice;
		for (String key : selectedTopping.keySet()) {
			totalCost += selectedTopping.get(key);
		}

		// jsp로 데이터 전달 및 jsp로 이동
		RequestDispatcher rd = request.getRequestDispatcher("views/pizza/result.jsp");
		// 데이터 전달
		request.setAttribute("userName", userName);
		request.setAttribute("userPhone", userPhone);
		request.setAttribute("userEmail", userEmail);

		request.setAttribute("pizzaSizeStr", pizzaSizeStr);
		request.setAttribute("selectedToppingNames", selectedTopping.keySet());
		request.setAttribute("totalCost", totalCost);
		
		// jsp로 이동
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
