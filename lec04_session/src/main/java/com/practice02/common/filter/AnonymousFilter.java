package com.practice02.common.filter;

import java.io.IOException;

import com.practice02.wrapper.AnonymousWrapper;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class AnonymousFilter
 */
@WebFilter("/comment/write") // 이 경로로 가는 요청을 가로챔
public class AnonymousFilter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public AnonymousFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		
		// 1. 요청을 가로채서 실행할 코드
		// 화면에서 입력받은 값을 조작한 다음 조작한 값을 서블릿으로 보내야 함 => RequestWrapper 사용
		// 2. 다음 필터 혹은 서블릿으로 요청을 보냄
		chain.doFilter(new AnonymousWrapper(request), response);
		// 3. 응답을 가로채서 실행할 코드
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
