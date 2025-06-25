package com.prefix.common.filter;

import java.io.IOException;

import com.prefix.common.wrapper.TitlePrefixWrapper;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/board/write")
public class TitlePrefixFilter extends HttpFilter implements Filter {
	private static final long serialVersionUID = 1L;

	public TitlePrefixFilter() {
        super();
    }

	public void destroy() {
	
	}

	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 1. 요청을 가로채서 할 행동
		System.out.println("[TitlePrefixFilter] 요청 가로챔");
		
		// 2. 다음 필터 혹은 서블릿으로 이동
		chain.doFilter(new TitlePrefixWrapper(request), response); // request를 requstWrapper로 감싸서 전달
		
		// 3. 응답을 가로채서 할 행동
		System.out.println("[TitlePrefixFilter] 응답 가로챔");
	}

	public void init(FilterConfig fConfig) throws ServletException {
	
	}

}
