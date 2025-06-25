package com.practice02.wrapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

public class AnonymousWrapper extends HttpServletRequestWrapper {

	public AnonymousWrapper(HttpServletRequest request) {
		super(request);
	}
	
	@Override
	public String getParameter(String name) {
		// 만약 name이 "writer"이면서
		// name의 value가 null/"익명"이 아닌 경우, value를 "익명"으로		
		String value = super.getParameter(name);
		
		if ("writer".equals(name)) {
			if (!value.equals("익명") || value != null) return "익명";			
		}
		
		return value;
	}

}
