package com.campus.filter;

import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.httpFilter;

@Override
@WebFilter("/*")
public class LoggingFilter extends HttpsFilter{

    @Override 
    public void do Filter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Request received");
        chain.doFilter(request, response);
        System.out.println("Response sent");
    }
}




public class LoggingFilter {
    
}
