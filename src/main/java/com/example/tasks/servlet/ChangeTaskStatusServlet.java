package com.example.tasks.servlet;

import com.example.tasks.manager.TaskManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ChangeTaskStatusServlet extends HttpServlet {
    TaskManager taskManager = new TaskManager();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        taskManager.updateTaskStatus(req.getParameter("newStatus"), Integer.parseInt(req.getParameter("taskId")));
        resp.sendRedirect("/ehome.jsp");
    }
}
