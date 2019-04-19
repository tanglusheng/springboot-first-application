package com.forezp.springbootfirstapplication.filter;

import javax.servlet.*;
import java.io.IOException;

public class HeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("您已进入HeFilter过滤器，您的请求正常，请继续遵守规则...");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
