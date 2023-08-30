package com.example.tasks.servlet;

import com.example.tasks.manager.UserManager;
import com.example.tasks.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class LoginServlet extends HttpServlet {
    UserManager userManager = new UserManager();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User user = userManager.getUserByEmailAndPassword(email, password);
        HttpSession session = req.getSession();
        session.setAttribute("user", user);
        if (user.getRole() == null) {
            resp.sendRedirect("/");
        } else if (user.getRole().equals("employee")) {
            resp.sendRedirect("/ehome.jsp");
        } else if (user.getRole().equals("manager")){
            resp.sendRedirect("/mhome.jsp");
        } else if (user.getRole().equals("s_manager")) {
            resp.sendRedirect("/smhome.jsp");
        }
    }
}
