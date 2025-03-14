package com.spr.middleware;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        
        System.out.println("Incoming request: " + req.getMethod() + " " + req.getRequestURI());

        HttpSession session = req.getSession(false);
        boolean loggedIn = (session != null && session.getAttribute("user") != null);
        boolean isLoginPage = req.getRequestURI().endsWith("login.html");
        boolean isLoginServlet = req.getRequestURI().endsWith("login"); // Allow login requests

        if (!loggedIn && !isLoginPage && !isLoginServlet) {
            System.out.println("Unauthorized access! Redirecting to login.jsp");
            resp.sendRedirect("login.html");
            return; // Stop further processing
        }

        chain.doFilter(request, response);
    }
}
