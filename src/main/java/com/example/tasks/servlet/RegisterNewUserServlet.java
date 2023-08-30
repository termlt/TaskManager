package com.example.tasks.servlet;

import com.example.tasks.manager.UserManager;
import com.example.tasks.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class RegisterNewUserServlet extends HttpServlet {
    UserManager userManager = new UserManager();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = User.builder()
                .name(req.getParameter("name"))
                .surname(req.getParameter("surname"))
                .email(req.getParameter("email"))
                .password(req.getParameter("password"))
                .role(req.getParameter("newUserRole"))
                .build();

        userManager.addUser(user);
        resp.sendRedirect("/smhome.jsp");
    }
}
