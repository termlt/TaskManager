package com.example.tasks.filter;

import com.example.tasks.model.User;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(urlPatterns = {"/ehome.jsp", "/mhome.jsp"})
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String requestedResource = httpRequest.getRequestURI();
        HttpSession session = httpRequest.getSession();
        User user = (User) session.getAttribute("user");
        String userRole = user.getRole();

        if (session.getAttribute("user") == null) {
            System.out.println("User is not logged in.");
            httpResponse.sendRedirect("/index.jsp");
        } else if (userRole.equals("manager") && requestedResource.startsWith("/ehome.jsp")) {
            httpResponse.sendRedirect("/mhome.jsp");
        } else if (userRole.equals("employee") && requestedResource.startsWith("/mhome.jsp")) {
            httpResponse.sendRedirect("/ehome.jsp");
        } else {
            System.out.println("User " + user.getName() + " logged in, proceeding.");
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
