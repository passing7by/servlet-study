package com.prefix.common.wrapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

public class TitlePrefixWrapper extends HttpServletRequestWrapper {

	public TitlePrefixWrapper(HttpServletRequest request) {
		super(request);
	}
	
	public String getParameter(String title) {
		// 부모 클래스인 HttpServletRequestWrapper의 getParameter(name)를 이용해 name의 value 가져옴
		String value = super.getParameter(title);
		
		// name이 "title"이고 value가 null이 아닌 경우에만 prefix 부착
		if (title.equals("title") && value != null) {
			return "[공지] " + value;
		}
		
		// 이외에는 value만 반환
		return value;
	}

}
