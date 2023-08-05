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

@WebFilter("/rainbowcompany/login/pw/*")
public class PasswordCheckfiltering implements Filter {



	    public PasswordCheckfiltering() {
	    	
	    } 

		public void destroy() {
		}

		public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
			HttpServletRequest req = (HttpServletRequest) request;
			HttpServletResponse res = (HttpServletResponse) response;
			HttpSession session = req.getSession();
			String passwordcheck = (String) session.getAttribute("verifypassword");
			if(passwordcheck == null) {
				res.sendRedirect("/rainbowcompany/login/accountverify");
			}else {
				
			}
			chain.doFilter(request, response);
			
		} 

		public void init(FilterConfig fConfig) throws ServletException {
			
		}


}
