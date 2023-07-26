package com.final_project.stock.filter;

import java.io.IOException;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebFilter("/rainbowcompany/login/*")
public class LoginCheckfiltering implements Filter {
    public LoginCheckfiltering() {
    	
    } 

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		String logincheck = (String) session.getAttribute("userid");
		if(logincheck == null) {
			res.sendRedirect("/rainbowcompany/main");
		}else {
			
		}
		chain.doFilter(request, response);
		
	} 

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}


