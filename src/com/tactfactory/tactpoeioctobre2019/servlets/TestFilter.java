package com.tactfactory.tactpoeioctobre2019.servlets;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import com.tactfactory.tactpoeioctobre2019.entites.User;

/**
 * Servlet Filter implementation class TestFilter
 */
@WebFilter(
            dispatcherTypes = {DispatcherType.REQUEST },
            urlPatterns = "/JspTestServlet" ) //  urlPatterns = "/" servletNames = { "JSPTestServlet" }
public class TestFilter implements Filter {

    /**
     * Default constructor.
     */
    public TestFilter() {
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
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // TODO Auto-generated method stub
        // place your code here

        System.out.println("Connection from : " + request.getRemoteAddr());

        // pass the request along the filter chain
        chain.doFilter(request, response);
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        // TODO Auto-generated method stub
    }

}
