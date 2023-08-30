package com.example.tasks.servlet;

import com.example.tasks.manager.TaskManager;
import com.example.tasks.manager.UserManager;
import com.example.tasks.model.Task;
import com.example.tasks.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddNewTaskServlet extends HttpServlet {
    TaskManager taskManager = new TaskManager();
    UserManager userManager = new UserManager();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Date deadline;
        try {
            deadline = sdf.parse(req.getParameter("deadline"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        int userId = userManager.getUserIdByEmail(req.getParameter("selectedUser"));
        User userById = userManager.getUserById(userId);
        Task task = Task.builder()
                .name(req.getParameter("taskName"))
                .description(req.getParameter("description"))
                .user(userById)
                .status(req.getParameter("status"))
                .deadline(deadline)
                .build();
        taskManager.addTask(task);
        resp.sendRedirect("/mhome.jsp");

    }
}
